package com.example.matka_apuri;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerViewAdapter mAdapter;
    private RecyclerViewAdapter mAdapter2;
    private ArrayList<RecyclerViewDataClass> dataList;
    private ArrayList<RecyclerViewDataClass> dataList2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton search_calendar = findViewById(R.id.search_calendar);
        Button search_button = findViewById(R.id.search_button);
        final EditText search_edittext = findViewById(R.id.search_edittext);
        TextView searchHistoryShowAll = findViewById(R.id.searchHistoryShowAll);

        dataList = new ArrayList<>();
        dataList2 = new ArrayList<>();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        search_calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePicker = new DatePickerDialog(MainActivity.this);
                datePicker.show();
            }
        });
        navigationView.setCheckedItem(R.id.nav_search);
        RecyclerViewDataClass data;

        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SearchActivity.class);
                intent.putExtra("search_name", search_edittext.getText().toString());
                startActivity(intent);
            }
        });

        searchHistoryShowAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SearchHistoryActivity.class);
                startActivity(intent);
            }
        });

        Bitmap helsinki = BitmapFactory.decodeResource(getResources(), R.drawable.helsinki);
        Bitmap joensuu = BitmapFactory.decodeResource(getResources(), R.drawable.joensuu);
        Bitmap lappeenranta = BitmapFactory.decodeResource(getResources(), R.drawable.lappeenranta);
        Bitmap savonlinna = BitmapFactory.decodeResource(getResources(), R.drawable.savonlinna);

        data = new RecyclerViewDataClass(joensuu, true, "Joensuu", "-1°C", "220km");
        dataList.add(data);
        data = new RecyclerViewDataClass(savonlinna, true, "Savonlinna", "0°C", "140km");
        dataList.add(data);
        data = new RecyclerViewDataClass(helsinki, true, "Helsinki", "2°C", "195km");
        dataList.add(data);
        data = new RecyclerViewDataClass(lappeenranta, true, "Lappeenranta", "1°C", "35km");
        dataList.add(data);
        data = new RecyclerViewDataClass(joensuu, true, "Joensuu", "-1°C", "220km");
        dataList.add(data);

        data = new RecyclerViewDataClass(lappeenranta, true, "Lappeenranta", "1°C", "35km");
        dataList2.add(data);
        data = new RecyclerViewDataClass(helsinki, true, "Helsinki", "2°C", "195km");
        dataList2.add(data);
        data = new RecyclerViewDataClass(joensuu, true, "Joensuu", "-1°C", "220km");
        dataList2.add(data);
        data = new RecyclerViewDataClass(savonlinna, true, "Savonlinna", "0°C", "140km");
        dataList2.add(data);
        data = new RecyclerViewDataClass(helsinki, true, "Helsinki", "2°C", "195km");
        dataList2.add(data);


        buildRecyclerView();
        buildRecyclerView2();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == R.id.nav_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        }
        if (id == R.id.nav_earliersearch) {
            Intent intent = new Intent(this, SearchHistoryActivity.class);
            startActivity(intent);
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.earlierSearchRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mAdapter = new RecyclerViewAdapter(dataList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(MainActivity.this, "Painoit: " + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCloseClick(int position) {
                dataList.remove(position);
                mAdapter.notifyItemRemoved(position);
            }
        });
    }

    public void buildRecyclerView2() {
        mRecyclerView = findViewById(R.id.favoriteRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mAdapter2 = new RecyclerViewAdapter(dataList2);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter2);

        mAdapter2.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(MainActivity.this, "Painoit: " + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCloseClick(int position) {
                dataList2.remove(position);
                mAdapter2.notifyItemRemoved(position);
            }
        });
    }
}

