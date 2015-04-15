package com.example.shanfernando.oncourse;

import java.util.Vector;

/**
 * Created by Shan Fernando on 4/9/2015.
 */
public class Course {


    private String name,title,credit_hours,crn,description;
    Vector<Course> prereqs;

    public Course(){
        name = "name";
        title = "title";
        credit_hours = "0";
        crn = "00000";
        prereqs = new Vector<Course>();
    }

    public Course(String Name, String Title, String Credit_hours,String CRN){

        name = Name;
        title = Title;
        credit_hours = Credit_hours;
        crn = CRN;

        prereqs = new Vector<Course>();

    }

    public String getName(){

        return name;
    }

    public String getTitle(){

        return title;
    }

    public String getCredit_hours(){

        return credit_hours;
    }

    public String getCrn(){

        return crn;
    }

}
