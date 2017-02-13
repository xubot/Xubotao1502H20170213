package com.example.administrator.xubotao1502h20170213.Bean;

/**
 * Created by Administrator on 2017/2/13.
 */

public class Bean {
    private String title;
    private String author_name;

    @Override
    public String toString() {
        return "Bean{" +
                "title='" + title + '\'' +
                ", author_name='" + author_name + '\'' +
                ", thumbnail_pic_s='" + thumbnail_pic_s + '\'' +
                '}';
    }

    public Bean(String title, String author_name, String thumbnail_pic_s) {
        this.title = title;
        this.author_name = author_name;
        this.thumbnail_pic_s = thumbnail_pic_s;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getThumbnail_pic_s() {
        return thumbnail_pic_s;
    }

    public void setThumbnail_pic_s(String thumbnail_pic_s) {
        this.thumbnail_pic_s = thumbnail_pic_s;
    }

    private String thumbnail_pic_s;
}
