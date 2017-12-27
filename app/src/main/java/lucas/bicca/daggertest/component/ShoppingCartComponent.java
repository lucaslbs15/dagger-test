package lucas.bicca.daggertest.component;

import dagger.Component;
import lucas.bicca.daggertest.model.ShoppingCart;
import lucas.bicca.daggertest.module.ShoppingCartModule;

@Component(modules = ShoppingCartModule.class)
public interface ShoppingCartComponent {

    ShoppingCart getShoppingCartComponent();
}
