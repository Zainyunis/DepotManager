package com.example.depotmanage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 仓库信息
 * </p>
 *
 * @author dzy
 * @since 2022-04-22
 */
@EqualsAndHashCode
@Data
public class House implements Serializable {

  /**
   * 表主键
   */
  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;

  private String name;

  private String sn;

  private String notes;

  /**
   * 逻辑删除，1表示删除，0表示未删除
   */
  private Integer isDeleted;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSn() {
    return sn;
  }

  public void setSn(String sn) {
    this.sn = sn;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public Integer getIsDeleted() {
    return isDeleted;
  }

  public void setIsDeleted(Integer isDeleted) {
    this.isDeleted = isDeleted;
  }

}
