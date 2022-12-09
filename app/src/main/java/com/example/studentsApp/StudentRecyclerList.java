package com.example.studentsApp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.studentsApp.model.Model;
import com.example.studentsApp.model.Student;

import java.util.List;

public class StudentRecyclerList extends AppCompatActivity {
    Model studentsModel;
    StudentRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_recycler_list);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Student List");

        studentsModel = Model.instance();
        RecyclerView list = findViewById(R.id.studentrecycler_list);
        list.setHasFixedSize(true);

        list.setLayoutManager(new LinearLayoutManager(this));
        adapter = new StudentRecyclerAdapter();
        list.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                Intent studentDetailsIntent = new Intent(StudentRecyclerList.this, StudentDetailsActivity.class);
                studentDetailsIntent.putExtra("position", pos);
                startActivity(studentDetailsIntent);
            }
        });

        Button addStudentButton = (Button)findViewById(R.id.activityStudentRecyclerList_button);

        addStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StudentRecyclerList.this, StudentForm.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    class StudentViewHolder extends RecyclerView.ViewHolder{
        TextView nameTv;
        TextView idTv;
        CheckBox cb;
        public StudentViewHolder(@NonNull View itemView,OnItemClickListener listener) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.studentlistrow_name_tv);
            idTv = itemView.findViewById(R.id.studentlistrow_id_tv);
            cb = itemView.findViewById(R.id.studentlistrow_cb);
            cb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = (int)cb.getTag();
                    Student st = Model.instance().getStudent(position);
                    st.cb = cb.isChecked();
                    Model.instance().editStudentDetails(position, st);
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    listener.onItemClick(pos);
                }
            });
        }

        public void bind(Student st, int pos) {
            nameTv.setText(st.name);
            idTv.setText(st.id);
            cb.setChecked(st.cb);
            cb.setTag(pos);
        }
    }

    public interface OnItemClickListener{
        void onItemClick(int pos);
    }

    class StudentRecyclerAdapter extends RecyclerView.Adapter<StudentViewHolder>{
        OnItemClickListener listener;

        void setOnItemClickListener(OnItemClickListener listener){
            this.listener = listener;
        }

        @NonNull
        @Override
        public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.student_list_row,parent,false);
            return new StudentViewHolder(view,listener);
        }

        @Override
        public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
            Student st = studentsModel.getStudent(position);
            holder.bind(st,position);
        }

        @Override
        public int getItemCount() {
            return studentsModel.size();
        }
        }
    }
