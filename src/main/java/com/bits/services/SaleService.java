/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bits.services;

import com.bits.Sale;
import com.bits.base.AppendableObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nonyx
 */
public class SaleService {
    private final String filename = "sales.obj";
    
    public void save(Sale sale) throws IOException{
        String sql = String.format(
        "INSERT INTO sale(product, date, quantity, price, total_price) VALUES('%s', '%s', '%s', '%s', '%s')", sale.getProduct(), sale.getDate(), sale.getQuantity(), sale.getPrice(), sale.getTotalPrice());
        DatabaseService service = new DatabaseService();
        System.out.println("sql executed");
        service.execute(sql);
    }
    
    public ArrayList<Sale> getAll(){
        ArrayList<Sale> data = new ArrayList<>();
        String sql = "SELECT * FROM sale ORDER BY id";
        DatabaseService service = new DatabaseService();
        
        try(
                Connection conn = service.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)
        ){
            while(rs.next()){
                data.add(
                    new Sale(
                        rs.getInt("id"),
                        rs.getString("product"),
                        rs.getString("date"),
                        rs.getString("quantity"),
                        rs.getString("price"),
                        rs.getString("total_price"))
                );
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            return data;
        }
    }
    
    public void update(Sale sale, String column, String value){
        String sql = String.format(
                "UPDATE sale SET %s='%s' WHERE id=%d",
                column,
                value,
                sale.getID()
        );
        DatabaseService service = new DatabaseService();
        service.execute(sql);
    }
    
    public void writeAll(List<Sale> sales){
        String values = "";
        for(Sale sale : sales){
            if(!values.equals("")){
                values += ",";
            }
            values += String.format("('%s', '%s', '%s', '%s', '%s')", sale.getProduct(), sale.getDate(), sale.getQuantity(), sale.getPrice(), sale.getTotalPrice());
        }
        String sql = String.format("INSERT INTO sale(product, date, quantity, price, total_price) VALUES %s;", values);
        DatabaseService service = new DatabaseService();
        service.execute(sql);
    }
}
