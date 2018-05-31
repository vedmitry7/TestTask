package com.vedmitryapps.chitest.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.vedmitryapps.chitest.Constants;
import com.vedmitryapps.chitest.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.current_start)
    TextView mCurrentStart;
    @BindView(R.id.previous_start)
    TextView mPreviousStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        SharedPreferences sharedPreferences = getSharedPreferences(Constants.PREFS, MODE_PRIVATE);
        int count = sharedPreferences.getInt(Constants.COUNT_KEY, 0);

        mCurrentStart.setText(sharedPreferences.getString(Constants.TIME_KEY + count, ""));
        mPreviousStart.setText(sharedPreferences.getString(Constants.TIME_KEY + (count-1), ""));
    }

    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
        startActivity(intent);
    }
}
