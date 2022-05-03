package com.example.bottomnavigation;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
public class MainActivity extends AppCompatActivity {
    BottomNavigationView bn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bn1 = findViewById(R.id.b1);
        getSupportFragmentManager().beginTransaction().replace(R.id.f1,new home()).commit();
        bn1.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment f = null;
                switch(menuItem.getItemId()) {
                    case R.id.menu1:
                        f = new home();
                        break;
                    case R.id.menu2:
                        f = new favourites();
                        break;
                    case R.id.menu3:
                        f = new search();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.f1,f).commit();
                return true;
            }
        });
    }
}