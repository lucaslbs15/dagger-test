package lucas.bicca.daggertest.model;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ShoppingCart {

    private int id;
    private String date;
    private List<Product> products = new ArrayList<>();
    private Customer customer;

    @Inject
    public ShoppingCart(Customer customer) {
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
