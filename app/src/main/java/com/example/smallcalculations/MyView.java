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

public class MyView extends AppCompatActivity {

    TextView someText;
    public MyView(){
    }

    public void alterText(){

        someText = (TextView)findViewById(R.id.result);
        someText.setText("In MyView");
    }

    public void exposeStream(){

    }

    public boolean checkForStreamUpdate(){
        return true;
    }

    public String checkForStreamUpdatePart(){
        return "which part got updated";
    }
    public void getStream(){
        //getStream().partOfData();

    }

}
