package com.e.ar_interview.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.e.ar_interview.R;
import com.e.ar_interview.adpater.CityDetailsItemAapter;
import com.e.ar_interview.model.CityData;
import com.e.ar_interview.view_models.CityDetailsViewModel;

/**
 * Created by shalvi on 9/2/2019.
 */
public class CityDetailsListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CityDetailsItemAapter adapter;
    CityDetailsViewModel model;
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_main);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        model = ViewModelProviders.of(this).get(CityDetailsViewModel.class);
        mDecelaration();
        getRcyclerData();

    }



    public void   mDecelaration(){
        recyclerView = findViewById(R.id.recyclerview);
        swipeRefreshLayout=findViewById(R.id.swipRefresh);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getRcyclerData();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

    }

    //define method for observer
    public void getRcyclerData(){

        model.getCityDetails().observe(this, new Observer<CityData>() {
            @Override
            public void onChanged(CityData cityData) {
                ((TextView) findViewById(R.id.txtTitle_Toolbar)).setText(cityData.getTitle());
                adapter = new CityDetailsItemAapter(CityDetailsListActivity.this, cityData.getRows());
                recyclerView.setAdapter(adapter);
            }
        });
    }
}
