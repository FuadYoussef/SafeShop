package tech.youssef.safeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AddBusinessInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_business_info);
    }

    public void saveChanges(View view) {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Changes Saved",
                Toast.LENGTH_SHORT);
        toast.show();
        Intent save = new Intent(this, BusinessPortalActivity.class);
        startActivity(save);
    }
}
