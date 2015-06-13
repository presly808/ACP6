package ua.artcode.kassa.controller;

import ua.artcode.kassa.model.Bill;
import ua.artcode.kassa.model.Kassa;
import ua.artcode.kassa.model.Product;
import ua.artcode.kassa.model.Salesman;

import java.util.Date;
import java.util.Map;

/**
 * Created by serhii on 18.04.15.
 */
public class KassaController implements IKassaController  {

    private Kassa kassa;
    private Bill currentBill;
    private Salesman currentSalesman;

    public KassaController(Kassa kassa) {
        this.kassa = kassa;
    }

    @Override
    public void showAllProducts() {
        Map<Integer,Product> map = kassa.getProductMap();
        for(Product product : map.values()){
            System.out.println(product);
        }
    }

    @Override
    public void addProduct(Product product) {

    }

    @Override
    public void sellProduct(int id) {
        if(currentBill == null) {
            currentBill = new Bill();
            currentBill.setSalesman(currentSalesman);
        }
        Product product = kassa.getProductMap().get(id);
        //validation

        currentBill.getList().add(product);

        //think about
        kassa.getProductMap().remove(id);
    }

    @Override
    public boolean open(String id) {
        Salesman salesman = kassa.getSalesmanMap().get(id);
        if(salesman != null){
            currentSalesman = salesman;
            return true;
        }
        return false;
    }

    @Override
    public void close() {
        currentSalesman = null;
    }

    @Override
    public Bill getBill() {
        Bill forReturn = currentBill;

        forReturn.processAmount();
        forReturn.setDate(new Date());

        kassa.getBillList().add(forReturn);

        currentBill = null;

        return forReturn;
    }
}
