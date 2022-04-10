package ru.mirea.pashev_anton_bsbo_04_20.looper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private MyLooper myLooper;
    private EditText textage, textwork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textage = (EditText) findViewById(R.id.age1);
        textwork = (EditText) findViewById(R.id.work1);

        myLooper = new MyLooper();
        myLooper.start();
    }

    public void MessageQueue(View v){ ;
        Message msg = new Message();
        Bundle bundle = new Bundle();

        int age = Integer.parseInt(textage.getText().toString());
        String work = textwork.getText().toString();

        bundle.putInt("AGE", age);
        bundle.putString("WORK", work);

        msg.setData(bundle);
        if (myLooper != null) {
            myLooper.handler.sendMessage(msg);
        }

    }
}