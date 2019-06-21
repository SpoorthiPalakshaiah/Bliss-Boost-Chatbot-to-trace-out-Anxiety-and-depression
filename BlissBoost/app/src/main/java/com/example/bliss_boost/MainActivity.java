package com.example.bliss_boost;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class
MainActivity extends AppCompatActivity {

    public static String KEY_EMAIL="email";
    public static String KEY_PASSWORD="password";

    private TextView userRegister;
    private EditText emailLogin,passwordLogin;
    private Button Loginbutton;
    private CheckBox saveLoginCheckBox;
    private SharedPreferences loginPreferences;
    private SharedPreferences.Editor loginPrefsEditor;
    private Boolean saveLogin;
    private CheckBox rememberme;
    static String em;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUIViews();
        final DatabaseHelper myDb=new DatabaseHelper(this);
     //   rememberme=(CheckBox)findViewById(R.id.cbRemember);


        Loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = emailLogin.getText().toString();
                String s2 = passwordLogin.getText().toString();
                StringBuffer buffer = new StringBuffer();
                em=s1;
                System.out.println(s1);
                System.out.println(s2);

                Cursor res;
                res = myDb.getAllData(s1);
                if (res.getCount() > 0) {
                    while (res.moveToNext()) {
                        buffer.append(res.getString(3));
                    }
                    //   showMessage("Data", buffer.toString());


                }


                if (s1.equals("") || s2.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fill all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    if (s2.equals(buffer.toString())) {
                        Toast.makeText(getApplicationContext(), "Logged in successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this,Home.class));
                    } else {
                        Toast.makeText(getApplicationContext(), "Fill all the fields with correct credentials", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });



        userRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RegistrationActivity.class));
            }
        });

       // saveLogin=loginPreferences.getBoolean("saveLogin",true);

    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    private void setupUIViews(){
        userRegister=(TextView)findViewById(R.id.tvRegister);
        emailLogin=(EditText)findViewById(R.id.etemailLogin);
        passwordLogin=(EditText)findViewById(R.id.etpasswordLogin);
        Loginbutton=(Button)findViewById(R.id.btnLogin);



    }




}
