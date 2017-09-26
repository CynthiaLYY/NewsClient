package com.example.yls.newsclient.fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.yls.newsclient.NewsDetailActivity;
import com.example.yls.newsclient.R;
import com.example.yls.newsclient.adapter.NewsAdapter;
import com.example.yls.newsclient.base.URLManager;
import com.example.yls.newsclient.bean.NewsEntity;
import com.google.gson.Gson;
import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.MeituanHeader;
import com.liaoinstan.springview.widget.SpringView;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.util.List;

/**
 * 显示一个类别下的新闻
 *
 * @author WJQ
 */
public class NewsItemFragment extends BaseFragment {

    private TextView textView;
    private ListView listView;

    /**
     * 新闻类别id
     */
    private String channelId;
    private NewsAdapter newsAdapter;
    private SpringView springView;
    private View headerView;

    private List<NewsEntity.ResultBean> listDatas;

    /**
     * 设置新闻类别id
     */
    public void setNewsCategoryId(String newsCategoryId) {
        this.channelId = newsCategoryId;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_news_item;
    }

    @Override
    public void initView() {
        textView = (TextView) mRootView.findViewById(R.id.tv_01);
        textView.setText("类别id：" + channelId);
        listView = (ListView) mRootView.findViewById(R.id.listView);
        newsAdapter = new NewsAdapter(getActivity(), null);
        listView.setAdapter(newsAdapter);
        initSpringView();
    }

    // 显示下拉刷新和加载更多的控件
    private void initSpringView() {
        springView = (SpringView) mRootView.findViewById(R.id.spring_view);

        springView.setHeader(new MeituanHeader(getContext()));
        springView.setFooter(new DefaultFooter(getContext()));

        // springView.setType(SpringView.Type.OVERLAP);
        springView.setType(SpringView.Type.FOLLOW);

        // 设置监听器
        springView.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {       // 下拉，刷新第一页数据
                // showToast("下拉");
                getNewsDatas(true);
            }

            @Override
            public void onLoadmore() {      // 上拉，加载下一页数据
                // showToast("上拉");
                getNewsDatas(false);
            }
        });
    }

    @Override
    public void initListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 用户点击的新闻

                NewsEntity.ResultBean newsBean = (NewsEntity.ResultBean)
                        parent.getItemAtPosition(position);
                Intent intent = new Intent(mActivity, NewsDetailActivity.class);
                intent.putExtra("news", newsBean);
                startActivity(intent);
            }
        });
    }

    @Override
    public void initData() {
        // 获取服务器新闻数据
        getNewsDatas(true);
    }

    /**
     * 要加载第几页数据
     */
    private int pageNo = 1;

    /**
     * 获取服务器新闻数据
     */
    private void getNewsDatas(final boolean refresh) {
        if (refresh)  // 如果是下拉刷新
            pageNo = 1;

        String url = URLManager.getUrl(channelId, pageNo);

        HttpUtils utils = new HttpUtils();
        utils.send(HttpRequest.HttpMethod.GET, url, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String json = responseInfo.result;
                System.out.println("----服务器返回的json数据:" + json);

                json = json.replace(channelId, "result");
                Gson gson = new Gson();
                NewsEntity newsEntity = gson.fromJson(json, NewsEntity.class);
                System.out.println("----解析json:" + newsEntity.getResult().size());

                listDatas = newsEntity.getResult();

                // （3）显示列表(数据，列表项布局，适配器BaseAdapter)
                if (refresh) {  // 下拉刷新
                    showListView(listDatas);

                } else {        // 上拉加载下一页数据
                    newsAdapter.appendDatas(listDatas);
                }
                pageNo++;       // 页码自增1

                //  隐藏SpringView的下拉和上拉显示
                springView.onFinishFreshAndLoad();


                // 显示数据到列表中
                showDatas(newsEntity);
            }

            @Override
            public void onFailure(HttpException error, String msg) {
                error.printStackTrace();
            }
        });
    }

    // 显示列表
    private void showListView(List<NewsEntity.ResultBean> listDatas) {
        // （1）显示轮播图

        // 如果列表已经添加了头部布局，则先移除
        if (listView.getHeaderViewsCount() > 0) {
            listView.removeHeaderView(headerView);
        }

        // 第一条新闻
        NewsEntity.ResultBean firstNews = listDatas.get(0);
        // 有轮播图
        if (firstNews.getAds() != null && firstNews.getAds().size() > 0) {
            headerView = LayoutInflater.from(getContext()).inflate(R.layout
                    .list_header, listView, false);

            // 查找轮播图控件
            SliderLayout sliderLayout = (SliderLayout)
                    headerView.findViewById(R.id.slider_layout);
            // 准备轮播图要显示的数据
            List<NewsEntity.ResultBean.AdsBean> ads = firstNews.getAds();
            // 添加轮播图子界面
            for (int i = 0; i < ads.size(); i++) {
                NewsEntity.ResultBean.AdsBean bean = ads.get(i);

                // 一个TextSliderView表示一个子界面
                TextSliderView textSliderView = new TextSliderView(getContext());
                textSliderView.description(bean.getTitle())  // 显示标题
                        .image(bean.getImgsrc());      // 显示图片

                sliderLayout.addSlider(textSliderView);       // 添加一个子界面
            }

            // 添加到轮播图到列表的头部
            listView.addHeaderView(headerView);

        } else {
            // 没有轮播图的情况
        }

        // （2）显示列表
        newsAdapter.setDatas(listDatas);    // 重置列表的数据，刷新列表显示
    }

    // 显示服务器数据
    private void showDatas(NewsEntity newsDatas) {
        if (newsDatas == null
                || newsDatas.getResult() == null
                || newsDatas.getResult().size() == 0) {
            System.out.println("----没有获取到服务器的新闻数据");
            return;
        }

        // （1）显示轮播图
        List<NewsEntity.ResultBean.AdsBean> ads
                = newsDatas.getResult().get(0).getAds();

        // 有轮播图广告
        if (ads != null && ads.size() > 0) {
            View headerView = View.inflate(mActivity, R.layout.list_header, null);
            SliderLayout sliderLayout = (SliderLayout)
                    headerView.findViewById(R.id.slider_layout);

            for (int i = 0; i < ads.size(); i++) {
                // 一则广告数据
                NewsEntity.ResultBean.AdsBean adBean = ads.get(i);

                TextSliderView sliderView = new TextSliderView(mActivity);
                sliderView.description(adBean.getTitle()).image(adBean.getImgsrc());
                // 添加子界面
                sliderLayout.addSlider(sliderView);
                // 设置点击事件
                sliderView.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                    @Override
                    public void onSliderClick(BaseSliderView slider) {
                        showToast(slider.getDescription());
                    }
                });
            }
//            // 添加列表头部布局
//            listView.addHeaderView(headerView);
        }

        // （2）显示新闻列表
//        NewsAdapter newsAdapter = new NewsAdapter(
//                mActivity, newsDatas.getResult());

    }

}















