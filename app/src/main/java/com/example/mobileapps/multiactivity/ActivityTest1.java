package com.example.mobileapps.multiactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class ActivityTest1 extends AppCompatActivity implements View.OnClickListener{

    int rightResult;//this is used to store our random operation
    Button buttonGenerate,buttonValidate,buttonCancel;

    TextView tvQuestion;
    EditText etAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);


        initialize ();

    }

    private void initialize() {
        tvQuestion=findViewById(R.id.tvQuestion);
        etAnswer=findViewById(R.id.etAnswer);

        buttonGenerate = findViewById(R.id.buttonGenerate);
        buttonGenerate.setOnClickListener(this);

        buttonValidate = findViewById(R.id.buttonValidate);
        buttonValidate.setOnClickListener(this);

        buttonCancel = findViewById(R.id.buttonCancel);
        buttonCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.buttonGenerate:
//                System.out.println("----------- buttonGenerate");
                goGenerate();
                break;
            case R.id.buttonValidate:
//                System.out.println("=========== buttonValidate");
                goValidate();
                break;


        }

    }
    public void goGenerate(){
        Random random = new Random();

        int operand1 = random.nextInt(10);
        int operand2 = random.nextInt(10);

        rightResult = operand1 + operand2;

        String operation = String.valueOf(operand1)+ "+" + String.valueOf(operand2)+ "= ?";

        System.out.println("-------------" + operation);

        tvQuestion.setText(operation);

    }
    public void goValidate(){
        int integerUserAnswer = Integer.valueOf(etAnswer.getText().toString());
        String strResult;

        if(integerUserAnswer == rightResult){
            strResult="Right Answer!!!! YAY";

        }else{
            strResult="Wrong Answer\uD83E\uDD2C ";

        }
// create intent and putextra result string
        Intent intent = new Intent();
        intent.putExtra("return_result_tag",strResult);

//      set result for main activity
       setResult(RESULT_OK,intent);
       finish();
    }
}
