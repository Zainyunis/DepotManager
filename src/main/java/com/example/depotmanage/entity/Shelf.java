package com.example.depotmanage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author dzy
 * @since 2022-04-22
 */
@EqualsAndHashCode
@Data
public class Shelf implements Serializable {

  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;

  private String sn;

  private Integer totalRow;

  private Integer totalCal;

  private Float maxLoad;

  private Float positionX;

  private Float positionY;

  private Float bottomHeight;

  private Float binLength;

  private Float binWidth;

  private Float binHeight;

  private Integer houseId;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getSn() {
    return sn;
  }

  public void setSn(String sn) {
    this.sn = sn;
  }

  public Integer getTotalRow() {
    return totalRow;
  }

  public void setTotalRow(Integer totalRow) {
    this.totalRow = totalRow;
  }

  public Integer getTotalCal() {
    return totalCal;
  }

  public void setTotalCal(Integer totalCal) {
    this.totalCal = totalCal;
  }

  public Float getMaxLoad() {
    return maxLoad;
  }

  public void setMaxLoad(Float maxLoad) {
    this.maxLoad = maxLoad;
  }

  public Float getPositionX() {
    return positionX;
  }

  public void setPositionX(Float positionX) {
    this.positionX = positionX;
  }

  public Float getPositionY() {
    return positionY;
  }

  public void setPositionY(Float positionY) {
    this.positionY = positionY;
  }

  public Float getBottomHeight() {
    return bottomHeight;
  }

  public void setBottomHeight(Float bottomHeight) {
    this.bottomHeight = bottomHeight;
  }

  public Float getBinLength() {
    return binLength;
  }

  public void setBinLength(Float binLength) {
    this.binLength = binLength;
  }

  public Float getBinWidth() {
    return binWidth;
  }

  public void setBinWidth(Float binWidth) {
    this.binWidth = binWidth;
  }

  public Float getBinHeight() {
    return binHeight;
  }

  public void setBinHeight(Float binHeight) {
    this.binHeight = binHeight;
  }

  public Integer getHouseId() {
    return houseId;
  }

  public void setHouseId(Integer houseId) {
    this.houseId = houseId;
  }

}
