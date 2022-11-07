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
    private float quantity;
    private float price;
    private float totalPrice;
    
    public Transaction(){
        
    }
    /*public Transaction(Product product, String date, String quantity, String totalPrice){
        this.product = product;
        this.date = date;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }*/
    public Transaction(String product_string, String date, float quantity, float price, float totalPrice){
        this.product_string = product_string;
        this.date = date;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = totalPrice;
    }
    
    public Transaction(int id, String product_string, String date, float quantity, float price, float totalPrice){
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
    public float getQuantity(){
        return this.quantity;
    }
    public void setQuantity(float quantity){
        this.quantity = quantity;
    }
    //price getter and setter
    public float getPrice(){
        return this.price;
    }
    public void setPrice(float price){
        this.price = price;
    }
    //totalprice getter and setter
    public float getTotalPrice(){
        return this.totalPrice;
    }
    public void setTotalPrice(float totalPrice){
        this.totalPrice = totalPrice;
    }
}
