package com.NhanNguyen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.NhanNguyen.model.Location;
import com.NhanNguyen.model.ModelCommom;
import com.NhanNguyen.model.OverviewInfo;
import com.NhanNguyen.model.VolleyResponseListener;
import com.NhanNguyen.service.VolleyService;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TabHost tabHost;
    TextView txtTotalInternaldeath, txtTotalInternalTreating, txtTotalInternalCases, txtTotalInternalRecovered;
    TextView txtTotalWorlddeath, txtTotalWorldTreating, txtTotalWorldCases, txtTotalWorldRecovered;

    TextView txtTodayInternaldeath, txtTodayInternalTreating, txtTodayInternalCases, txtTodayInternalRecovered;
    TextView txtTodayWorlddeath, txtTodayWorldTreating, txtTodayWorldCases, txtTodayWorldRecovered;
    
    ListView ls_overview, ls_location;
    ArrayList<OverviewInfo> overviewInfoArrayList = new ArrayList<>();
    ArrayList<Location> locations = new ArrayList<>();
    
    OverviewAdapter overviewAdapter;
    LocationAdapter locationAdapter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        addControls();
        addEvent();
    }

    private void addEvent() {
        Toast.makeText(MainActivity.this, "Đang tải dữ liệu  sử dụng volley", Toast.LENGTH_SHORT).show();
        useVolley();
    }

    private void useVolley() {
        VolleyService.getRequest(this, new VolleyResponseListener() {
            @Override
            public void onErro(String mesage) {

            }

            @Override
            public void onResponse(ModelCommom response) {

            }
        });
    }

    private void addControls() {
        txtTotalInternaldeath = findViewById(R.id.deathInternalTotal);
        txtTotalInternalTreating = findViewById(R.id.treatingInternalTotal);
        txtTotalInternalCases = findViewById(R.id.casesInternalTotal);
        txtTotalInternalRecovered = findViewById(R.id.recoveredInternalTotal);

        txtTotalWorlddeath = findViewById(R.id.deathWordTotal);
        txtTotalWorldTreating = findViewById(R.id.treatingWorldTotal);
        txtTotalWorldCases = findViewById(R.id.casesWorldTotal);
        txtTotalWorldRecovered = findViewById(R.id.recoveredWorldTotal);

        txtTodayInternaldeath = findViewById(R.id.deathTodayInternal);
        txtTodayInternalTreating = findViewById(R.id.treatingTodayInternal);
        txtTodayInternalCases = findViewById(R.id.casesTodayInternal);
        txtTodayInternalRecovered = findViewById(R.id.recoveredTodayInternal);

        txtTodayWorlddeath = findViewById(R.id.deathTodayWord);
        txtTodayWorldTreating = findViewById(R.id.treatingTodayWorld);
        txtTodayWorldCases = findViewById(R.id.casesTodayWorld);
        txtTodayWorldRecovered = findViewById(R.id.recoveredTodayWorld);

        ls_location = findViewById(R.id.ls_locations);
        ls_overview = findViewById(R.id.ls_overview);

        tabHost = findViewById(R.id.tabhosst);
        tabHost.setup();
        //Cài đặt cho tab theo tỉnh
        TabHost.TabSpec tabLocations = tabHost.newTabSpec("t1");
        tabLocations.setIndicator("Theo tỉnh");
        tabLocations.setContent(R.id.tabLocations);
        tabHost.addTab(tabLocations);

        //Cài đặt cho tab Hôm nay
        TabHost.TabSpec tabtoday = tabHost.newTabSpec("t2");
        tabtoday.setIndicator("Hôm nay");
        tabtoday.setContent(R.id.tabToday);
        tabHost.addTab(tabtoday);

        //Cài đặt cho tab Tổng quan
        TabHost.TabSpec tabOverview = tabHost.newTabSpec("t3");
        tabOverview.setIndicator("Tổng quan");
        tabOverview.setContent(R.id.tabOverview);
        tabHost.addTab(tabOverview);

        //Cài đặt cho tab Tổng
        TabHost.TabSpec tabTotal = tabHost.newTabSpec("t4");
        tabTotal.setIndicator("Tổng");
        tabTotal.setContent(R.id.tabTotal);
        tabHost.addTab(tabTotal);
    }
}