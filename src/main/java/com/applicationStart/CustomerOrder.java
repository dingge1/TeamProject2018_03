package com.applicationStart;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
public class CustomerOrder { 
  
  @Id // Specifies primary key
  @GeneratedValue(strategy = GenerationType.SEQUENCE) // Produce key sequentially; 1, 2, 3 ... n
  private long Id;
  
  
  private long index;
  
  private String name;
  private String table;
  
  private Boolean waiter;
  
  private Date ordrTime;
 
  private Boolean confirmed;
  private Boolean ready;

  public CustomerOrder(){}
  
  public CustomerOrder(long index, String name, String table, Date ordrTime, Boolean confirmed, Boolean ready){ 
    this.index =index;
    this.name = name;
    this.table = table;
    this.waiter = false;
    this.ordrTime = ordrTime;
    this.confirmed = confirmed;
    this.ready = ready;
  }
  
  
  public long getId() {
    return Id;
  }

  public void setId(long id) {
    Id = id;
  }
  
  public long getIndex() {
    return index;
  }

  public void setIndex(long index) {
    this.index = index;
  }
  
  public String getTable() {
    return table;
  }

  public void setTable(String table) {
    this.table = table;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }

  public Boolean getWaiter() {
    return this.waiter;
  }
  
  public void setWaiter(Boolean waiter) {
    this.waiter = waiter;
  }
  
  public String getOrdrTime() {
    SimpleDateFormat ordrTimeF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return ordrTimeF.format(ordrTime);
  }

  public void setOrdrTime(Date ordrTime) {
    this.ordrTime = ordrTime;
  }
  
  
  public Boolean getConfirmed() {
    return confirmed;
  }

  public void setConfirmed(Boolean confirmed) {
    this.confirmed = confirmed;
  }
  
  public Boolean getReady() {
    return ready;
  }

  public void setReady(Boolean ready) {
    this.ready = ready;
  }
  
}
