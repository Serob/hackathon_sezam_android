package com.spb.sezam;

import java.lang.Thread.UncaughtExceptionHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import android.app.Application;

public class App extends Application {
    private UncaughtExceptionHandler defaultUEH;
    
    private UncaughtExceptionHandler unCaughtExceptionHandler =
        new UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread thread, Throwable ex) {
                // here is logging of exception into a db
            	 Logger SlfLogger = LoggerFactory.getLogger(App.class);
                 SlfLogger.error("Error accured in thread " + thread.getName(), ex);

                // re-throw critical exception further to the os (important)
                defaultUEH.uncaughtException(thread, ex);
            }
        };
        
    public App() {
        defaultUEH = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(unCaughtExceptionHandler);
    }
}
