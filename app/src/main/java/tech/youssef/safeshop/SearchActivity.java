package tech.youssef.safeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SearchActivity extends AppCompatActivity {
    Spinner typeSpinner;
    Spinner locationSpinner;
    Spinner sortSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        typeSpinner = (Spinner) findViewById(R.id.typeSpinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> typeAdapter = ArrayAdapter.createFromResource(this,
                R.array.store_type_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        typeSpinner.setAdapter(typeAdapter);

        locationSpinner = (Spinner) findViewById(R.id.locationSpinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> locationAdapter = ArrayAdapter.createFromResource(this,
                R.array.store_location_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        locationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        locationSpinner.setAdapter(locationAdapter);

        sortSpinner = (Spinner) findViewById(R.id.sortBySpinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> sortAdapter = ArrayAdapter.createFromResource(this,
                R.array.sort_by_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        sortAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        sortSpinner.setAdapter(sortAdapter);
    }

    @Override
    public void onBackPressed() {
        return;
    }

    public void search(View view) {
        String type = typeSpinner.getSelectedItem().toString();
        int location = Integer.parseInt(locationSpinner.getSelectedItem().toString());
        String sort = sortSpinner.getSelectedItem().toString();
        Intent intent = new Intent(this, DisplayResultsActivity.class);
        intent.putExtra("type", type);
        intent.putExtra("location", location);
        intent.putExtra("sort", sort);
        startActivity(intent);
    }
}
