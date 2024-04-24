package com.example.mfmoodandfeelingdiary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RecommendationsActivity extends AppCompatActivity {

    String mood;
    int recomhumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendations);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        TextView recomtext = findViewById(R.id.textView5);
        mood = getIntent().getStringExtra("mood");
        if(mood.equals("Crazy")){
            recomhumber = getRandomNumber(1,6);
            if (recomhumber == 1){
                recomtext.setText("Меняй что-то в своей жизни! Сядь на телевизор, смотри на диван. ");
            }
            if (recomhumber == 2){
                recomtext.setText("Будь так же внезапен, как арбуз, в который Вы постучали, а из него постучали в ответ. ");
            }
            if (recomhumber == 3){
                recomtext.setText("«Кто не рискует, тот живет посредственной жизнью». Джим Рон. ");
            }
            if (recomhumber == 4){
                recomtext.setText("Не ждите чуда, чудите сами! ");
            }
            if (recomhumber == 5){
                recomtext.setText("Если у тебя бесяка, то ты милый котик из стикеров телеграмма \uD83D\uDE1C. ");
            }
            ImageView imageView = findViewById(R.id.imageView47);
            imageView.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.crazy_em));
        }
        if(mood.equals("VHappy")){
            recomhumber = getRandomNumber(1,6);
            if (recomhumber == 1){
                recomtext.setText("Улыбайся и любовью наполняйся! ");
            }
            if (recomhumber == 2){
                recomtext.setText("«День без смеха потрачен зря». Чарли Чаплин. ");
            }
            if (recomhumber == 3){
                recomtext.setText("«Свет всегда отгоняет тьму». Фонд Анасази. ");
            }
            if (recomhumber == 4){
                recomtext.setText("Красота повсюду, просто начни ее замечать. ");
            }
            if (recomhumber == 5){
                recomtext.setText("Энергия и настойчивость побеждают все на свете. ");
            }
            ImageView imageView = findViewById(R.id.imageView47);
            imageView.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.very_happy_em));

        }
        if(mood.equals("Happy")){
            recomhumber = getRandomNumber(1,6);
            if (recomhumber == 1){
                recomtext.setText("Ты добьешься всего, что ты хочешь. Я верю в тебя и буду всегда на твоей стороне. ");
            }
            if (recomhumber == 2){
                recomtext.setText("Ты как солнечный лучик! ");
            }
            if (recomhumber == 3){
                recomtext.setText("Будьте собой, и будьте счастливы! ");
            }
            if (recomhumber == 4){
                recomtext.setText("Оставайтесь таким же - не давайте невзгодам встать на Вашем пути. ");
            }
            if (recomhumber == 5){
                recomtext.setText("Сделай свои мечты сильнее своих страхов. ");
            }
            ImageView imageView = findViewById(R.id.imageView47);
            imageView.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.happy_em));

        }
        if(mood.equals("Bewilderment")){

            recomhumber = getRandomNumber(1,7);
            if (recomhumber == 1){
                recomtext.setText("Все, что не делается – то к лучшему. А что не произошло, то на пользу. ");
            }
            if (recomhumber == 2){
                recomtext.setText("Помни о том, что любой минус можно превратить в плюс. ");
            }
            if (recomhumber == 3){
                recomtext.setText("Завтра опять взойдет солнце, несмотря ни на что. ");
            }
            if (recomhumber == 4){
                recomtext.setText("Давай придумаем вместе повод для улыбки. ");
            }
            if (recomhumber == 5){
                recomtext.setText("Ты прекрасный человек, который заслуживает всего самого лучшего. ");
            }
            if (recomhumber == 6){
                recomtext.setText("Мир полон проблем и сложностей, но ты будешь победителем. ");
            }
            ImageView imageView = findViewById(R.id.imageView47);
            imageView.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.drunk_em));
        }
        if(mood.equals("Sad")){

            recomhumber = getRandomNumber(1,7);
            if (recomhumber == 1){
                recomtext.setText("Для счастья человеку многое не нужно. Требуется только яркое солнце, свежий воздух и немного отдыха. Просто возьми паузу и немногого отдохни. У тебя все наладится. ");
            }
            if (recomhumber == 2){
                recomtext.setText("Не смей сдаваться и отчаиваться. Каждый день появляются новые возможности и технологии двигаются вперед. Что еще сегодня кажется невозможным, завтра станет реальностью. ");
            }
            if (recomhumber == 3){
                recomtext.setText("Не отчаивайся. Тебя впереди ждет только самое лучшее. Ты мне веришь? ");
            }
            if (recomhumber == 4){
                recomtext.setText("Помни о том, что любой минус можно превратить в плюс. ");
            }
            if (recomhumber == 5){
                recomtext.setText("Именно в тяжелые времена раскрывается наш потенциал и возможности. ");
            }
            if (recomhumber == 6){
                recomtext.setText("Падай 9 раз, а вставай 10. Не теряй веры в себя. ");
            }
            ImageView imageView = findViewById(R.id.imageView47);
            imageView.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.sad_em));
        }
        if(mood.equals("Crying")){

            recomhumber = getRandomNumber(1,7);
            if (recomhumber == 1){
                recomtext.setText("Царь Соломон говорил: «Всё проходит. И это пройдёт». ");
            }
            if (recomhumber == 2){
                recomtext.setText("Ты обязательно справишься и пройдешь через все это. Тебе очень тяжело, но крепись. ");
            }
            if (recomhumber == 3){
                recomtext.setText("Через время горечь уйдет, а ты будешь счастливым, а все наладится.");
            }
            if (recomhumber == 4){
                recomtext.setText("Я верю в то, что все будет хорошо. Ты справишься, а неприятности останутся позади. ");
            }
            if (recomhumber == 5){
                recomtext.setText("Каждое поражение несет в себе семена будущей победы. Я в тебя верю. ");
            }
            if (recomhumber == 6){
                recomtext.setText("Посмотри на ситуацию с другой стороны. Для гусеницы – это может быть концом, а для бабочки – это самое начало. ");
            }
            ImageView imageView = findViewById(R.id.imageView47);
            imageView.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.crying_em));
        }

    }
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public void onClickToMain(View view){
        Intent ToMainInintent = new Intent(this, MainActivity.class);
        startActivity(ToMainInintent);
    }

}