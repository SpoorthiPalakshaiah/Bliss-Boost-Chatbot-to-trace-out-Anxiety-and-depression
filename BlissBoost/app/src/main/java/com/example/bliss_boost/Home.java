package com.example.bliss_boost;

import android.content.Intent;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class Home extends AppCompatActivity {
Button remainder;
Button anxiety;
Button pdetails;
Button depression;
Button boost;
Button progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        AnxietyTest.mTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = AnxietyTest.mTTS.setLanguage(Locale.ENGLISH);
                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported");
                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });



        remainder=findViewById(R.id.btnremainder);
        remainder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this,Remainder.class));
    }

});
        anxiety=findViewById(R.id.btnanxietytest);
        anxiety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this,AnxietyTest.class));
            }

        });

        pdetails=findViewById(R.id.btnPersonalDetails);
        pdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this,Personaldetails.class));
            }

        });

        depression=findViewById(R.id.btndepressiontest);
        depression.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this,DepressionTest.class));
            }

        });

        boost=findViewById(R.id.btnbooster);
        boost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this,Booster.class));
            }

        });

        progress=findViewById(R.id.btnprogress);
        progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this,ProgressTracker.class));
            }

        });
    }
    private void speak() {

        String text = "";
        AnxietyTest.mTTS.setPitch((float) 1.0);
        AnxietyTest.mTTS.setSpeechRate((float) 1.0);
        AnxietyTest.mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

@Override
protected void onResume(){
        super.onResume();
        speak();
}
    @Override
    protected void onDestroy() {
        if (AnxietyTest.mTTS != null) {
            AnxietyTest.mTTS.stop();
            AnxietyTest.mTTS.shutdown();
        }
        super.onDestroy();

    }
}