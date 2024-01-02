package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository srobj;
    public void addStudent(Student s){
        srobj.addStudent(s);
    }

    public void addTeacher(Teacher t){
        srobj.addTeacher(t);
    }

    public void pairstudentteacher(String sname,String tname){
        srobj.pairstudentteacher(sname,tname);
    }
    public Student getStudentByName(String sname){
        return srobj.getStudentByName(sname);
    }

    public Teacher getTeacherByName(String tname){
        return srobj.getTeacherByName(tname);
    }

    public List<String> getStudentNameList (String tname){
        return srobj.getStudentNameList(tname);
    }

    public List<String> getallStudents(){
        return srobj.getallStudents();
    }

    public void deleteTeacherAndAllItsStudent(String tname){
       srobj.deleteTeacherAndAllItsStudent(tname);
    }

    void deleteAllTeacher(){
     srobj.deleteAllTeacher();
    }

}
