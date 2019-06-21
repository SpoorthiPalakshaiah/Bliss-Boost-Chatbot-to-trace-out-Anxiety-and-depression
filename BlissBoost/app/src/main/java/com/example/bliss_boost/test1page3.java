package com.example.bliss_boost;

import android.content.Intent;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

public class test1page3 extends AppCompatActivity {
    static int ans=0;
    static String a1;
    private ScrollView Scroll1;
    private RadioGroup radioGroup;
    private RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1page3);
        Scroll1=findViewById(R.id.scroll1);
        Scroll1.post(new Runnable() {
            @Override
            public void run() {
                Scroll1.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });

        final Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                speak();
            }
        },40);

        radioGroup=findViewById(R.id.rg1);
        Button btnd1=findViewById(R.id.btna1);
        btnd1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int radioId=radioGroup.getCheckedRadioButtonId();
                radioButton=findViewById(radioId);
                //  System.out.println("String is"+radioButton.getText().toString());
                a1=radioButton.getText().toString();
                if(radioButton.getText().toString().equals("Never")){
                    ans=1;
                }
                else if(radioButton.getText().toString().equals("Rarely")){
                    ans=2;
                }
                else if(radioButton.getText().toString().equals("Sometimes")){
                    ans=3;
                }
                else if(radioButton.getText().toString().equals("Frequently")){
                    ans=4;
                }
                else{
                    ans=5;
                }

                //  System.out.println("Answer is "+ans);
                startActivity(new Intent(test1page3.this,test1page4.class));
            }
        });

    }
    private void speak(){
        TextView tv=findViewById(R.id.tvq1);
        String text=tv.getText().toString();
        AnxietyTest.mTTS.setPitch((float)1.0);
        AnxietyTest.mTTS.setSpeechRate((float)1.0);
        AnxietyTest.mTTS.speak(text, TextToSpeech.QUEUE_FLUSH,null);
    }


    @Override
    protected void onDestroy(){
        if(AnxietyTest.mTTS!=null){
            AnxietyTest.mTTS.stop();
            AnxietyTest.mTTS.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public void onBackPressed(){
        startActivity(new Intent(test1page3.this,Home.class));
    }
}

