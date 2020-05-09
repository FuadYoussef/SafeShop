package tech.youssef.safeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class SignUpActivity extends AppCompatActivity {
    boolean isCustomer = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_as);
    }

    public void launchSearch(View view) {
        Intent searchIntent = new Intent(this, SearchActivity.class);
        startActivity(searchIntent);
    }

    public void launchSignUpCustomer(View view) {
        setContentView(R.layout.activity_sign_up);
    }

    public void launchSignUpBusiness(View view) {
        isCustomer = false;
        setContentView(R.layout.activity_sign_up);
    }
}
