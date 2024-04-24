package com.example.mfmoodandfeelingdiary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NoteActivity extends AppCompatActivity {

    int countBack = 0;
    String date;

    String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference usersRef = rootRef.child("Users");
    DatabaseReference current_userRef = usersRef.child(uid);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);


        TextView savebutton = findViewById(R.id.textView17);
        savebutton.setVisibility(View.INVISIBLE);

    }

    public void onClickText(View view){
        TextView savebutton = findViewById(R.id.textView17);
        savebutton.setVisibility(View.VISIBLE);
    }

    public void onClickSave(View view){

        final EditText diarytext = (EditText) findViewById(R.id.editTextTextMultiLine2);

        if(TextUtils.isEmpty(diarytext.getText())){
            Toast toastText = Toast.makeText(getApplicationContext(), "Введите текст.", Toast.LENGTH_SHORT);
            toastText.show();
            return;
        }
        else {
            DatabaseReference dateRef = current_userRef.child("note");
            DatabaseReference textRef = dateRef.child(date);
            textRef.setValue(diarytext.getText().toString());
            TextView savebutton = findViewById(R.id.textView17);
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
}