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

public class test1page16 extends AppCompatActivity {

    TextView ansprev;
    TextView ansprev1;
    static int ans14=0;
    static String a14;
    private ScrollView Scroll14;
    private RadioGroup radioGroup;
    private RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1page16);


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
        ansprev=findViewById(R.id.tvReply14);
        ansprev.setText(test1page14.a12);
        ansprev=findViewById(R.id.tvReply15);
        ansprev.setText(test1page15.a13);


        Scroll14=findViewById(R.id.scroll14);
        Scroll14.post(new Runnable() {
            @Override
            public void run() {
                Scroll14.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });

        final Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                speak();
            }
        },40);

        radioGroup=findViewById(R.id.rg14);
        Button btnd4=findViewById(R.id.btna14);
        btnd4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int radioId=radioGroup.getCheckedRadioButtonId();
                radioButton=findViewById(radioId);
                //  System.out.println("String is"+radioButton.getText().toString());
                a14=radioButton.getText().toString();
                if(radioButton.getText().toString().equals("Never")){
                    ans14=1;
                }
                else if(radioButton.getText().toString().equals("Rarely")){
                    ans14=2;
                }
                else if(radioButton.getText().toString().equals("Sometimes")){
                    ans14=3;
                }
                else if(radioButton.getText().toString().equals("Frequently")){
                    ans14=4;
                }
                else{
                    ans14=5;
                }

                //  System.out.println("Answer is "+ans);
                startActivity(new Intent(test1page16.this,test1page17.class));
            }
        });
    }
    private void speak(){
        TextView tv=findViewById(R.id.tvq14);
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
        startActivity(new Intent(test1page16.this,Home.class));
    }
}

