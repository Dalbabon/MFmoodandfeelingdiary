package com.example.mfmoodandfeelingdiary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class CalendarActivity extends AppCompatActivity {

    CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        long date = System.currentTimeMillis();
        TextView tv = (TextView) findViewById(R.id.textViewMounth2);
        SimpleDateFormat sdf1 = new SimpleDateFormat("LLLL: dd");
        String sdf = sdf1.format(date);
        String dateString1 = sdf.substring(0,1).toUpperCase();
        String dateString = dateString1 + sdf.substring(1);
        tv.setText(dateString);

        SimpleDateFormat diarydate1 = new SimpleDateFormat("dd-MM-yyyy");
        TextView diarydatetv =(TextView) findViewById(R.id.textView14);
        String diarydate = diarydate1.format(date);
        diarydatetv.setText(diarydate);

        calendarView = (CalendarView) findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String diarydate1 = i2 + "-" + (i1 + 1) + "-" + i;
                TextView diarydatetv =(TextView) findViewById(R.id.textView14);
                diarydatetv.setText(diarydate1);
            }
        });
    }

    public void onClickDiary(View view){

        TextView diarydatetv = findViewById(R.id.textView14);
        String diarydate = diarydatetv.getText().toString();

        Intent ToDiaryIntent = new Intent(this, DiaryActivity.class);
        ToDiaryIntent.putExtra("diarydate", diarydate);
        startActivity(ToDiaryIntent);

    }

    public void onClickToMain(View view){
        Intent ToMainInintent = new Intent(this, MainActivity.class);
        startActivity(ToMainInintent);
    }

}