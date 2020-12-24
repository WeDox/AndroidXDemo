package com.onedream.androidxdemo.common.bean.random_poetry;

import java.util.List;

/**
 * @author jdallen
 * @since 2020/12/24
 */
public class RandomPoetryBean {
    /**
     * id : 21822
     * title : 通州丁溪馆夜别李景信三首 一
     * author : 元稹
     * author_id : 117
     * paragraphList : [{"id":"119425","poetry_id":"21822","paragraph":"月蒙蒙兮山掩掩，束束别魂眉敛敛。","strain":"仄平平平平仄仄，仄仄仄平平仄仄。","p_desc":"","is_famous":"0"},{"id":"119426","poetry_id":"21822","paragraph":"蠡盏覆时天欲明，碧幌青灯风滟滟。","strain":"○仄仄平平仄平，仄仄平平平仄仄。","p_desc":"","is_famous":"0"},{"id":"119427","poetry_id":"21822","paragraph":"泪消语尽还暂眠，唯梦千山万山险。","strain":"仄平仄仄平仄平，仄仄平平仄平仄。","p_desc":"","is_famous":"0"}]
     */

    private String id;
    private String title;
    private String author;
    private String author_id;
    private List<ParagraphListBean> paragraphList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }

    public List<ParagraphListBean> getParagraphList() {
        return paragraphList;
    }

    public void setParagraphList(List<ParagraphListBean> paragraphList) {
        this.paragraphList = paragraphList;
    }

    public static class ParagraphListBean {
        /**
         * id : 119425
         * poetry_id : 21822
         * paragraph : 月蒙蒙兮山掩掩，束束别魂眉敛敛。
         * strain : 仄平平平平仄仄，仄仄仄平平仄仄。
         * p_desc :
         * is_famous : 0
         */

        private String id;
        private String poetry_id;
        private String paragraph;
        private String strain;
        private String p_desc;
        private String is_famous;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPoetry_id() {
            return poetry_id;
        }

        public void setPoetry_id(String poetry_id) {
            this.poetry_id = poetry_id;
        }

        public String getParagraph() {
            return paragraph;
        }

        public void setParagraph(String paragraph) {
            this.paragraph = paragraph;
        }

        public String getStrain() {
            return strain;
        }

        public void setStrain(String strain) {
            this.strain = strain;
        }

        public String getP_desc() {
            return p_desc;
        }

        public void setP_desc(String p_desc) {
            this.p_desc = p_desc;
        }

        public String getIs_famous() {
            return is_famous;
        }

        public void setIs_famous(String is_famous) {
            this.is_famous = is_famous;
        }
    }
}
