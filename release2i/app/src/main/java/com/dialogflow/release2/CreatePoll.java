package com.dialogflow.release2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class CreatePoll extends AppCompatActivity implements View.OnClickListener{

    static int editTextsNum = 3;
    ScrollView sv;
    LinearLayout ll;
    ArrayList<String> choices;
    ArrayList<EditText> editTexts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_poll);
        Objects.requireNonNull(this.getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        choices = new ArrayList<>();
        editTexts = new ArrayList<>();
        sv = findViewById(R.id.scrollView);
        ll = findViewById(R.id.linearLayout);
        Button button = new Button(this);
        button.setText("Add Choice");
        button.setOnClickListener(this);
        EditText question = new EditText(this);
        editTexts.add(question);
        question.setText("Poll Question");
        EditText et = new EditText(this);
        et.setText("Choice 1");
        editTexts.add(et);
        EditText et2 = new EditText(this);
        et2.setText("Choice 2");
        editTexts.add(et2);
        ll.addView(question);
        ll.addView(button);
        ll.addView(et);
        ll.addView(et2);
        ll.setOrientation(LinearLayout.VERTICAL);

    }
    @Override
    public void onClick(View view) {
        editTextsNum++;
        EditText editText = new EditText(this);
        ll.addView(editText);
        editText.setGravity(Gravity.START);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) editText.getLayoutParams();
        layoutParams.width = LinearLayout.LayoutParams.MATCH_PARENT;
        editText.setLayoutParams(layoutParams);
        editText.setText("Choice " + (editTextsNum - 1));
        editTexts.add(editText);
    }

    public void createPoll(View view){
        Intent intent = new Intent(getApplicationContext(), Poll.class);
        for (int i = 0; i < editTextsNum; i++) {
            choices.add(editTexts.get(i).getText().toString());
        }
        intent.putExtra("choices", choices);
        intent.putExtra("numChoices", editTextsNum);
        startActivity(intent);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;
    }

}