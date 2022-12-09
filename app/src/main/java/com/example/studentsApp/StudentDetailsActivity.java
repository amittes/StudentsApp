package com.example.studentsApp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.studentsApp.model.Model;
import com.example.studentsApp.model.Student;

import org.w3c.dom.Text;

import java.util.List;

public class StudentDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);
        int position = getIntent().getIntExtra("position", -1);

        TextView id = findViewById(R.id.studentdetails_id_tv);
        TextView name = findViewById(R.id.studentdetails_name_tv);
        TextView phoneNumber = findViewById(R.id.studentdetails_phone_tv);
        TextView address = findViewById(R.id.studentdetails_address_tv);
        CheckBox cb = findViewById(R.id.studentdetails_cb);
        Button editButton = findViewById(R.id.studentdetails_edit_btn);

        Student student = Model.instance().getStudent(position);
        id.setText(student.id);
        name.setText(student.name);
        phoneNumber.setText(student.phoneNumber);
        address.setText(student.address);
        cb.setChecked(student.cb);

        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = getIntent().getIntExtra("position", -1);
                if (position != -1) {
                    Student st = Model.instance().getStudent(position);
                    st.cb = cb.isChecked();
                    Model.instance().editStudentDetails(position, st);
                }
            }
        });

        editButton.setOnClickListener(view -> {
            Intent studentFormIntent = new Intent(StudentDetailsActivity.this, StudentForm.class);
            studentFormIntent.putExtra("enableDelete", true);
            studentFormIntent.putExtra("position", position);
            startActivity(studentFormIntent);
            finish();
        });
    }
}