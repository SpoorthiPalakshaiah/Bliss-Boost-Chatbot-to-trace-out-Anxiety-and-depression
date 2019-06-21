package com.example.bliss_boost;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import java.io.IOException;
import java.util.Calendar;


public class ProgressTracker extends AppCompatActivity implements  DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener{
    String names[]={"Great","Very Good","Good","Okay","Not Good","Bad","Awful"};
    CircleMenu circleMenu;
    Button next;
    int day,month,year,hour,minute,second;
    int dayFinal,monthFinal,yearFinal,minuteFinal,hourFinal,day_of_week;
    String moment;
    public static String date;
    public static String mood_selected;
    SQLiteDatabase sqLiteDatabase;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_tracker);
        //  circleMenu = (CircleMenu) findViewById(R.id.cm) ;

        circleMenu=(CircleMenu)findViewById(R.id.cm);
        //    circleMenu.setMainMenu(Color.parseColor("#CDCDCD"),R.drawable.mood,R.drawable.remove)
        circleMenu.setMainMenu(Color.parseColor("#CDCDCD"),R.drawable.mood,R.drawable.remove)
                .addSubMenu(Color.parseColor("#008080"),R.drawable.great_ed)
                .addSubMenu(Color.parseColor("#87CEFA"),R.drawable.very_good)
                .addSubMenu(Color.parseColor("#DCDCDC"),R.drawable.good_ed)
                .addSubMenu(Color.parseColor("#FFD700"),R.drawable.okay_ed)
                .addSubMenu(Color.parseColor("#98FB98"),R.drawable.notgood_ed)
                .addSubMenu(Color.parseColor("#000000"),R.drawable.bad_ed)

                .addSubMenu(Color.parseColor("#DDA0DD"),R.drawable.awful_ed)

                .setOnMenuSelectedListener(new OnMenuSelectedListener() {
                    @Override
                    public void onMenuSelected(int index) {
                        //Toast.makeText(getApplicationContext(),"Yay!Nice work.You should be proud of yourself.",Toast.LENGTH_SHORT).show();

                        if(names[index]=="Great"){
                            mood_selected="Great";
                            Toast.makeText(getApplicationContext(),"You Selected :"+names[index],Toast.LENGTH_LONG).show();

                            Toast.makeText(getApplicationContext(),"Yay!Nice work.You should be proud of yourself.",Toast.LENGTH_LONG).show();}
                        //startActivity(new Intent(ProgressTracker.this,pick_date_mood.class));}

                        if(names[index]=="Very Good"){
                            mood_selected="Very Good";
                            Toast.makeText(getApplicationContext(),"You Selected :"+names[index],Toast.LENGTH_LONG).show();

                            Toast.makeText(getApplicationContext(),"Kudos!Remember that you are amazing.",Toast.LENGTH_LONG).show();}

                        if(names[index]=="Good"){
                            mood_selected="Good";
                            Toast.makeText(getApplicationContext(),"You Selected :"+names[index],Toast.LENGTH_LONG).show();

                            Toast.makeText(getApplicationContext(),"Yay!Nice work.You should be proud of yourself.",Toast.LENGTH_LONG).show();}

                        if(names[index]=="Okay"){
                            mood_selected="Okay";
                            Toast.makeText(getApplicationContext(),"You Selected :"+names[index],Toast.LENGTH_LONG).show();

                            Toast.makeText(getApplicationContext(),"No matter how you feel,get up,dress up,show up,and never give up.",Toast.LENGTH_LONG).show();}

                        if(names[index]=="Not Good"){
                            mood_selected="Not Good";
                            Toast.makeText(getApplicationContext(),"You Selected :"+names[index],Toast.LENGTH_LONG).show();

                            Toast.makeText(getApplicationContext(),"You are a work in progress.Try not to be too hard on yourself.",Toast.LENGTH_LONG).show();}

                        if(names[index]=="Bad"){
                            mood_selected="Bad";
                            Toast.makeText(getApplicationContext(),"You Selected :"+names[index],Toast.LENGTH_LONG).show();

                            Toast.makeText(getApplicationContext(),"You have to fight through some bad days to earn the best days of your lives.Dont give up.",Toast.LENGTH_LONG).show();}

                        if(names[index]=="Awful"){
                            mood_selected="Awful";
                            Toast.makeText(getApplicationContext(),"You Selected :"+names[index],Toast.LENGTH_LONG).show();

                            Toast.makeText(getApplicationContext(),"Hang in there,Things are hard right now and that's okay.",Toast.LENGTH_LONG).show();}



                    }
                });

        next=(Button)findViewById(R.id.next_button);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(ProgressTracker.this,pick_date_mood.class));
                Calendar c= Calendar.getInstance();
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day = c.get(Calendar.DAY_OF_MONTH);
                int day_of_week=c.get(Calendar.DAY_OF_WEEK);
                String[] w={"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};

                date=w[day_of_week-1];
                //date=Integer.toString(day)+""+Integer.toString(month)+""+Integer.toString(year);


                DatePickerDialog datePickerDialog=new DatePickerDialog(ProgressTracker.this,ProgressTracker.this,year,month,day);
                datePickerDialog.show();
            }

        });


    }
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2){
        yearFinal=i;
        monthFinal=i1+1;
        dayFinal=i2;

        Calendar c= Calendar.getInstance();
        hour= c.get(Calendar.HOUR_OF_DAY);
        minute=c.get(Calendar.MINUTE);
        second=c.get(Calendar.SECOND);

        String  time=hour+":"+minute;
        // time=hour+""+minute;
        moment=time;
    //    Toast.makeText(getApplicationContext(),moment,Toast.LENGTH_SHORT).show();

        TimePickerDialog timePickerDialog=new TimePickerDialog(ProgressTracker.this,ProgressTracker.this,hour,minute, DateFormat.is24HourFormat(this));
        timePickerDialog.show();

    }
    public void onTimeSet(TimePicker timePicker, int i, int i1){
        hourFinal=i;
        minuteFinal=i1;

     //   Toast.makeText(getApplicationContext(),"Entered",Toast.LENGTH_SHORT).show();
        databaseHelper=new DatabaseHelper(this);
        sqLiteDatabase=databaseHelper.getWritableDatabase();
        String[] columns = {"email","date","mood"};

        //databaseHelper.execSQL("delete from mood_tab where email='a'");
        //sqLiteDatabase.execSQL("delete from mood_tab where email='a'");

        Boolean isInserted = databaseHelper.insertDataintomood(MainActivity.em,moment,mood_selected);
    //    Toast.makeText(getApplicationContext(),"Exec",Toast.LENGTH_SHORT).show();
        if(isInserted==true){
    //        Toast.makeText(getApplicationContext(), "Inserted Successfully", Toast.LENGTH_SHORT).show();

            Cursor cursor = sqLiteDatabase.query("mood_tab", columns, null, null, null, null, null);

    //        Toast.makeText(getApplicationContext(), ""+cursor.getCount(), Toast.LENGTH_SHORT).show();
            String nd="";
            for ( i = 0; i < cursor.getCount(); i++) {

                cursor.moveToNext();
                nd=cursor.getString(1);

            }

    //        Toast.makeText(getApplicationContext(), ""+nd, Toast.LENGTH_SHORT).show();


        }
        startActivity(new Intent(ProgressTracker.this,graph_out.class));





    }


}
