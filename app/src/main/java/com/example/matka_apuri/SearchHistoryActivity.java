package com.example.matka_apuri;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchHistoryActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private SearchHistoryRecyclerViewAdapter mAdapter;
    private ArrayList<RecyclerViewDataClass> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_history);

        dataList = new ArrayList<>();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Aiemmat haut");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        Bitmap helsinki = BitmapFactory.decodeResource(getResources(), R.drawable.helsinki);
        Bitmap joensuu = BitmapFactory.decodeResource(getResources(), R.drawable.joensuu);
        Bitmap lappeenranta = BitmapFactory.decodeResource(getResources(), R.drawable.lappeenranta);
        Bitmap savonlinna = BitmapFactory.decodeResource(getResources(), R.drawable.savonlinna);

        RecyclerViewDataClass data;
        data = new RecyclerViewDataClass(joensuu, true, "Joensuu", "-1°C", "220km");
        dataList.add(data);
        data = new RecyclerViewDataClass(helsinki, true, "Helsinki", "2°C", "195km");
        dataList.add(data);
        data = new RecyclerViewDataClass(savonlinna, true, "Savonlinna", "0°C", "140km");
        dataList.add(data);
        data = new RecyclerViewDataClass(lappeenranta, true, "Lappeenranta", "1°C", "35km");
        dataList.add(data);
        data = new RecyclerViewDataClass(joensuu, true, "Joensuu", "-1°C", "220km");
        dataList.add(data);
        data = new RecyclerViewDataClass(joensuu, true, "Joensuu", "-1°C", "220km");
        dataList.add(data);
        data = new RecyclerViewDataClass(helsinki, true, "Helsinki", "2°C", "195km");
        dataList.add(data);
        data = new RecyclerViewDataClass(savonlinna, true, "Savonlinna", "0°C", "140km");
        dataList.add(data);
        data = new RecyclerViewDataClass(lappeenranta, true, "Lappeenranta", "1°C", "35km");
        dataList.add(data);
        data = new RecyclerViewDataClass(joensuu, true, "Joensuu", "-1°C", "220km");
        dataList.add(data);

        buildRecyclerView();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
        }
        return true;
    }

    public void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.searchHistoryRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mAdapter = new SearchHistoryRecyclerViewAdapter(dataList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new SearchHistoryRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

            }

            @Override
            public void onCloseClick(int position) {
                dataList.remove(position);
                mAdapter.notifyItemRemoved(position);
            }
        });
    }
}
