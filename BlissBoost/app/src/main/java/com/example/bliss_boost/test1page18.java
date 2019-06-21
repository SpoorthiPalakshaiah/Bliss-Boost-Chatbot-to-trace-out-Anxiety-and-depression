package com.example.bliss_boost;

import android.content.Intent;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;


public class test1page18 extends AppCompatActivity {
    Button home,retake;
    ProgressBar pB;
    ProgressBar pB1;
    TextView tvpercent;
    TextView tvpercent1;
    TextView tvAnxietyLevel;
    TextView tvAnxietyLevel1;
   // static int sum=test1page3.ans+test1page4.ans2+test1page5.ans3+test1page6.ans4+test1page7.ans5+test1page8.ans6+test1page9.ans7+test1page10.ans8+test1page11.ans9+test1page12.ans10+test1page13.ans11+test1page14.ans12+test1page15.ans13+test1page16.ans14+test1page17.ans15;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1page18);

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
        if(((test1page3.ans+test1page4.ans2+test1page5.ans3+test1page6.ans4+test1page7.ans5+test1page8.ans6+test1page9.ans7+test1page10.ans8+test1page11.ans9+test1page12.ans10+test1page13.ans11+test1page14.ans12+test1page15.ans13+test1page16.ans14+test1page17.ans15)>=15)&&((test1page3.ans+test1page4.ans2+test1page5.ans3+test1page6.ans4+test1page7.ans5+test1page8.ans6+test1page9.ans7+test1page10.ans8+test1page11.ans9+test1page12.ans10+test1page13.ans11+test1page14.ans12+test1page15.ans13+test1page16.ans14+test1page17.ans15)<40)){
            cluster1=true;
        }
        else if(((test1page3.ans+test1page4.ans2+test1page5.ans3+test1page6.ans4+test1page7.ans5+test1page8.ans6+test1page9.ans7+test1page10.ans8+test1page11.ans9+test1page12.ans10+test1page13.ans11+test1page14.ans12+test1page15.ans13+test1page16.ans14+test1page17.ans15)>=40)&&((test1page3.ans+test1page4.ans2+test1page5.ans3+test1page6.ans4+test1page7.ans5+test1page8.ans6+test1page9.ans7+test1page10.ans8+test1page11.ans9+test1page12.ans10+test1page13.ans11+test1page14.ans12+test1page15.ans13+test1page16.ans14+test1page17.ans15)<=50)){
            cluster2=true;
        }
        else{
            cluster3=true;
        }
        double res=(test1page3.ans+test1page4.ans2+test1page5.ans3+test1page6.ans4+test1page7.ans5+test1page8.ans6+test1page9.ans7+test1page10.ans8+test1page11.ans9+test1page12.ans10+test1page13.ans11+test1page14.ans12+test1page15.ans13+test1page16.ans14+test1page17.ans15)/75.0;
        System.out.println(test1page3.ans+test1page4.ans2+test1page5.ans3+test1page6.ans4+test1page7.ans5+test1page8.ans6+test1page9.ans7+test1page10.ans8+test1page11.ans9+test1page12.ans10+test1page13.ans11+test1page14.ans12+test1page15.ans13+test1page16.ans14+test1page17.ans15);
     //   System.out.println(sum);
        System.out.println((int)java.lang.Math.floor(res*100));
        if(cluster1==true){
            pB=findViewById(R.id.pb);
            pB.setProgress((int)java.lang.Math.floor(res*100));
            tvpercent=findViewById(R.id.tvpercent);
            tvpercent.setText(""+(int)java.lang.Math.floor(res*100)+"%");
            tvAnxietyLevel=findViewById(R.id.tvAnxietyLevel);
            tvAnxietyLevel.setText("Congratulations!!You are not prone to Anxiety!Spread happiness within you wherever you go!");
        }
        else if(cluster2==true){
            pB=findViewById(R.id.pb);
            pB.setProgress((int)java.lang.Math.floor(res*100));
            tvpercent=findViewById(R.id.tvpercent);
            tvpercent.setText(""+(int)java.lang.Math.floor(res*100)+"%");
            tvAnxietyLevel=findViewById(R.id.tvAnxietyLevel);
            tvAnxietyLevel.setText("You are in border level to the risk of Anxiety!Keep calm and Rock on!!!");
        }
        else {
            if (cluster3 == true) {
                String cope="";
                pB1 = findViewById(R.id.pb);
                pB1.setProgress((int)java.lang.Math.floor(res*100));
                tvpercent1 = findViewById(R.id.tvpercent);
                tvpercent1.setText(""+(int)java.lang.Math.floor(res*100)+"%");
                tvAnxietyLevel1 = findViewById(R.id.tvAnxietyLevel);
                if(test1page3.ans==4){
                    cope=cope+"Do not try to be perfect.Bad days and setbacks may happen.Visualize a happy place.Take a moment to close your eyes and imagine a place of safety and calm...";
                }
                if(test1page3.ans==5){
                    cope=cope+"Take time out so you can physically calm down.Breathe slowly and deeply through panic.Face your fears with all the strength,it starts to fade...";
                }
                if(test1page6.ans4==4){
                    cope=cope+"Look at the evidence.It sometimes helps challenge fearful thoughts.Ask yourself what you would say to a friend who had a similar fear of avoiding situation....";

                }
                if(test1page6.ans4==5){
                    cope=cope+"Imagine the worst thing that can happen.Then try to think yourself into that situation.It's just not possible.The fear of facing such situations will run away....";

                }
                if(test1page7.ans5==4){
                    cope=cope+"Start small.Start practising to stand in smaller queues and set yourself up for success...";
                }
                if(test1page7.ans5==5){
                    cope=cope+"Practise to stand in queues.Be prepared to fully accept any weird feeling you might get while standing in queue.Check your breathing.Listen to a helpful recording while you wait...";
                }
                if(test1page9.ans7==4){
                    cope=cope+"Get some distance from the source of obsession.Stop feeding it.Distract yourself from obsessive thoughts.Focus on things you have neglected....";
                }
                if(test1page9.ans7==5){
                    cope=cope+"Learn to be in this moment.Strengthen your relationships with people.Pursue new interests.Make changes in your daily routine...";
                }
               if((test1page11.ans9==4)||(test1page11.ans9==5)) {
                   cope=cope+"Prepare for a situation if possible.Assume rapport in social situations.Remember people don't think about you and what you do that much really.Tell yourself that you are excited....";

               }
               if(test1page12.ans10==4){
                   cope=cope+"Reduce checking behavior.Checking your symptoms,reading about them online and asking others for resassurance may increase anxiety....";
               }
               if(test1page12.ans10==5){
                   cope=cope+"Revise your thinking.Avoid catastrophizing and jumping into conclusions.Avoid underestimating ability to cope....";
               }
               if(test1page13.ans11==4){
                   cope=cope+"Relax your body.Manage your emotions.Force yourself to slow down.Practice active listening and empathic listening.... ";
               }
               if(test1page13.ans11==5){
                   cope=cope+"Stop doing things that aren't important.Be mindful of the things making you impatient.Relax and take deep breaths...";
               }
               if((test1page14.ans12==4)||(test1page14.ans12==15)){
                   cope=cope+"Accept yourself as an imperfect being who is inherently subject to making mistakes about the future.Live life by probabilities,not by guarantees.Stop worrying and ruminating now...";
               }
               if((test1page17.ans15==4)||(test1page17.ans15==5)){
                   cope=cope+"Wake up at the same time each day.Limit naps.Exercise regularly.Limit activities in bed.Do not eat or drink right before going to bed.Make your sleeping environment comfortable.Get all your worrying over with before you go to bed....";
               }

                TextView tvCope=findViewById(R.id.tvcopetest1);
               tvCope.setText(cope);
               tvAnxietyLevel1.setText("You are at the higher rate of risk to Anxiety!!Keep calm and believe in yourself");
            }

        }

        home=findViewById(R.id.btnhome1);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(test1page18.this,Home.class));
            }

        });
        retake=findViewById(R.id.btnrt1);
        retake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(test1page18.this,AnxietyTest.class));

            }

        });

System.out.println(test1page3.ans);
        System.out.println(test1page3.ans+test1page4.ans2+test1page5.ans3+test1page6.ans4+test1page7.ans5+test1page8.ans6+test1page9.ans7+test1page10.ans8+test1page11.ans9+test1page12.ans10+test1page13.ans11+test1page14.ans12+test1page15.ans13+test1page16.ans14+test1page17.ans15);

    }
    private void speak(){
        TextView tv=findViewById(R.id.tvcopetest1);
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
        startActivity(new Intent(test1page18.this,Home.class));
    }
}

