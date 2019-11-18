package com.example.matka_apuri;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SearchRecyclerViewAdapter extends RecyclerView.Adapter<SearchRecyclerViewAdapter.ViewHolder> {
    private ArrayList<SearchDataClass> mDataList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    void setOnItemClickListener(OnItemClickListener listener) { mListener = listener; }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImage;
        TextView mName;
        TextView mPrice;
        TextView mDistance;
        TextView mReview;

        public ViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            mImage = itemView.findViewById(R.id.searchCard_image);
            mName = itemView.findViewById(R.id.searchCard_name);
            mPrice = itemView.findViewById(R.id.searchCard_price);
            mDistance = itemView.findViewById(R.id.searchCard_distance);
            mReview = itemView.findViewById(R.id.searchCard_review);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });

        }
    }

    SearchRecyclerViewAdapter(ArrayList<SearchDataClass> mDataListArg) {
        mDataList = mDataListArg;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.searchrecyclerview_card, parent, false);
        return new ViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SearchDataClass currentItem = mDataList.get(position);

        holder.mImage.setImageBitmap(currentItem.getImage());
        holder.mName.setText(currentItem.getName());
        holder.mPrice.setText(currentItem.getPrice());
        holder.mDistance.setText(currentItem.getDistance());
        holder.mReview.setText(currentItem.getReview());
    }

    @Override
    public int getItemCount() { return mDataList.size(); }
}

