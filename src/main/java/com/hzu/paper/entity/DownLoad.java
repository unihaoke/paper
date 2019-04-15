package com.hzu.paper.entity;

import java.util.Date;

public class DownLoad extends DownLoadKey {
    private Date downDate;

    private String title;

    public DownLoad(String yhid, String lwid, Date downDate, String title) {
        super(yhid, lwid);
        this.downDate = downDate;
        this.title = title;
    }

    public DownLoad() {
        super();
    }

    public Date getDownDate() {
        return downDate;
    }

    public void setDownDate(Date downDate) {
        this.downDate = downDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }
}