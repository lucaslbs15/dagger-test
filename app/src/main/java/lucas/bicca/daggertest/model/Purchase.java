package lucas.bicca.daggertest.model;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

public class Purchase implements Serializable {

    private int id;
    private ShoppingCart shoppingCart;
    private Date date;

    @Inject
    public Purchase(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Purchase(int id, ShoppingCart shoppingCart, Date date) {
        this.id = id;
        this.shoppingCart = shoppingCart;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
