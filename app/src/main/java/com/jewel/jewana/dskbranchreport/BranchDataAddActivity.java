package com.jewel.jewana.dskbranchreport;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class BranchDataAddActivity extends AppCompatActivity {
    BranchDataStorage branchDataStorage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch_data_add);
        branchDataStorage=new BranchDataStorage(getApplicationContext());
    }

    public void onClickSave(View view) {


        BranchModel branchModel =new BranchModel("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19");
        boolean insert = branchDataStorage.insertBranch(branchModel);
        if (insert) {
            Toast.makeText(getApplication(), "Product Added Successfully", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplication(), "Failed", Toast.LENGTH_LONG).show();
        }

    }
}
