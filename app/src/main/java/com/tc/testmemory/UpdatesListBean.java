package com.tc.testmemory;

import java.util.List;

/**
 * <p></p>
 *
 * @author chenyou
 * @version 2.0.1.0 , 2017/3/18
 */

public class UpdatesListBean {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * icon : static/images/game/Icon.png
         * game_name : Ultimate 3D Hold'em
         * download : static/files/TexasHoldem_1.0.5.apk
         * verison : 1.0.5
         * game_id : 1000
         * packName : com.Aipu.TexasHoldem
         */

        private String icon;
        private String game_name;
        private String download;
        private String verison;
        private int game_id;
        private String packName;

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getGame_name() {
            return game_name;
        }

        public void setGame_name(String game_name) {
            this.game_name = game_name;
        }

        public String getDownload() {
            return download;
        }

        public void setDownload(String download) {
            this.download = download;
        }

        public String getVerison() {
            return verison;
        }

        public void setVerison(String verison) {
            this.verison = verison;
        }

        public int getGame_id() {
            return game_id;
        }

        public void setGame_id(int game_id) {
            this.game_id = game_id;
        }

        public String getPackName() {
            return packName;
        }

        public void setPackName(String packName) {
            this.packName = packName;
        }
    }
}
