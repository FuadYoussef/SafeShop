package tech.youssef.safeshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import java.util.ArrayList;

public class DisplayResultsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ArrayList<String> businessNames = new ArrayList<>();
        ArrayList<Integer> numCustomers = new ArrayList<>();
        ArrayList<Integer> numWaiting = new ArrayList<>();
        businessNames.add("Bank");
        businessNames.add("Post Office");
        numCustomers.add(29);
        numCustomers.add(10);
        numWaiting.add(2);
        numWaiting.add(4);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_results);
        recyclerView = findViewById(R.id.resultRecycle);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new mAdapter(businessNames, numCustomers, numWaiting, this);
        recyclerView.setAdapter(mAdapter);
    }
}
