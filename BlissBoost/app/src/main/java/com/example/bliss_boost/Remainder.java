package com.example.bliss_boost;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class Remainder extends AppCompatActivity implements View.OnClickListener{
    private int notificationId=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remainder);

        findViewById(R.id.btnSet).setOnClickListener(this);
        findViewById(R.id.btnCancel).setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        EditText editText=findViewById(R.id.ettask);
        TimePicker timePicker=findViewById(R.id.tp);

        //Set notifications and text
        Intent intent=new Intent(Remainder.this,AlarmReceiver.class);
        intent.putExtra("notificationId",notificationId);
        intent.putExtra("todo",editText.getText().toString());

        PendingIntent alarmIntent=PendingIntent.getBroadcast(Remainder.this,0,intent,PendingIntent.FLAG_CANCEL_CURRENT);

        AlarmManager alarm=(AlarmManager)getSystemService(ALARM_SERVICE);

        switch(v.getId()){
            case R.id.btnSet:
                int hour=timePicker.getCurrentHour();
                int minute=timePicker.getCurrentMinute();

                Calendar startTime=Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY,hour);
                startTime.set(Calendar.MINUTE,minute);
                startTime.set(Calendar.SECOND,0);
                long alarmStartTime=startTime.getTimeInMillis();

                alarm.set(AlarmManager.RTC_WAKEUP,alarmStartTime,alarmIntent);
                Toast.makeText(this,"Done!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnCancel:
                alarm.cancel(alarmIntent);
                Toast.makeText(this,"Cancel" +
                        "led!",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
