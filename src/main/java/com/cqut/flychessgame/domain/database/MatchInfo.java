package com.cqut.flychessgame.domain.database;

public class MatchInfo {
    private Long sponsorid;

    private Long acceptid;

    private Integer sign;

    private Integer dicenum;

    private Double locx;

    private Double locy;

    private String cellcolor;

    private Integer planenum;

    private Integer direction;

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

    public Integer getSign() {
        return sign;
    }

    public void setSign(Integer sign) {
        this.sign = sign;
    }

    public Integer getDicenum() {
        return dicenum;
    }

    public void setDicenum(Integer dicenum) {
        this.dicenum = dicenum;
    }

    public Double getLocx() {
        return locx;
    }

    public void setLocx(Double locx) {
        this.locx = locx;
    }

    public Double getLocy() {
        return locy;
    }

    public void setLocy(Double locy) {
        this.locy = locy;
    }

    public String getCellcolor() {
        return cellcolor;
    }

    public void setCellcolor(String cellcolor) {
        this.cellcolor = cellcolor == null ? null : cellcolor.trim();
    }

    public Integer getPlanenum() {
        return planenum;
    }

    public void setPlanenum(Integer planenum) {
        this.planenum = planenum;
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }
}