package com.example.dell.myapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by DELL on 6/10/2016.
 */
public class Splash extends Activity {
    private static long SLEEP_TIME = 3;

    @Override public void onResume() { super.onResume(); Memo.setContext(this); }
    @Override public void onPause() { super.onPause(); Memo.setContext(null); }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Memo.setContext(this);
        setContentView(R.layout.splash);
        new IntentLauncher().start();

//dbHandler.deleteDatabase(); // TODO remove this test line!!!
        // new dbHandler().getReadableDatabase().close();
//        if (Utils.isOnline(this)) {
//            new IntentLauncher().start();
//        }
    }
    private class IntentLauncher extends Thread {
        public void run() {
            try { sleep(SLEEP_TIME * 1000); } catch (Exception e) {;}

                startActivity(new Intent(Splash.this, MainActivity.class));

            finish();

        }
    }
}
