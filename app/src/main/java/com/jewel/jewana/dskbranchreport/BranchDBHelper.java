package com.jewel.jewana.dskbranchreport;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jewana on 12/31/2015.
 */
public class BranchDBHelper  extends SQLiteOpenHelper {

    static final String DATABASE_NAME="DSKBranchData";
    static  final int DATABASE_VERSION=1;
    public static final String TABLE_NAME_BRANCH_DATA ="branch_data_report";

    public static final String COL_ID ="Id";
    public static final String COL_AREA_NAME ="area_name";
    public static final String COL_BRANCH_NAME ="branch_name";
    public static final String COL_MONTH_OF_REPORT ="month_of_report";
    public static final String COL_NO_OF_CENTER ="no_of_center";
    public static final String COL_NO_OF_STAFF="no_of_staff";
    public static final String COL_CLOSING_MEMBER="closing_member";
    public static final String COL_CLOSING_SAVINGS_OUTS="closing_savings_outs";
    public static final String COL_THIS_M_DISBURSE_LOAN="this_m_disburse_loan";
    public static final String COL_THIS_YEAR_DISBURSEMENT="this_year_disbursement";
    public static final String COL_END_OUTSTANDING_LOAN="End_Outstanding_Loan";
    public static final String COL_THIS_M_TOTAL_DISBURSE_LOANEE="this_m_total_disburse_loanee";
    public static final String COL_END_TOTAL_OUTSTANDING_LOANEE="end_total_outstanding_loanee";
    public static final String COL_NEW_DUE_LOAN="new_due_loan";
    public static final String COL_OVERDUE_LOAN="overdue_loan";
    public static final String COL_OVERDUE_LOANEE="overdue_loanee";
    public static final String COL_END_DUE_LOAN="end_due_loan";
    public static final String COL_RECOVERYDUE_LOAN="recoverydue_loan";
    public static final String COL_END_DUE_LOANSC="end_due_loansc";
    public static final String COL_END_DUE_LOANEE="end_due_loanee";

    public BranchDBHelper(Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    static final String CREATE_TABLE_BRANCH_DATA_INFO ="CREATE TABLE "+ TABLE_NAME_BRANCH_DATA +" ( " + COL_ID +" INTEGER PRIMARY KEY,"+
            COL_AREA_NAME +" TEXT,"+ COL_BRANCH_NAME +" TEXT,"+
            COL_MONTH_OF_REPORT +" TEXT,"+ COL_NO_OF_CENTER +" TEXT,"+COL_NO_OF_STAFF+" TEXT,"+ COL_CLOSING_MEMBER +" TEXT,"+COL_CLOSING_SAVINGS_OUTS+" TEXT,"+
            COL_THIS_M_DISBURSE_LOAN+" TEXT,"+COL_THIS_YEAR_DISBURSEMENT+" TEXT,"+COL_END_OUTSTANDING_LOAN+" TEXT,"+COL_THIS_M_TOTAL_DISBURSE_LOANEE+" TEXT,"+COL_END_TOTAL_OUTSTANDING_LOANEE+" TEXT,"+
            COL_NEW_DUE_LOAN+" TEXT,"+COL_OVERDUE_LOAN+" TEXT,"+COL_OVERDUE_LOANEE+" TEXT,"+COL_END_DUE_LOAN+" TEXT,"+COL_RECOVERYDUE_LOAN+" TEXT,"+
            COL_END_DUE_LOANSC+" TEXT,"+COL_END_DUE_LOANEE+" TEXT)";


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_BRANCH_DATA_INFO);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST"+ TABLE_NAME_BRANCH_DATA);
    }
}
