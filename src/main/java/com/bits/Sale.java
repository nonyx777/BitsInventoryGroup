/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bits;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author henock
 */
public class Sale extends Transaction implements Serializable{
    public Sale() {
    }
    
    /*public Sale(Product product, String saleDate, String quantity, String totalPrice) {
        super(product, saleDate, quantity, totalPrice);
    }*/
    
    public Sale(String product_string, String saleDate, String quantity, String price, String totalPrice){
        super(product_string, saleDate, quantity, price, totalPrice);
    }
    public Sale(int id, String product_string, String saleDate, String quantity, String price, String totalPrice){
        super(id, product_string, saleDate, quantity, price, totalPrice);
    }
}
