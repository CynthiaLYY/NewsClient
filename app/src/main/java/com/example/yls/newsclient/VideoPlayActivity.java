package com.example.yls.newsclient;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.VideoView;

/**
 * Created by yls on 2017/6/30.
 */
public class VideoPlayActivity extends BaseActivity {

    private VideoView videoView;
    private ProgressBar progressBar;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_video_play;
    }

    @Override
    public void initView() {
        videoView = (VideoView) findViewById(R.id.video_view);
        progressBar = (ProgressBar) findViewById(R.id.pb_01);
    }

    @Override
    public void initListener() {
    }

    @Override
    public void initData() {
        String videoUrl = getIntent().getStringExtra("video_url");

        // 设置视频播放路径
        videoView.setVideoPath(videoUrl);

        // 设置监听器，监听缓冲完成
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override   // 缓冲完成后回调
            public void onPrepared(MediaPlayer mp) {
                videoView.start();  // 缓冲完成后，开始播放视频
                progressBar.setVisibility(View.GONE);
            }
        });
    }
}