package com.example.fragmentdata;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements Fragment1.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = findViewById(R.id.data);
                String data = editText.getText().toString();
                Fragment1 fragment1 = new Fragment1();

                Bundle  bundle = new Bundle();
                bundle.putString("Data",data);
                fragment1.setArguments(bundle);

              getSupportFragmentManager().beginTransaction().add(R.id.fragment1,fragment1).commit();
            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
