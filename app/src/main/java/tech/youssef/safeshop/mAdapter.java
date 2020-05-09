package tech.youssef.safeshop;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class mAdapter extends RecyclerView.Adapter<mAdapter.ViewHolder> {

    private ArrayList<String> businessNames = new ArrayList<>();
    private ArrayList<Integer> numPeople = new ArrayList<>();
    private ArrayList<Integer> waitLines = new ArrayList<>();
    private Context mContext;

    public mAdapter(ArrayList<String> businessNames, ArrayList<Integer> numPeople, ArrayList<Integer> waitLines, Context context) {
        this.businessNames = businessNames;
        this.numPeople = numPeople;
        this.waitLines = waitLines;
        mContext = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.business_element, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.businessName.setText(businessNames.get(i));
        viewHolder.numPeople.setText(numPeople.get(i));
        viewHolder.waitLine.setText(waitLines.get(i));
    }

    @Override
    public int getItemCount() {
        return businessNames.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView businessName;
        TextView numPeople;
        TextView waitLine;
        RelativeLayout parentLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            businessName = itemView.findViewById(R.id.businessNameLabel);
            numPeople = itemView.findViewById(R.id.numPeopleLabel);
            waitLine = itemView.findViewById(R.id.numWaitingLabel);
            parentLayout = itemView.findViewById(R.id.business_element_layout);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }
}