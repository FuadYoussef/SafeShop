package tech.youssef.safeshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class DisplayBusinessInfoActivity extends AppCompatActivity {
    String companyName;
    TextView companyNameTv;
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
        companyNameTv = findViewById(R.id.businessNameLabel);
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            companyName = extras.getString("name");
            companyNameTv.setText(companyName);
        }
        ArrayList<String> policies = new ArrayList<>();
        policies.add("6 feet apart");
        policies.add("Wear Masks");
        policyRecyclerView = findViewById(R.id.policyRecycle);
        policyLayoutManager = new LinearLayoutManager(this);
        policyRecyclerView.setLayoutManager(policyLayoutManager);

        // specify an adapter (see also next example)
        policyAdapter = new ReviewAdapter(policies, this);
        policyRecyclerView.setAdapter(policyAdapter);

        ArrayList<String> reviews = new ArrayList<>();
        reviews.add("Very good");
        reviews.add("felt very safe");
        reviewRecyclerView = findViewById(R.id.reviewRecycle);
        reviewLayoutManager = new LinearLayoutManager(this);
        reviewRecyclerView.setLayoutManager(reviewLayoutManager);
        // specify an adapter (see also next example)
        reviewAdapter = new ReviewAdapter(reviews, this);
        reviewRecyclerView.setAdapter(reviewAdapter);

    }

    public void launchAddReview(View view) {
        Intent reviewIntent = new Intent(view.getContext(), AddReviewActivity.class);
        reviewIntent.putExtra("name", companyName);
        view.getContext().startActivity(reviewIntent);
    }
}
