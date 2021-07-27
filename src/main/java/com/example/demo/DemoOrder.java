package com.example.demo;

import javax.persistence.*;

@Entity
public class DemoOrder {
  
  @Id    
  @GeneratedValue(strategy = GenerationType.AUTO)    
  private Long id;
  
  private  String name; 
  private  String drink;
  private  String entree;

  public DemoOrder(){
      this.id = null;
      this.name = null;
      this.drink = null;
      this.entree = null;
  }
  public DemoOrder(String name, String drink, String entree){
      this.name = name;
      this.drink = drink;
      this.entree = entree;
}



public void setId(Long id) {        
    this.id = id;   
 }
public Long getId(){
    return this.id;
}


public void setName(String name) {        
    this.name = name;   
 }

public String getName(){
    return this.name;
}

public void setDrink(String drink) {        
    this.drink = drink;   
 }

public String getDrink(){
    return this.drink;
}

public void setEntree(String entree) {        
    this.entree = entree;   
 }
public String getEntree(){
    return this.entree;
}

}
