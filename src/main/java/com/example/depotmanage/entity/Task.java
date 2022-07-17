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
 * @since 2022-05-05
 */
@EqualsAndHashCode
@Data
public class Task implements Serializable {

  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;

  private String taskNo;

  private Integer type;

  private String binSn;

  private String username;

  private String goodsSn;

  private Date taskTime;

  private Integer amount;

  private String goodsName;

  public Integer getId() {
    return id;
  }

  public Integer getType() {
    return type;
  }

  public String getBinSn() {
    return binSn;
  }

  public String getUsername() {
    return username;
  }

  public String getGoodsSn() {
    return goodsSn;
  }

  public Date getTaskTime() {
    return taskTime;
  }

  public Integer getAmount() {
    return amount;
  }

  public String getGoodsName() {
    return goodsName;
  }

  public String getTaskNo() {
    return taskNo;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setTaskNo(String taskNo) {
    this.taskNo = taskNo;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public void setBinSn(String binSn) {
    this.binSn = binSn;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setGoodsSn(String goodsSn) {
    this.goodsSn = goodsSn;
  }

  public void setTaskTime(Date taskTime) {
    this.taskTime = taskTime;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public void setGoodsName(String goodsName) {
    this.goodsName = goodsName;
  }

}
