package com.example.contextualactionmodedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.contextualactionmodedemo.R;

public class MainActivity extends AppCompatActivity {

    ActionMode actionMode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.mode).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(actionMode!=null)
                return false;

                actionMode = startSupportActionMode(callback);
                return true;

            }
        });
    }

    ActionMode.Callback callback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {

            actionMode.getMenuInflater().inflate(R.menu.menu,menu);
            actionMode.setTitle("Hello");
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {

            switch (menuItem.getItemId()){
                case R.id.search:
                    Toast.makeText(MainActivity.this,"Search",Toast.LENGTH_SHORT).show();
                    actionMode.finish();
                    break;
                default:
                    Toast.makeText(MainActivity.this,"Search",Toast.LENGTH_SHORT).show();
                    actionMode.finish();

            }
            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {
            actionMode=null;

        }
    };

}
