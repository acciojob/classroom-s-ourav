package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class StudentRepository {

   HashMap<String,Student> smap=new HashMap<>();
   HashMap<String,Teacher> tmap=new HashMap<>();
   HashMap<String,List<String>> stmap=new HashMap<>();

   public void addStudent(Student s){
      smap.put(s.getName(),s);
   }

   public void addTeacher(Teacher t){
      tmap.put(t.getName(),t);
   }

   public void pairstudentteacher(String sname,String tname){
      if(smap.containsKey(sname) && tmap.containsKey(tname)){
         List<String>temp=stmap.getOrDefault(tname,new ArrayList<>());
         temp.add(sname);
         stmap.put(tname,temp);
      }
   }
   public Student getStudentByName(String sname){
      if(smap.containsKey(sname)){
         return smap.get(sname);
      }
      else return null;
   }

   public Teacher getTeacherByName(String tname){
      if(tmap.containsKey(tname)){
         return tmap.get(tname);
      }
      else return null;
   }

   public List<String> getStudentNameList (String tname){
      List<String> snames=new ArrayList<>();
      if(tmap.containsKey(tname)){
         snames=new ArrayList<>(stmap.get(tname));
      }
      return snames;
   }

   public List<String> getallStudents(){
      List<String> students=new ArrayList<>();
      for(String snames:smap.keySet()){
         students.add(snames);
      }
      return students;
   }

   public void deleteTeacherAndAllItsStudent(String tname){
      tmap.remove(tname);
      if(stmap.containsKey(tname)){
         for(String snames:stmap.get(tname)){ // stmap.get(tname)=the arraylist mapped to tname in tmap // removing students from students HM by traversing stmap.get(tname)List
            smap.remove(snames);
         }
         stmap.remove(tname);
      }
   }

   void deleteAllTeacher(){

      HashSet<String> students=new HashSet<>();
      for(String t:stmap.keySet()){
         students.addAll(stmap.get(t));
      }

      for(String s:students){
         smap.remove(s);
      }
      tmap.clear();
   }
}
