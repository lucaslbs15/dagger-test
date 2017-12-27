package lucas.bicca.daggertest.component;

import dagger.Component;
import lucas.bicca.daggertest.model.Customer;

@Component
public interface CustomerComponent {

    Customer getCustomerComponent();
}
