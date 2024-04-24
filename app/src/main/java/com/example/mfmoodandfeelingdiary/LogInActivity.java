package com.example.mfmoodandfeelingdiary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LogInActivity extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseDatabase db;
    DatabaseReference users;

    final String Saved_Login = " ";
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        sharedPreferences = getPreferences(MODE_PRIVATE);
        final EditText email = (EditText) findViewById(R.id.editTextTextEmailAddress2);
        String savedLogin = sharedPreferences.getString(Saved_Login, "");
        email.setText(savedLogin);

    }

    public  void  onClickLogIn(View view){
        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        users = db.getReference("Users");

        final EditText email = (EditText) findViewById(R.id.editTextTextEmailAddress2);
        final EditText pass = (EditText) findViewById(R.id.editTextTextPassword);

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

        auth.signInWithEmailAndPassword(email.getText().toString(), pass.getText().toString())
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        sharedPreferences = getPreferences(MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString(Saved_Login, email.getText().toString());
                        editor.commit();
                        startActivity(new Intent(LogInActivity.this, MainActivity.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast toastLog = Toast.makeText(getApplicationContext(), "Ошибка авторизации. " + e.getMessage(), Toast.LENGTH_SHORT);
                        toastLog.show();
                    }
                });
    }

    public void  onClickForgotPass(View view){
        auth = FirebaseAuth.getInstance();
        final EditText email = (EditText) findViewById(R.id.editTextTextEmailAddress2);
        if(TextUtils.isEmpty(email.getText())){
            Toast toastEmail = Toast.makeText(getApplicationContext(), "Введите Почту/Email", Toast.LENGTH_SHORT);
            toastEmail.show();
            return;
        }
        String emailAddress = email.getText().toString();

        auth.sendPasswordResetEmail(emailAddress)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast toastLog = Toast.makeText(getApplicationContext(), "На вашу почту отправлено письмо с восстановлением пароля. ", Toast.LENGTH_SHORT);
                            toastLog.show();
                        }
                    }
                });

    }

    public void onClickToSignIn(View view){
        Intent ToSignInintent = new Intent(this, SignInActivity.class);
        startActivity(ToSignInintent);
    }

}