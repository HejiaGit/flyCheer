package com.cqut.flychessgame.domain.database;

public class PlayInfo {
    private Long userid;

    private Integer playcount;

    private Integer wincount;

    private Integer playtor;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Integer getPlaycount() {
        return playcount;
    }

    public void setPlaycount(Integer playcount) {
        this.playcount = playcount;
    }

    public Integer getWincount() {
        return wincount;
    }

    public void setWincount(Integer wincount) {
        this.wincount = wincount;
    }

    public Integer getPlaytor() {
        return playtor;
    }

    public void setPlaytor(Integer playtor) {
        this.playtor = playtor;
    }
}