package tech.youssef.safeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CounterActivity extends AppCompatActivity {

    int numCustomers = 10, numShopping = 10, numWaiting = 0;
    int maxOccupancy = 15;

    TextView numCustomersValue;
    TextView numInStoreValue;
    TextView numWaitValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        this.numCustomersValue = findViewById(R.id.numCustomersValue);
        this.numInStoreValue = findViewById(R.id.numInStoreValue);
        this.numWaitValue = findViewById(R.id.numWaitValue);

        this.numCustomersValue.setText(numCustomers);
        this.numInStoreValue.setText(numShopping);
        this.numWaitValue.setText(numWaiting);

    }

    public void add(View view) {
        numCustomers++;
        if(numCustomers < maxOccupancy) {
            numShopping = numCustomers;
        } else {
            numShopping = maxOccupancy;
            numWaiting = numCustomers - numShopping;
        }

        this.numCustomersValue.setText(numCustomers);
        this.numInStoreValue.setText(numShopping);
        this.numWaitValue.setText(numWaiting);


    }

    public void subtract(View view) {
        numCustomers--;
        if(numCustomers < 0) {
            numCustomers = 0;
            numShopping = 0;
            numWaiting = 0;
        } else {
            numWaiting--;
            if (numWaiting < 0) {
                numWaiting = 0;
                numShopping--;
            }
        }
        this.numCustomersValue.setText(numCustomers);
        this.numInStoreValue.setText(numShopping);
        this.numWaitValue.setText(numWaiting);
    }
}
