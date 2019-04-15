package com.hzu.paper.entity;

import java.util.Date;

public class Recode {
    private String yhid;

    private Date visitDate;

    private Date visitTimes;

    public Recode(String yhid, Date visitDate, Date visitTimes) {
        this.yhid = yhid;
        this.visitDate = visitDate;
        this.visitTimes = visitTimes;
    }

    public Recode() {
        super();
    }

    public String getYhid() {
        return yhid;
    }

    public void setYhid(String yhid) {
        this.yhid = yhid == null ? null : yhid.trim();
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public Date getVisitTimes() {
        return visitTimes;
    }

    public void setVisitTimes(Date visitTimes) {
        this.visitTimes = visitTimes;
    }
}