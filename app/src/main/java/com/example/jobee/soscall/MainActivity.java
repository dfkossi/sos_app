package com.example.jobee.soscall;

        import android.Manifest;
        import android.animation.Animator;
        import android.app.Activity;
        import android.content.Context;
        import android.content.Intent;
        import android.content.pm.PackageManager;
        import android.location.Location;
        import android.location.LocationManager;
        import android.media.MediaPlayer;
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
        import android.media.MediaPlayer;
        import android.view.View;
        import android.view.animation.Animation;
        import android.view.animation.AnimationUtils;
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

    FloatingActionButton fab, fab1, fab2, fab3;
    Animation fabOpen, fabClose,rotateFoward, rotateBackward;
    boolean isOpen=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainGrid = (GridLayout) findViewById(R.id.mainGrid);
        setSingleEvent(mainGrid);

        final MediaPlayer policeplay= MediaPlayer.create(this,R.raw.policesound);

        fab=(FloatingActionButton) findViewById(R.id.fab);
        fab1=(FloatingActionButton) findViewById(R.id.fab1);
        fab2=(FloatingActionButton) findViewById(R.id.fab2);
        fab3=(FloatingActionButton) findViewById(R.id.fab3);


        fabOpen= AnimationUtils.loadAnimation(this,R.anim.fab_open);
        fabClose= AnimationUtils.loadAnimation(this,R.anim.fab_close);

        rotateFoward=AnimationUtils.loadAnimation(this,R.anim.rotate_foward);
        rotateBackward=AnimationUtils.loadAnimation(this,R.anim.rotate_backward);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateFab();
            }
        });


        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(policeplay.isPlaying()){
                    policeplay.stop();
                    fab1.setImageResource(R.drawable.ic_launcher_foreground);
                }else if(!policeplay.isPlaying()){
                    policeplay.start();
                    fab1.setImageResource(R.drawable.ic_notifications_black_24dp);
                }
            }
        });


        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


///////Permission location//////////////////////////////////////////////////////////////////////////////////////////////
        textView = (TextView) findViewById(R.id.textView_City);

        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
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
                Toast.makeText(MainActivity.this, "Ville non trouvée", Toast.LENGTH_SHORT).show();
            }
        }

    }


    private  void animateFab(){
        if(isOpen){
            fab.startAnimation(rotateFoward);
            fab1.startAnimation(fabClose);
            fab2.startAnimation(fabClose);
            fab3.startAnimation(fabClose);
            fab1.setClickable(false);
            fab2.setClickable(false);
            fab3.setClickable(false);
            isOpen=false;
        }
        else{
            fab.startAnimation(rotateBackward);
            fab1.startAnimation(fabOpen);
            fab2.startAnimation(fabOpen);
            fab3.startAnimation(fabOpen);
            fab1.setClickable(true);
            fab2.setClickable(true);
            fab3.setClickable(true);
            isOpen=true;
        }

    }

    ///////Avoir le nom de la ville ///////////////////////////////////////////////////////////////////////////////////////////
    public String Ind_location(double lat, double lon){
        String currenCity="";
        String locality="";
        String Country="";
        Geocoder geocoder=new Geocoder(MainActivity.this, Locale.getDefault());
        List<Address> addressList;
        try{
            addressList=geocoder.getFromLocation(lat, lon, 1);
            if(addressList.size()>0){
                locality=addressList.get(0).getLocality();
                Country =locality+", "+addressList.get(0).getCountryName();
                //currenCity =locality+", "+Country;
                currenCity = Country;
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
                        //Toast.makeText(MainActivity.this, "Je suis dans la trape 5", Toast.LENGTH_SHORT).show();
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
