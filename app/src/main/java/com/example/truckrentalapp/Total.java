package com.example.truckrentalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Total extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total);
        TextView totalCost = (TextView) findViewById(R.id.truckCost);
        ImageView image = (ImageView) findViewById(R.id.imgSize);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        float flPrice = sharedPref.getFloat("key1", 0);
        int intMiles = sharedPref.getInt("key2", 0);
        double flCost;

        flCost = (intMiles * .99) + flPrice;
        DecimalFormat currency = new DecimalFormat("$###,###.00");
        totalCost.setText("Total Rental Cost: " + currency.format(flCost));
        if (flPrice == 19.99) {
            image.setImageResource(R.drawable.tenft);

        } else if (flPrice == 29.95){
            image.setImageResource(R.drawable.seventeenft);

        } else if (flPrice == 39.95){
            image.setImageResource(R.drawable.twentysix);

        } else {
            totalCost.setText("Please enter correct truck price");
        }

    }
}
