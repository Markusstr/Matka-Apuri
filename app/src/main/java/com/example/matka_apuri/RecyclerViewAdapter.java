package com.example.matka_apuri;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<RecyclerViewDataClass> mDataList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
        void onCloseClick(int position);
    }

    void setOnItemClickListener(OnItemClickListener listener) { mListener = listener; }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImage;
        ImageButton mClose;
        TextView mName;
        TextView mInfo;

        public ViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            mImage = itemView.findViewById(R.id.card_image);
            mClose = itemView.findViewById(R.id.card_closeButton);
            mName = itemView.findViewById(R.id.card_name);
            mInfo = itemView.findViewById(R.id.card_info);

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

            mClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onCloseClick(position);
                        }
                    }
                }
            });
        }
    }

    RecyclerViewAdapter(ArrayList<RecyclerViewDataClass> mDataListArg) {
        mDataList = mDataListArg;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_card, parent, false);
        return new ViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RecyclerViewDataClass currentItem = mDataList.get(position);

        if (currentItem.isClose()) {
            holder.mClose.setVisibility(View.VISIBLE);
        }
        else {
            holder.mClose.setVisibility(View.INVISIBLE);
        }

        //holder.mImage
        holder.mName.setText(currentItem.getName());
        holder.mInfo.setText(currentItem.getInfo());

    }

    @Override
    public int getItemCount() { return mDataList.size(); }
}
