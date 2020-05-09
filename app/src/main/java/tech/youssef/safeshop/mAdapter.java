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

import java.util.ArrayList;

public class mAdapter extends RecyclerView.Adapter<mAdapter.ViewHolder> {

    private ArrayList<String> businessNames = new ArrayList<>();
    private Context mContext;

    public mAdapter(ArrayList<String> businessNames, Context context) {
        this.businessNames = businessNames;
        mContext = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.market_list_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.itemName.setText(mItemNames.get(i));
        viewHolder.itemPrice.setText(mItemPrices.get(i)+"");
    }

    @Override
    public int getItemCount() {
        return businessNames.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView businessName;
        ImageView businessIcon;
        RelativeLayout parentLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.itemName);
            itemPrice = itemView.findViewById(R.id.itemPrice);
            parentLayout = itemView.findViewById(R.id.marketItemLayout);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }
}