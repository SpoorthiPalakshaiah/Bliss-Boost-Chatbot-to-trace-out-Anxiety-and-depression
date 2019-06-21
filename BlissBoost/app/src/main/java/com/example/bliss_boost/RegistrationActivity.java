package com.example.bliss_boost;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class RegistrationActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    private EditText registername,registeremail,registerphone,registerpassword;
    private TextView userLogin;
    private Button registerbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setupUIViews();
        final DatabaseHelper myDb=new DatabaseHelper(this);
        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistrationActivity.this,MainActivity.class));
            }
        });

        AnxietyTest.mTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = AnxietyTest.mTTS.setLanguage(Locale.ENGLISH);
                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported");
                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });

        //For register button

        registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=registername.getText().toString();
                String s2=registerphone.getText().toString();
                String s3=registeremail.getText().toString();
                String s4=registerpassword.getText().toString();


                if(s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")){
                    Toast.makeText(getApplicationContext(),"Fill all the fields",Toast.LENGTH_SHORT).show();
                }
                else{

                    Boolean chkemail=myDb.chkemail(s3);
                   if(chkemail==true) {
                       Boolean isInserted = myDb.insertData(s1,s2,s3,s4);
                       if (isInserted == true) {
                           Toast.makeText(getApplicationContext(), "Registered successfully", Toast.LENGTH_SHORT).show();

                       }


                   }else{
                       Toast.makeText(getApplicationContext(), "Already registered! Login", Toast.LENGTH_SHORT).show();
                   }

            }
            }
        });

    }

    private void setupUIViews(){
        registername=(EditText)findViewById(R.id.etnameRegister);
        registerphone=(EditText)findViewById(R.id.etphoneRegister);
        registeremail=(EditText)findViewById(R.id.etemailRegister);
        registerpassword=(EditText)findViewById(R.id.etpasswordRegister);
        userLogin=(TextView)findViewById(R.id.tvLogin);
        registerbutton=(Button)findViewById(R.id.btnRegister);
    }
}
