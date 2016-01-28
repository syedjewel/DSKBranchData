package com.jewel.jewana.dskbranchreport;

/**
 * Created by Jewana on 12/31/2015.
 */
public class BranchModel {
    public Integer Id;
    public String areaName;
    public String branchName;//Branch
    public String month_Of_Report;
    public String noOfCenter;
    public String noOFStaff;
    public String closing_Member;
    public String closing_Savings_Outs;
    public String this_M_Disburse_Loan;
    public String thisYearDisbursement;
    public String end_Outstanding_Loan;
    public String this_M_Total_Disburse_Loanee;
    public String end_Total_Outstanding_Loanee;
    public String new_Due_Loan;
    public String overDue_Loan;
    public String overDue_Loanee;
    public String end_Due_Loan;
    public String recoveryDue_Loan;
    public String  end_Due_LoanSC;//End_Due_Loan1
    public String end_Due_Loanee;

    public BranchModel(){}

    public BranchModel(String areaName, String branchName,String month_Of_Report,
                       String noOfCenter, String noOFStaff,
                       String closing_Member,
                       String closing_Savings_Outs,
                       String this_M_Disburse_Loan,
                       String thisYearDisbursement,
                       String end_Outstanding_Loan,
                       String this_M_Total_Disburse_Loanee,
                       String end_Total_Outstanding_Loanee,
                       String new_Due_Loan,
                       String overDue_Loanee,
                       String overDue_Loan,
                       String recoveryDue_Loan,
                       String end_Due_Loan,
                       String end_Due_LoanSC,
                       String end_Due_Loanee) {
        this.areaName = areaName;
        this.branchName = branchName;
        this.closing_Member = closing_Member;
        this.closing_Savings_Outs = closing_Savings_Outs;
        this.end_Due_Loan = end_Due_Loan;
        this.end_Due_Loanee = end_Due_Loanee;
        this.end_Due_LoanSC = end_Due_LoanSC;
        this.end_Outstanding_Loan = end_Outstanding_Loan;
        this.end_Total_Outstanding_Loanee = end_Total_Outstanding_Loanee;
        this.month_Of_Report = month_Of_Report;
        this.new_Due_Loan = new_Due_Loan;
        this.noOfCenter = noOfCenter;
        this.noOFStaff = noOFStaff;
        this.overDue_Loan = overDue_Loan;
        this.overDue_Loanee = overDue_Loanee;
        this.recoveryDue_Loan = recoveryDue_Loan;
        this.this_M_Disburse_Loan = this_M_Disburse_Loan;
        this.this_M_Total_Disburse_Loanee = this_M_Total_Disburse_Loanee;
        this.thisYearDisbursement = thisYearDisbursement;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getClosing_Member() {
        return closing_Member;
    }

    public void setClosing_Member(String closing_Member) {
        this.closing_Member = closing_Member;
    }

    public String getClosing_Savings_Outs() {
        return closing_Savings_Outs;
    }

    public void setClosing_Savings_Outs(String closing_Savings_Outs) {
        this.closing_Savings_Outs = closing_Savings_Outs;
    }

    public String getEnd_Due_Loan() {
        return end_Due_Loan;
    }

    public void setEnd_Due_Loan(String end_Due_Loan) {
        this.end_Due_Loan = end_Due_Loan;
    }

    public String getEnd_Due_Loanee() {
        return end_Due_Loanee;
    }

    public void setEnd_Due_Loanee(String end_Due_Loanee) {
        this.end_Due_Loanee = end_Due_Loanee;
    }

    public String getEnd_Due_LoanSC() {
        return end_Due_LoanSC;
    }

    public void setEnd_Due_LoanSC(String end_Due_LoanSC) {
        this.end_Due_LoanSC = end_Due_LoanSC;
    }

    public String getEnd_Outstanding_Loan() {
        return end_Outstanding_Loan;
    }

    public void setEnd_Outstanding_Loan(String end_Outstanding_Loan) {
        this.end_Outstanding_Loan = end_Outstanding_Loan;
    }

    public String getEnd_Total_Outstanding_Loanee() {
        return end_Total_Outstanding_Loanee;
    }

    public void setEnd_Total_Outstanding_Loanee(String end_Total_Outstanding_Loanee) {
        this.end_Total_Outstanding_Loanee = end_Total_Outstanding_Loanee;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getMonth_Of_Report() {
        return month_Of_Report;
    }

    public void setMonth_Of_Report(String month_Of_Report) {
        this.month_Of_Report = month_Of_Report;
    }

    public String getNew_Due_Loan() {
        return new_Due_Loan;
    }

    public void setNew_Due_Loan(String new_Due_Loan) {
        this.new_Due_Loan = new_Due_Loan;
    }

    public String getNoOfCenter() {
        return noOfCenter;
    }

    public void setNoOfCenter(String noOfCenter) {
        this.noOfCenter = noOfCenter;
    }

    public String getNoOFStaff() {
        return noOFStaff;
    }

    public void setNoOFStaff(String noOFStaff) {
        this.noOFStaff = noOFStaff;
    }

    public String getOverDue_Loan() {
        return overDue_Loan;
    }

    public void setOverDue_Loan(String overDue_Loan) {
        this.overDue_Loan = overDue_Loan;
    }

    public String getOverDue_Loanee() {
        return overDue_Loanee;
    }

    public void setOverDue_Loanee(String overDue_Loanee) {
        this.overDue_Loanee = overDue_Loanee;
    }

    public String getRecoveryDue_Loan() {
        return recoveryDue_Loan;
    }

    public void setRecoveryDue_Loan(String recoveryDue_Loan) {
        this.recoveryDue_Loan = recoveryDue_Loan;
    }

    public String getThis_M_Disburse_Loan() {
        return this_M_Disburse_Loan;
    }

    public void setThis_M_Disburse_Loan(String this_M_Disburse_Loan) {
        this.this_M_Disburse_Loan = this_M_Disburse_Loan;
    }

    public String getThis_M_Total_Disburse_Loanee() {
        return this_M_Total_Disburse_Loanee;
    }

    public void setThis_M_Total_Disburse_Loanee(String this_M_Total_Disburse_Loanee) {
        this.this_M_Total_Disburse_Loanee = this_M_Total_Disburse_Loanee;
    }

    public String getThisYearDisbursement() {
        return thisYearDisbursement;
    }

    public void setThisYearDisbursement(String thisYearDisbursement) {
        this.thisYearDisbursement = thisYearDisbursement;
    }
}
