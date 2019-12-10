package com.example.javafinalpractical;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.KeyEvent;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView.OnEditorActionListener;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
        implements  OnEditorActionListener,OnClickListener,
      OnCheckedChangeListener {


    private TextView teamA_textview , teamB_textview ,teamA_score_textview ,teamB_score_textview,teamC_textview,teamC_score_textview;
    private Button increase_TeamA_Button3, increase_TeamB_Button, decrease_TeamA_Button, decrease_TeamB_Button , increase_TeamC_Button,
            decrease_TeamC_Button;
    private RadioButton rad_1, rad_2, rad_3;
    private RadioGroup rad_group;
    private String scoreAString = "";
    private String scoreBString = "";
    private int scoreA = 0;
    private int scoreB = 0;
    private int scoreC = 0 ;
    private int scoreChange = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teamA_score_textview = (TextView) findViewById(R.id.teamA_score_textview);
        teamB_score_textview = (TextView) findViewById(R.id.teamB_score_textview);
        teamC_score_textview = (TextView) findViewById(R.id.teamC_score_textview);
        increase_TeamA_Button3 = (Button) findViewById(R.id.increase_TeamA_Button3);
        increase_TeamB_Button = (Button) findViewById(R.id.increase_TeamB_Button);
        increase_TeamC_Button = (Button) findViewById(R.id.increase_TeamC_Button);


        decrease_TeamA_Button = (Button) findViewById(R.id.decrease_TeamA_Button);
        decrease_TeamB_Button = (Button) findViewById(R.id.decrease_TeamB_Button);
        decrease_TeamC_Button = (Button) findViewById(R.id.decrease_TeamC_Button);

        rad_1 = (RadioButton) findViewById(R.id.radiotwopoints);
        rad_2 = (RadioButton) findViewById(R.id.radiofourpoints);
        rad_3 = (RadioButton) findViewById(R.id.radiosixpoints);
        rad_group = (RadioGroup) findViewById(R.id.radioGroup);
        rad_group.setOnCheckedChangeListener(this);

        teamA_score_textview.setOnEditorActionListener(this);
        teamB_score_textview.setOnEditorActionListener(this);
        teamC_score_textview . setOnEditorActionListener(this);

        increase_TeamA_Button3.setOnClickListener(this);
        increase_TeamB_Button.setOnClickListener(this);
        increase_TeamC_Button.setOnClickListener(this);
        decrease_TeamB_Button.setOnClickListener(this);
        decrease_TeamA_Button.setOnClickListener(this);
        decrease_TeamC_Button.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu. menu_main , menu);
        return true;
    }


    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE ||
                actionId == EditorInfo.IME_ACTION_UNSPECIFIED) {
            teamA_score_textview.setText("10");
            teamB_score_textview.setText("10");
            teamC_score_textview.setText("10");
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.decrease_TeamA_Button:
                scoreA = Integer.parseInt(teamA_score_textview.getText().toString());
                scoreA = scoreA - scoreChange;
                teamA_score_textview.setText(Integer.toString(scoreA));
                break;


            case R.id.decrease_TeamB_Button:
                scoreB = Integer.parseInt(teamB_score_textview.getText().toString());
                scoreB = scoreB - scoreChange;
                teamB_score_textview.setText(Integer.toString(scoreB));
//                calculateAndDisplay();
                break;
            case R.id.increase_TeamA_Button3:
                scoreA = Integer.parseInt(teamA_score_textview.getText().toString());
                scoreA = scoreA + scoreChange;
                teamA_score_textview.setText(Integer.toString(scoreA));
//                calculateAndDisplay();
                break;

            case R.id.increase_TeamB_Button:
                scoreB = Integer.parseInt(teamB_score_textview.getText().toString());
                scoreB = scoreB + scoreChange;
                teamB_score_textview.setText(Integer.toString(scoreB));
//                calculateAndDisplay();
                break;
            case  R.id.decrease_TeamC_Button:
                scoreC = Integer.parseInt(teamC_score_textview.getText().toString());
                scoreC = scoreC - scoreChange;
                teamC_score_textview.setText(Integer.toString(scoreC));
                break;

            case R.id.increase_TeamC_Button:
                scoreC = Integer.parseInt(teamC_score_textview.getText().toString());
                scoreC = scoreC + scoreChange;
                teamC_score_textview.setText(Integer.toString(scoreC));
                break;



        }




    }



    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId) {
            case R.id.radiotwopoints:
            default:
                scoreChange = 2;
                break;
            case R.id.radiofourpoints:
                scoreChange = 4;
                break;
            case R.id.radiosixpoints:
                scoreChange = 6;
                break;
        }



    }
}
