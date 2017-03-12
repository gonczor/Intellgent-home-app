package com.gonczor.intelligenthomeapp;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import java.io.*;
import java.net.*;
import java.util.*;

import java.io.IOException;

public class MainActivity extends Activity {

    private Button serverButton;
    private Button exitAppButton;

    public static final String debugString = "debug";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        this.serverButton = (Button) this.findViewById(R.id.connect_server_button);
        this.serverButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                try (Socket s = new Socket("127.0.0.1", 12345)){
                    InputStream inStream = s.getInputStream();
                    Scanner in = new Scanner(inStream);

                    while (in.hasNextLine()){
                        String line = in.nextLine();
                        System.out.println(line);
                    }
                }
                catch (IOException e){
                    System.out.println("something goes wrong");
                    Log.e(debugString,e.getMessage());
                }
            }
        });

        this.exitAppButton = (Button) this.findViewById(R.id.exitApp);
        this.exitAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }
}
