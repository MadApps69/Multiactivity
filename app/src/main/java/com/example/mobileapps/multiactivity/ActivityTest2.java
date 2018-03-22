package com.example.mobileapps.multiactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityTest2 extends AppCompatActivity implements View.OnClickListener{

    Button buttonOk,buttonCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);

        initialize ();

    }

    private void initialize() {

        buttonOk = findViewById(R.id.buttonOk);
        buttonOk.setOnClickListener(this);

        buttonCancel = findViewById(R.id.buttonCancel);
        buttonCancel.setOnClickListener(this);
    }




    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.buttonOk:
                goOk();
                break;
            case R.id.buttonCancel:
                goCancel();
                break;

        }
    }

    private void goCancel() {
        String strResult = "Cancel results from test 2";
        Intent intent = new Intent();
        intent.putExtra("cancel_tag", strResult);
        setResult(RESULT_CANCELED,intent);
        finish();


    }

    private void goOk() {
        String strResult = "OK results from test 2";
        Intent intent = new Intent();
        intent.putExtra("OK", strResult);
        setResult(RESULT_OK,intent);
        finish();
    }

}


