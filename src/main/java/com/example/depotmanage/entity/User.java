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
 * @since 2022-04-19
 */
@EqualsAndHashCode
@Data
public class User implements Serializable {

  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;

  private String name;

  private String account;

  private String tel;

  private String password;

  private Integer visitPower;

  private Integer isDeleted;

  private Date creatTime;

  private Integer titleId;

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getAccount() {
    return account;
  }

  public String getTel() {
    return tel;
  }

  public String getPassword() {
    return password;
  }

  public Integer getVisitPower() {
    return visitPower;
  }

  public Integer getIsDeleted() {
    return isDeleted;
  }

  public Date getCreatTime() {
    return creatTime;
  }

  public Integer getTitleId() {
    return titleId;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setVisitPower(Integer visitPower) {
    this.visitPower = visitPower;
  }

  public void setIsDeleted(Integer isDeleted) {
    this.isDeleted = isDeleted;
  }

  public void setCreatTime(Date creatTime) {
    this.creatTime = creatTime;
  }

  public void setTitleId(Integer titleId) {
    this.titleId = titleId;
  }

}
