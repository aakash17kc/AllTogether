package com.example.cse225;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class AlertDialogClass extends AppCompatDialogFragment {

    EditText name,password;

    AlertDialofInterface alertDialofInterface;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        View view = LayoutInflater.from(getContext()).inflate(R.layout.alert_layout,null);
        builder.setView(view);


        name = view.findViewById(R.id.name1);
        password = view.findViewById(R.id.password1);



        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String name1  = name.getText().toString();
                String pass = password.getText().toString();
                alertDialofInterface.applytext(name1,pass);




            }
        });

        return builder.create();


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            alertDialofInterface = (AlertDialofInterface) context;

        }catch (ClassCastException e){
            throw new ClassCastException(context.toString() +"mus implament");
        }
    }

    public interface AlertDialofInterface{
        void applytext(String name, String password);
    }
}
