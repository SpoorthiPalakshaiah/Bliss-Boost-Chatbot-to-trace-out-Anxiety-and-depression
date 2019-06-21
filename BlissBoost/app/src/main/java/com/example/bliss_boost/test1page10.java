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

public class test1page10 extends AppCompatActivity {

    TextView ansprev;
    TextView ansprev1;
    static int ans8=0;
    static String a8;
    private ScrollView Scroll8;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1page10);

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

        Scroll8=findViewById(R.id.scroll8);
        Scroll8.post(new Runnable() {
            @Override
            public void run() {
                Scroll8.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });

        final Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                speak();
            }
        },40);

        radioGroup=findViewById(R.id.rg8);
        Button btnd4=findViewById(R.id.btna8);
        btnd4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int radioId=radioGroup.getCheckedRadioButtonId();
                radioButton=findViewById(radioId);
                //  System.out.println("String is"+radioButton.getText().toString());
                a8=radioButton.getText().toString();
                if(radioButton.getText().toString().equals("No")){
                    ans8=1;
                }
                else if(radioButton.getText().toString().equals("Yes,but not that often")){
                    ans8=2;
                }
                else if(radioButton.getText().toString().equals("Somewhat")){
                    ans8=3;
                }
                else if(radioButton.getText().toString().equals("Frequently")){
                    ans8=4;
                }
                else{
                    ans8=5;
                }

                //  System.out.println("Answer is "+ans);
                startActivity(new Intent(test1page10.this,test1page11.class));
            }
        });
    }
    private void speak(){
        TextView tv=findViewById(R.id.tvq8);
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
        startActivity(new Intent(test1page10.this,Home.class));
    }
}

