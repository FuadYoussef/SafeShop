package tech.youssef.safeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BusinessPortalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_portal);
    }

    public void launchCounter(View view) {
        Intent counterIntent = new Intent(this, CounterActivity.class);
        startActivity(counterIntent);
    }

    public void launchEditInfo(View view) {
        Intent infoIntent = new Intent(this, AddBusinessInfoActivity.class);
        startActivity(infoIntent);
    }
}
