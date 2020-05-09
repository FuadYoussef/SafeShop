package tech.youssef.safeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void launchSearch(View view) {
        Intent searchIntent = new Intent(this, SearchActivity.class);
        startActivity(searchIntent);
    }
}
