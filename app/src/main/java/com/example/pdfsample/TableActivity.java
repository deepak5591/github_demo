package com.example.pdfsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;

public class TableActivity extends AppCompatActivity {
    SeekBar seekBar;
    ListView listView;
    ArrayList<String>  tableContent = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        seekBar = findViewById(R.id.seekbar);
        listView = findViewById(R.id.list);
        seekBar.setMax(20);
        seekBar.setProgress(1);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                int min = 1;
                int timeTable;


                if (progress < 1) {
                    timeTable = min;
                    seekBar.setProgress(min);
                } else {
                 timeTable = progress;
                }
                generateTimeTable(timeTable);
                Log.d("TimeTable",""+Integer.toString(timeTable));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        generateTimeTable(1);

    }
    public void generateTimeTable(int tableCount){
          tableContent.clear();
        for(int i=1;i<=10;i++){
            tableContent.add(Integer.toString(i*tableCount));
        }
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,tableContent);
        listView.setAdapter(adapter);
        Log.d("TableActivity","Size of Array:"+tableContent.size());

    }
}