package lucas.bicca.daggertest;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import javax.inject.Inject;

import lucas.bicca.daggertest.component.CustomerComponent;
import lucas.bicca.daggertest.component.DaggerCustomerComponent;
import lucas.bicca.daggertest.databinding.ActivityMainBinding;
import lucas.bicca.daggertest.model.Customer;
import lucas.bicca.daggertest.model.Purchase;

public class MainActivity extends AppCompatActivity {

    private final String LOG_TAG = MainActivity.class.getSimpleName();

    @Inject Purchase purchase;
    private ActivityMainBinding binding;
    Customer customer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    public void onFinishClick(View view) {
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
        Toast.makeText(this, "purchase saved", Toast.LENGTH_SHORT).show();
    }

    public void onShowResultClick(View view) {
        Log.i(LOG_TAG, String.format("Description: %s", purchase.showBriefDescription()));
        Toast.makeText(this, purchase.showBriefDescription(), Toast.LENGTH_SHORT).show();
    }

    public void onAddProductClick(View view) {

    }
}
