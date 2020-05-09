package tech.youssef.safeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AddReviewActivity extends AppCompatActivity {
    ImageView star1;
    ImageView star2;
    ImageView star3;
    ImageView star4;
    ImageView star5;
    TextView companyNameTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_review);
        star1 = findViewById(R.id.addStar1);
        star2 = findViewById(R.id.addStar2);
        star3 = findViewById(R.id.addStar3);
        star4 = findViewById(R.id.addStar4);
        star5 = findViewById(R.id.addStar5);
        companyNameTv = findViewById(R.id.storeNameReviewLabel);
        String companyName;
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            companyName = extras.getString("name");
            companyNameTv.setText(companyName);
        }

    }

    public void addStar1(View view) {
        star1.setImageResource(R.mipmap.filled_star);
        star2.setImageResource(R.mipmap.empty_star);
        star3.setImageResource(R.mipmap.empty_star);
        star4.setImageResource(R.mipmap.empty_star);
        star5.setImageResource(R.mipmap.empty_star);
    }

    public void addStar2(View view) {
        star1.setImageResource(R.mipmap.filled_star);
        star2.setImageResource(R.mipmap.filled_star);
        star3.setImageResource(R.mipmap.empty_star);
        star4.setImageResource(R.mipmap.empty_star);
        star5.setImageResource(R.mipmap.empty_star);
    }

    public void addStar3(View view) {
        star1.setImageResource(R.mipmap.filled_star);
        star2.setImageResource(R.mipmap.filled_star);
        star3.setImageResource(R.mipmap.filled_star);
        star4.setImageResource(R.mipmap.empty_star);
        star5.setImageResource(R.mipmap.empty_star);
    }

    public void addStar4(View view) {
        star1.setImageResource(R.mipmap.filled_star);
        star2.setImageResource(R.mipmap.filled_star);
        star3.setImageResource(R.mipmap.filled_star);
        star4.setImageResource(R.mipmap.filled_star);
        star5.setImageResource(R.mipmap.empty_star);
    }

    public void addStar5(View view) {
        star1.setImageResource(R.mipmap.filled_star);
        star2.setImageResource(R.mipmap.filled_star);
        star3.setImageResource(R.mipmap.filled_star);
        star4.setImageResource(R.mipmap.filled_star);
        star5.setImageResource(R.mipmap.filled_star);
    }

    public void submitReview(View view) {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Review Added",
                Toast.LENGTH_SHORT);
        toast.show();
        Intent returnIntent = new Intent(this, DisplayResultsActivity.class);
        startActivity(returnIntent);
    }
}
