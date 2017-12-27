package lucas.bicca.daggertest.module;

import dagger.Module;
import dagger.Provides;
import lucas.bicca.daggertest.model.Customer;
import lucas.bicca.daggertest.model.ShoppingCart;

@Module
public class ShoppingCartModule {

    private Customer customer;

    public ShoppingCartModule(Customer customer) {
        this.customer = customer;
    }

    @Provides
    ShoppingCart provideShoppingCart() {
        return new ShoppingCart(customer);
    }
}
