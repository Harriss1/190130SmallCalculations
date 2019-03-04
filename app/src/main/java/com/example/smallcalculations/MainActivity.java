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

import com.example.smallcalculations.Model.SmallCalculations;
import com.example.smallcalculations.ViewModel.SmallCalculationsConnector;
import com.example.smallcalculations.ViewModel.DisplayableResult;

import com.example.smallcalculations.ViewModel.ViewModel;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {



    // Why do I have to declare EditText and TextView here, but ResultText can be declared inside?
    //-> everything that wants to be modified after run needs to be declared globally here...

    EditText inputFirstNumber;
    EditText inputSecondNumber;

    TextView result2Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        //Why can I declare TextView resultText as local variable?
        //because it isn't used in the overwritten function!!!
        //This also means, that every view-element that I want to modify after the run, must be global.
        TextView resultText;
        resultText = (TextView) findViewById(R.id.result);
        resultText.setText("Here we display the result.");

        // implement button "Calculate" fab.setOnClickListener();
        final Button calculateButton = (Button)findViewById(R.id.button);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputFirstNumber = (EditText) findViewById(R.id.phone);
                inputSecondNumber =(EditText) findViewById(R.id.phone2);

                result2Text = (TextView)findViewById(R.id.result2);

                String inputA = inputFirstNumber.getText().toString();
                String inputB = inputSecondNumber.getText().toString();
                String inputOperator = "NOTSET";

                SmallCalculationsConnector calculation = new SmallCalculationsConnector();
                calculation.setA(inputA);
                calculation.setB(inputB);
                calculation.setOperator(1);

                DisplayableResult result=calculation.getResult();
                //result.result=30;
                result2Text.setText(Double.toString(result.result));


                //result2Text.setText("Nice Stuff");
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
