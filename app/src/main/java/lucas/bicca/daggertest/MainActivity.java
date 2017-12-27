package lucas.bicca.daggertest;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import lucas.bicca.daggertest.component.CustomerComponent;
import lucas.bicca.daggertest.component.DaggerCustomerComponent;
import lucas.bicca.daggertest.component.DaggerPurchaseComponent;
import lucas.bicca.daggertest.component.DaggerShoppingCartComponent;
import lucas.bicca.daggertest.component.PurchaseComponent;
import lucas.bicca.daggertest.component.ShoppingCartComponent;
import lucas.bicca.daggertest.databinding.ActivityMainBinding;
import lucas.bicca.daggertest.model.Customer;
import lucas.bicca.daggertest.model.Product;
import lucas.bicca.daggertest.model.Purchase;
import lucas.bicca.daggertest.model.ShoppingCart;
import lucas.bicca.daggertest.module.PurchaseModule;
import lucas.bicca.daggertest.module.ShoppingCartModule;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Customer customer;
    private List<Product> products = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    public void onSaveCustomerClick(View view) {
        CustomerComponent customerComponent = DaggerCustomerComponent.create();
        customer = customerComponent.getCustomerComponent();
        customer.setName(binding.activityMainName.getText().toString());
        customer.setLastName(binding.activityMainLastName.getText().toString());
        customer.setCpf(binding.activityMainCpf.getText().toString());
        customer.setBirthday(binding.activityMainBirthDay.getText().toString());
        customer.getAddress().setStreet(binding.activityMainStreet.getText().toString());
        try {
            customer.getAddress().setNumber(Integer.valueOf(binding.activityMainNumber.getText().toString()));
        } catch (Exception ex) {
            customer.getAddress().setNumber(0);
        }
        customer.getAddress().setComplement(binding.activityMainComplement.getText().toString());
        customer.getAddress().setNeighborhood(binding.activityMainNeighborhood.getText().toString());
        customer.getAddress().setZipCode(binding.activityMainZipCode.getText().toString());
        customer.getAddress().setCity(binding.activityMainCity.getText().toString());
        customer.getAddress().setState(binding.activityMainState.getText().toString());
        Toast.makeText(this, R.string.activity_main_saved, Toast.LENGTH_SHORT).show();
    }

    public void onShowResultClick(View view) {
        ShoppingCartComponent shoppingCartComponent = DaggerShoppingCartComponent.builder()
                .shoppingCartModule(new ShoppingCartModule(customer)).build();
        ShoppingCart shoppingCart = shoppingCartComponent.getShoppingCartComponent();
        shoppingCart.setProducts(products);
        PurchaseComponent purchaseComponent = DaggerPurchaseComponent.builder()
                .purchaseModule(new PurchaseModule(shoppingCart)).build();
        Purchase purchase = purchaseComponent.getPurchaseComponent();
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("intent_purchase", purchase);
        startActivity(intent);
    }

    public void onAddProductClick(View view) {
        try {
            Product product = new Product(
                    Integer.valueOf(binding.activityMainProductId.getText().toString()),
                    binding.activityMainProductDescription.getText().toString(),
                    Integer.valueOf(binding.activityMainProductQuantity.getText().toString()));

            products.add(product);
        } catch (Exception ex) {
            Toast.makeText(this, R.string.activity_main_add_product_error, Toast.LENGTH_SHORT).show();
        }
    }
}
