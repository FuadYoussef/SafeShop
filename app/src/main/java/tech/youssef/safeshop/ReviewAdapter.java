package tech.youssef.safeshop;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ViewHolder> {

    private ArrayList<String> reviews = new ArrayList<>();
    private Context mContext;

    public ReviewAdapter(ArrayList<String> reviews, Context context) {
        this.reviews = reviews;
        mContext = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.review_element, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.reviewContent.setText(reviews.get(i));
    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView reviewContent;
        ConstraintLayout parentLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            reviewContent = itemView.findViewById(R.id.reviewContentInList);
            parentLayout = itemView.findViewById(R.id.review_element_layout);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            /*
            Intent reviewIntent = new Intent(view.getContext(), ShowReviewActivity.class);
            reviewIntent.putExtra("name", reviewContent.getText());
            System.out.println(reviewContent.getText().toString());
            view.getContext().startActivity(reviewIntent);
             */
        }
    }
}