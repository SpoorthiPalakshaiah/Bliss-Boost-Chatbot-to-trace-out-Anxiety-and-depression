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

public class test1page5 extends AppCompatActivity {
    TextView ansprev;
    TextView ansprev1;
    static int ans3=0;
    static String a3;
    private ScrollView Scroll3;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1page5);
        //   System.out.println("\n\n\n\n\n"+test1page4.a2);
        ansprev=findViewById(R.id.tvReply3);
        ansprev.setText(test1page3.a1);
        ansprev1=findViewById(R.id.tvReply4);
        ansprev1.setText(test1page4.a2);

        Scroll3=findViewById(R.id.scroll3);
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

        radioGroup=findViewById(R.id.rg3);
        Button btnd3=findViewById(R.id.btna3);
        btnd3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int radioId=radioGroup.getCheckedRadioButtonId();
                radioButton=findViewById(radioId);
                //  System.out.println("String is"+radioButton.getText().toString());
                a3=radioButton.getText().toString();
                if(radioButton.getText().toString().equals("No")){
                    ans3=1;
                }
                else if(radioButton.getText().toString().equals("Yes,but not that often")){
                    ans3=2;
                }
                else if(radioButton.getText().toString().equals("Yes,sometimes")){
                    ans3=3;
                }
                else if(radioButton.getText().toString().equals("Frequently")){
                    ans3=4;
                }
                else{
                    ans3=5;
                }

                //  System.out.println("Answer is "+ans);
                startActivity(new Intent(test1page5.this,test1page6.class));
            }
        });
    }
    private void speak(){
        TextView tv=findViewById(R.id.tvq3);
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
        startActivity(new Intent(test1page5.this,Home.class));
    }
}
