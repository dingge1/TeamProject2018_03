package com.applicationStart;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CaseItem {

  @Id // Specifies primary key
  @GeneratedValue(strategy = GenerationType.SEQUENCE) // Produce key sequentially; 1, 2, 3 ... n
	private long Id;
	
  private long index;
  
  private long itemId;
  private String custName;
  private String custTable;
  
  private String orderedName;
  private double orderedPrice;
  private int prepTime;
  

  public CaseItem (){}
  
  public CaseItem (long index, long itemId, String custName, String custTable, String orderedName, double orderedPrice, int prepTime){
    this.index = index;
    this.itemId = itemId;
    this.custName = custName;
    this.custTable = custTable;
    this.orderedName = orderedName;
    this.orderedPrice = orderedPrice;
    this.prepTime = prepTime;
  }
  
  public long getId() {
    return Id;
  }
  
  public void setId(long id) {
    Id = id;
  }
  
  public long getItemId() {
    return itemId;
  }
  
  public void setItemId(long itemId) {
    this.itemId = itemId;
  }
  
  public String getCustName() {
    return custName;
  }
  
  public void setCustName(String custName) {
    this.custName = custName;
  }
  
  public String getCustTable() {
    return custTable;
  }
  
  public void setCustTable(String custTable) {
    this.custTable = custTable;
  }
  
  public long getIndex() {
    return index;
  }

  public void setIndex(long index) {
    this.index = index;
  }
  
  public String getOrderedName() {
    return orderedName;
  }

  public void setOrderedName(String orderedName) {
    this.orderedName = orderedName;
  }

  public double getOrderedPrice() {
    return orderedPrice;
  }

  public void setOrderedPrice(double orderedPrice) {
    this.orderedPrice = orderedPrice;
  }
  
  public int getPrepTime() {
	  return prepTime;
  }
  
  public void setPrepTime(int prepTime) {
	  this.prepTime = prepTime;
  }
  
  
	
}
