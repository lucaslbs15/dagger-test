package lucas.bicca.daggertest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import lucas.bicca.daggertest.model.Purchase;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        if (intent != null && intent.getSerializableExtra("intent_purchase") != null) {
            Purchase purchase = (Purchase) intent.getSerializableExtra("intent_purchase");
            Log.i("Bicca", String.format("Nome do comprador: %s", purchase.getShoppingCart().getCustomer().getName()));
        }
    }
}
