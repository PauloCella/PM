package com.example.paulo.pm;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.MapView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("LOGGPS","CHEGOU ANTES DO LOCATIONMANAGER");
        LocationManager locationManager = (LocationManager) getSystemService(MainActivity.this.LOCATION_SERVICE);


        //é extremamente necessário fazer essa verificação


        Log.i("LOGGPS","ANTES DO IF");



       if ( (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) &&
               (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)) {

            Log.i("LOGGPS","ENTROU NO IF");
            locationManager.requestSingleUpdate(LocationManager.GPS_PROVIDER, new LocationListener() {

                @Override
                public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
                    Toast.makeText(getApplicationContext(), "Status alterado",
                            Toast.LENGTH_LONG).show();
                }

                @Override
                public void onProviderEnabled(String arg0) {
                    Toast.makeText(getApplicationContext(), "Provider Habilitado",
                            Toast.LENGTH_LONG).show();
                }

                @Override
                public void onProviderDisabled(String arg0) {
                    Toast.makeText(getApplicationContext(), "Provider Desabilitado",
                            Toast.LENGTH_LONG).show();
                }

                @Override
                public void onLocationChanged(Location location) {

                    if (location != null) {

                    /*
                    latitude.setText( & quot; Latitude:&quot;
                    +location.getLatitude());
                    longitude.setText( & quot; Longitude:&quot;
                    +location.getLongitude());
                    acuracy.setText( & quot; Precis?o:&quot;
                    +location.getAccuracy() + & quot;&quot;);

                    SimpleDateFormat sdf = new SimpleDateFormat( & quot; dd / MM / yyyy HH:
                    mm:
                    ss & quot;);
                    time.setText( & quot; Data:&quot;
                    +sdf.format(location.getTime()));

                    provider.setText(location.getProvider());
                    */
                    }

                }
            }, null);
            return;
        }
        else {

            Log.i("LOGGPS"," NÃO eNTROU NO IF");
        }

        Log.i("LOGGPS", "CHEGOU ANTES DO REQUESTuPDATES");



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.action_about) {
            Intent i = new Intent(MainActivity.this, SplashAboutActivity.class);
            startActivity(i);
            return true; // aqui faze a logica para mostrar, talvez um splash ou outra tela;
        }

        return super.onOptionsItemSelected(item);
    }
}
