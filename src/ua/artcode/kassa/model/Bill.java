package ua.artcode.kassa.model;

import java.util.*;

public class Bill {

    // depends on abstraction
    //private Map<Integer,Product> map = new HashMap<>();
    private List<Product> list = new LinkedList<>();

    private Salesman salesman;

    private Date date = new Date();

    private double amount;

    public Bill() {
    }

    public void processAmount(){
        for(Product product : list){
            amount += product.getPrice();
        }
    }


    public List<Product> getList() {
        return list;
    }

    public void setList(List<Product> list) {
        this.list = list;
    }

    public Salesman getSalesman() {
        return salesman;
    }

    public void setSalesman(Salesman salesman) {
        this.salesman = salesman;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        //String res = "";
        StringBuilder sb = new StringBuilder();
        sb.append("BILL\nProducts : \n");

        for(Product product : list){
            sb.append("\t")
                    .append(product.toString())
                    .append("\n");
        }

        sb.append("Amount : ").append(amount).append("\n");
        String formatDate = String.format("%1$ty/%1$tm/%1$td %1$tH:%1$tM:%1$tS", date);

        sb.append("Date : ").append(formatDate).append("\n");
        sb.append("Salesman : ").append(salesman.getName()).append("\n");


        return sb.toString();
    }
}
