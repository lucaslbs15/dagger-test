package lucas.bicca.daggertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import javax.inject.Inject;
import lucas.bicca.daggertest.model.Purchase;

public class MainActivity extends AppCompatActivity {

    private final String LOG_TAG = MainActivity.class.getSimpleName();

    @Inject
    Purchase purchase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onFinishClick(View view) {
        purchase.addProductsInCart();
        Toast.makeText(this, "purchase saved", Toast.LENGTH_SHORT).show();
    }

    public void onShowResultClick(View view) {
        Log.i(LOG_TAG, String.format("Description: %s", purchase.showBriefDescription()));
        Toast.makeText(this, purchase.showBriefDescription(), Toast.LENGTH_SHORT).show();
    }
}
