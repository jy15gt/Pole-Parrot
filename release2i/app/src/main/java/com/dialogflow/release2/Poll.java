package com.dialogflow.release2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

public class Poll extends AppCompatActivity {

    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poll);
        Objects.requireNonNull(this.getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        RelativeLayout rl = findViewById(R.id.r_layout);
        radioGroup = findViewById(R.id.radioGroup);
        RadioButton button;
        int numChoices = getIntent().getIntExtra("numChoices", 0);
        ArrayList<String> choices = (ArrayList<String>) getIntent().getSerializableExtra("choices");
        TextView tv = findViewById(R.id.pollQuestion);
        tv.setText(choices.get(0));
        for (int i = 1; i < numChoices; i++) {
            button = new RadioButton(this);
            button.setText(choices.get(i));
            radioGroup.addView(button);
        }
        radioGroup.setOrientation(LinearLayout.VERTICAL);
        ArrayList<String> list1 = (ArrayList<String>) getIntent().getSerializableExtra("choices");
        ArrayList<String> list2 = choices;
        // test if these arraylists are equal to each other to make sure I'm passing the right object.
        System.out.println(list1.equals(list2));
    }

    public void Vote(View view){
        int selection = radioGroup.getCheckedRadioButtonId();
        if (selection == -1){ //no choice made, throw alertdialog

        }
        else{

        }
        radioGroup.clearCheck();
    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), CreatePoll.class);
        startActivityForResult(myIntent, 0);
        return true;
    }
}