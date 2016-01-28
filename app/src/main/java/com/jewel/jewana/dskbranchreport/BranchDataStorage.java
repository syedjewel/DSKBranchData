package com.jewel.jewana.dskbranchreport;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Jewana on 12/31/2015.
 */
public class BranchDataStorage {
    private BranchDBHelper branchDBHelper;
    private SQLiteDatabase sqLiteDatabase;
    private BranchModel branchModel;

public BranchDataStorage(Context context){

    branchDBHelper=new BranchDBHelper(context);
}


    private void open() {
        sqLiteDatabase = branchDBHelper.getWritableDatabase();
    }

    private void close() {
        branchDBHelper.close();
    }


    public boolean insertBranch(BranchModel branchModel)
    {
        //this.close();
        this.open();

        ContentValues cv = new ContentValues();
        cv.put(BranchDBHelper.COL_AREA_NAME, branchModel.getAreaName());
        cv.put(BranchDBHelper.COL_BRANCH_NAME, branchModel.getBranchName());
        cv.put(BranchDBHelper.COL_MONTH_OF_REPORT, branchModel.getMonth_Of_Report());
        cv.put(BranchDBHelper.COL_NO_OF_CENTER, branchModel.getNoOfCenter());
        cv.put(BranchDBHelper.COL_NO_OF_STAFF, branchModel.getNoOFStaff());
        cv.put(BranchDBHelper.COL_CLOSING_MEMBER, branchModel.getClosing_Member());
        cv.put(BranchDBHelper.COL_CLOSING_SAVINGS_OUTS, branchModel.getClosing_Savings_Outs());
        cv.put(BranchDBHelper.COL_THIS_M_DISBURSE_LOAN, branchModel.getThis_M_Disburse_Loan());
        cv.put(BranchDBHelper.COL_THIS_YEAR_DISBURSEMENT, branchModel.getThisYearDisbursement());
        cv.put(BranchDBHelper.COL_END_OUTSTANDING_LOAN, branchModel.getEnd_Outstanding_Loan());
        cv.put(BranchDBHelper.COL_THIS_M_TOTAL_DISBURSE_LOANEE, branchModel.getThis_M_Total_Disburse_Loanee());
        cv.put(BranchDBHelper.COL_END_TOTAL_OUTSTANDING_LOANEE, branchModel.getEnd_Total_Outstanding_Loanee());
        cv.put(BranchDBHelper.COL_NEW_DUE_LOAN, branchModel.getNew_Due_Loan());
        cv.put(BranchDBHelper.COL_OVERDUE_LOAN, branchModel.getOverDue_Loan());
        cv.put(BranchDBHelper.COL_OVERDUE_LOANEE, branchModel.getOverDue_Loanee());
        cv.put(BranchDBHelper.COL_END_DUE_LOAN, branchModel.getEnd_Due_Loan());
        cv.put(BranchDBHelper.COL_RECOVERYDUE_LOAN, branchModel.getRecoveryDue_Loan());
        cv.put(BranchDBHelper.COL_END_DUE_LOANSC, branchModel.getEnd_Due_LoanSC());
        cv.put(BranchDBHelper.COL_END_DUE_LOANEE,branchModel.getEnd_Due_Loanee());

        // database.insert(DSKDBHelper.TABLE_NAME_BRANCH_DATA, null, cv);
        long inserted = sqLiteDatabase.insert(BranchDBHelper.TABLE_NAME_BRANCH_DATA, null, cv);
        this.close();

        if (inserted > 0) {
            return true;
        } else {
            return false;
        }

    }

