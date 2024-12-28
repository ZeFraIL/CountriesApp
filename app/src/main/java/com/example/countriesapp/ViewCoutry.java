package com.example.countriesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ViewCoutry extends AppCompatActivity {

    Intent takeit;
    Country country;
    TextView Name;
    TextView Area;
    TextView Capitol;
    ImageView cFlag;
    ImageView cSymbol;
    ImageButton Anthem;
    TextView Link;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewcountry);

        initComponents();
    }

    private void initComponents() {
        takeit=getIntent();
        country= (Country) takeit.getSerializableExtra("country");

        Toast.makeText(this, ""+country.getCapitol(), Toast.LENGTH_SHORT).show();

        Name= (TextView) findViewById(R.id.Name);
        Area= (TextView) findViewById(R.id.Area);
        Capitol= (TextView) findViewById(R.id.Capitol);
        cFlag= (ImageView) findViewById(R.id.cFlag);
        cSymbol= (ImageView) findViewById(R.id.cSymbol);
        Anthem= (ImageButton) findViewById(R.id.Anthem);
        Link= (Button) findViewById(R.id.Link);

        Name.setText(country.getName());
        Area.setText(country.getArea());
        Capitol.setText(country.getCapitol());
        cFlag.setImageResource(country.getcFlag());
        cSymbol.setImageResource(country.getcSymbol());
        Anthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp=MediaPlayer.create(ViewCoutry.this,country.getcAnthem());
                mp.start();

            }
        });

        Link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = country.getLink();
                Intent openSiteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                if (openSiteIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(openSiteIntent);
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        mp.stop();
    }
}