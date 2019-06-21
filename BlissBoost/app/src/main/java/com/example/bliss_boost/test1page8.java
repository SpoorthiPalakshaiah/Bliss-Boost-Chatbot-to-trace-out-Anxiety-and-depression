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

public class test1page8 extends AppCompatActivity {

    TextView ansprev;
    TextView ansprev1;
    TextView ansprev2;
    TextView ansprev3;
    TextView ansprev4;
    static int ans6=0;
    static String a6;
    private ScrollView Scroll6;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1page8);

        ansprev=findViewById(R.id.tvReply3);
        ansprev.setText(test1page3.a1);
        ansprev1=findViewById(R.id.tvReply4);
        ansprev1.setText(test1page4.a2);
        ansprev=findViewById(R.id.tvReply5);
        ansprev.setText(test1page5.a3);
        ansprev=findViewById(R.id.tvReply6);
        ansprev.setText(test1page6.a4);
        ansprev=findViewById(R.id.tvReply7);
        ansprev.setText(test1page7.a5);

        Scroll6=findViewById(R.id.scroll6);
        Scroll6.post(new Runnable() {
            @Override
            public void run() {
                Scroll6.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });

        final Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                speak();
            }
        },40);

        radioGroup=findViewById(R.id.rg6);
        Button btnd4=findViewById(R.id.btna6);
        btnd4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int radioId=radioGroup.getCheckedRadioButtonId();
                radioButton=findViewById(radioId);
                //  System.out.println("String is"+radioButton.getText().toString());
                a6=radioButton.getText().toString();
                if(radioButton.getText().toString().equals("Never")){
                    ans6=1;
                }
                else if(radioButton.getText().toString().equals("Rarely")){
                    ans6=2;
                }
                else if(radioButton.getText().toString().equals("Sometimes")){
                    ans6=3;
                }
                else if(radioButton.getText().toString().equals("Frequently")){
                    ans6=4;
                }
                else{
                    ans6=5;
                }

                //  System.out.println("Answer is "+ans);
                startActivity(new Intent(test1page8.this,test1page9.class));
            }
        });
    }
    private void speak(){
        TextView tv=findViewById(R.id.tvq6);
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
        startActivity(new Intent(test1page8.this,Home.class));
    }
}

