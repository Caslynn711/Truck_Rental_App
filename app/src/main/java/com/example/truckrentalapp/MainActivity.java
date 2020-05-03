package com.example.truckrentalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    int intMiles;
    float flPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText price = (EditText) findViewById(R.id.hint1);
        final EditText miles = (EditText) findViewById(R.id.hint2);
        Button button = (Button) findViewById(R.id.btnPayment);
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intMiles = Integer.parseInt(miles.getText().toString());
                flPrice = Float.parseFloat(price.getText().toString());
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putFloat("key1", flPrice);
                editor.putInt("key2", intMiles);
                editor.apply();
                startActivity(new Intent(MainActivity.this, Total.class));

            }
        });

    }
}
