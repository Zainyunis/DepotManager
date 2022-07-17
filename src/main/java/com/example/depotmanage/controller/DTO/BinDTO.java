package com.example.depotmanage.controller.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class BinDTO {
    private String houseName;
    private String houseSn;
    private String shelfSn;
    private String binSn;
    private Integer col;
    private Integer row;
    private Float maxLoad;
    private Date operationDate;
    private String goodsName;
    private String goodsSn;
    private Integer amount;
    private Float unitWeight;
    private String unit;
    private String goodsNotes;
    private Integer isLoad;

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getHouseSn() {
        return houseSn;
    }

    public void setHouseSn(String houseSn) {
        this.houseSn = houseSn;
    }

    public String getShelfSn() {
        return shelfSn;
    }

    public void setShelfSn(String shelfSn) {
        this.shelfSn = shelfSn;
    }

    public String getBinSn() {
        return binSn;
    }

    public void setBinSn(String binSn) {
        this.binSn = binSn;
    }

    public Integer getCol() {
        return col;
    }

    public void setCol(Integer col) {
        this.col = col;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Float getMaxLoad() {
        return maxLoad;
    }

    public void setMaxLoad(Float maxLoad) {
        this.maxLoad = maxLoad;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsSn() {
        return goodsSn;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Float getUnitWeight() {
        return unitWeight;
    }

    public void setUnitWeight(Float unitWeight) {
        this.unitWeight = unitWeight;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getGoodsNotes() {
        return goodsNotes;
    }

    public void setGoodsNotes(String goodsNotes) {
        this.goodsNotes = goodsNotes;
    }

    public Integer getIsLoad() {
        return isLoad;
    }

    public void setIsLoad(Integer isLoad) {
        this.isLoad = isLoad;
    }

}
