package com.example.shanfernando.oncourse;

import com.example.shanfernando.oncourse.Major;

import java.util.Vector;

/**
 * Created by Shan Fernando on 4/9/2015.
 */

public class Student {

    Vector<Course> studentCourses;
    String name;
    Major major;


    Student(){

        name = "name";
        studentCourses = new Vector<Course>();
    }

    Student(String Name, Major majors){

        name = Name;
        major = majors;
    }


}
