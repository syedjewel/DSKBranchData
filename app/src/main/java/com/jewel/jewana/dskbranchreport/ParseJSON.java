package com.jewel.jewana.dskbranchreport;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Jewana on 12/28/2015.
 */
public class ParseJSON {
//    public static String[] ids;
//    public static String[] names;
//    public static String[] emails;
    public Context contextJason;
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

    BranchDataStorage branchDataStorage;


    BranchModel branchModel;

    public ParseJSON(String json){
        this.json = "{branchInfo:"+json+"}";
    }

    protected void parseJSON(){

        branchDataStorage=new BranchDataStorage(contextJason);

        JSONObject jsonObject=null;
        try {
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

                branchModel = new BranchModel(AreaName[i], Branch[i], Month_Of_Report[i],
                        String.valueOf(NoOfCenter[i]),
                        String.valueOf(NoOFStaff[i]),String.valueOf(Closing_Member[i]),
                        String.valueOf(Closing_Savings_Outs[i]),
                        String.valueOf(This_M_Disburse_Loan[i]),String.valueOf(ThisYearDisbursement[i]),
                        String.valueOf(End_Outstanding_Loan[i]),
                        String.valueOf(This_M_Total_Disburse_Loanee[i]), String.valueOf(End_Total_Outstanding_Loanee[i]),
                        String.valueOf(New_Due_Loan[i]),String.valueOf(OverDue_Loan[i]),String.valueOf(OverDue_Loanee[i]),
                        String.valueOf(End_Due_Loan[i]), String.valueOf(RecoveryDue_Loan[i]),String.valueOf(End_Due_Loan1[i]),
                        String.valueOf(End_Due_Loanee[i]));

                        //dskBranchStorage.insertBranch(dskBranchModel);
                boolean insert = branchDataStorage.insertBranch(branchModel);

               //dskBranchStorage.insertBranch(dskBranchModel);
                if (insert) {
                    Toast.makeText(contextJason, "Product Added Successfully", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(contextJason, "Failed", Toast.LENGTH_LONG).show();
                }
//
//                        boolean insert = dskBranchStorage.insertBranch(dskBranchModel);
//                        Toast.makeText(contextJason,String.valueOf(insert),Toast.LENGTH_SHORT).show();


            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}