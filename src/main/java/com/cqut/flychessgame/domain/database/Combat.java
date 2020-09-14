package com.cqut.flychessgame.domain.database;

import java.util.Date;

public class Combat {
    private Long sponsorid;

    private Long acceptid;

    private Long winid;

    private Date playdate;

    public Long getSponsorid() {
        return sponsorid;
    }

    public void setSponsorid(Long sponsorid) {
        this.sponsorid = sponsorid;
    }

    public Long getAcceptid() {
        return acceptid;
    }

    public void setAcceptid(Long acceptid) {
        this.acceptid = acceptid;
    }

    public Long getWinid() {
        return winid;
    }

    public void setWinid(Long winid) {
        this.winid = winid;
    }

    public Date getPlaydate() {
        return playdate;
    }

    public void setPlaydate(Date playdate) {
        this.playdate = playdate;
    }
}