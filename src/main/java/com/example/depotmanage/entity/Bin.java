package com.example.depotmanage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author dzy
 * @since 2022-04-26
 */
@EqualsAndHashCode
@Data
public class Bin implements Serializable {

  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;

  private Integer shelfId;

  private Integer row;

  private Integer col;

  private String sn;

  private Float positionZ;

  private Integer isLoad;

  private Float maxLoad;

  private String goodsSn;

  private Integer amount;

  private Date operationDate;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getShelfId() {
    return shelfId;
  }

  public void setShelfId(Integer shelfId) {
    this.shelfId = shelfId;
  }

  public Integer getRow() {
    return row;
  }

  public void setRow(Integer row) {
    this.row = row;
  }

  public Integer getCol() {
    return col;
  }

  public void setCol(Integer col) {
    this.col = col;
  }

  public String getSn() {
    return sn;
  }

  public void setSn(String sn) {
    this.sn = sn;
  }

  public Float getPositionZ() {
    return positionZ;
  }

  public void setPositionZ(Float positionZ) {
    this.positionZ = positionZ;
  }

  public Integer getIsLoad() {
    return isLoad;
  }

  public void setIsLoad(Integer isLoad) {
    this.isLoad = isLoad;
  }

  public Float getMaxLoad() {
    return maxLoad;
  }

  public void setMaxLoad(Float maxLoad) {
    this.maxLoad = maxLoad;
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

  public Date getOperationDate() {
    return operationDate;
  }

  public void setOperationDate(Date operationDate) {
    this.operationDate = operationDate;
  }

}
