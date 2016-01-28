package com.jewel.jewana.dskbranchreport;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class BranchSearchActivity extends AppCompatActivity {
    ListView productLV;
    ArrayList<BranchModel> dskBranchModels;
    BranchDataStorage dskBranchStorage;
    EditText searchET;
    TextView numberofProductsTV;

    ImageButton btnSpeak;
    private final int REQ_CODE_SPEECH_INPUT = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_branch_search);

        setContentView(R.layout.search_layout);
        productLV = (ListView) findViewById(R.id.productLV);
        dskBranchStorage = new BranchDataStorage(getApplicationContext());
        searchET=(EditText) findViewById(R.id.searchET);
        numberofProductsTV = (TextView) findViewById(R.id.numberofProductsTV);
        btnSpeak = (ImageButton) findViewById(R.id.btnSpeak);

        showProduct();

        btnSpeak.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                promptSpeechInput();
            }
        });

        searchET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                showSearchProduct(searchET.getText().toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    /**
     * Showing google speech input dialog
     * */
    private void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                getString(R.string.speech_prompt));
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Receiving speech input
     * */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    searchET.setText(result.get(0));
                }
                break;
            }

        }
    }


    private void showSearchProduct(String searchText) {
        dskBranchModels = dskBranchStorage.getSearchBranch(searchText);
        int numberOfProducts = dskBranchModels.size();
        numberofProductsTV.setText("Number of Branch: "+String.valueOf(numberOfProducts));

        BranchLVAdapter branchLVAdapter = new BranchLVAdapter(getBaseContext(), dskBranchModels);
        productLV.setAdapter(branchLVAdapter);
        productLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(BranchSearchActivity.this, BranchDetailsActivity.class);
                intent.putExtra("position", String.valueOf(position));
                startActivity(intent);
            }
        });
    }


    private void showProduct() {
        dskBranchModels = dskBranchStorage.getAllBranchData();

        int numberOfProducts = dskBranchModels.size();
        numberofProductsTV.setText("Number of Record: "+String.valueOf(numberOfProducts));

        BranchLVAdapter dskBranchLVAdapter = new BranchLVAdapter(getBaseContext(), dskBranchModels);
        productLV.setAdapter(dskBranchLVAdapter);
        productLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(BranchSearchActivity.this, BranchDetailsActivity.class);
                intent.putExtra("position", String.valueOf(position));
                startActivity(intent);
            }
        });
    }

}
