package com.hzu.paper.entity;

import java.util.Date;

public class History extends HistoryKey {
    private Date browDate;

    private String title;

    public History(String yhid, String lwid, Date browDate, String title) {
        super(yhid, lwid);
        this.browDate = browDate;
        this.title = title;
    }

    public History() {
        super();
    }

    public Date getBrowDate() {
        return browDate;
    }

    public void setBrowDate(Date browDate) {
        this.browDate = browDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }
}