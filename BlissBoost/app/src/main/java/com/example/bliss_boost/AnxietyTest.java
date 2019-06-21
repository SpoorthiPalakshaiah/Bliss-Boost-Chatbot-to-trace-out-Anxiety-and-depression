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

public class AnxietyTest extends AppCompatActivity {
    private Button Ok;
    public static TextToSpeech mTTS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anxiety_test);

        Ok = findViewById(R.id.btnok);
        Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AnxietyTest.this, test1page2.class));
            }
        });

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                speak();
            }
        }, 50);
    }

    private void speak() {
        TextView tv = findViewById(R.id.tvGreetings);
        String text = tv.getText().toString();
      AnxietyTest.mTTS.setPitch((float) 1.0);
        AnxietyTest.mTTS.setSpeechRate((float) 1.0);
        AnxietyTest.mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    protected void onResume() {
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
