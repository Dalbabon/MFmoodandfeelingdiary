package com.example.mfmoodandfeelingdiary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mfmoodandfeelingdiary.Models.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class SignInActivity extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseDatabase db;
    DatabaseReference users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);


    }
      public void onClickRegister(View view){

        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        users = db.getReference("Users");

        final EditText fname = (EditText) findViewById(R.id.editTextTextPersonName);
        final EditText lname = (EditText) findViewById(R.id.editTextTextPersonName2);
        final EditText email = (EditText) findViewById(R.id.editTextTextEmailAddress);
        final EditText pass = (EditText) findViewById(R.id.editTextTextPassword2);

        if(TextUtils.isEmpty(fname.getText())){
            Toast toastFname = Toast.makeText(getApplicationContext(), "Введите Имя", Toast.LENGTH_SHORT);
            toastFname.show();
            return;
        }
        if(TextUtils.isEmpty(lname.getText())){
            Toast toastlname = Toast.makeText(getApplicationContext(), "Введите Фамилию", Toast.LENGTH_SHORT);
            toastlname.show();
            return;
        }
        if(TextUtils.isEmpty(email.getText())){
            Toast toastEmail = Toast.makeText(getApplicationContext(), "Введите Почту/Email", Toast.LENGTH_SHORT);
            toastEmail.show();
            return;
        }
        if(pass.getText().toString().length()<5){
            Toast toastPass = Toast.makeText(getApplicationContext(), "Введите Пароль, не менее 5 символов", Toast.LENGTH_SHORT);
            toastPass.show();
            return;
        }
        auth.createUserWithEmailAndPassword(email.getText().toString(), pass.getText().toString())
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        User user = new User();
                        user.setFname(fname.getText().toString());
                        user.setLname(lname.getText().toString());
                        user.setEmail(email.getText().toString());

                        users.child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                .setValue(user)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast toastReg = Toast.makeText(getApplicationContext(), "Пользователь успешно зарегистрирован.", Toast.LENGTH_LONG);
                                        toastReg.show();
                                        startActivity(new Intent(SignInActivity.this, LogInActivity.class));
                                        finish();
                                    }
                                });
                        }

                    }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast toastRegF = Toast.makeText(getApplicationContext(), "Ошибка регистрации. " + e.getMessage(), Toast.LENGTH_LONG);
                        toastRegF.show();
                    }
                });

      }
    public void onClickToLogIn(View view){
        Intent ToLogInintent = new Intent(this, LogInActivity.class);
        startActivity(ToLogInintent);
        finish();
    }
}