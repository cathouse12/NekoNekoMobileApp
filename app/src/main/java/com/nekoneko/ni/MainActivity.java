package com.nekoneko.ni;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNekoRecyclerView = findViewById(R.id.mNekoRecyclerView);

        mNekoLayoutManger = new LinearLayoutManager(getApplicationContext());
        mNekoRecyclerView.setLayoutManager(mNekoLayoutManger);

        mNekoAdapter = new NekoAdapter();

        mNekoRecyclerView.setAdapter(mNekoAdapter);
    }

    public void addButtonClicked(View view){
        Intent intent = new Intent(getApplicationContext(),MapActivity.class);
        startActivity(intent,g);
    }
}
