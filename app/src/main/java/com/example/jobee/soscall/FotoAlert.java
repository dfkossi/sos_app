package com.example.jobee.soscall;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class FotoAlert extends AppCompatActivity {

    ImageView imageView;
    TextView textpoint;
    Button btnSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto_alert);

         imageView=(ImageView)findViewById(R.id.imageView);
         textpoint=(TextView) findViewById(R.id.textpoint);
         btnSend=(Button) findViewById(R.id.btnenvoie);
         textpoint.setText("Cliquez sur le button camera pour prendre une la photo...");

        // btnSend.isEnabled()=true;
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabcam);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Cette partie va etre remplacer fLoattngFab circle", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();

                Intent intent =new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Bitmap bitmap = (Bitmap) data.getExtras().get("data");
        imageView.setImageBitmap(bitmap);

        textpoint.setText("Vous pouvez soit, l'envoyer par mail ou reprendre la photo...");
    }
}