package com.example.notificaation;

import android.app.RemoteInput;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle bundle = RemoteInput.getResultsFromIntent(getIntent());

        String name = bundle.getCharSequence(NotificationHandler.TXT_REPLY).toString();

        TextView textView = findViewById(R.id.text);

        textView.setText(name);
    }
}
