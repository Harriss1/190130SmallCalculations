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

import com.example.smallcalculations.Model.VersionControl;

import com.example.smallcalculations.ViewModel.ViewModel;

import org.w3c.dom.Text;

import android.widget.Toast;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {



    // Why do I have to declare EditText and TextView here, but ResultText can be declared inside?
    //-> everything that wants to be modified after run needs to be declared globally here...

    EditText inputFirstNumber;
    EditText inputSecondNumber;
    int glOperator=0; //0=+, 1=-, 2=*, 3=/

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
        resultText.setText("Input two numbers and select operation.");

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
                calculation.setOperator(glOperator);

                DisplayableResult result=calculation.getResult();
                //result.result=30;
                if (result.calculationSuccessful) {
                    result2Text.setText(Double.toString(result.result));
                } else {
                  result2Text.setText("Error: " +result.errorMessage);
                }


                //result2Text.setText("Nice Stuff");
            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.spinnerOperatorType);
        // Create an ArrayAdapter using the string array and a default spinner layout
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.planets_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
                spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);


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

        if (id == R.id.action_version){
            VersionControl v = new VersionControl();
            String version = v.getVersionString();
            Toast.makeText(MainActivity.this, ("Build version: "+version), Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)

        glOperator=pos;

    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

}
