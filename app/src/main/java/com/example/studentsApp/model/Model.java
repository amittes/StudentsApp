package com.example.studentsApp.model;

import java.util.LinkedList;
import java.util.List;

public class Model {
    private static final Model _instance = new Model();

    public static Model instance(){
        return _instance;
    }
    private Model(){
        for(int i=0;i<5;i++){
            addStudent(new Student("name " + i,""+i,"",false,
                    "0525381628", "Israel"));
        }
    }

    List<Student> data = new LinkedList<>();

    public void addStudent(Student st){
        data.add(st);
    }

    public void deleteStudent(int position) { data.remove(position); }

    public void editStudentDetails(int position, Student student) { data.set(position, student); }

    public Student getStudent(int position) { return  data.get(position); }

    public int size() { return data.size(); }
}
