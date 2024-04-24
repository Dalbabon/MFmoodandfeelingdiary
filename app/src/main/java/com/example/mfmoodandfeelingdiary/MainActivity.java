package com.example.mfmoodandfeelingdiary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        Calendar cal = new GregorianCalendar();
        cal.add(Calendar.DATE, -3);
        Calendar calnex = new GregorianCalendar();
        calnex.add(Calendar.DATE, -2);
        Calendar calthi = new GregorianCalendar();
        calthi.add(Calendar.DATE, -1);
        Calendar calfou = new GregorianCalendar();
        Calendar calfiv = new GregorianCalendar();
        calfiv.add(Calendar.DATE, 1);
        Calendar calsix = new GregorianCalendar();
        calsix.add(Calendar.DATE, 2);
        Calendar calsev = new GregorianCalendar();
        calsev.add(Calendar.DATE, 3);

        // Месяц
        TextView tvm = (TextView) findViewById(R.id.textViewMounth);
        SimpleDateFormat sdf1 = new SimpleDateFormat("LLLL");
        String sdf = sdf1.format(calfou.getTime());
        String dateString1 = sdf.substring(0,1).toUpperCase();
        String dateString = dateString1 + sdf.substring(1);
        tvm.setText(dateString);

        // ПредПредПредыдущий день
        TextView tvthis = (TextView) findViewById(R.id.textViewThisDay);
        TextView tvthisdate = (TextView) findViewById(R.id.textViewThisDayDate);

        SimpleDateFormat sdfthis1 = new SimpleDateFormat("E");
        String sdfthis = sdfthis1.format(cal.getTime());
        String thisdateString1 = sdfthis.substring(0,1).toUpperCase();
        String thisdateString = thisdateString1 + sdfthis.substring(1);
        tvthis.setText(thisdateString);

        SimpleDateFormat sdfthisd1 = new SimpleDateFormat("dd");
        String sdfthisd = sdfthisd1.format(cal.getTime());
        tvthisdate.setText(sdfthisd);

        // ПредПредыдущий день
        TextView tvnext = (TextView) findViewById(R.id.textViewNextDay);
        TextView tvnextdate = (TextView) findViewById(R.id.textViewNextDayDate);

        SimpleDateFormat sdfnext1 = new SimpleDateFormat("E");
        String sdfnext = sdfnext1.format(calnex.getTime());
        String nextdateString1 = sdfnext.substring(0,1).toUpperCase();
        String nextdateString = nextdateString1 + sdfnext.substring(1);
        tvnext.setText(nextdateString);

        SimpleDateFormat sdfnextd1 = new SimpleDateFormat("dd");
        String sdfnextd = sdfnextd1.format(calnex.getTime());
        tvnextdate.setText(sdfnextd);

        // Предыдущий день
        TextView tvthird = (TextView) findViewById(R.id.textViewThirdDay);
        TextView tvthirddate = (TextView) findViewById(R.id.textViewThirdDayDate);

        SimpleDateFormat sdfthird1 = new SimpleDateFormat("E");
        String sdfthird = sdfthird1.format(calthi.getTime());
        String thirddateString1 = sdfthird.substring(0,1).toUpperCase();
        String thirddateString = thirddateString1 + sdfthird.substring(1);
        tvthird.setText(thirddateString);

        SimpleDateFormat sdfthirdd1 = new SimpleDateFormat("dd");
        String sdfthirdd = sdfthirdd1.format(calthi.getTime());
        tvthirddate.setText(sdfthirdd);

        // Текущий день
        TextView tvfour = (TextView) findViewById(R.id.textViewFourDay);
        TextView tvfourdate = (TextView) findViewById(R.id.textViewFourDayDate);

        SimpleDateFormat sdffour1 = new SimpleDateFormat("E");
        String sdffour = sdffour1.format(calfou.getTime());
        String fourdateString1 = sdffour.substring(0,1).toUpperCase();
        String fourdateString = fourdateString1 + sdffour.substring(1);
        tvfour.setText(fourdateString);

        SimpleDateFormat sdffourd1 = new SimpleDateFormat("dd");
        String sdffourd = sdffourd1.format(calfou.getTime());
        tvfourdate.setText(sdffourd);

        // Следующий день
        TextView tvfive = (TextView) findViewById(R.id.textViewFiveDay);
        TextView tvfivedate = (TextView) findViewById(R.id.textViewFiveDayDate);

        SimpleDateFormat sdffive1 = new SimpleDateFormat("E");
        String sdffive = sdffive1.format(calfiv.getTime());
        String fivedateString1 = sdffive.substring(0,1).toUpperCase();
        String fivedateString = fivedateString1 + sdffive.substring(1);
        tvfive.setText(fivedateString);

        SimpleDateFormat sdffived1 = new SimpleDateFormat("dd");
        String sdffived = sdffived1.format(calfiv.getTime());
        tvfivedate.setText(sdffived);

        // СледСледующий день
        TextView tvsix = (TextView) findViewById(R.id.textViewSixDay);
        TextView tvsixdate = (TextView) findViewById(R.id.textViewSixDayDate);

        SimpleDateFormat sdfsix1 = new SimpleDateFormat("E");
        String sdfsix = sdfsix1.format(calsix.getTime());
        String sixdateString1 = sdfsix.substring(0,1).toUpperCase();
        String sixdateString = sixdateString1 + sdfsix.substring(1);
        tvsix.setText(sixdateString);

        SimpleDateFormat sdfsixd1 = new SimpleDateFormat("dd");
        String sdfsixd = sdfsixd1.format(calsix.getTime());
        tvsixdate.setText(sdfsixd);

        // СледСледСледующий день
        TextView tvseven = (TextView) findViewById(R.id.textViewSevenDay);
        TextView tvsevendate = (TextView) findViewById(R.id.textViewSevenDayDate);

        SimpleDateFormat sdfseven1 = new SimpleDateFormat("E");
        String sdfseven = sdfseven1.format(calsev.getTime());
        String sevendateString1 = sdfseven.substring(0,1).toUpperCase();
        String sevendateString = sevendateString1 + sdfseven.substring(1);
        tvseven.setText(sevendateString);

        SimpleDateFormat sdfsevend1 = new SimpleDateFormat("dd");
        String sdfsevend = sdfsevend1.format(calsev.getTime());
        tvsevendate.setText(sdfsevend);

    }

    public void onClickToCalendar(View view){
        Intent ToCalendarInintent = new Intent(this, CalendarActivity.class);
        startActivity(ToCalendarInintent);
    }

    public void onClickToDiary(View view){
        Calendar diarycal = new GregorianCalendar();
        SimpleDateFormat diarydate1 = new SimpleDateFormat("dd-MM-yyyy");
        String diarydate = diarydate1.format(diarycal.getTime());

        Intent ToDiaryIntent = new Intent(this, DiaryActivity.class);
        ToDiaryIntent.putExtra("diarydate", diarydate);
        startActivity(ToDiaryIntent);
    }

    public void onClickToNavi(View view){

        Intent ToNaviIntent = new Intent(this, NavigationActivity.class);
        startActivity(ToNaviIntent);
        finish();
    }

}