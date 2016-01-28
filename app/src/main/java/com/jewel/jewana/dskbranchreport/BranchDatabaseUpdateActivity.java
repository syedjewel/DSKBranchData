package com.jewel.jewana.dskbranchreport;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class BranchDatabaseUpdateActivity extends AppCompatActivity implements View.OnClickListener {

    public static String[] AreaName;
    public static String[] Branch;
    public static String[] Month_Of_Report;
    public static String[] NoOfCenter;
    public static String[] NoOFStaff;
    public static String[] Closing_Member;
    public static String[] Closing_Savings_Outs;
    public static String[] This_M_Disburse_Loan;
    public static String[] ThisYearDisbursement;
    public static String[] End_Outstanding_Loan;
    public static String[] This_M_Total_Disburse_Loanee;
    public static String[] End_Total_Outstanding_Loanee;
    public static String[] New_Due_Loan;
    public static String[] OverDue_Loan;
    public static String[] OverDue_Loanee;
    public static String[] End_Due_Loan;
    public static String[]  RecoveryDue_Loan;
    public static String[] End_Due_Loan1;
    public static String[] End_Due_Loanee;



//    private BranchDBHelper branchDBHelper;
//    private SQLiteDatabase sqLiteDatabase;
    //private BranchModel branchModel;

//
//    public static final String JSON_ARRAY = "result";
//    public static final String KEY_ID = "id";
//    public static final String KEY_NAME = "name";
//    public static final String KEY_EMAIL = "email";

    public static final String JSON_ARRAY = "branchInfo";
    public static final String KEY_AREANAME="AreaName";
    public static final String KEY_BRANCH ="Branch";
    public static final String KEY_MONTHOFREPORT ="Month_Of_Report";
    public static final String KEY_NOOFCENTER ="NoOfCenter";
    public static final String KEY_NOOFSTAFF= "NoOFStaff";
    public static final String KEY_CLOSINGMEMBER ="Closing_Member";
    public static final String KEY_CLOSINGSAVINGSOUTS="Closing_Savings_Outs";
    public static final String KEY_THISMDISBURSELOAN= "This_M_Disburse_Loan";
    public static final String KEY_THISYEARDISBURSEMENT= "ThisYearDisbursement";
    public static final String KEY_END_OUTSTANDING_LOAN ="End_Outstanding_Loan";
    public static final String KEY_THIS_M_TOTAL_DISBURSE_LOANEE="This_M_Total_Disburse_Loanee";
    public static final String KEY_END_TOTAL_OUTSTANDING_LOANEE="End_Total_Outstanding_Loanee";
    public static final String KEY_NEW_DUE_LOAN="New_Due_Loan";
    public static final String KEY_OVERDUE_LOAN="OverDue_Loan";
    public static final String KEY_OVERDUE_LOANEE="OverDue_Loanee";
    public static final String KEY_END_DUE_LOAN="End_Due_Loan";
    public static final String  KEY_RECOVERYDUE_LOAN="RecoveryDue_Loan";
    public static final String KEY_END_DUE_LOAN1="End_Due_Loan1";
    public static final String KEY_END_DUE_LOANEE="End_Due_Loanee";

    private JSONArray users = null;

    private String json;

//    BranchDataStorage branchDataStorage;


    BranchModel branchModel;



    public String JSON_URL = "";

    private Button buttonGet;

    private ListView listView;

    private EditText fromDateEtxt;
    private EditText toDateEtxt;

    private DatePickerDialog fromDatePickerDialog;
    private DatePickerDialog toDatePickerDialog;

    private SimpleDateFormat dateFormatter;
    BranchDataStorage branchDataStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch_database_update);
        branchDataStorage=new BranchDataStorage(getApplicationContext());
        dateFormatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.US);

        findViewsById();
        setDateTimeField();

    }


    private void setDateTimeField() {
        fromDateEtxt.setOnClickListener(this);
        toDateEtxt.setOnClickListener(this);

        Calendar newCalendar = Calendar.getInstance();
        fromDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                fromDateEtxt.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        toDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                toDateEtxt.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }

    private void sendRequest(){

        StringRequest stringRequest = new StringRequest(JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(final String response) {

                        final ProgressDialog ringProgressDialog = ProgressDialog.show(BranchDatabaseUpdateActivity.this, "Please wait ...", "Downloading Data ...", true);
                        ringProgressDialog.setCancelable(true);
                        new Thread(new Runnable() {

                            @Override

                            public void run() {

                                try {

                                    // Here you should write your time consuming task...

                                    // Let the progress ring for 10 seconds...

                                   //Thread.sleep(10000);

                                    showJSON(response);


                                } catch (Exception e) {

                                  }
                                 ringProgressDialog.dismiss();

                            }
                        }).start();

                        Toast.makeText(BranchDatabaseUpdateActivity.this, "Data Updated sucessfully", Toast.LENGTH_LONG).show();


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(BranchDatabaseUpdateActivity.this, "Check Your Internet or Try Again", Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void showJSON(String json){
        //ParseJSON pj = new ParseJSON(json);
        //pj.parseJSON();
        json="{branchInfo:"+json+"}";

        parseJSON(json);
//        DSKBranchLVAdapter dskBranchLVAdapter=new DSKBranchLVAdapter(this,)
//        CustomList cl = new CustomList(this, ParseJSON.Branch,ParseJSON.Closing_Savings_Outs,ParseJSON.End_Outstanding_Loan);
//        listView.setAdapter(cl);
    }

    private void findViewsById() {
        fromDateEtxt = (EditText) findViewById(R.id.etxt_fromdate);
        fromDateEtxt.setInputType(InputType.TYPE_NULL);
        fromDateEtxt.requestFocus();

        toDateEtxt = (EditText) findViewById(R.id.etxt_todate);
        toDateEtxt.setInputType(InputType.TYPE_NULL);
    }


    @Override
    public void onClick(View v) {
        if(v == fromDateEtxt) {
            fromDatePickerDialog.show();
        } else if(v == toDateEtxt) {
            toDatePickerDialog.show();
        }

    }

    public void onClickgetData(View view) {

        String fisrtDate=fromDateEtxt.getText().toString();
        String endDate=toDateEtxt.getText().toString();
        JSON_URL="http://115.127.7.5:8112/api/customer/GetAllCustomer/?"+"StartDate="+fisrtDate+"&"+"EndDate="+endDate;
        //JSON_URL=JSON_URL

        sendRequest();
    }


    private void parseJSON(String json){

//        branchDataStorage=new BranchDataStorage(getApplicationContext());

        JSONObject jsonObject=null;
        try {
            //json="";
            //json=

            jsonObject = new JSONObject(json);
            users = jsonObject.getJSONArray(JSON_ARRAY);

//            ids = new String[users.length()];
//            names = new String[users.length()];
//            emails = new String[users.length()];


            AreaName= new String[users.length()];
            Branch= new String[users.length()];
            Month_Of_Report= new String[users.length()];
            NoOfCenter= new String[users.length()];
            NoOFStaff= new String[users.length()];
            Closing_Member= new String[users.length()];
            Closing_Savings_Outs= new String[users.length()];
            This_M_Disburse_Loan= new String[users.length()];
            ThisYearDisbursement= new String[users.length()];
            End_Outstanding_Loan= new String[users.length()];
            This_M_Total_Disburse_Loanee= new String[users.length()];
            End_Total_Outstanding_Loanee= new String[users.length()];
            New_Due_Loan= new String[users.length()];
            OverDue_Loan= new String[users.length()];
            OverDue_Loanee= new String[users.length()];
            End_Due_Loan= new String[users.length()];
            RecoveryDue_Loan= new String[users.length()];
            End_Due_Loan1= new String[users.length()];
            End_Due_Loanee= new String[users.length()];



            for(int i=0;i<users.length();i++){
                JSONObject jo = users.getJSONObject(i);
//                ids[i] = jo.getString(KEY_ID);
//                names[i] = jo.getString(KEY_NAME);
//                emails[i] = jo.getString(KEY_EMAIL);

                AreaName[i]= jo.getString(KEY_AREANAME);
                Branch[i]= jo.getString(KEY_BRANCH);
                Month_Of_Report[i]= jo.getString(KEY_MONTHOFREPORT);
                NoOfCenter[i]= jo.getString(KEY_NOOFCENTER);
                NoOFStaff[i]= jo.getString(KEY_NOOFSTAFF);
                Closing_Member[i]= jo.getString(KEY_CLOSINGMEMBER);
                Closing_Savings_Outs[i]= jo.getString(KEY_CLOSINGSAVINGSOUTS);
                This_M_Disburse_Loan[i]= jo.getString(KEY_THISMDISBURSELOAN);
                ThisYearDisbursement[i]= jo.getString(KEY_THISYEARDISBURSEMENT);
                End_Outstanding_Loan[i]= jo.getString(KEY_END_OUTSTANDING_LOAN);
                This_M_Total_Disburse_Loanee[i]= jo.getString(KEY_THIS_M_TOTAL_DISBURSE_LOANEE);
                End_Total_Outstanding_Loanee[i]= jo.getString(KEY_END_TOTAL_OUTSTANDING_LOANEE);
                New_Due_Loan[i]= jo.getString(KEY_NEW_DUE_LOAN);
                OverDue_Loan[i]= jo.getString(KEY_OVERDUE_LOAN);
                OverDue_Loanee[i]= jo.getString(KEY_OVERDUE_LOANEE);
                End_Due_Loan[i]= jo.getString(KEY_END_DUE_LOAN);
                RecoveryDue_Loan[i]= jo.getString(KEY_RECOVERYDUE_LOAN);
                End_Due_Loan1[i]= jo.getString(KEY_END_DUE_LOAN1);
                End_Due_Loanee[i]= jo.getString(KEY_END_DUE_LOANEE);

//Inserting Data to SQLite from JSON RemoteServer

                String areaName=AreaName[i];
                String branchName=Branch[i];
                String monthOfreport=Month_Of_Report[i];

                boolean delete =branchDataStorage.deleteselectedBranchData(branchName,monthOfreport);


                BranchModel  branchModels = new BranchModel(areaName, Branch[i], Month_Of_Report[i],
                        String.valueOf(Double.valueOf(NoOfCenter[i]).longValue()) ,
                        String.valueOf(Double.valueOf(NoOFStaff[i]).longValue()),
                        String.valueOf(Double.valueOf(Closing_Member[i]).longValue()),
                        String.valueOf(Double.valueOf(Closing_Savings_Outs[i]).longValue()),
                        String.valueOf(Double.valueOf(This_M_Disburse_Loan[i]).longValue()),
                        String.valueOf(Double.valueOf(ThisYearDisbursement[i]).longValue()),
                        String.valueOf(Double.valueOf(End_Outstanding_Loan[i]).longValue()),
                        String.valueOf(Double.valueOf(This_M_Total_Disburse_Loanee[i]).longValue()),
                        String.valueOf(Double.valueOf(End_Total_Outstanding_Loanee[i]).longValue()),
                        String.valueOf(Double.valueOf(New_Due_Loan[i]).longValue()),
                        String.valueOf(Double.valueOf(OverDue_Loan[i]).longValue()),
                        String.valueOf(Double.valueOf(OverDue_Loanee[i]).longValue()),
                        String.valueOf(Double.valueOf(End_Due_Loan[i]).longValue()),
                        String.valueOf(Double.valueOf(RecoveryDue_Loan[i]).longValue()),
                        String.valueOf(Double.valueOf(End_Due_Loan1[i]).longValue()),
                        String.valueOf(Double.valueOf(End_Due_Loanee[i]).longValue()));





                //dskBranchStorage.insertBranch(dskBranchModel);
                boolean insert = branchDataStorage.insertBranch(branchModels);

                //dskBranchStorage.insertBranch(dskBranchModel);
                if (insert) {
                   // Toast.makeText(getApplicationContext(), "Branch Data Save Successfully", Toast.LENGTH_SHORT).show();
                } else {
                    //Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_LONG).show();
                }
//
//                        boolean insert = dskBranchStorage.insertBranch(dskBranchModel);
//                        Toast.makeText(contextJason,String.valueOf(insert),Toast.LENGTH_SHORT).show();


            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void onClickClearDatabase(View view) {

        new AlertDialog.Builder(BranchDatabaseUpdateActivity.this)
                .setTitle("Delete entry")
                .setMessage("Are you sure you want to delete this entry?")
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                        //int id = Integer.valueOf(tempID);
                        boolean success = branchDataStorage.deleteBranchData();
                        if (success) {
                            Toast.makeText(getApplication(), "Branch All Data Deleted Successfully", Toast.LENGTH_LONG).show();
                            //showProduct();
                        } else {
                            Toast.makeText(getApplication(), "Failed", Toast.LENGTH_LONG).show();
                        }

                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();

    }

    public void onClickbackToSeach(View view) {

        Intent intent=new Intent(getApplicationContext(),BranchSearchActivity.class);
        startActivity(intent);
        finish();
    }
}
