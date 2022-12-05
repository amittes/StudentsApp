package com.example.studentsApp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.studentsApp.model.Model;
import com.example.studentsApp.model.Student;

import java.util.List;

public class AddStudentActivity extends AppCompatActivity {

    List<Student> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        data = Model.instance().getAllStudents();

        setContentView(R.layout.activity_add_student);

        EditText nameEt = findViewById(R.id.addstudent_name_et);
        EditText idEt = findViewById(R.id.addstudent_id_et);
        EditText phoneEt = findViewById(R.id.addstudent_phone_et);
        EditText addressEt = findViewById(R.id.addstudent_address_et);
        Button saveBtn = findViewById(R.id.addstudent_save_btn);
        Button cancelBtn = findViewById(R.id.addstudent_cancel_btn);

        saveBtn.setOnClickListener(view -> {

            String name = nameEt.getText().toString();
            String id = nameEt.getText().toString();
            String phone = nameEt.getText().toString();
            String address = nameEt.getText().toString();
            //Boolean isChecked =

            Student student = new Student(name, id, phone, address, false);
            data.add(student);
            finish();
        });

        cancelBtn.setOnClickListener(view -> finish());
    }

}