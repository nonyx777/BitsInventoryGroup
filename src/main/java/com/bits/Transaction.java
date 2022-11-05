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
    //private Product product;
    private int id;
    private String product_string;
    private String date;
    private String quantity;
    private String price;
    private String totalPrice;
    
    public Transaction(){
        
    }
    /*public Transaction(Product product, String date, String quantity, String totalPrice){
        this.product = product;
        this.date = date;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }*/
    public Transaction(String product_string, String date, String quantity, String price, String totalPrice){
        this.product_string = product_string;
        this.date = date;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = totalPrice;
    }
    
    public Transaction(int id, String product_string, String date, String quantity, String price, String totalPrice){
        this(product_string, date, quantity, price, totalPrice);
        this.id = id;
    }
    
    
    //id getter and setter
    public int getID(){
        return this.id;
    }
    public void setID(int id){
        this.id = id;
    }
    //product getter and setter
    public String getProduct(){
        return this.product_string;
    }
    public void setProduct(String product_string){
        this.product_string = product_string;
    }
    //date getter and setter
    public String getDate(){
        return this.date;
    }
    public void setDate(String date){
        this.date = date;
    }
    //quantity getter and setter
    public String getQuantity(){
        return this.quantity;
    }
    public void setQuantity(String quantity){
        this.quantity = quantity;
    }
    //price getter and setter
    public String getPrice(){
        return this.price;
    }
    public void setPrice(String price){
        this.price = price;
    }
    //totalprice getter and setter
    public String getTotalPrice(){
        return this.totalPrice;
    }
    public void setTotalPrice(String totalPrice){
        this.totalPrice = totalPrice;
    }
}
