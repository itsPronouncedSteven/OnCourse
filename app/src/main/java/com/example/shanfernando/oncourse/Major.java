package com.example.shanfernando.oncourse;

import java.util.Vector;

/**
 * Created by Shan Fernando on 4/9/2015.
 */
public class Major {

    Vector<Course> courseList;
    String name;

    Major(){

        name = "name";
        courseList = new Vector<Course>();
    }

    Major(String Name){

        name = Name;
        courseList = new Vector<Course>();
    }
}
