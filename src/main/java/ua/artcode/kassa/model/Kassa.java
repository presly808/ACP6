package ua.artcode.kassa.model;

import java.util.*;

/**
 * Created by serhii on 18.04.15.
 */
public class Kassa {

    // depends on abstraction
    private Map<Integer,Product> productMap = new HashMap<>();
    private Map<String,Salesman> salesmanMap = new TreeMap<>();
    private List<Bill> billList = new LinkedList<>();

    public Kassa() {
    }

    public Map<Integer, Product> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<Integer, Product> productMap) {
        this.productMap = productMap;
    }

    public Map<String, Salesman> getSalesmanMap() {
        return salesmanMap;
    }

    public void setSalesmanMap(Map<String, Salesman> salesmanMap) {
        this.salesmanMap = salesmanMap;
    }

    public List<Bill> getBillList() {
        return billList;
    }

    public void setBillList(List<Bill> billList) {
        this.billList = billList;
    }


}
