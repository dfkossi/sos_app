package com.example.jobee.soscall;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.location.Geocoder;
import android.location.Address;
import org.w3c.dom.Text;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    GridLayout mainGrid;
    public static final int MY_PERMISSION_REQUEST_LOCATION=1;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //  setSupportActionBar(toolbar)
        mainGrid = (GridLayout) findViewById(R.id.mainGrid);
        setSingleEvent(mainGrid);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Cette partie va etre remplacer fLoattngFab circle", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        textView = (TextView) findViewById(R.id.textView_City);

        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                    Manifest.permission.ACCESS_COARSE_LOCATION
            )) {
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, MY_PERMISSION_REQUEST_LOCATION);
            } else {
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, MY_PERMISSION_REQUEST_LOCATION);
            }
        } else {
            LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            Location location = locationManager.getLastKnownLocation(locationManager.NETWORK_PROVIDER);
            try {
                textView.setText(Ind_location(location.getLatitude(), location.getLongitude()));
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(MainActivity.this, " Ville non trouvé1", Toast.LENGTH_SHORT).show();
            }
        }

    }


///////Avoir le nom de la ville /////////////////////////////////////////////////
    public String Ind_location(double lat, double lon){
        String currenCity="";
        String locality="";
        String Country="";
        Geocoder geocoder=
                new Geocoder(MainActivity.this, Locale.getDefault());
        List<Address> addressList;
        try{
            addressList=geocoder.getFromLocation(lat, lon, 1);
            if(addressList.size()>0){
                locality=addressList.get(0).getLocality();
                Country =addressList.get(0).getCountryName();
                currenCity =locality+", "+Country;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(MainActivity.this, "Mauvaise connection Internet", Toast.LENGTH_SHORT).show();
        }
        return currenCity;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch(requestCode){
            case MY_PERMISSION_REQUEST_LOCATION: {
                if (grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED) {
                       if(ContextCompat.checkSelfPermission(MainActivity.this,
                               Manifest.permission.ACCESS_COARSE_LOCATION)== PackageManager.PERMISSION_GRANTED){
                           LocationManager locationManager=(LocationManager) getSystemService(Context.LOCATION_SERVICE);
                           Location location= locationManager.getLastKnownLocation(locationManager.NETWORK_PROVIDER);
                           try{
                               textView.setText(Ind_location(location.getLatitude(), location.getLongitude()));
                           }catch (Exception e){
                               e.printStackTrace();
                               Toast.makeText(MainActivity.this, " Ville non trouvé", Toast.LENGTH_SHORT).show();
                           }

                       }
                }else {

                    Toast.makeText(this, " No Permission Granted", Toast.LENGTH_SHORT).show();

                }
            }
        }
    }
 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


//Partie qui gere l'evenement des cardViews dans le Main Intent
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
                        Intent intent= new Intent(Intent.ACTION_DIAL);
                        String police="113";
                        intent.setData(Uri.parse("tel:"+police));
                        startActivity(intent);
                        //Toast.makeText(MainActivity.this, "Je suis dans la trape 1", Toast.LENGTH_SHORT).show();
                    }

                    else if(finalI==1){
                        Intent intent= new Intent(Intent.ACTION_DIAL);
                        String hospital = "114";
                        intent.setType("Police");
                        intent.setData(Uri.parse("tel:"+hospital));
                        startActivity(intent);
                        //Toast.makeText(MainActivity.this, "Je suis dans la trape 2", Toast.LENGTH_SHORT).show();
                    }

                    else if(finalI==2){
                        Intent intent= new Intent(Intent.ACTION_DIAL);
                        String pomp = "115";
                        intent.setData(Uri.parse("tel:"+pomp));
                        startActivity(intent);
                        //Toast.makeText(MainActivity.this, "Je suis dans la trape 3", Toast.LENGTH_SHORT).show();
                    }

                    else if(finalI==3){
                        Intent intent=new Intent(MainActivity.this,FotoAlert.class);
                        startActivity(intent);
                       // Toast.makeText(MainActivity.this, "Je suis dans la trape 4", Toast.LENGTH_SHORT).show();
                    }
                    else if(finalI==4){

                        Intent intent=new Intent(MainActivity.this,Add_infoMed.class);
                        startActivity(intent);
                        Toast.makeText(MainActivity.this, "Je suis dans la trape 5", Toast.LENGTH_SHORT).show();
                    }
                    else if(finalI==5){

                         Intent intent=new Intent(MainActivity.this,Advices.class);
                         startActivity(intent);
                      //  Toast.makeText(MainActivity.this, "Je suis dans la trape 6", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }


}
