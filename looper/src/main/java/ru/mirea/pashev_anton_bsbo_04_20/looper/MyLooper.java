package ru.mirea.pashev_anton_bsbo_04_20.looper;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

public class MyLooper extends Thread {
    private int number = 0;
    Handler handler;

    @SuppressLint("HandlerLeak")
    @Override
    public void run() {
        Log.d("MyLooper", "run");
        Looper.prepare();
        handler = new Handler() {

            @Override
            public void handleMessage(Message msg) {

                int age = msg.getData().getInt("AGE");
                String work = msg.getData().getString("WORK");

                try {
                    Thread.sleep(age);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                Log.d("MyLooper", "age" + ": " + age);
                Log.d("MyLooper", "work" + ": " + work);
                number++;
            }
        };
        Looper.loop();
    }
}
