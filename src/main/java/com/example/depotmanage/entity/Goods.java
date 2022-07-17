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
public class Goods implements Serializable {

  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;

  private String sn;

  private String name;

  private String unit;

  private Float unitWeight;

  private String notes;

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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  public Float getUnitWeight() {
    return unitWeight;
  }

  public void setUnitWeight(Float unitWeight) {
    this.unitWeight = unitWeight;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

}
