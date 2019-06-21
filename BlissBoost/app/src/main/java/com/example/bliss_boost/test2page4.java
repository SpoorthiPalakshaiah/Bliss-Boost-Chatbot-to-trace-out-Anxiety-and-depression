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

public class test2page4 extends AppCompatActivity {
    TextView ansprev;
    static int ans2;
    static String a2;
    private ScrollView Scroll2;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2page4);
        ansprev=findViewById(R.id.ttvReply3);
        ansprev.setText(test2page3.a1);


        final Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                speak();
            }
        },40);

        Scroll2=findViewById(R.id.tscroll2);
        Scroll2.post(new Runnable() {
            @Override
            public void run() {
                Scroll2.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });
        radioGroup=findViewById(R.id.trg2);
        Button btnd2=findViewById(R.id.tbtna2);
        btnd2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int radioId=radioGroup.getCheckedRadioButtonId();
                radioButton=findViewById(radioId);
                System.out.println("String is"+radioButton.getText().toString());
                a2=radioButton.getText().toString();
                if(radioButton.getText().toString().equals("Not at all")){
                    ans2=1;
                }
                else if(radioButton.getText().toString().equals("Several days")){
                    ans2=2;
                }
                else if(radioButton.getText().toString().equals("More than half the days")){
                    ans2=3;
                }
                else{
                    ans2=4;
                }

                System.out.println("Answer is "+ans2);
                startActivity(new Intent(test2page4.this,test2page5.class));
            }
        });
    }
    private void speak(){
        TextView tv=findViewById(R.id.ttvq2);
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
        startActivity(new Intent(test2page4.this,Home.class));
    }
}
