package com.example.jobee.soscall;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Add_infoMed extends AppCompatActivity {
    View mView;
    Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_info_med);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabinfomed);
        fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder mBuilder= new AlertDialog.Builder(Add_infoMed.this) ;
                   View mView=getLayoutInflater().inflate(R.layout.dialog_addinfo_perso, null);

                    EditText nomP= (EditText) findViewById(R.id.textNomP);
                    EditText prenomP= (EditText) findViewById(R.id.textprenomP);
                    //EditText sexeP= (EditText) findViewById(R.id.textSexeP);
                    EditText nomPR= (EditText) findViewById(R.id.textNomPR);
                    EditText prenomPR= (EditText) findViewById(R.id.textPrenomPR);
                    EditText PhonePR= (EditText) findViewById(R.id.textPhonePR);
                    EditText LparentePR= (EditText) findViewById(R.id.textLParentePR);
                    // btnSave= (Button) findViewById(R.id.btnSave);

                    mBuilder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

                    mBuilder.setPositiveButton("Sauvegader", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    
                    mBuilder.setView(mView);
                    AlertDialog dialog=mBuilder.create();
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialog.show();

                }


        });
    }

}
