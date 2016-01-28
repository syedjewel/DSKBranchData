package com.jewel.jewana.dskbranchreport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickDatabaseUpdate(View view) {

        Intent intent=new Intent(MainActivity.this,BranchDatabaseUpdateActivity.class);
        startActivity(intent);
    }



    public void onClickSearch(View view) {

        Intent intent=new Intent(MainActivity.this,BranchSearchActivity.class);
        startActivity(intent);
    }
}
