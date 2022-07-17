package com.example.depotmanage.controller.DTO;

import lombok.Data;

@Data
public class GoodsDTO {
    private float positionX;
    private float positionY;
    private float positionZ;
    private String goodsName;
    private String binSn;

    public float getPositionX() {
        return positionX;
    }

    public void setPositionX(float positionX) {
        this.positionX = positionX;
    }

    public float getPositionY() {
        return positionY;
    }

    public void setPositionY(float positionY) {
        this.positionY = positionY;
    }

    public float getPositionZ() {
        return positionZ;
    }

    public void setPositionZ(float positionZ) {
        this.positionZ = positionZ;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getBinSn() {
        return binSn;
    }

    public void setBinSn(String binSn) {
        this.binSn = binSn;
    }
}
