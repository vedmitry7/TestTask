package com.vedmitryapps.chitest.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.vedmitryapps.chitest.Constants;
import com.vedmitryapps.chitest.R;
import com.vedmitryapps.chitest.adapters.HistoryRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoryActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ButterKnife.bind(this);

        SharedPreferences sharedPreferences = getSharedPreferences(Constants.PREFS, MODE_PRIVATE);
        int count = sharedPreferences.getInt(Constants.COUNT_KEY, 0);

        List<String> times = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            times.add(sharedPreferences.getString(Constants.TIME_KEY + i, ""));
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new HistoryRecyclerAdapter(times));

    }
}
