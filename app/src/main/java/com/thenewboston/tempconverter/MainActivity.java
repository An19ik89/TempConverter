package com.thenewboston.tempconverter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private Button CelButton;
    private Button FaButton;
    private EditText MyEditText;
    private TextView MyTextView;
    DecimalFormat round = new DecimalFormat("0.0");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyEditText = (EditText)findViewById(R.id.editTextId);
        CelButton = (Button)findViewById(R.id.cId);
        FaButton = (Button)findViewById(R.id.fId);
        MyTextView = (TextView)findViewById(R.id.textView);

        CelButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
              String val = MyEditText.getText().toString();

               //if (val instanceof String){
                //Toast.makeText(getApplicationContext(),"Wrong Input",Toast.LENGTH_LONG).show();
               //}


               if (val.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please Enter Value",Toast.LENGTH_LONG).show();
                }

                else {

                   try {

                       double doubleEditText = Double.parseDouble(val);
                       double convertedcel = convertToCel(doubleEditText);
                       String convertedvalue = String.valueOf(round.format(convertedcel));
                       MyTextView.setText(convertedvalue+" C ");
                   }catch (Exception e){
                      Toast.makeText(getApplicationContext(),"Wrong Input",Toast.LENGTH_LONG).show();
                   }
                }
            }
        });
        FaButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String val1 = MyEditText.getText().toString();
                if (val1.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please Enter Value",Toast.LENGTH_LONG).show();
                }
                else {
                    try {

                        double doubleEditText1 = Double.parseDouble(val1);
                        double convertedfar = convertToFar(doubleEditText1);
                        String convertedvalue = String.valueOf(round.format(convertedfar));
                        MyTextView.setText(convertedvalue+" F ");
                    }catch (Exception e){
                        Toast.makeText(getApplicationContext(),"Wrong Input",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }
    public double convertToCel(double c){
     double resultcel;
        resultcel=(c-32)*5/9;
        return resultcel;
    }
    public double convertToFar(double f){
        double resultfar;
        resultfar=(f*9/5)+32;
        return resultfar;
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
