package com.example.smallcalculations;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.EditText;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {


    String fortuneList[] = {
            "Don’t count on it","Ask again later","You may rely on it","Without a doubt","Outlook not so good","It's decidedly so","Signs point to yes","Yes definitely","Yes","My sources say NO"
    };

    EditText inputNumber;
    TextView resultText;
    Button doStuffButton;
    ImageView mFortuneBallImage;
    TextView result2Text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        resultText = (TextView) findViewById(R.id.result);
        resultText.setText("Here we display the result.");
        SmallCalculations testObject = new SmallCalculations();
        resultText.setText(testObject.getName());



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
        });

        // implement button "Do Stuff" fab.setOnClickListener();
        doStuffButton = (Button)findViewById(R.id.button);
        doStuffButton.setOnClickListener(new View.OnClickListener() {
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
