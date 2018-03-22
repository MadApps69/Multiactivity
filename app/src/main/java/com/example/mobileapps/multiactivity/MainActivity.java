package com.example.mobileapps.multiactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    final static int REQUEST_CODE1 = 1;
    final static int REQUEST_CODE2 = 2;

    TextView textViewfeedback;
    Button buttonTest1, buttonTest2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize ();

    }

    private void initialize() {

        buttonTest1 = findViewById(R.id.buttonTest1);
        buttonTest1.setOnClickListener(this);

        buttonTest2 = findViewById(R.id.buttonTest2);
        buttonTest2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.buttonTest1:
                gotoTest1();
                break;
            case R.id.buttonTest2:
                gotoTest2();
                break;

        }



    }


    private void gotoTest1() {
        Intent intent = new Intent(this, ActivityTest1.class);
        startActivityForResult(intent, REQUEST_CODE1);
    }

    private void gotoTest2() {
        Intent intent = new Intent(this, ActivityTest2.class);
        startActivityForResult(intent, REQUEST_CODE2);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE1){
            String receivedData =(String) data.getStringExtra("return_result_tag");
            if(resultCode == RESULT_OK)
                textViewfeedback.setText(receivedData);
            else textViewfeedback.setText("Cancelled");
        }
        if(requestCode == REQUEST_CODE2){
            String receivedData =(String) data.getStringExtra("OK");
            if(resultCode == RESULT_OK)
                textViewfeedback.setText(receivedData);
            else textViewfeedback.setText("Cancelled_From_Test_2");
        }


    }
}

