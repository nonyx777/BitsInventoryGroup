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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nonyx
 */
public class SaleService {
    private final String filename = "sales.obj";
    
    public void save(Sale sale) throws IOException{
        File f = new File(filename);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        
        try{
            if(f.exists()){
                fos = new FileOutputStream(filename, true);
                oos = new AppendableObjectOutputStream(fos);
            }else{
                fos = new FileOutputStream(filename);
                oos = new ObjectOutputStream(fos);
            }
            
            oos.writeObject(sale);
            
            oos.close();
            fos.close();
        } finally{
            if(oos != null){
                oos.close();
            }
            if(fos != null){
                fos.close();
            }
        }
    }
    
    public ArrayList<Sale> getAll(){
        boolean eof = false;
        ArrayList<Sale> data = new ArrayList<>();
        
        try(
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis)){
            Sale sale;
            
            while(!eof){
                sale = (Sale) ois.readObject();
                if(sale != null){
                    data.add(sale);
                }else{
                    eof = true;
                }
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }finally{
            return data;
        }
    }
    
    public void writeAll(List<Sale> sales){
        try(FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            for(Sale sale: sales){
                oos.writeObject(sale);
            }
        }catch(IOException ex){
            //....
        }
    }
}
