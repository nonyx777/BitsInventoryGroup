/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bits;

import java.io.Serializable;
import java.util.Date;
/**
 *
 * @author nonyx
 */
public class Transaction implements Serializable{
    private Product product;
    private Date date;
    private String quantity;
    private String totalPrice;
    
    public Transaction(){
        
    }
    public Transaction(Product product, Date date, String quantity, String totalPrice){
        this.product = product;
        this.date = date;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }
    public Transaction(String quantity, String totalPrice){
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }
    
    //product getter and setter
    public Product getProduct(){
        return product;
    }
    public void setProduct(Product product){
        this.product = product;
    }
    //date getter and setter
    public Date getDate(){
        return this.date;
    }
    public void setDate(Date date){
        this.date = date;
    }
    //quantity getter and setter
    public String getQuantity(){
        return this.quantity;
    }
    public void setQuantity(String quantity){
        this.quantity = quantity;
    }
    //totalprice getter and setter
    public String getTotalPrice(){
        return this.totalPrice;
    }
    public void setTotalPrice(String totalPrice){
        this.totalPrice = totalPrice;
    }
}
