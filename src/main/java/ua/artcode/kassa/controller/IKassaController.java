package ua.artcode.kassa.controller;


import ua.artcode.kassa.model.Bill;
import ua.artcode.kassa.model.Product;

public interface IKassaController {

    void showAllProducts();
    void addProduct(Product product);
    void sellProduct(int id);

    boolean open(String id);
    void close();

    Bill getBill();


}
