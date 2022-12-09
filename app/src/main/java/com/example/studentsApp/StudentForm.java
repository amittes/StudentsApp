package com.example.studentsApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.studentsApp.model.Model;
import com.example.studentsApp.model.Student;

public class StudentForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_form);

        EditText nameEt = findViewById(R.id.studentform_name_et);
        EditText idEt = findViewById(R.id.studentform_id_et);
        EditText phoneNumberEt = findViewById(R.id.studentform_phone_et);
        EditText addressEt = findViewById(R.id.studentform_address_et);
        CheckBox cb = findViewById(R.id.studentform_cb);
        Button saveBtn = findViewById(R.id.studentform_save_btn);
        Button cancelBtn = findViewById(R.id.studentform_cancel_btn);

        int position = getIntent().getIntExtra("position", -1);

        if (position != -1) {
            Button deleteBtn = findViewById(R.id.studentform_delete_btn);
            deleteBtn.setVisibility(Button.VISIBLE);

            Student student = Model.instance().getStudent(position);
            nameEt.setText(student.name);
            idEt.setText(student.id);
            phoneNumberEt.setText(student.phoneNumber);
            addressEt.setText(student.address);
            cb.setChecked(student.cb);
            deleteBtn.setOnClickListener(view -> {
                Model.instance().deleteStudent(position);
                finish();
            });
        }

        saveBtn.setOnClickListener(view -> {
            String name = nameEt.getText().toString();
            String id = idEt.getText().toString();
            String phoneNumber = phoneNumberEt.getText().toString();
            String address = addressEt.getText().toString();
            boolean isChecked = cb.isChecked();

            Model studentsModel = Model.instance();
            Student student = new Student(name, id, "", isChecked, phoneNumber, address);
            if (position != -1 ) { studentsModel.editStudentDetails(position, student); }
            else { studentsModel.addStudent(student); }
            finish();
        });

        cancelBtn.setOnClickListener(view -> {
            finish();
        });
    }
}