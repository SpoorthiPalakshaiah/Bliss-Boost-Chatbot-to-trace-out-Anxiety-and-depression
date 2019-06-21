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

public class test2page5 extends AppCompatActivity {
    TextView ansprev;
    TextView ansprev1;
    static int ans3;
    static String a3;
    private ScrollView Scroll3;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2page5);
        ansprev=findViewById(R.id.ttvReply3);
        ansprev.setText(test2page3.a1);
        ansprev1=findViewById(R.id.ttvReply4);
        ansprev1.setText(test2page4.a2);

        Scroll3=findViewById(R.id.tscroll3);
        Scroll3.post(new Runnable() {
            @Override
            public void run() {
                Scroll3.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });



        final Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                speak();
            }
        },40);

        radioGroup=findViewById(R.id.trg3);
        Button btnd3=findViewById(R.id.tbtna3);
        btnd3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int radioId=radioGroup.getCheckedRadioButtonId();
                radioButton=findViewById(radioId);
                //  System.out.println("String is"+radioButton.getText().toString());
                a3=radioButton.getText().toString();
                if(radioButton.getText().toString().equals("Not at all")){
                    ans3=1;
                }
                else if(radioButton.getText().toString().equals("Several days")){
                    ans3=2;
                }
                else if(radioButton.getText().toString().equals("More than half the days")){
                    ans3=3;
                }
                else{
                    ans3=4;
                }

                //  System.out.println("Answer is "+ans);
                startActivity(new Intent(test2page5.this,test2page6.class));
            }
        });
    }
    private void speak(){
        TextView tv=findViewById(R.id.ttvq3);
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
        startActivity(new Intent(test2page5.this,Home.class));
    }
}
