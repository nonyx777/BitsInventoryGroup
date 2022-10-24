/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bits.ui;

import com.bits.Sale;
import com.bits.Util;
import com.bits.services.SaleService;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author nonyx
 */
public class SaleTableModel extends AbstractTableModel{
    List<Sale> sales = new ArrayList<>();
    String columnNames[] = {"Product", "Date", "Quantity", "Price", "TotalPrice"};
    Class<?> columnClasses[] = {String.class, String.class, String.class, String.class, String.class};
    
    Map fieldMap = new HashMap();
    
    SaleTableModel(){
        fieldMap.put(0, "Product");
        fieldMap.put(1, "Date");
        fieldMap.put(2, "Quantity");
        fieldMap.put(3, "Price");
        fieldMap.put(4, "TotalPrice");
    }
    
    @Override
    public int getRowCount(){
        return sales.size();
    }
    @Override
    public int getColumnCount(){
        return columnNames.length;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        var methodName = String.format("get%s", (String) fieldMap.get(columnIndex));
        Method method = Util.getByMethodName(sales.get(rowIndex), methodName);
        return (String) Util.callMethod(method, sales.get(rowIndex));
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return columnNames[columnIndex];
    }
    @Override
    public Class<?> getColumnClass(int columnIndex){
        return columnClasses[columnIndex];
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return true;
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex){
        var methodName = String.format("set%s", (String) fieldMap.get(columnIndex));
        Method method = Util.getByMethodName(sales.get(rowIndex), methodName, String.class);
        Util.callMethod(method, sales.get(rowIndex), aValue);
        
        fireTableCellUpdated(rowIndex, columnIndex);
        
        SaleService service = new SaleService();
        service.writeAll(sales);
    }
}
