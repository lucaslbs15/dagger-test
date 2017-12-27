package lucas.bicca.daggertest.module;

import java.util.Date;

import dagger.Module;
import dagger.Provides;
import lucas.bicca.daggertest.model.Purchase;
import lucas.bicca.daggertest.model.ShoppingCart;

@Module
public class PurchaseModule {

    private ShoppingCart shoppingCart;

    public PurchaseModule(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Provides
    Purchase providePurchase() {
        return new Purchase(0, shoppingCart, new Date());
    }
}
