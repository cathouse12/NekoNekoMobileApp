package com.nekoneko.ni;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private double mInitialLongitude;
    private double mInitialLatitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //처음 줌 인(Zoom In)할 위도와 경도를 가져온다
        mInitialLongitude = getIntent().getDoubleExtra("longitude",0);
        mInitialLatitude = getIntent().getDoubleExtra("latitude", 0);

        //프래그먼트 세팅하기
        FragmentManager fragmentManager = getFragmentManager();
        MapFragment mapFragment = (MapFragment) fragmentManager.findFragmentById(R.id.mMapFragment);

        //mapFragment 준비 완료 시 발생할 콜백 함수 설정
        mapFragment.getMapAsync(this);

//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("message");
//
//        myRef.setValue("Hello, World!");
//
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                String value = dataSnapshot.getValue(String.class);
//                Log.d(TAG, "Value is: " + value);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                Log.w(TAG, "Failed to read Value.", databaseError.toException());
//            }
//        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        //처음 줌 인(Zoom in)할 위도와 경도 설정하기
        LatLng SEOUL = new LatLng(mInitialLongitude,mInitialLatitude);

        //처음 설정한 위치 좌표로 카메라 이동하기
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(100));

//        MarkerOptions markerOptions = new MarkerOptions();
//        markerOptions.position(SEOUL);
//        markerOptions.title("서울");
//        markerOptions.snippet("한국의 수도");
//
//        googleMap.addMarker(markerOptions);
    }
}
