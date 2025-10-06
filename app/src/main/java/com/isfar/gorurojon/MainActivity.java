package com.isfar.gorurojon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    TextView tvHeading, tvresult, tvShow;
    EditText edDoirgo, edBer;
    AppCompatButton button_cal, button_clear;
    Integer intDoirgo, intBer, intOjon, intKg, intKg2;
    DrawerLayout drawerLayout;
    MaterialToolbar toolBar;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvHeading = findViewById(R.id.tvHeading);
        tvresult = findViewById(R.id.tvresult);
        tvShow = findViewById(R.id.tvShow);
        edDoirgo = findViewById(R.id.edDoirgo);
        edBer = findViewById(R.id.edBer);
        button_cal = findViewById(R.id.button_cal);
        button_clear = findViewById(R.id.button_clear);
        drawerLayout = findViewById(R.id.drawerLayout);
        toolBar = findViewById(R.id.toolBar);
        navigationView = findViewById(R.id.navigationView);

        tvHeading.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                MainActivity.this, drawerLayout, toolBar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId()==R.id.koushol) {

                    startActivity(new Intent(MainActivity.this, MainActivity2.class));

                } else if (item.getItemId()==R.id.apps) {
                    //paste your all apps link here
                    Toast.makeText(MainActivity.this, "nothing here", Toast.LENGTH_SHORT).show();
                } else if (item.getItemId()==R.id.share) {
                    //paste your app share link here
                    Toast.makeText(MainActivity.this, "nothing here", Toast.LENGTH_SHORT).show();
                } else if (item.getItemId()==R.id.like) {
                    //paste your app like link here
                    Toast.makeText(MainActivity.this, "nothing here", Toast.LENGTH_SHORT).show();
                }

                return true;
            }
        });


        button_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String stringDoirgo = edDoirgo.getText().toString();
                String stringBer = edBer.getText().toString();


                if (stringDoirgo.length()<=0 || stringBer.length()<=0){

                    if (stringDoirgo.length()<=0){
                        edDoirgo.setError("please enter a number");
                    }
                    if (stringBer.length()<=0) {
                        edBer.setError("please enter a number");
                    }

                }else {

                    intDoirgo = Integer.parseInt(stringDoirgo);
                    intBer = Integer.parseInt(stringBer);


                    intOjon = ((intDoirgo*intBer*intBer)/660);
                    intKg = (int) ((intOjon / 100.0f) * 60);
                    intKg2 = (int) ((intOjon / 100.0f) * 65);

                    String ojon = intOjon.toString();
                    String kg = intKg.toString();
                    String kg2 = intKg2.toString();

                    tvresult.setText("Total body weight = "+ojon+" kg\n"+"Amount of potential meat is "+kg+" kg to "+kg2+" kg");

                    tvShow.setText("(The total meat content of the cow is 60% to 65% of the total body weight.)");

                    button_clear.setVisibility(View.VISIBLE);

                }

            }//onClick END==
        });//onClick END==


        button_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                edDoirgo.setText("");
                edBer.setText("");
                tvresult.setText("");
                tvShow.setText("");

            }
        });


    }//onCreate END==


    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        //super.onBackPressed();

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            navigationView.setSelected(false);
            super.onBackPressed();
        }

    }

}//Main class END==