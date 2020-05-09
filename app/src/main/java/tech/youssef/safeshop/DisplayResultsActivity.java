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
        businesses.add(b1);
        businesses.add(b2);
        businesses.add(b3);
        ArrayList<String> bnames = new ArrayList<>();
        ArrayList<Integer> bnum = new ArrayList<>();
        ArrayList<Integer> bwait = new ArrayList<>();
        ArrayList<Business> temp = new ArrayList<>();

        for (Business b : businesses) {
            if (b.getRange() < location && b.getType().equals(type)) {
                temp.add(b);
            }
        }

        if(sort.equals("Number of People")) {
            for (int i = 1; i < temp.size(); i++) {
                int current = temp.get(i).getNumCustomers();
                int j = i - 1;
                while(j >= 0 && current < temp.get(j).getNumCustomers()) {
                    temp.set(j+1, temp.get(j));
                    j--;
                }
                // at this point we've exited, so j is either -1
                // or it's at the first element where current >= a[j]
                temp.set(j+1, temp.get(i));
            }
        } else if(sort.equals("Wait Line Length")) {
            for (int i = 1; i < temp.size(); i++) {
                int current = temp.get(i).getNumWaiting();
                int j = i - 1;
                while(j >= 0 && current < temp.get(j).getNumWaiting()) {
                    temp.set(j+1, temp.get(j));
                    j--;
                }
                // at this point we've exited, so j is either -1
                // or it's at the first element where current >= a[j]
                temp.set(j+1, temp.get(i));
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
