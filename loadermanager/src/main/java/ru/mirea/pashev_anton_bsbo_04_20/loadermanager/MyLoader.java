package ru.mirea.pashev_anton_bsbo_04_20.loadermanager;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.loader.content.AsyncTaskLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MyLoader extends AsyncTaskLoader<String> {

    Random random = new Random();
    String text;

    public static final String ARG_WORD = "word";
    public MyLoader(@NonNull Context context, Bundle args) {
        super(context);
        if (args != null)
            text = args.getString(ARG_WORD);
    }
    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public String loadInBackground() {
        List<String> arr = Arrays.asList(text.split(""));
        Collections.shuffle(arr);
        String text1 = String.join("",arr);
        SystemClock.sleep(3000);
        return text1;
    }
}
