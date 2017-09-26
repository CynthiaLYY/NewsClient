package com.example.yls.newsclient.bean;

import java.util.List;

/**
 * Created by yls on 2017/6/30.
 */
public class VideoEntity {

    private List<ResultBean> result;

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * sizeSHD : 0
         * replyCount : 0
         * videosource : 新媒体
         * mp4Hd_url : http://flv2.bn.netease.com/videolib3/1706/16/JWfed5257/HD/JWfed5257-mobile.mp4
         * title : 阿拉斯加和金毛一起泡水，金毛才是大二货！
         * cover : http://vimg3.ws.126.net/image/snapshot/2017/6/2/6/VCM4OB426.jpg
         * videoTopic : {"alias":"萌宠、搞笑","tname":"萌宠菌","ename":"T1496854007547","tid":"T1496854007547","topic_icons":"http://dingyue.nosdn.127.net/Njeb=IO1AE1Fv4VTc2A8aF9DfkxS4a9czQnuJF2h0E5f51496854006724.jpg"}
         * description : 阿拉斯加和金毛一起泡水，金毛才是大二货！
         * replyid : ZM4KVRVI050835RB
         * length : 33
         * m3u8_url : http://flv.bn.netease.com/videolib3/1706/16/JWfed5257/SD/movie_index.m3u8
         * vid : VZM4KVRVI
         * topicName : 萌宠菌
         * votecount : 0
         * topicImg : http://vimg3.ws.126.net/image/snapshot/2017/6/V/8/VCLEHUHV8.jpg
         * topicDesc : 分享各类萌宠、搞怪趣事，今天你被萌到了吗？更多萌宠尽在萌宠菌。
         * topicSid : VCLEHUHUO
         * replyBoard : video_bbs
         * playCount : 0
         * sectiontitle :
         * mp4_url : http://flv2.bn.netease.com/videolib3/1706/16/JWfed5257/SD/JWfed5257-mobile.mp4
         * playersize : 0
         * sizeSD : 2475
         * sizeHD : 3300
         * m3u8Hd_url : http://flv.bn.netease.com/videolib3/1706/16/JWfed5257/HD/movie_index.m3u8
         * ptime : 2017-06-16 14:43:34
         */

        private int sizeSHD;
        private int replyCount;
        private String videosource;
        private String mp4Hd_url;
        private String title;
        private String cover;
        private VideoTopicBean videoTopic;
        private String description;
        private String replyid;
        private int length;
        private String m3u8_url;
        private String vid;
        private String topicName;
        private int votecount;
        private String topicImg;
        private String topicDesc;
        private String topicSid;
        private String replyBoard;
        private int playCount;
        private String sectiontitle;
        private String mp4_url;
        private int playersize;
        private int sizeSD;
        private int sizeHD;
        private String m3u8Hd_url;
        private String ptime;

        public int getSizeSHD() {
            return sizeSHD;
        }

        public void setSizeSHD(int sizeSHD) {
            this.sizeSHD = sizeSHD;
        }

        public int getReplyCount() {
            return replyCount;
        }

        public void setReplyCount(int replyCount) {
            this.replyCount = replyCount;
        }

        public String getVideosource() {
            return videosource;
        }

        public void setVideosource(String videosource) {
            this.videosource = videosource;
        }

        public String getMp4Hd_url() {
            return mp4Hd_url;
        }

        public void setMp4Hd_url(String mp4Hd_url) {
            this.mp4Hd_url = mp4Hd_url;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public VideoTopicBean getVideoTopic() {
            return videoTopic;
        }

        public void setVideoTopic(VideoTopicBean videoTopic) {
            this.videoTopic = videoTopic;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getReplyid() {
            return replyid;
        }

        public void setReplyid(String replyid) {
            this.replyid = replyid;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getM3u8_url() {
            return m3u8_url;
        }

        public void setM3u8_url(String m3u8_url) {
            this.m3u8_url = m3u8_url;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public String getTopicName() {
            return topicName;
        }

        public void setTopicName(String topicName) {
            this.topicName = topicName;
        }

        public int getVotecount() {
            return votecount;
        }

        public void setVotecount(int votecount) {
            this.votecount = votecount;
        }

        public String getTopicImg() {
            return topicImg;
        }

        public void setTopicImg(String topicImg) {
            this.topicImg = topicImg;
        }

        public String getTopicDesc() {
            return topicDesc;
        }

        public void setTopicDesc(String topicDesc) {
            this.topicDesc = topicDesc;
        }

        public String getTopicSid() {
            return topicSid;
        }

        public void setTopicSid(String topicSid) {
            this.topicSid = topicSid;
        }

        public String getReplyBoard() {
            return replyBoard;
        }

        public void setReplyBoard(String replyBoard) {
            this.replyBoard = replyBoard;
        }

        public int getPlayCount() {
            return playCount;
        }

        public void setPlayCount(int playCount) {
            this.playCount = playCount;
        }

        public String getSectiontitle() {
            return sectiontitle;
        }

        public void setSectiontitle(String sectiontitle) {
            this.sectiontitle = sectiontitle;
        }

        public String getMp4_url() {
            return mp4_url;
        }

        public void setMp4_url(String mp4_url) {
            this.mp4_url = mp4_url;
        }

        public int getPlayersize() {
            return playersize;
        }

        public void setPlayersize(int playersize) {
            this.playersize = playersize;
        }

        public int getSizeSD() {
            return sizeSD;
        }

        public void setSizeSD(int sizeSD) {
            this.sizeSD = sizeSD;
        }

        public int getSizeHD() {
            return sizeHD;
        }

        public void setSizeHD(int sizeHD) {
            this.sizeHD = sizeHD;
        }

        public String getM3u8Hd_url() {
            return m3u8Hd_url;
        }

        public void setM3u8Hd_url(String m3u8Hd_url) {
            this.m3u8Hd_url = m3u8Hd_url;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public static class VideoTopicBean {
            /**
             * alias : 萌宠、搞笑
             * tname : 萌宠菌
             * ename : T1496854007547
             * tid : T1496854007547
             * topic_icons : http://dingyue.nosdn.127.net/Njeb=IO1AE1Fv4VTc2A8aF9DfkxS4a9czQnuJF2h0E5f51496854006724.jpg
             */

            private String alias;
            private String tname;
            private String ename;
            private String tid;
            private String topic_icons;

            public String getAlias() {
                return alias;
            }

            public void setAlias(String alias) {
                this.alias = alias;
            }

            public String getTname() {
                return tname;
            }

            public void setTname(String tname) {
                this.tname = tname;
            }

            public String getEname() {
                return ename;
            }

            public void setEname(String ename) {
                this.ename = ename;
            }

            public String getTid() {
                return tid;
            }

            public void setTid(String tid) {
                this.tid = tid;
            }

            public String getTopic_icons() {
                return topic_icons;
            }

            public void setTopic_icons(String topic_icons) {
                this.topic_icons = topic_icons;
            }
        }
    }

}
