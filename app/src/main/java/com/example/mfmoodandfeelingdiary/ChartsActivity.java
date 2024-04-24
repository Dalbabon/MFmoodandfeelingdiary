package com.example.mfmoodandfeelingdiary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class ChartsActivity extends AppCompatActivity {

    private BarChart chart;

    String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference usersRef = rootRef.child("Users");
    DatabaseReference current_userRef = usersRef.child(uid);

    int MonMood = 0;
    int TueMood = 0;
    int WedMood = 0;
    int ThuMood = 0;
    int FriMood = 0;
    int SatMood = 0;
    int SunMood = 0;
    int MoodMonth = 0;
    int MoodYear = 0;
    int i = 1;
    int j = 1;

    int countJanuary;
    int countFebruary;
    int countMarch;
    int countApril;
    int countMay;
    int countJune;
    int countJuly;
    int countAugust;
    int countSeptember;
    int countOctober;
    int countNovember;
    int countDecember;

    int sumJunuary;
    int sumFebruary;
    int sumMarch;
    int sumApril;
    int sumMay;
    int sumJune;
    int sumJuly;
    int sumAugust;
    int sumSeptember;
    int sumOctober;
    int sumNovember;
    int sumDecember;

    int averJunuary;
    int averFebruary;
    int averMarch;
    int averApril;
    int averMay;
    int averJune;
    int averJuly;
    int averAugust;
    int averSeptember;
    int averOctober;
    int averNovember;
    int averDecember;



    ArrayList<BarEntry> entriesMonth = new ArrayList<>();
    ArrayList<String> labelsMonth = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charts);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        chart = findViewById(R.id.chart);
        ArrayList<BarEntry> entriesNull = new ArrayList<>();
        entriesNull.add(new BarEntry(1, 0));
        entriesNull.add(new BarEntry(2, 0));
        entriesNull.add(new BarEntry(3, 0));
        entriesNull.add(new BarEntry(4, 0));
        entriesNull.add(new BarEntry(5, 0));
        entriesNull.add(new BarEntry(6, 0));
        entriesNull.add(new BarEntry(7, 0));

        BarDataSet datasetNull = new BarDataSet(entriesNull, "График настроения");

        BarData chart1 = new BarData(datasetNull);
        chart.setData(chart1);

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case -1:
                        Toast.makeText(getApplicationContext(), "Ничего не выбрано",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton2: // Неделя

                        MonMood = 0;
                        TueMood = 0;
                        WedMood = 0;
                        ThuMood = 0;
                        FriMood = 0;
                        SatMood = 0;
                        SunMood = 0;

                        final EditText editDDateDay = (EditText) findViewById(R.id.editTextDate);
                        final EditText editDDateMonth = (EditText) findViewById(R.id.editTextDate2);
                        final EditText editDDateYear = (EditText) findViewById(R.id.editTextDate3);
                        SimpleDateFormat chosendateformat = new SimpleDateFormat("dd-MM-yyyy");
                        String date = editDDateDay.getText().toString()+"-" + editDDateMonth.getText().toString()+"-" + editDDateYear.getText().toString();

                        try {

                            Date chosendate = chosendateformat.parse(date);
                            Calendar chosencal = Calendar.getInstance();
                            chosencal.setTime(chosendate);

                            chosencal.set(Calendar.DAY_OF_WEEK, 2); // Понедельник

                            int year1 = chosencal.get(Calendar.YEAR);
                            int month1 = chosencal.get(Calendar.MONTH)+1;
                            int day1 = chosencal.get(Calendar.DAY_OF_MONTH);

                            chosencal.set(Calendar.DAY_OF_WEEK, 3); // Вторник

                            int year2 = chosencal.get(Calendar.YEAR);
                            int month2 = chosencal.get(Calendar.MONTH)+1;
                            int day2 = chosencal.get(Calendar.DAY_OF_MONTH);

                            chosencal.set(Calendar.DAY_OF_WEEK, 4); // Среда

                            int year3 = chosencal.get(Calendar.YEAR);
                            int month3 = chosencal.get(Calendar.MONTH)+1;
                            int day3 = chosencal.get(Calendar.DAY_OF_MONTH);

                            chosencal.set(Calendar.DAY_OF_WEEK, 5); // Четверг

                            int year4 = chosencal.get(Calendar.YEAR);
                            int month4 = chosencal.get(Calendar.MONTH)+1;
                            int day4 = chosencal.get(Calendar.DAY_OF_MONTH);

                            chosencal.set(Calendar.DAY_OF_WEEK, 6); // Пятница

                            int year5 = chosencal.get(Calendar.YEAR);
                            int month5 = chosencal.get(Calendar.MONTH)+1;
                            int day5 = chosencal.get(Calendar.DAY_OF_MONTH);

                            chosencal.set(Calendar.DAY_OF_WEEK, 7); // Суббота

                            int year6 = chosencal.get(Calendar.YEAR);
                            int month6 = chosencal.get(Calendar.MONTH)+1;
                            int day6 = chosencal.get(Calendar.DAY_OF_MONTH);

                            chosencal.set(Calendar.DAY_OF_WEEK, 1); // Восресенье

                            int year7 = chosencal.get(Calendar.YEAR);
                            int month7 = chosencal.get(Calendar.MONTH)+1;
                            int day7 = chosencal.get(Calendar.DAY_OF_MONTH);

                            String monday = day1 + "-" + month1 + "-" + year1;
                            String tuesday = day2 + "-" + month2 + "-" + year2;
                            String wednesday = day3 + "-" + month3 + "-" + year3;
                            String thursday = day4 + "-" + month4 + "-" + year4;
                            String friday = day5 + "-" + month5 + "-" + year5;
                            String saturday = day6 + "-" + month6 + "-" + year6;
                            String sunday = day7 + "-" + month7 + "-" + year7;




                            ValueEventListener nameListener = new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    if(dataSnapshot.child("diarymood").hasChild(monday)) {

                                        String savedMood = dataSnapshot.child("diarymood").child(monday).getValue(String.class);

                                        if(savedMood.equals("Crazy")){
                                            MonMood = 6;
                                        }
                                        if(savedMood.equals( "VHappy")){
                                            MonMood = 5;
                                        }
                                        if(savedMood.equals("Happy")){
                                            MonMood = 4;
                                        }
                                        if(savedMood.equals("Bewilderment")){
                                            MonMood = 3;
                                        }
                                        if(savedMood.equals("Sad")){
                                            MonMood = 2;
                                        }
                                        if(savedMood.equals("Crying")){
                                            MonMood = 1;
                                        }
                                    }
                                    if(dataSnapshot.child("diarymood").hasChild(tuesday)) {

                                        String savedMood = dataSnapshot.child("diarymood").child(tuesday).getValue(String.class);

                                        if(savedMood.equals("Crazy")){
                                            TueMood = 6;
                                        }
                                        if(savedMood.equals( "VHappy")){
                                            TueMood = 5;
                                        }
                                        if(savedMood.equals("Happy")){
                                            TueMood = 4;
                                        }
                                        if(savedMood.equals("Bewilderment")){
                                            TueMood = 3;
                                        }
                                        if(savedMood.equals("Sad")){
                                            TueMood = 2;
                                        }
                                        if(savedMood.equals("Crying")){
                                            TueMood = 1;
                                        }
                                    }
                                    if(dataSnapshot.child("diarymood").hasChild(wednesday)) {

                                        String savedMood = dataSnapshot.child("diarymood").child(wednesday).getValue(String.class);

                                        if(savedMood.equals("Crazy")){
                                            WedMood = 6;
                                        }
                                        if(savedMood.equals( "VHappy")){
                                            WedMood = 5;
                                        }
                                        if(savedMood.equals("Happy")){
                                            WedMood = 4;
                                        }
                                        if(savedMood.equals("Bewilderment")){
                                            WedMood = 3;
                                        }
                                        if(savedMood.equals("Sad")){
                                            WedMood = 2;
                                        }
                                        if(savedMood.equals("Crying")){
                                            WedMood = 1;
                                        }

                                    }
                                    if(dataSnapshot.child("diarymood").hasChild(thursday)) {

                                        String savedMood = dataSnapshot.child("diarymood").child(thursday).getValue(String.class);

                                        if(savedMood.equals("Crazy")){
                                            ThuMood = 6;
                                        }
                                        if(savedMood.equals( "VHappy")){
                                            ThuMood = 5;
                                        }
                                        if(savedMood.equals("Happy")){
                                            ThuMood = 4;
                                        }
                                        if(savedMood.equals("Bewilderment")){
                                            ThuMood = 3;
                                        }
                                        if(savedMood.equals("Sad")){
                                            ThuMood = 2;
                                        }
                                        if(savedMood.equals("Crying")){
                                            ThuMood = 1;
                                        }

                                    }
                                    if(dataSnapshot.child("diarymood").hasChild(friday)) {

                                        String savedMood = dataSnapshot.child("diarymood").child(friday).getValue(String.class);

                                        if(savedMood.equals("Crazy")){
                                            FriMood = 6;
                                        }
                                        if(savedMood.equals( "VHappy")){
                                            FriMood = 5;
                                        }
                                        if(savedMood.equals("Happy")){
                                            FriMood = 4;
                                        }
                                        if(savedMood.equals("Bewilderment")){
                                            FriMood = 3;
                                        }
                                        if(savedMood.equals("Sad")){
                                            FriMood = 2;
                                        }
                                        if(savedMood.equals("Crying")){
                                            FriMood = 1;
                                        }

                                    }
                                    if(dataSnapshot.child("diarymood").hasChild(saturday)) {

                                        String savedMood = dataSnapshot.child("diarymood").child(saturday).getValue(String.class);

                                        if(savedMood.equals("Crazy")){
                                            SatMood = 6;
                                        }
                                        if(savedMood.equals( "VHappy")){
                                            SatMood = 5;
                                        }
                                        if(savedMood.equals("Happy")){
                                            SatMood = 4;
                                        }
                                        if(savedMood.equals("Bewilderment")){
                                            SatMood = 3;
                                        }
                                        if(savedMood.equals("Sad")){
                                            SatMood = 2;
                                        }
                                        if(savedMood.equals("Crying")){
                                            SatMood = 1;
                                        }

                                    }
                                    if(dataSnapshot.child("diarymood").hasChild(sunday)) {

                                        String savedMood = dataSnapshot.child("diarymood").child(sunday).getValue(String.class);

                                        if(savedMood.equals("Crazy")){
                                            SunMood = 6;
                                        }
                                        if(savedMood.equals( "VHappy")){
                                            SunMood = 5;
                                        }
                                        if(savedMood.equals("Happy")){
                                            SunMood = 4;
                                        }
                                        if(savedMood.equals("Bewilderment")){
                                            SunMood = 3;
                                        }
                                        if(savedMood.equals("Sad")){
                                            SunMood = 2;
                                        }
                                        if(savedMood.equals("Crying")){
                                            SunMood = 1;
                                        }

                                    }

                                    chart = findViewById(R.id.chart);
                                    ArrayList<BarEntry> entriesWeek = new ArrayList<>();
                                    entriesWeek.add(new BarEntry(1, MonMood));
                                    entriesWeek.add(new BarEntry(2, TueMood));
                                    entriesWeek.add(new BarEntry(3, WedMood));
                                    entriesWeek.add(new BarEntry(4, ThuMood));
                                    entriesWeek.add(new BarEntry(5, FriMood));
                                    entriesWeek.add(new BarEntry(6, SatMood));
                                    entriesWeek.add(new BarEntry(7, SunMood));

                                    BarDataSet datasetWeek = new BarDataSet(entriesWeek, "График настроения");

                                    ArrayList<String> labelsWeek = new ArrayList<String>();
                                    labelsWeek.add("");
                                    labelsWeek.add("Пн");
                                    labelsWeek.add("Вт");
                                    labelsWeek.add("Ср");
                                    labelsWeek.add("Чт");
                                    labelsWeek.add("Пт");
                                    labelsWeek.add("Сб");
                                    labelsWeek.add("Вс");
                                    chart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(labelsWeek));


                                    datasetWeek.setColor(Color.parseColor("#2C88BA"));

                                    chart.animateY(500);

                                    BarData data = new BarData(datasetWeek);
                                    chart.setData(data);

                                    chart.invalidate();

                                }


                                @Override
                                public void onCancelled(DatabaseError databaseError) {
                                }
                            };
                            current_userRef.addListenerForSingleValueEvent(nameListener);


                        } catch (ParseException e) {
                            e.printStackTrace();
                        }




                        break;
                    case R.id.radioButton3: // Месяц

                        final EditText editDDateDayMonth = (EditText) findViewById(R.id.editTextDate);
                        final EditText editDDateMonthMonth = (EditText) findViewById(R.id.editTextDate2);
                        final EditText editDDateYearMonth = (EditText) findViewById(R.id.editTextDate3);
                        SimpleDateFormat chosendateformatMonth = new SimpleDateFormat("dd-MM-yyyy");
                        String dateMonth = editDDateDayMonth.getText().toString()+"-" + editDDateMonthMonth.getText().toString()+"-" + editDDateYearMonth.getText().toString();

                        try {

                            Date chosendate = chosendateformatMonth.parse(dateMonth);
                            Calendar chosencal = Calendar.getInstance();
                            chosencal.setTime(chosendate);


                            String[] arrayDayOfMonth =  new String[32];
                            int[] arrayMoodMonth = new int[33];
                            ValueEventListener nameListener = new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {


                                    labelsMonth.add("");

                                    for (i = 1; i<32; i++) {
                                        chosencal.set(Calendar.DAY_OF_MONTH, i);

                                        int yearMon = chosencal.get(Calendar.YEAR);
                                        int monthMon = chosencal.get(Calendar.MONTH) + 1;
                                        int dayMon = chosencal.get(Calendar.DAY_OF_MONTH);

                                        String DayOfMonth = dayMon + "-" + monthMon + "-" + yearMon;

                                        String LabesMonth = dayMon + "-" + monthMon;

                                        arrayDayOfMonth[i] = DayOfMonth;


                                        labelsMonth.add(LabesMonth);




                                        if (dataSnapshot.child("diarymood").hasChild(DayOfMonth)) {

                                            String arraySavedMood = dataSnapshot.child("diarymood").child(DayOfMonth).getValue(String.class);
                                            if (arraySavedMood.equals("Crazy")) {
                                                MoodMonth = 6;
                                            }
                                            if (arraySavedMood.equals("VHappy")) {
                                                MoodMonth = 5;
                                            }
                                            if (arraySavedMood.equals("Happy")) {
                                                MoodMonth = 4;
                                            }
                                            if (arraySavedMood.equals("Bewilderment")) {
                                                MoodMonth = 3;
                                            }
                                            if (arraySavedMood.equals("Sad")) {
                                                MoodMonth = 2;
                                            }
                                            if (arraySavedMood.equals("Crying")) {
                                                MoodMonth = 1;
                                            }
                                            arrayMoodMonth[i] = MoodMonth;

                                            entriesMonth.add(new BarEntry(i, arrayMoodMonth[i]));
                                        }
                                        else{
                                            MoodMonth = 0;
                                            arrayMoodMonth[i] = MoodMonth;
                                        }



                                    }
                                    chart = findViewById(R.id.chart);
                                    BarDataSet datasetMonth = new BarDataSet(entriesMonth, "График настроения");


                                    chart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(labelsMonth));

                                    datasetMonth.setColor(Color.parseColor("#2C88BA"));

                                    chart.animateY(500);

                                    BarData dataMonth = new BarData(datasetMonth);
                                    chart.setData(dataMonth);

                                    chart.invalidate();


                            }
                                @Override
                                public void onCancelled(DatabaseError databaseError) {
                                }
                            };
                            current_userRef.addListenerForSingleValueEvent(nameListener);


                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                        break;


                    case R.id.radioButton4: // Год

                        final EditText editDDateDayYear = (EditText) findViewById(R.id.editTextDate);
                        final EditText editDDateMonthYear = (EditText) findViewById(R.id.editTextDate2);
                        final EditText editDDateYearYear = (EditText) findViewById(R.id.editTextDate3);
                        SimpleDateFormat chosendateformatYear = new SimpleDateFormat("dd-MM-yyyy");
                        String dateYear = editDDateDayYear.getText().toString()+"-" + editDDateMonthYear.getText().toString()+"-" + editDDateYearYear.getText().toString();


                        try {

                            Date chosendate = chosendateformatYear.parse(dateYear);
                            Calendar chosencal = Calendar.getInstance();
                            chosencal.setTime(chosendate);


                            String[] arrayDayOfYear =  new String[367];
                            int[] arrayMoodYear = new int[367];

                            ValueEventListener nameListener = new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {

                                    for (j = 1; j<366; j++) {
                                        chosencal.set(Calendar.DAY_OF_YEAR, j);

                                        int yearYear = chosencal.get(Calendar.YEAR);
                                        int monthYear = chosencal.get(Calendar.MONTH) + 1;
                                        int dayYear = chosencal.get(Calendar.DAY_OF_MONTH);

                                        String DayOfYear = dayYear + "-" + monthYear + "-" + yearYear;
                                        arrayDayOfYear[j] = DayOfYear;

                                        if (dataSnapshot.child("diarymood").hasChild(DayOfYear)) {

                                            String arraySavedMood = dataSnapshot.child("diarymood").child(DayOfYear).getValue(String.class);
                                            if (arraySavedMood.equals("Crazy")) {
                                                MoodYear = 6;
                                            }
                                            if (arraySavedMood.equals("VHappy")) {
                                                MoodYear = 5;
                                            }
                                            if (arraySavedMood.equals("Happy")) {
                                                MoodYear = 4;
                                            }
                                            if (arraySavedMood.equals("Bewilderment")) {
                                                MoodYear = 3;
                                            }
                                            if (arraySavedMood.equals("Sad")) {
                                                MoodYear = 2;
                                            }
                                            if (arraySavedMood.equals("Crying")) {
                                                MoodYear = 1;
                                            }
                                            arrayMoodYear[j] = MoodYear;

                                            if (j >= 1 && j < 32 ){
                                                countJanuary++ ;
                                                sumJunuary = sumJunuary + arrayMoodYear[j];
                                            }
                                            if (j >= 32 && j < 60){
                                                countFebruary++;
                                                sumFebruary = sumFebruary + arrayMoodYear[j];
                                            }
                                            if (j>= 60 && j < 91){
                                                countMarch++;
                                                sumMarch = sumMarch + arrayMoodYear[j];
                                            }
                                            if (j >= 91 && j < 121){
                                                countApril++;
                                                sumApril = sumApril + arrayMoodYear[j];
                                            }
                                            if (j >= 121 && j < 152){
                                                countMay++;
                                                sumMay = sumMay + arrayMoodYear[j];
                                            }
                                            if (j >= 152 && j < 182){
                                                countJune++;
                                                sumJune = sumJune + arrayMoodYear[j];
                                            }
                                            if (j >= 192 && j < 213){
                                                countJuly++;
                                                sumJuly = sumJuly + arrayMoodYear[j];
                                            }
                                            if (j >= 213 && j < 243){
                                                countAugust++;
                                                sumAugust = sumAugust + arrayMoodYear[j];
                                            }
                                            if (j >= 243 && j < 274){
                                                countSeptember++;
                                                sumSeptember = sumSeptember + arrayMoodYear[j];
                                            }
                                            if (j >= 274 && j < 305){
                                                countOctober++;
                                                sumOctober = sumOctober + arrayMoodYear[j];
                                            }
                                            if (j >= 305 && j < 335){
                                                countNovember++;
                                                sumNovember = sumNovember + arrayMoodYear[j];
                                            }
                                            if (j >= 335 && j < 366){
                                                countDecember++;
                                                sumDecember = sumDecember + arrayMoodYear[j];
                                            }
                                        }
                                        else{
                                            MoodYear = 0;
                                            arrayMoodYear[j] = MoodYear;

                                        }



                                    }
                                    if (sumJunuary !=0 || countJanuary !=0){
                                        averJunuary = sumJunuary/countJanuary;
                                    }
                                    if (sumFebruary !=0 || countFebruary !=0) {
                                        averFebruary = sumFebruary / countFebruary;
                                    }
                                    if (sumMarch !=0 || countMarch !=0) {
                                        averMarch = sumMarch / countMarch;
                                    }
                                    if (sumApril !=0 || countApril !=0) {
                                        averApril = sumApril/countApril;
                                    }
                                    if (sumMay !=0 || countMay !=0) {
                                        averMay = sumMay / countMay;
                                    }
                                    if (sumJune !=0 || countJune !=0) {
                                        averJune = sumJune / countJune;
                                    }
                                    if (sumJuly !=0 || countJuly !=0) {
                                        averJuly = sumJuly / countJuly;
                                    }
                                    if (sumAugust !=0 || countAugust !=0) {
                                        averAugust = sumAugust / countAugust;
                                    }
                                    if (sumSeptember !=0 || countSeptember !=0) {
                                        averSeptember = sumSeptember / countSeptember;
                                    }
                                    if (sumOctober !=0 || countOctober !=0) {
                                        averOctober = sumOctober / countOctober;
                                    }
                                    if (sumNovember !=0 || countNovember !=0) {
                                        averNovember = sumNovember / countNovember;
                                    }
                                    if (sumDecember !=0 || countDecember !=0) {
                                        averDecember = sumDecember / countDecember;
                                    }

                                    chart = findViewById(R.id.chart);
                                    ArrayList<BarEntry> entriesYear = new ArrayList<>();
                                    entriesYear.add(new BarEntry(1, averJunuary));
                                    entriesYear.add(new BarEntry(2, averFebruary));
                                    entriesYear.add(new BarEntry(3, averMarch));
                                    entriesYear.add(new BarEntry(4, averApril));
                                    entriesYear.add(new BarEntry(5, averMay));
                                    entriesYear.add(new BarEntry(6, averJune));
                                    entriesYear.add(new BarEntry(7, averJuly));
                                    entriesYear.add(new BarEntry(8, averAugust));
                                    entriesYear.add(new BarEntry(9, averSeptember));
                                    entriesYear.add(new BarEntry(10, averOctober));
                                    entriesYear.add(new BarEntry(11, averNovember));
                                    entriesYear.add(new BarEntry(12, averDecember));

                                    BarDataSet datasetYear = new BarDataSet(entriesYear, "График настроения");

                                    ArrayList<String> labelsYear = new ArrayList<String>();
                                    labelsYear.add("");
                                    labelsYear.add("Янв");
                                    labelsYear.add("Февр");
                                    labelsYear.add("Март");
                                    labelsYear.add("Апр");
                                    labelsYear.add("Май");
                                    labelsYear.add("Июнь");
                                    labelsYear.add("Июль");
                                    labelsYear.add("Авг");
                                    labelsYear.add("Сент");
                                    labelsYear.add("Окт");
                                    labelsYear.add("Нояб");
                                    labelsYear.add("Дек");

                                    chart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(labelsYear));

                                    datasetYear.setColor(Color.parseColor("#2C88BA"));

                                    chart.animateY(500);

                                    BarData dataYear = new BarData(datasetYear);
                                    chart.setData(dataYear);

                                    chart.invalidate();

                                }
                                @Override
                                public void onCancelled(DatabaseError databaseError) {
                                }
                            };
                            current_userRef.addListenerForSingleValueEvent(nameListener);

                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        break;
                    default:
                        break;
                }
            }
        });

    }


    public void onClickToNavi(View view){

        Intent ToNaviIntent = new Intent(this, NavigationActivity.class);
        startActivity(ToNaviIntent);
        finish();
    }

}