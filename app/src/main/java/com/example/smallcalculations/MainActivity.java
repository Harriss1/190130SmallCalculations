package com.example.smallcalculations;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {


    String fortuneList[] = {
            "Don’t count on it","Ask again later","You may rely on it","Without a doubt","Outlook not so good","It's decidedly so","Signs point to yes","Yes definitely","Yes","My sources say NO"
    };

// Why do I have to declare EditText and TextView here, but ResultText can be declared inside?
    EditText inputNumber;

    TextView result2Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        /*
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                inputNumber = (EditText) findViewById(R.id.phone);
                result2Text = (TextView)findViewById(R.id.result2);
                String inputNumberStr = inputNumber.getText().toString();
                double inputNumberDouble = Double.parseDouble(inputNumber.getText().toString());
                result2Text.setText(inputNumberStr);
                MyView test = new MyView();
                //test.alterText();
                //change after latest push from 18:15
                //change after switching to branch learnsession190202

                ViewModel newTest = new ViewModel();
                ViewModel.DisplayableResult var1 = newTest.getResult();
                int helloThere = var1.result;
                newTest.doCalculate();
                ViewModel.DisplayableResult var2;
                var2 = newTest.getDisplayableResult();

            }
        });*/

        //Why can I declare TextView resultText as local variable?
        //because it isn't used in the overwritten function!!!
        //This also means, that every view-element that I want to modify after the run, must be global.
        TextView resultText;
        resultText = (TextView) findViewById(R.id.result);
        resultText.setText("Here we display the result.");

        // implement button "Calculate" fab.setOnClickListener();
        Button calculateButton = (Button)findViewById(R.id.button);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNumber = (EditText) findViewById(R.id.phone);
                result2Text = (TextView)findViewById(R.id.result2);
                String inputNumberStr = inputNumber.getText().toString();
                double inputNumberDouble = Double.parseDouble(inputNumber.getText().toString());
                result2Text.setText("Nice Stuff");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
