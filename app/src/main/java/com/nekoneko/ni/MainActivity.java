package com.nekoneko.ni;

import android.Manifest;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.view.View;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private RecyclerView mNekoRecyclerView;
    private RecyclerView.Adapter mNekoAdapter;
    private RecyclerView.LayoutManager mNekoLayoutManger;

    private Button mAddNekoButton;

    public static final int REQUEST_CODE_MAIN = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //뷰 정의하기
        mNekoRecyclerView = findViewById(R.id.mNekoRecyclerView);
        mAddNekoButton = findViewById(R.id.mAddNekoButton);

        //mNekoLayoutManger 설정하기
        mNekoLayoutManger = new LinearLayoutManager(getApplicationContext());
        mNekoRecyclerView.setLayoutManager(mNekoLayoutManger);

        //mNekoAdapter 설정하기
        mNekoAdapter = new NekoAdapter();
        mNekoRecyclerView.setAdapter(mNekoAdapter);

        //버튼 리스너 등록하기
        mAddNekoButton.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Log.d(TAG, "Button Clicked");

                //Location Manager 객체 가져오기
                LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

                //위치 퍼미션 체크하기
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                        && ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                    Log.d(TAG,"MapActivity");

                    //가장 최근의 위치정보 가져오기
                    Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

                    //인텐트 준비하기
                    Intent intent = new Intent(getApplicationContext(), MapActivity.class);

                    intent.putExtra("longitude", location.getLongitude());  //위도 가져오기
                    intent.putExtra("latitude", location.getLatitude());    //경도 가져오기

                    //MapActivity로 화면 전환하기
                    startActivityForResult(intent,REQUEST_CODE_MAIN);
                }
            }
        });
    }
}
