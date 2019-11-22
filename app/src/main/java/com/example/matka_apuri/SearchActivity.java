package com.example.matka_apuri;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private SearchRecyclerViewAdapter mAdapter;
    private ArrayList<SearchDataClass> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        dataList = new ArrayList<>();
        String search_name = getIntent().getStringExtra("search_name");
        TextView search_name_text = findViewById(R.id.search_name_text);
        search_name_text.setText(search_name);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Matkan haku");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        Bitmap hotel1 = BitmapFactory.decodeResource(getResources(), R.drawable.hotel1);
        Bitmap hotel2 = BitmapFactory.decodeResource(getResources(), R.drawable.hotel2);
        Bitmap hotel3 = BitmapFactory.decodeResource(getResources(), R.drawable.hotel3);
        SearchDataClass data;
        data = new SearchDataClass(hotel1, "Radisson Blu Royal Hotel Helsinki", "210 €", "0,9 km", "4,1");
        dataList.add(data);
        data = new SearchDataClass(hotel2, "Clarion Hotel Helsinki", "128 €", "2,0 km", "4,4");
        dataList.add(data);
        data = new SearchDataClass(hotel3, "Original Sokos Hotel Presidentti", "130 €", "0,7 km", "4,2");
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
        mRecyclerView = findViewById(R.id.searchRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mAdapter = new SearchRecyclerViewAdapter(dataList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new SearchRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(SearchActivity.this, "Painoit: " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
