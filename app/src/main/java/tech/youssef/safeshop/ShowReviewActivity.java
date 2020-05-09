package tech.youssef.safeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


public class ShowReviewActivity extends AppCompatActivity {
    TextView reviewContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_review);
        reviewContent = findViewById(R.id.storeNameReviewLabel);
        String companyName;
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            companyName = extras.getString("name");
            reviewContent.setText(companyName);
        }
    }
}
