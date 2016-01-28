package com.jewel.jewana.dskbranchreport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jewana on 12/30/2015.
 */
public class BranchLVAdapter extends ArrayAdapter {

    Context context;
    LayoutInflater inflater;
    ArrayList<BranchModel> branchModels;

    public BranchLVAdapter(Context context, ArrayList<BranchModel> branchModels)
    {
        super(context, R.layout.list_view_layout, branchModels);
        this.context=context;
        this.branchModels = branchModels;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder branchHolder = new ViewHolder();

        if (convertView == null)
        {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_view_layout,parent,false);
            branchHolder.areaNameTV = (TextView) convertView.findViewById(R.id.areaNameTV);
            branchHolder.branchNameTV = (TextView) convertView.findViewById(R.id.branchTV);
            branchHolder.noOfStaffTV = (TextView) convertView.findViewById(R.id.noOfStaffTV);
            branchHolder.noOfMemberTV = (TextView) convertView.findViewById(R.id.totalMemberTV);
            branchHolder.savingBalanceTV = (TextView) convertView.findViewById(R.id.savingBalanceTV);
            branchHolder.loanBalanceTV = (TextView) convertView.findViewById(R.id.loanBalanceTV);
            branchHolder.totalDueTV = (TextView) convertView.findViewById(R.id.totaldueTV);
            branchHolder.monthOfReportTV = (TextView) convertView.findViewById(R.id.monthOfReportTV);

            convertView.setTag(branchHolder);
        }
        else
        {
            branchHolder = (ViewHolder) convertView.getTag();
        }
        Integer Id = (branchModels.get(position)).getId();
        String areaNamePosition = (branchModels.get(position)).getAreaName();
        String branchNamePosition = (branchModels.get(position)).getBranchName();
        String noOfStaffPosition = (branchModels.get(position)).getNoOFStaff();
        String noOfMemberPosition = (branchModels.get(position)).getClosing_Member();
        String savingBalancePosition = (branchModels.get(position)).getClosing_Savings_Outs();
        String loanBalancePosition = (branchModels.get(position)).getEnd_Outstanding_Loan();
        String dueBalancePosition = (branchModels.get(position)).getEnd_Due_LoanSC();
        String monthOfReportPosition = (branchModels.get(position)).getMonth_Of_Report();

        branchHolder.areaNameTV.setText(String.valueOf(areaNamePosition));
        branchHolder.branchNameTV.setText(branchNamePosition);
        branchHolder.noOfStaffTV.setText(String.valueOf(noOfStaffPosition));
        branchHolder.noOfMemberTV.setText(String.valueOf(noOfMemberPosition));
        branchHolder.savingBalanceTV.setText(String.valueOf(savingBalancePosition));
        branchHolder.loanBalanceTV.setText(String.valueOf(loanBalancePosition));
        branchHolder.totalDueTV.setText(String.valueOf(dueBalancePosition));
        branchHolder.monthOfReportTV.setText(String.valueOf(monthOfReportPosition));

        return convertView;
    }

    private static class ViewHolder
    {
        TextView areaNameTV;
        TextView branchNameTV;
        TextView noOfStaffTV;
        TextView noOfMemberTV;
        TextView savingBalanceTV;
        TextView loanBalanceTV;
        TextView totalDueTV;
        TextView monthOfReportTV;

    }
}