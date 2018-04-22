package com.bounouamustapha.mata3im.Activities;

import android.app.Application;

import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

/**
 * Created by bounouamustapha on 4/22/18.
 */

public class Myapp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Iconify
                .with(new FontAwesomeModule());

    }
}
