package com.example.mfmoodandfeelingdiary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ChoseDateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose_date);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

    }
    public void onClickToDiary(View view){
        final EditText editTextDay = (EditText) findViewById(R.id.editTextNumber);
        final EditText editTextMonth = (EditText) findViewById(R.id.editTextNumber2);
        final EditText editTextYear = (EditText) findViewById(R.id.editTextNumber3);
        if(TextUtils.isEmpty(editTextDay.getText())){
            Toast toastTextDay = Toast.makeText(getApplicationContext(), "Введите день", Toast.LENGTH_SHORT);
            toastTextDay.show();
            return;
        }
        if(TextUtils.isEmpty(editTextMonth.getText())){
            Toast toastTextMonth = Toast.makeText(getApplicationContext(), "Введите месяц", Toast.LENGTH_SHORT);
            toastTextMonth.show();
            return;
        }
        if(TextUtils.isEmpty(editTextYear.getText())){
            Toast toastTextYear = Toast.makeText(getApplicationContext(), "Введите год", Toast.LENGTH_SHORT);
            toastTextYear.show();
            return;
        }



        else{
            int day = Integer.parseInt(editTextDay.getText().toString());
            int month = Integer.parseInt(editTextMonth.getText().toString());
            int year = Integer.parseInt(editTextYear.getText().toString());
            if (month > 12 || month <= 0) {
                Toast toastEmail = Toast.makeText(getApplicationContext(), "Неверный формат даты", Toast.LENGTH_SHORT);
                toastEmail.show();
                return;
            }
            if (day <= 0 || day > 32) {
                Toast toastEmail = Toast.makeText(getApplicationContext(), "Неверный формат даты", Toast.LENGTH_SHORT);
                toastEmail.show();
                return;
            }
            if (year <= 0 || year > 9999) {
                Toast toastEmail = Toast.makeText(getApplicationContext(), "Неверный формат даты", Toast.LENGTH_SHORT);
                toastEmail.show();
                return;
            }
            if (day > 29 && month == 2) {
                Toast toastEmail = Toast.makeText(getApplicationContext(), "Неверный формат даты", Toast.LENGTH_SHORT);
                toastEmail.show();
                return;
            }
            if (day > 30 && (month == 4 || month == 6 || month == 9 || month == 11)) {
                Toast toastEmail = Toast.makeText(getApplicationContext(), "Неверный формат даты", Toast.LENGTH_SHORT);
                toastEmail.show();
                return;
            }
            if (day > 31 && (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)) {
                Toast toastEmail = Toast.makeText(getApplicationContext(), "Неверный формат даты", Toast.LENGTH_SHORT);
                toastEmail.show();
                return;
            } else {
                String diarydate = day + "-" + month + "-" + year;
                Intent ToDiaryIntent = new Intent(this, DiaryActivity.class);
                ToDiaryIntent.putExtra("diarydate", diarydate);
                startActivity(ToDiaryIntent);
            }
        }
    }

    public void onClickToNavi(View view){

        Intent ToNaviIntent = new Intent(this, NavigationActivity.class);
        startActivity(ToNaviIntent);
        finish();
    }
}