package com.example.bliss_boost;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;

public class graph_out extends AppCompatActivity {
    SQLiteDatabase sqLiteDatabase;
    DatabaseHelper db;
    Button result_botton;


    LineDataSet lineDataSet;
    ArrayList<ILineDataSet> dataSets = new ArrayList<>();
    LineData lineData;


    LineChart lineChart;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_out);


        db = new DatabaseHelper(this);
        sqLiteDatabase = db.getWritableDatabase();

        LineChartView lineChartView = findViewById(R.id.chart);
        String[] columns = {"email", "date", "mood"};

        Cursor cursor = sqLiteDatabase.query("mood_tab", columns, "email='"+MainActivity.em+"'", null, null, null, null);



        String[] axisData =new String[cursor.getCount()];
        String[] yAxisData=new String[cursor.getCount()];
        for (int i = 0; i < cursor.getCount(); i++) {

            cursor.moveToNext();
            axisData[i]=cursor.getString(1);
            yAxisData[i]=cursor.getString(2);

        }

        String[] labels={"Great","Very Good","Good","Okay","Not Good","Bad","Awful"};

        List yAxisValues = new ArrayList();
        List axisValues = new ArrayList();
        Line line = new Line(yAxisValues).setColor(Color.parseColor("#9C27B0"));
        for(int i = 0; i < axisData.length; i++){
            axisValues.add(i, new AxisValue(i).setLabel(axisData[i]));
        }

        for(int i = 0; i < yAxisData.length; i++){
            yAxisValues.add(i, new PointValue(i, 1*(6-Arrays.asList(yAxisData).indexOf(yAxisData[i]))));
        }



        List lines = new ArrayList();

        lines.add(line);
        LineChartData data = new LineChartData();
        data.setLines(lines);
        lineChartView.setLineChartData(data);

        Axis axis = new Axis();
        axis.setValues(axisValues);
        axis.setTextColor(Color.parseColor("#03A9F4"));

        data.setAxisXBottom(axis);

        Axis yAxis = new Axis();
        yAxis.setTextColor(Color.parseColor("#FF0000"));
        yAxis.setTextSize(16);
        yAxis.setName("Mood (Awful - Great)");
        axis.setName("Time");



        data.setAxisYLeft(yAxis);


        lineChartView.animate();
        yAxis.setHasTiltedLabels(true);

        Viewport viewport = new Viewport(lineChartView.getMaximumViewport());
        viewport.top =7;

        lineChartView.setMaximumViewport(viewport);
        lineChartView.setCurrentViewport(viewport);







    }


    private ArrayList<com.github.mikephil.charting.data.Entry> getDataValues() {
        int val=0;

        ArrayList<com.github.mikephil.charting.data.Entry> dataVals = new ArrayList<>();

        String[] columns = {"email", "date", "mood"};

        Cursor cursor = sqLiteDatabase.query("mood_tab", columns, "email='q'", null, null, null, null);

        for (int i = 0; i < cursor.getCount(); i++) {

            cursor.moveToNext();


            dataVals.add(new Entry(cursor.getFloat(1), val));
            Toast.makeText(getApplicationContext(),cursor.getString(2),Toast.LENGTH_SHORT).show();

        }

        return dataVals;
    }




}

