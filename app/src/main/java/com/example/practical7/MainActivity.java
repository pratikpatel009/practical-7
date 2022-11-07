package com.example.practical7;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    EditText name,enrollmentNumber,branch,year;
    Button button;
    String studentName,studentEnrollmentNumber,studentBranch,studentYear;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        enrollmentNumber = findViewById(R.id.enrollmentNumber);
        branch = findViewById(R.id.branch);
        year = findViewById(R.id.year);
        button = findViewById(R.id.save);

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                studentName = name.getText().toString().trim();
//                studentEnrollmentNumber = enrollmentNumber.getText().toString().trim();
//                studentBranch = branch.getText().toString().trim();
//                studentYear = year.getText().toString().trim();
//
//                DBHandler dbHandler = new DBHandler(MainActivity.this);
//                dbHandler.execute(studentName,studentEnrollmentNumber,studentBranch,studentYear);
//                finish();
//            }
//        });
    }





    public void saveData(View view){

        studentName = name.getText().toString().trim();
        studentEnrollmentNumber = enrollmentNumber.getText().toString().trim();
        studentBranch = branch.getText().toString().trim();
        studentYear = year.getText().toString().trim();

        DBHandler dbHandler = new DBHandler(this);
        dbHandler.execute(studentName,studentEnrollmentNumber,studentBranch,studentYear);


    }
}