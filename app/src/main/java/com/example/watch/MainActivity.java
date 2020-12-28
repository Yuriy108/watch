package com.example.watch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private int seconds;
    private boolean flag=false;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        isRaning();
    }

    public void start(View view) {
        flag=true;

    }

    public void pouse(View view) {
        flag=false;
    }

    public void restart(View view) {
        flag=false;
        seconds=0;

    }
    public void isRaning(){
        final Handler handler=new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours=seconds/3600;
                int min=seconds%3600/60;
                int sec=seconds%60;
                String time= String.format(Locale.getDefault(),"%d:%02d:%02d",hours,min,sec);
                textView.setText(time);
                if(flag){seconds++;}
                handler.postDelayed(this,1000);

            }
        });

    }
}
