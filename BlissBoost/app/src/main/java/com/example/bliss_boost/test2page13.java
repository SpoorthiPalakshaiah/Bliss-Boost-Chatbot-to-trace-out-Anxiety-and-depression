package com.example.bliss_boost;
import android.content.Intent;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class test2page13 extends AppCompatActivity {
    ProgressBar pB;
    ProgressBar pB1;
    TextView tvpercent;
    TextView tvpercent1;
    TextView tvAnxietyLevel;
    TextView tvAnxietyLevel1;
    static int sum=test2page3.ans+test2page4.ans2+test2page5.ans3+test2page6.ans4+test2page7.ans5+test2page8.ans6+test2page9.ans7+test2page10.ans8+test2page11.ans9+test2page12.ans10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2page13);

        final Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                speak();
            }
        },40);

        boolean cluster1=false;
        boolean cluster2=false;
        boolean cluster3=false;
        if((test2page3.ans+test2page4.ans2+test2page5.ans3+test2page6.ans4+test2page7.ans5+test2page8.ans6+test2page9.ans7+test2page10.ans8+test2page11.ans9+test2page12.ans10>=10)&&(test2page3.ans+test2page4.ans2+test2page5.ans3+test2page6.ans4+test2page7.ans5+test2page8.ans6+test2page9.ans7+test2page10.ans8+test2page11.ans9+test2page12.ans10<25)){
            cluster1=true;
        }

        else if((test2page3.ans+test2page4.ans2+test2page5.ans3+test2page6.ans4+test2page7.ans5+test2page8.ans6+test2page9.ans7+test2page10.ans8+test2page11.ans9+test2page12.ans10>=25)&&(test2page3.ans+test2page4.ans2+test2page5.ans3+test2page6.ans4+test2page7.ans5+test2page8.ans6+test2page9.ans7+test2page10.ans8+test2page11.ans9+test2page12.ans10<=30)){
            cluster2=true;
        }
        else{
            cluster3=true;

        }
        double res=(test2page3.ans+test2page4.ans2+test2page5.ans3+test2page6.ans4+test2page7.ans5+test2page8.ans6+test2page9.ans7+test2page10.ans8+test2page11.ans9+test2page12.ans10)/40.0;
        //   System.out.println(test1page3.ans+test1page4.ans2+test1page5.ans3+test1page6.ans4+test1page7.ans5+test1page8.ans6+test1page9.ans7+test1page10.ans8+test1page11.ans9+test1page12.ans10+test1page13.ans11+test1page14.ans12+test1page15.ans13+test1page16.ans14+test1page17.ans15);
        System.out.println(sum);
        System.out.println((int)java.lang.Math.floor(res*100));
        if(cluster1==true){
            pB=findViewById(R.id.tpb);
            pB.setProgress((int)java.lang.Math.floor(res*100));
            tvpercent=findViewById(R.id.tvpercent1);
            tvpercent.setText(""+(int)java.lang.Math.floor(res*100)+"%");
            tvAnxietyLevel=findViewById(R.id.ttvAnxietyLevel);
            tvAnxietyLevel.setText("Congratulations!!You are not prone to Depression!Spread happiness within you wherever you go!");
        }
        else if(cluster2==true){
            pB=findViewById(R.id.tpb);
            pB.setProgress((int)java.lang.Math.floor(res*100));
            tvpercent=findViewById(R.id.tvpercent1);
            tvpercent.setText(""+(int)java.lang.Math.floor(res*100)+"%");
            tvAnxietyLevel=findViewById(R.id.ttvAnxietyLevel);
            tvAnxietyLevel.setText("You are in border level to the risk of Depression!Keep calm and Rock on!!!");
        }
        else {
            if (cluster3 == true) {
                pB1 = findViewById(R.id.tpb);
                pB1.setProgress((int)java.lang.Math.floor(res*100));
                tvpercent1 = findViewById(R.id.tvpercent1);
                tvpercent1.setText(""+(int)java.lang.Math.floor(res*100)+"%");
                tvAnxietyLevel1 = findViewById(R.id.ttvAnxietyLevel);
                tvAnxietyLevel1.setText("You are at the higher rate of risk to Depression!!Keep calm and believe in yourself");

                String cope="To overcome the risk of depression:                                  "+"Look for support from people who make you feel safe and cared for...Try to keep up with social activities even if you don't feel like it... Care for a pet... Do things you enjoy... Aim for eight hours of sleep..Keep stress in check..Practice relaxation techniques..Find exercises that are continuous and rhythmic...Don't skip meals...Boost you food with B-vitamins and foods rich in omega-3 fatty acids...";
                TextView tvCope=findViewById(R.id.tvcopetest2);
                tvCope.setText(cope);
            }

        }
       Button home=findViewById(R.id.btnhome2);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(test2page13.this,Home.class));
            }

        });
       Button retake=findViewById(R.id.btnrt2);
        retake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(test2page13.this,DepressionTest.class));

            }

        });
    }

    private void speak(){
        TextView tv=findViewById(R.id.tvcopetest2);
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
}