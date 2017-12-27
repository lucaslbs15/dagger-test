package lucas.bicca.daggertest.component;

import dagger.Component;
import lucas.bicca.daggertest.model.Purchase;
import lucas.bicca.daggertest.module.PurchaseModule;

@Component(modules = PurchaseModule.class)
public interface PurchaseComponent {

    Purchase getPurchaseComponent();
}
