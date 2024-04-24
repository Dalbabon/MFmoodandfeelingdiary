package com.example.mfmoodandfeelingdiary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class NavigationActivity extends AppCompatActivity {

    String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference usersRef = rootRef.child("Users");
    DatabaseReference current_userRef = usersRef.child(uid);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        ValueEventListener nameListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                TextView tvfn = (TextView) findViewById(R.id.textViewAccName);
                TextView tvln = (TextView) findViewById(R.id.textViewAccName2);

                String fname = dataSnapshot.child("fname").getValue(String.class);
                String lname = dataSnapshot.child("lname").getValue(String.class);

                tvfn.setText(fname);
                tvln.setText(lname);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }

        };
        current_userRef.addListenerForSingleValueEvent(nameListener);

    }


    public void onClickToMain(View view){

        Intent ToMainIntent = new Intent(this, MainActivity.class);
        startActivity(ToMainIntent);

    }

    public void onClickToChDate(View view){

        Intent ToChDateIntent = new Intent(this, ChoseDateActivity.class);
        startActivity(ToChDateIntent);
    }

    public void onClickToCharts(View view){

        Intent ToChartsIntent = new Intent(this, ChartsActivity.class);
        startActivity(ToChartsIntent);
    }

    public void onClickToAbout(View view){

        Intent ToAboutIntent = new Intent(this, AboutUsActivity.class);
        startActivity(ToAboutIntent);
    }

    public void onClickLogOut(View view){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(NavigationActivity.this, LogInActivity.class));
        finish();
    }

}