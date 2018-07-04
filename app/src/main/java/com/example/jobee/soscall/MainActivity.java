package com.example.jobee.soscall;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      //  setSupportActionBar(toolbar)

        mainGrid=(GridLayout)findViewById(R.id.mainGrid);
        setSingleEvent(mainGrid);


       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Cette partie va etre remplacer fLoattngFab circle", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void setSingleEvent(GridLayout manh) {

        for(int i=0;i<manh.getChildCount();i++){
            CardView cardView=(CardView)manh.getChildAt(i);
            final int finalI=i;
            cardView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                       // this is here to add event
                        //Toast.makeText(MainActivity.this,"Click at index"+finalI,Toast.LENGTH_SHORT).show();

                    if (finalI==0){

                        Toast.makeText(MainActivity.this, "Je suis dans la trape 1", Toast.LENGTH_SHORT).show();
                    }
                    else if(finalI==1){
                        Toast.makeText(MainActivity.this, "Je suis dans la trape 2", Toast.LENGTH_SHORT).show();
                    }
                    else if(finalI==2){

                        Toast.makeText(MainActivity.this, "Je suis dans la trape 3", Toast.LENGTH_SHORT).show();
                    }
                    else if(finalI==3){
                        Toast.makeText(MainActivity.this, "Je suis dans la trape 4", Toast.LENGTH_SHORT).show();

                    }
                    else if(finalI==4){

                        Toast.makeText(MainActivity.this, "Je suis dans la trape 5", Toast.LENGTH_SHORT).show();
                    }
                    else if(finalI==5){

                        Toast.makeText(MainActivity.this, "Je suis dans la trape 6", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }


}
