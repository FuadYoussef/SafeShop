package tech.youssef.safeshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DisplayBusinessInfoActivity extends AppCompatActivity {
    String companyName;
    TextView companyNameTv;
    TextView numPeople;
    TextView numWaiting;
    TextView maxOccupancy;
    ImageView star1;
    ImageView star2;
    ImageView star3;
    ImageView star4;
    ImageView star5;
    int rating;
    private RecyclerView policyRecyclerView;
    private RecyclerView.Adapter policyAdapter;
    private RecyclerView.LayoutManager policyLayoutManager;

    private RecyclerView reviewRecyclerView;
    private RecyclerView.Adapter reviewAdapter;
    private RecyclerView.LayoutManager reviewLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_business_info);
        star1 = findViewById(R.id.addStar1);
        star2 = findViewById(R.id.addStar2);
        star3 = findViewById(R.id.addStar3);
        star4 = findViewById(R.id.addStar4);
        star5 = findViewById(R.id.addStar5);
        companyNameTv = findViewById(R.id.businessNameLabel);
        numPeople = findViewById(R.id.numInStoreValue);
        numWaiting = findViewById(R.id.numWaitValue);
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            companyName = extras.getString("name");
            companyNameTv.setText(companyName);
            numPeople.setText(Integer.toString(extras.getInt("num")));
            numWaiting.setText(Integer.toString(extras.getInt("wait")));
        }
        maxOccupancy = findViewById(R.id.maxOccupancyValue);


        ArrayList<String> policies = new ArrayList<>();
        ArrayList<String> reviews = new ArrayList<>();
        if (companyName.equals("Publix")) {
            maxOccupancy.setText("50");
            policies.add("Wipe down carts");
            policies.add("Hand sanitizer stations");
            policies.add("Employees must wear facemasks");

            reviews.add("The store made sure its employees used facemasks at all times and also wore gloves while checking out the customers.");
            reviews.add("The store did not have any wipes when I was there to clean the carts but they had sanitizer for the customers to use when entering and leaving the store");
            rating = 3;
        } else if (companyName.equals("Kroger")) {
            maxOccupancy.setText("100");
            policies.add("Employees wear facemasks and gloves");
            policies.add("Sanitizer stations");
            policies.add("Shopping Cart Cleaning");

            reviews.add("They did not have any way to clean the carts and the employees did not wear any gloves.");
            reviews.add("When I went to this grocery store they did not have that many stations for cleaning the customers' hands.");
            rating = 2;
        } else if (companyName.equals("Whole Foods")) {
            maxOccupancy.setText("70");
            policies.add("Face masks for employees");

            reviews.add("They did not have any way to clean the carts and the employees did not wear any gloves.");
            reviews.add("Even though they wore masks, the employees were not as careful as other stores I have been to. They also did not wipe down the carts after other people used them.");
            rating = 4;
        }
        policyRecyclerView = findViewById(R.id.policyRecycle);
        policyLayoutManager = new LinearLayoutManager(this);
        policyRecyclerView.setLayoutManager(policyLayoutManager);

        // specify an adapter (see also next example)
        policyAdapter = new ReviewAdapter(policies, this);
        policyRecyclerView.setAdapter(policyAdapter);


        reviewRecyclerView = findViewById(R.id.reviewRecycle);
        reviewLayoutManager = new LinearLayoutManager(this);
        reviewRecyclerView.setLayoutManager(reviewLayoutManager);
        // specify an adapter (see also next example)
        reviewAdapter = new ReviewAdapter(reviews, this);
        reviewRecyclerView.setAdapter(reviewAdapter);

        if (rating == 2) {
            star1.setImageResource(R.mipmap.filled_star);
            star2.setImageResource(R.mipmap.filled_star);
            star3.setImageResource(R.mipmap.empty_star);
            star4.setImageResource(R.mipmap.empty_star);
            star5.setImageResource(R.mipmap.empty_star);
        } else if (rating == 3) {
            star1.setImageResource(R.mipmap.filled_star);
            star2.setImageResource(R.mipmap.filled_star);
            star3.setImageResource(R.mipmap.filled_star);
            star4.setImageResource(R.mipmap.empty_star);
            star5.setImageResource(R.mipmap.empty_star);

        } else if (rating == 4) {
            star1.setImageResource(R.mipmap.filled_star);
            star2.setImageResource(R.mipmap.filled_star);
            star3.setImageResource(R.mipmap.filled_star);
            star4.setImageResource(R.mipmap.filled_star);
            star5.setImageResource(R.mipmap.empty_star);
        }

    }

    public void launchAddReview(View view) {
        Intent reviewIntent = new Intent(view.getContext(), AddReviewActivity.class);
        reviewIntent.putExtra("name", companyName);
        view.getContext().startActivity(reviewIntent);
    }
}
