package com.example.pdfsample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnDrawListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* PDFView view = findViewById(R.id.pdfView);
        view.fromAsset("dummy.pdf").enableSwipe(true)
                .swipeHorizontal(true)
                .load();*/
        Button button = findViewById(R.id.table);
        button.setOnClickListener(view -> {
            startActivity(new Intent(this,TableActivity.class));
        });
        new CountDownTimer(10000,1000){

            @Override
            public void onTick(long l) {
                Log.i("CountDownTimer",""+String.valueOf(l));
            }

            @Override
            public void onFinish() {
                Log.i("CountDownTimer","Timer is Finished");
            }
        }.start();
    }
}