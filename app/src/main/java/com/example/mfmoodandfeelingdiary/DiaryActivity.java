package com.example.mfmoodandfeelingdiary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DiaryActivity extends AppCompatActivity {

    int countBack = 0;
    int countRecom = 0;

    String mood = "Null";
    String date;
    boolean isRotate = false;

    String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference usersRef = rootRef.child("Users");
    DatabaseReference current_userRef = usersRef.child(uid);


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        TextView savebutton = findViewById(R.id.textView7);
        savebutton.setVisibility(View.INVISIBLE);
        ViewAnimation.init(findViewById(R.id.fab_crazy));
        ViewAnimation.init(findViewById(R.id.fab_happy));
        ViewAnimation.init(findViewById(R.id.fab_happy_1));
        ViewAnimation.init(findViewById(R.id.fab_drunk));
        ViewAnimation.init(findViewById(R.id.fab_sad));
        ViewAnimation.init(findViewById(R.id.fab_crying));

        TextView ddate = findViewById(R.id.textView8);
        date = getIntent().getStringExtra("diarydate");
        ddate.setText(date);

        ValueEventListener nameListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.child("diary").hasChild(date)){
                    TextView savebutton = findViewById(R.id.textView7);
                    savebutton.setVisibility(View.VISIBLE);
                    EditText tvfn = (EditText) findViewById(R.id.editTextTextMultiLine3);
                    String savedText = dataSnapshot.child("diary").child(date).getValue(String.class);
                    tvfn.setText(savedText);

                    String savedMood = dataSnapshot.child("diarymood").child(date).getValue(String.class);
                    mood = savedMood;

                    if(savedMood.equals("Crazy")){
                        ImageView imageView = findViewById(R.id.imageView48);
                        imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.crazy_em));
                    }
                    if(savedMood.equals( "VHappy")){
                        ImageView imageView = findViewById(R.id.imageView48);
                        imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.very_happy_em));
                    }
                    if(savedMood.equals("Happy")){
                        ImageView imageView = findViewById(R.id.imageView48);
                        imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.happy_em));
                    }
                    if(savedMood.equals("Bewilderment")){
                        ImageView imageView = findViewById(R.id.imageView48);
                        imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.drunk_em));
                    }
                    if(savedMood.equals("Sad")){
                        ImageView imageView = findViewById(R.id.imageView48);
                        imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.sad_em));
                    }
                    if(savedMood.equals("Crying")){
                        ImageView imageView = findViewById(R.id.imageView48);
                        imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.crying_em));
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }

        };
        current_userRef.addListenerForSingleValueEvent(nameListener);


    }
    public void onClickFab(View view){

        isRotate = ViewAnimation.rotateFab(view, !isRotate);
        if(isRotate){
            ViewAnimation.showIn(findViewById(R.id.fab_crazy));
            ViewAnimation.showIn(findViewById(R.id.fab_happy));
            ViewAnimation.showIn(findViewById(R.id.fab_happy_1));
            ViewAnimation.showIn(findViewById(R.id.fab_drunk));
            ViewAnimation.showIn(findViewById(R.id.fab_sad));
            ViewAnimation.showIn(findViewById(R.id.fab_crying));
        }else{
            ViewAnimation.showOut(findViewById(R.id.fab_crazy));
            ViewAnimation.showOut(findViewById(R.id.fab_happy));
            ViewAnimation.showOut(findViewById(R.id.fab_happy_1));
            ViewAnimation.showOut(findViewById(R.id.fab_drunk));
            ViewAnimation.showOut(findViewById(R.id.fab_sad));
            ViewAnimation.showOut(findViewById(R.id.fab_crying));
        }
    }
    public void onClickFabCrazy(View view){
        mood = "Crazy";
        ImageView imageView = findViewById(R.id.imageView48);
        imageView.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.crazy_em));
        TextView savebutton = findViewById(R.id.textView7);
        savebutton.setVisibility(View.VISIBLE);
    }
    public void onClickFabHappy(View view){
        mood = "VHappy";
        ImageView imageView = findViewById(R.id.imageView48);
        imageView.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.very_happy_em));
        TextView savebutton = findViewById(R.id.textView7);
        savebutton.setVisibility(View.VISIBLE);
    }
    public void onClickFabHappy1(View view){
        mood = "Happy";
        ImageView imageView = findViewById(R.id.imageView48);
        imageView.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.happy_em));
        TextView savebutton = findViewById(R.id.textView7);
        savebutton.setVisibility(View.VISIBLE);
    }
    public void onClickFabDrunk(View view){
        mood = "Bewilderment";
        ImageView imageView = findViewById(R.id.imageView48);
        imageView.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.drunk_em));
        TextView savebutton = findViewById(R.id.textView7);
        savebutton.setVisibility(View.VISIBLE);
    }
    public void onClickFabSad(View view){
        mood = "Sad";
        ImageView imageView = findViewById(R.id.imageView48);
        imageView.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.sad_em));
        TextView savebutton = findViewById(R.id.textView7);
        savebutton.setVisibility(View.VISIBLE);
    }
    public void onClickFabCrying(View view){
        mood = "Crying";
        ImageView imageView = findViewById(R.id.imageView48);
        imageView.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.crying_em));
        TextView savebutton = findViewById(R.id.textView7);
        savebutton.setVisibility(View.VISIBLE);
    }

    public void onClickSave(View view){

        final EditText diarytext = (EditText) findViewById(R.id.editTextTextMultiLine3);

        if(TextUtils.isEmpty(diarytext.getText())){
            Toast toastText = Toast.makeText(getApplicationContext(), "Введите текст.", Toast.LENGTH_SHORT);
            toastText.show();
            return;
        }
        if(mood.equals("Null")){
            Toast toastMood = Toast.makeText(getApplicationContext(), "Выберите настроение.", Toast.LENGTH_SHORT);
            toastMood.show();
            return;
        }
        else {
            DatabaseReference dateRef = current_userRef.child("diary");
            DatabaseReference textRef = dateRef.child(date);
            DatabaseReference moodRefT = current_userRef.child("diarymood");
            DatabaseReference moodRef = moodRefT.child(date);
            textRef.setValue(diarytext.getText().toString());
            moodRef.setValue(mood);
            TextView savebutton = findViewById(R.id.textView7);
            savebutton.setVisibility(View.INVISIBLE);
            Toast toastSave = Toast.makeText(getApplicationContext(), "Сохранено.", Toast.LENGTH_SHORT);
            toastSave.show();
        }

    }

    public void onClickToMain(View view){
        if(countBack == 0){
            Toast toastSave = Toast.makeText(getApplicationContext(), "Все несохраненные данные будут потеряны, для перехода нажмите ещё раз.", Toast.LENGTH_SHORT);
            toastSave.show();
            countBack += 1;
        }
        else{
        Intent ToMainInintent = new Intent(this, MainActivity.class);
        startActivity(ToMainInintent);
        }
    }

    public void onClickToRecom(View view){

        final EditText diarytext = (EditText) findViewById(R.id.editTextTextMultiLine3);

        if(TextUtils.isEmpty(diarytext.getText())){
            Toast toastText = Toast.makeText(getApplicationContext(), "Введите текст.", Toast.LENGTH_SHORT);
            toastText.show();
            return;
        }

        if (mood.equals("Null")){
            Toast toastMood = Toast.makeText(getApplicationContext(), "Выберите настроение.", Toast.LENGTH_SHORT);
            toastMood.show();
            return;
        }
        else{
            if(countRecom == 0){
                Toast toastSave = Toast.makeText(getApplicationContext(), "Все несохраненные данные будут потеряны, для перехода нажмите ещё раз.", Toast.LENGTH_SHORT);
                toastSave.show();
                countRecom += 1;
            }
            else {
                Intent ToRecomInintent = new Intent(this, RecommendationsActivity.class);
                ToRecomInintent.putExtra("mood", mood);
                startActivity(ToRecomInintent);
            }
        }
    }
}