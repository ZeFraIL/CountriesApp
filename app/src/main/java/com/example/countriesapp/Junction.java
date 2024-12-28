package com.example.countriesapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Junction extends AppCompatActivity {

    Context context;
    ListView cList;
    ArrayList<Country> allCountries;
    ArrayAdapter<String> adapter;
    ArrayList<String> countriesnames;
    InputStream is;
    InputStreamReader isr;
    BufferedReader br;

    int[] cFlag={R.drawable.brazilflag,R.drawable.egyptflag,R.drawable.franceflag,R.drawable.germanyflag,
            R.drawable.icelandflag,R.drawable.italyflag,R.drawable.mexicoflag,R.drawable.netherlandsflag,
            R.drawable.norwayflag,R.drawable.polandflag,R.drawable.russiaflag,R.drawable.spainflag,
            R.drawable.swedenflag, R.drawable.switzerlandflag,R.drawable.ukflag};

    int[] cSymbol={R.drawable.brazilsymbol,R.drawable.egyptsymbol,R.drawable.francesymbol,R.drawable.germanysymbol,
            R.drawable.icelandsymbol,R.drawable.italysymbol,R.drawable.mexicosymbol,R.drawable.netherlandssymbol,
            R.drawable.norwaysymbol,R.drawable.polandsymbol,R.drawable.russiasymbol,R.drawable.spainsymbol,
            R.drawable.swedensymbol, R.drawable.switzerlandsymbol, R.drawable.uksymbol};
    int[] cAnthem={R.raw.brazilanthem,R.raw.egyptanthem,R.raw.franceanthem,R.raw.germanyanthem,
            R.raw.icelandanthem,R.raw.italyanthem,R.raw.mexicoanthem,R.raw.netherlandsanthem,
            R.raw.norwayanthem,R.raw.polandanthem,R.raw.russiaanthem,R.raw.spainanthem,
            R.raw.swedenanthem,R.raw.switzerlandanthem,R.raw.ukanthem};
    int i=0;
    private Country country;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_junction);

        initComponents();

        cList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder adb=new AlertDialog.Builder(context);
                adb.setTitle("Information:");
                country=allCountries.get(position);
                adb.setMessage("Would you like to get more information?");
                adb.setPositiveButton("Go", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent go=new Intent(context, ViewCoutry.class);
                        go.putExtra("country",country);
                        startActivity(go);
                    }
                });
                adb.create().show();
            }
        });


    }

    private void initComponents() {
        context=this;
        cList= (ListView) findViewById(R.id.cList);
        allCountries=new ArrayList<>();
        countriesnames=new ArrayList<>();
        is=getResources().openRawResource(R.raw.countries);
        isr=new InputStreamReader(is);
        br=new BufferedReader(isr);
        String st1,st2,st3,st4;
        try {
            while ((st1=br.readLine())!=null){
                st2= br.readLine();
                st3= br.readLine();
                st4= br.readLine();
                Country country=new Country(st1,st2,st3,cFlag[i],cSymbol[i],cAnthem[i],st4);
                allCountries.add(country);
                countriesnames.add(country.getName());
                i++;
            }
            br.close();
        } catch (IOException e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
        adapter = new ArrayAdapter<>(Junction.this,
                android.R.layout.simple_list_item_1,
                countriesnames);
        cList.setAdapter(adapter);

    }
}