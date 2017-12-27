package lucas.bicca.daggertest.model;

import android.util.Log;

import javax.inject.Inject;

public class Purchase {

    private final String LOG_TAG = Purchase.class.getSimpleName();

    private int id;
    private ShoppingCart shoppingCart;
    private String date;

    @Inject
    public Purchase(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void addProductsInCart() {
        date = "26/12/2017 11:02:00";
        id = 1515;
        shoppingCart.getCustomer().setName("Lucas");
        shoppingCart.getCustomer().setLastName("Bicca");
        shoppingCart.getCustomer().getAddress().setCity("Porto Alegre");
        shoppingCart.getCustomer().getAddress().setComplement("Ap 2");
        shoppingCart.getCustomer().getAddress().setNeighborhood("Centro");
        shoppingCart.getCustomer().getAddress().setNumber(200);
        shoppingCart.getCustomer().getAddress().setState("Rio Grande do Sul");
        shoppingCart.getCustomer().getAddress().setStreet("Riachuelo");
        shoppingCart.getCustomer().getAddress().setZipCode("91320150");
        shoppingCart.getProducts().add(new Product(1, "iPhone 8", 2));
        shoppingCart.getProducts().add(new Product(5, "Moto Z Play", 1));
        Log.i(LOG_TAG, "addProductsInCart() called");
    }

    public String showBriefDescription() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(id + "\n");
        stringBuilder.append(date + "\n");
        stringBuilder.append(shoppingCart.getCustomer().getName() + "\n");
        stringBuilder.append(shoppingCart.getProducts().size() + " products\n");
        Log.i(LOG_TAG, "showBriefDescription() called");
        return stringBuilder.toString();
    }
}
