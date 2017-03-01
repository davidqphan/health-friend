package com.helpfool.healthfriend;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {
    enum days {SU, M, T, W, TH, F, S};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Center action bar text
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);

        Intent intro_intent = new Intent(this, IntroActivity.class);
        startActivity(intro_intent);

        BarChart chart = (BarChart) findViewById(R.id.chart);

        int dayStats[] = {40, 80, 60, 89, 98, 45, 42};

        List<BarEntry> entries = new ArrayList<>();
        for (int i = 0; i < dayStats.length; i++) {
            entries.add(new BarEntry(i, dayStats[i]));
        }

        BarDataSet set = new BarDataSet(entries, "BarDataSet");
        set.setColor(ContextCompat.getColor(this, R.color.colorPrimary));

        BarData data = new BarData(set);
        data.setBarWidth(0.6f); // set custom bar width
        data.setDrawValues(false);

        chart.setData(data);
        chart.setFitBars(true); // make the x-axis fit exactly all bars
        chart.getAxisLeft().setTextColor(ContextCompat.getColor(this, R.color.colorBlackLight));
        chart.getAxisLeft().setAxisMinimum(0);
        chart.getAxisLeft().setAxisMaximum(100);
        chart.getAxisLeft().setLabelCount(2);
        chart.getAxisLeft().setDrawAxisLine(false);
        chart.getAxisRight().setDrawAxisLine(false);
        chart.getLegend().setEnabled(false);
        chart.getAxisRight().setEnabled(false);
        chart.setDrawGridBackground(false);
        chart.getXAxis().setDrawGridLines(false);
        chart.setScaleXEnabled(false);
        chart.setScaleYEnabled(false);
        chart.setPinchZoom(false);
        chart.getDescription().setEnabled(false);
        chart.getXAxis().setTextSize(12);
        chart.getXAxis().setTextColor(ContextCompat.getColor(this, R.color.colorBlackLight));

        String[] values = new String[] {"S","M","T","W","TH","F","S"};
        chart.getXAxis().setValueFormatter(new GraphXAxisValueFormatter(values));

        chart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        chart.setHighlightPerDragEnabled(false);
        chart.setHighlightPerTapEnabled(false);

        chart.invalidate(); // refresh

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
                return true;
        }
        return false;
    }
}
