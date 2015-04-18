package ua.artcode.kassa;

import ua.artcode.kassa.controller.KassaController;
import ua.artcode.kassa.model.Kassa;
import ua.artcode.kassa.model.Product;
import ua.artcode.kassa.model.Salesman;
import ua.artcode.kassa.view.KassaView;

/**
 * Created by serhii on 18.04.15.
 */
public class RunKassa {


    public static void main(String[] args) {
        Kassa kassa = new Kassa();
        kassa.getSalesmanMap().put("1234", new Salesman("1234","Anatoliy"));
        kassa.getProductMap().put(345, new Product(345,"Apple",19));
        kassa.getProductMap().put(234, new Product(234,"Orange",30));
        kassa.getProductMap().put(12, new Product(12,"Coconut",60));
        kassa.getProductMap().put(55, new Product(55,"Beer",10));

        KassaController kassaController = new KassaController(kassa);

        KassaView view = new KassaView(kassaController);

        view.start();
    }
}
