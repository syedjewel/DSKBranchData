package com.jewel.jewana.dskbranchreport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class BranchDetailsActivity extends AppCompatActivity {

    ArrayList<BranchModel> branchModels;
    BranchDataStorage branchDataStorage;

    TextView IdTV;
    TextView area_nameTV;
    TextView branch_nameTV;
    TextView month_of_reportTV;
    TextView no_of_centerTV;
    TextView no_of_staffTV;
    TextView closing_memberTV;
    TextView closing_savings_outsTV;
    TextView this_m_disburse_loanTV;
    TextView this_year_disbursementTV;
    TextView End_Outstanding_LoanTV;
    TextView this_m_total_disburse_loaneeTV;
    TextView end_total_outstanding_loaneeTV;
    TextView new_due_loanTV;
    TextView overdue_loanTV;
    TextView overdue_loaneeTV;
    TextView end_due_loanTV;
    TextView recoverydue_loanTV;
    TextView end_due_loanscTV;
    TextView end_due_loaneeTV;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch_details);
        Initialization();
        ShowData();
    }

    private void ShowData()
    {
        branchModels = branchDataStorage.getAllBranchData();
        String positionString = getIntent().getStringExtra("position");
        int position = Integer.valueOf(positionString);

        Integer rIdPosition = (branchModels.get(position)).getId();
        String areaNamePosition = (branchModels.get(position)).getAreaName();
        String branchNamePosition = (branchModels.get(position)).getBranchName();
        String month_of_reportPosition = (branchModels.get(position)).getMonth_Of_Report();
        String no_of_centerPosition = (branchModels.get(position)).getNoOfCenter();
        String no_of_staffPosition = (branchModels.get(position)).getNoOFStaff();
        String closing_memberPosition = (branchModels.get(position)).closing_Member;
        String closing_savings_outsPosition = (branchModels.get(position)).closing_Savings_Outs;
        String this_m_disburse_loanPosition = (branchModels.get(position)).getThis_M_Disburse_Loan();
        String this_m_total_disburse_loaneePosition = (branchModels.get(position)).getThis_M_Total_Disburse_Loanee();
        String this_year_disbursementPosition = (branchModels.get(position)).getThisYearDisbursement();
        String End_Outstanding_LoanPosition = (branchModels.get(position)).end_Outstanding_Loan;
        String end_total_outstanding_loaneePosition = (branchModels.get(position)).end_Total_Outstanding_Loanee;
        String new_due_loanPosition = (branchModels.get(position)).getNew_Due_Loan();
        String overdue_loanPosition = (branchModels.get(position)).getOverDue_Loan();
        String overdue_loaneePosition = (branchModels.get(position)).getOverDue_Loanee();
        String end_due_loanPosition = (branchModels.get(position)).getEnd_Due_Loan();
        String recoverydue_loanPosition = (branchModels.get(position)).getRecoveryDue_Loan();
        String end_due_loanscPosition = (branchModels.get(position)).getEnd_Due_LoanSC();
        String end_due_loaneePosition = (branchModels.get(position)).getEnd_Due_Loanee();



        IdTV.setText(String.valueOf(rIdPosition));
        area_nameTV.setText(areaNamePosition);
        branch_nameTV.setText(branchNamePosition);
        month_of_reportTV.setText(month_of_reportPosition);
        no_of_centerTV.setText(no_of_centerPosition);
        no_of_staffTV.setText(no_of_staffPosition);
        closing_memberTV.setText(closing_memberPosition);
        closing_savings_outsTV.setText(closing_savings_outsPosition);
        this_m_disburse_loanTV.setText(this_m_disburse_loanPosition);
        this_year_disbursementTV.setText(this_year_disbursementPosition);
        End_Outstanding_LoanTV.setText(End_Outstanding_LoanPosition);
        this_m_total_disburse_loaneeTV.setText(this_m_total_disburse_loaneePosition);
        end_total_outstanding_loaneeTV.setText(end_total_outstanding_loaneePosition);
        new_due_loanTV.setText(new_due_loanPosition);
        overdue_loanTV.setText(overdue_loanPosition);
        overdue_loaneeTV.setText(overdue_loaneePosition);
        end_due_loanTV.setText(end_due_loanPosition);
        recoverydue_loanTV.setText(recoverydue_loanPosition);
        end_due_loanscTV.setText(end_due_loanscPosition);
        end_due_loaneeTV.setText(end_due_loaneePosition);


    }

    private void Initialization()
    {
        branchDataStorage = new BranchDataStorage(getApplicationContext());
        IdTV= (TextView) findViewById(R.id.IdDetailsTV);
                area_nameTV= (TextView) findViewById(R.id.areaNameDetailsTV);
                branch_nameTV= (TextView) findViewById(R.id.branchNameDetailsTV);
                month_of_reportTV= (TextView) findViewById(R.id.monthOfReportDetailsTV);
                no_of_centerTV= (TextView) findViewById(R.id.no_of_centerDetailsTV);
                no_of_staffTV= (TextView) findViewById(R.id.no_of_staffDetailsTV);
                closing_memberTV= (TextView) findViewById(R.id.closing_memberDetailsTV);
                closing_savings_outsTV= (TextView) findViewById(R.id.closing_savings_outsDetailsTV);
                this_m_disburse_loanTV= (TextView) findViewById(R.id.this_m_disburse_loanDetailsTV);
                this_year_disbursementTV= (TextView) findViewById(R.id.this_year_disbursementDetailsTV);
                End_Outstanding_LoanTV= (TextView) findViewById(R.id.end_Outstanding_LoanDetailsTV);
                this_m_total_disburse_loaneeTV= (TextView) findViewById(R.id.this_m_total_disburse_loaneeDetailsTV);
                end_total_outstanding_loaneeTV= (TextView) findViewById(R.id.end_total_outstanding_loaneeDetailsTV);
                new_due_loanTV= (TextView) findViewById(R.id.new_due_loanDetailsTV);
                overdue_loanTV= (TextView) findViewById(R.id.overdue_loanDetailsTV);
                overdue_loaneeTV= (TextView) findViewById(R.id.overdue_loaneeDetailsTV);
                end_due_loanTV= (TextView) findViewById(R.id.end_due_loanDetailsTV);
                recoverydue_loanTV= (TextView) findViewById(R.id.recoverydue_loanDetailsTV);
                end_due_loanscTV= (TextView) findViewById(R.id.end_due_loanscDetailsTV);
                end_due_loaneeTV= (TextView) findViewById(R.id.end_due_loaneeDetailsTV);
    }

    public void onClickBacktoMain(View view) {
        Intent intent=new Intent(getApplicationContext(),BranchSearchActivity.class);
        startActivity(intent);
        finish();

    }
}
