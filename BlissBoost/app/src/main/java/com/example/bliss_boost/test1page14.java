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

public class test1page14 extends AppCompatActivity {

    TextView ansprev;
    TextView ansprev1;
    static int ans12=0;
    static String a12;
    private ScrollView Scroll12;
    private RadioGroup radioGroup;
    private RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1page14);

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
        ansprev=findViewById(R.id.tvReply8);
        ansprev.setText(test1page8.a6);
        ansprev=findViewById(R.id.tvReply9);
        ansprev.setText(test1page9.a7);
        ansprev=findViewById(R.id.tvReply10);
        ansprev.setText(test1page10.a8);
        ansprev=findViewById(R.id.tvReply11);
        ansprev.setText(test1page11.a9);
        ansprev=findViewById(R.id.tvReply12);
        ansprev.setText(test1page12.a10);
        ansprev=findViewById(R.id.tvReply13);
        ansprev.setText(test1page13.a11);


        Scroll12=findViewById(R.id.scroll12);
        Scroll12.post(new Runnable() {
            @Override
            public void run() {
                Scroll12.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });

        final Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                speak();
            }
        },40);

        radioGroup=findViewById(R.id.rg12);
        Button btnd4=findViewById(R.id.btna12);
        btnd4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int radioId=radioGroup.getCheckedRadioButtonId();
                radioButton=findViewById(radioId);
                //  System.out.println("String is"+radioButton.getText().toString());
                a12=radioButton.getText().toString();
                if(radioButton.getText().toString().equals("Never")){
                    ans12=1;
                }
                else if(radioButton.getText().toString().equals("Not very often")){
                    ans12=2;
                }
                else if(radioButton.getText().toString().equals("Sometimes")){
                    ans12=3;
                }
                else if(radioButton.getText().toString().equals("Frequently")){
                    ans12=4;
                }
                else{
                    ans12=5;
                }

                //  System.out.println("Answer is "+ans);
                startActivity(new Intent(test1page14.this,test1page15.class));
            }
        });
    }
    private void speak(){
        TextView tv=findViewById(R.id.tvq12);
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
        startActivity(new Intent(test1page14.this,Home.class));
    }
}