    public ArrayList<BranchModel> getAllBranchData(){

        ArrayList<BranchModel> branchDataList=new ArrayList<>();
        this.open();
        Cursor cursor=sqLiteDatabase.query(BranchDBHelper.TABLE_NAME_BRANCH_DATA, null, null, null, null, null, null);

        if (cursor!=null && cursor.getCount()>0){

            cursor.moveToFirst();

            for (int i=0; i<cursor.getCount(); i++){

                int Id=cursor.getInt(cursor.getColumnIndex(BranchDBHelper.COL_ID));
                String areaName=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_AREA_NAME));
                String branchName=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_BRANCH_NAME));
                String month_of_report=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_MONTH_OF_REPORT));
                String no_of_center=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_NO_OF_CENTER));
                String no_of_staff=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_NO_OF_STAFF));
                String closing_member=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_CLOSING_MEMBER));
                String closing_savings_outs=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_CLOSING_SAVINGS_OUTS));
                String this_m_disburse_loan=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_THIS_M_DISBURSE_LOAN));
                String this_m_total_disburse_loanee=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_THIS_M_TOTAL_DISBURSE_LOANEE));
                String this_year_disbursement=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_THIS_YEAR_DISBURSEMENT));
                String End_Outstanding_Loan=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_END_OUTSTANDING_LOAN));
                String end_total_outstanding_loanee=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_END_TOTAL_OUTSTANDING_LOANEE));
                String new_due_loan=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_NEW_DUE_LOAN));
                String overdue_loan=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_OVERDUE_LOAN));
                String overdue_loanee=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_OVERDUE_LOANEE));
                String end_due_loan=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_END_DUE_LOAN));
                String recoverydue_loan=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_RECOVERYDUE_LOAN));
                String end_due_loansc=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_END_DUE_LOANSC));
                String end_due_loanee = cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_END_DUE_LOANEE));

                branchModel =new BranchModel(areaName,branchName, month_of_report, no_of_center, no_of_staff,closing_member,closing_savings_outs, this_m_disburse_loan,
                        this_year_disbursement, End_Outstanding_Loan, this_m_total_disburse_loanee, end_total_outstanding_loanee,
                        new_due_loan, overdue_loan, overdue_loanee,end_due_loan, recoverydue_loan, end_due_loansc, end_due_loanee);
                branchDataList.add(branchModel);
                cursor.moveToNext();
            }
        }
        sqLiteDatabase.close();
        this.close();
        return branchDataList;
    }

    ///

    public ArrayList<BranchModel> getSearchBranch(String searchText){

        ArrayList<BranchModel> branchDataList=new ArrayList<>();
        this.open();

        String selectQuery = "SELECT  * FROM " + BranchDBHelper.TABLE_NAME_BRANCH_DATA+" WHERE "+
                BranchDBHelper.COL_BRANCH_NAME+" LIKE '%"+searchText+"%'" +" OR "+BranchDBHelper.COL_AREA_NAME+" LIKE '%"+searchText+"%'" ;

        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        if (cursor!=null && cursor.getCount()>0){

            cursor.moveToFirst();

            for (int i=0; i<cursor.getCount(); i++){
                int Id=cursor.getInt(cursor.getColumnIndex(BranchDBHelper.COL_ID));
                String areaName=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_AREA_NAME));
                String branchName=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_BRANCH_NAME));
                String month_of_report=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_MONTH_OF_REPORT));
                String no_of_center=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_NO_OF_CENTER));
                String no_of_staff=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_NO_OF_STAFF));
                String closing_member=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_CLOSING_MEMBER));
                String closing_savings_outs=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_CLOSING_SAVINGS_OUTS));
                String this_m_disburse_loan=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_THIS_M_DISBURSE_LOAN));
                String this_m_total_disburse_loanee=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_THIS_M_TOTAL_DISBURSE_LOANEE));
                String this_year_disbursement=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_THIS_YEAR_DISBURSEMENT));
                String End_Outstanding_Loan=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_END_OUTSTANDING_LOAN));
                String end_total_outstanding_loanee=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_END_TOTAL_OUTSTANDING_LOANEE));
                String new_due_loan=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_NEW_DUE_LOAN));
                String overdue_loan=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_OVERDUE_LOAN));
                String overdue_loanee=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_OVERDUE_LOANEE));
                String end_due_loan=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_END_DUE_LOAN));
                String recoverydue_loan=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_RECOVERYDUE_LOAN));
                String end_due_loansc=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_END_DUE_LOANSC));
                String end_due_loanee = cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_END_DUE_LOANEE));

                branchModel =new BranchModel(areaName,branchName, month_of_report, no_of_center, no_of_staff,closing_member,closing_savings_outs, this_m_disburse_loan,
                        this_year_disbursement, End_Outstanding_Loan, this_m_total_disburse_loanee, end_total_outstanding_loanee,
                        new_due_loan, overdue_loan, overdue_loanee,end_due_loan, recoverydue_loan, end_due_loansc, end_due_loanee);
                branchDataList.add(branchModel);
                cursor.moveToNext();
            }
        }
        sqLiteDatabase.close();
        this.close();
        return branchDataList;
    }

    public BranchModel getSingleBranch(int Id)
    {
        BranchModel singleBranchData=new BranchModel();

        this.open();

        String selectQuery = "SELECT  * FROM " + BranchDBHelper.TABLE_NAME_BRANCH_DATA+" WHERE "+
                BranchDBHelper.COL_ID + " = "+Id;

        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        if (cursor!=null && cursor.getCount()>0) {

            cursor.moveToFirst();

            int bId=cursor.getInt(cursor.getColumnIndex(BranchDBHelper.COL_ID));
            String areaName=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_AREA_NAME));
            String branchName=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_BRANCH_NAME));
            String month_of_report=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_MONTH_OF_REPORT));
            String no_of_center=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_NO_OF_CENTER));
            String no_of_staff=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_NO_OF_STAFF));
            String closing_member=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_CLOSING_MEMBER));
            String closing_savings_outs=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_CLOSING_SAVINGS_OUTS));
            String this_m_disburse_loan=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_THIS_M_DISBURSE_LOAN));
            String this_m_total_disburse_loanee=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_THIS_M_TOTAL_DISBURSE_LOANEE));
            String this_year_disbursement=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_THIS_YEAR_DISBURSEMENT));
            String End_Outstanding_Loan=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_END_OUTSTANDING_LOAN));
            String end_total_outstanding_loanee=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_END_TOTAL_OUTSTANDING_LOANEE));
            String new_due_loan=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_NEW_DUE_LOAN));
            String overdue_loan=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_OVERDUE_LOAN));
            String overdue_loanee=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_OVERDUE_LOANEE));
            String end_due_loan=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_END_DUE_LOAN));
            String recoverydue_loan=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_RECOVERYDUE_LOAN));
            String end_due_loansc=cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_END_DUE_LOANSC));
            String end_due_loanee = cursor.getString(cursor.getColumnIndex(BranchDBHelper.COL_END_DUE_LOANEE));

            // dskBranchModel =new ProductModel(productId,productName,productPrice,productCategory,productStatus,companyName,productLocation);
            singleBranchData.setAreaName(areaName);
            singleBranchData.setBranchName(branchName);
            singleBranchData.setMonth_Of_Report(month_of_report);
            singleBranchData.setNoOfCenter(no_of_center);
            singleBranchData.setNoOFStaff(no_of_staff);
            singleBranchData.setClosing_Member(closing_member);
            singleBranchData.setClosing_Savings_Outs(closing_savings_outs);
            singleBranchData.setThis_M_Disburse_Loan(this_m_disburse_loan);
            singleBranchData.setThisYearDisbursement(this_year_disbursement);
            singleBranchData.setEnd_Outstanding_Loan(End_Outstanding_Loan);
            singleBranchData.setThis_M_Total_Disburse_Loanee(this_m_total_disburse_loanee);
            singleBranchData.setEnd_Total_Outstanding_Loanee(end_total_outstanding_loanee);
            singleBranchData.setNew_Due_Loan(new_due_loan);
            singleBranchData.setOverDue_Loan(overdue_loan);
            singleBranchData.setOverDue_Loanee(overdue_loanee);
            singleBranchData.setEnd_Due_Loan(end_due_loan);
            singleBranchData.setRecoveryDue_Loan(recoverydue_loan);
            singleBranchData.setEnd_Due_LoanSC(end_due_loansc);
            singleBranchData.setEnd_Due_Loanee(end_due_loanee);

        }
        return singleBranchData;
    }



    public boolean deleteselectedBranchData(String branchName,String monthofReport)
    {
        this.open();

        int deleted=   sqLiteDatabase.delete(BranchDBHelper.TABLE_NAME_BRANCH_DATA,BranchDBHelper.COL_BRANCH_NAME + "= '" + branchName+"' AND "+BranchDBHelper.COL_MONTH_OF_REPORT + "= '" + monthofReport + "'" , null);
        sqLiteDatabase.close();
        this.close();

        if (deleted > 0) {
            return true;
        } else {
            return false;
        }
    }



    public boolean deleteBranchData()
    {
        this.open();

        int deleted=   sqLiteDatabase.delete(BranchDBHelper.TABLE_NAME_BRANCH_DATA, null, null);
        sqLiteDatabase.close();
        this.close();

        if (deleted > 0) {
            return true;
        } else {
            return false;
        }
    }

}
