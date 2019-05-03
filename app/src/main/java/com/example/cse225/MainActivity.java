package com.example.cse225;

import android.os.Handler;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AlertDialogClass.AlertDialofInterface {

    TextView name1,password1;

    ContentLoadingProgressBar progressBar;
    private int progressStatus=0;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name1 = findViewById(R.id.name);
        password1 = findViewById(R.id.password);
        progressBar = findViewById(R.id.progress_horizontal);
        progressBar.setProgress(0);

        findViewById(R.id.alertdialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog();
            }
        });


    }

    public void dialog(){
        AlertDialogClass alertDialogClass = new AlertDialogClass();
        alertDialogClass.show(getSupportFragmentManager(),"Aakash");
    }

    @Override
    public void applytext(String name, String password) {

        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < 100) {
                    progressStatus += 10;
                    // Update the progress bar and display the
                    //current value in the text view
                    handler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(progressStatus);
                        }
                    });
                    try {
                        // Sleep for 200 milliseconds.
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


        name1.setText(name);
        password1.setText(password);

    }
}
