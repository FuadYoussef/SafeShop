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
        Bundle extras = getIntent().getExtras();
        String type = "";
        String sort = "";
        int location = 0;
        if(extras != null) {
            type = extras.getString("type");
            sort = extras.getString("sort");
            location = extras.getInt("location");
            System.out.println(type);
        }
        ArrayList<Business> businesses = new ArrayList<>();
        ArrayList<String> reviews1 = new ArrayList<>();
        ArrayList<String> reviews2 = new ArrayList<>();
        ArrayList<String> reviews3 = new ArrayList<>();
        ArrayList<String> policy1 = new ArrayList<>();
        ArrayList<String> policy2 = new ArrayList<>();
        ArrayList<String> policy3 = new ArrayList<>();
        Business b1 = new Business("Publix", 50, 5, "Grocery Store" ,reviews1, policy1);
        Business b2 = new Business("Kroger", 100, 10, "Grocery Store" ,reviews2, policy2);
        Business b3 = new Business("Whole Foods", 70, 20, "Grocery Store" ,reviews3, policy3);
        b1.setNumShopping(20);
        b1.setNumWaiting(30);
        b2.setNumShopping(10);
        b2.setNumWaiting(5);
        b3.setNumShopping(50);
        b3.setNumWaiting(15);
        businesses.add(b1);
        businesses.add(b2);
        businesses.add(b3);
        ArrayList<String> bnames = new ArrayList<>();
        ArrayList<Integer> bnum = new ArrayList<>();
        ArrayList<Integer> bwait = new ArrayList<>();
        ArrayList<Business> temp = new ArrayList<>();

        for (Business b : businesses) {
            if (b.getRange() <= location && b.getType().equals(type)) {
                if (sort.equals("Number of People")) {
                    int i = 0;
                    while (i < temp.size() && b.getNumCustomers() > temp.get(i).getNumCustomers()) {
                        i++;
                    }
                    temp.add(i, b);
                } else if(sort.equals("Wait Line Length")) {
                    int i = 0;
                    while (i < temp.size() && b.getNumWaiting() > temp.get(i).getNumWaiting()) {
                        i++;
                    }
                    temp.add(i, b);
                }

            }
        }


        for (Business b: temp) {
            bnames.add(b.getName());
            bnum.add(b.getNumCustomers());
            bwait.add(b.getNumWaiting());
        }


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_results);
        recyclerView = findViewById(R.id.resultRecycle);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new mAdapter(bnames, bnum, bwait, this);
        recyclerView.setAdapter(mAdapter);
    }
}
