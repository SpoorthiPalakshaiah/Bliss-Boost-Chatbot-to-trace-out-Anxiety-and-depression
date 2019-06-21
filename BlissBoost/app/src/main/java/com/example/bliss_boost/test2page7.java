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

public class test2page7 extends AppCompatActivity {
    TextView ansprev;
    TextView ansprev1;
    TextView ansprev2;
    TextView ansprev3;
    static int ans5;
    static String a5;
    private ScrollView Scroll5;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2page7);

        ansprev=findViewById(R.id.ttvReply3);
        ansprev.setText(test2page3.a1);
        ansprev1=findViewById(R.id.ttvReply4);
        ansprev1.setText(test2page4.a2);
        ansprev=findViewById(R.id.ttvReply5);
        ansprev.setText(test2page5.a3);
        ansprev=findViewById(R.id.ttvReply6);
        ansprev.setText(test2page6.a4);


        final Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                speak();
            }
        },40);

        Scroll5=findViewById(R.id.tscroll5);
        Scroll5.post(new Runnable() {
            @Override
            public void run() {
                Scroll5.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });

        radioGroup=findViewById(R.id.ttrg5);
        Button btnd4=findViewById(R.id.tbtna5);
        btnd4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int radioId=radioGroup.getCheckedRadioButtonId();
                radioButton=findViewById(radioId);
                //  System.out.println("String is"+radioButton.getText().toString());
                a5=radioButton.getText().toString();
                if(radioButton.getText().toString().equals("Not at all")){
                    ans5=1;
                }
                else if(radioButton.getText().toString().equals("Several days")){
                    ans5=2;
                }
                else if(radioButton.getText().toString().equals("More than half the days")){
                    ans5=3;
                }
                else{
                    ans5=4;
                }

                //  System.out.println("Answer is "+ans);
                startActivity(new Intent(test2page7.this,test2page8.class));
            }
        });
    }
    private void speak(){
        TextView tv=findViewById(R.id.ttvq5);
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
        startActivity(new Intent(test2page7.this,Home.class));
    }
}
