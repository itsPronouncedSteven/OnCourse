package com.example.shanfernando.oncourse;

import java.util.Vector;

/**
 * Created by Shan Fernando on 4/9/2015.
 */
public class Department {

    Vector<Major> majorList;
    String name;

    Department(){

        name = "name";
        majorList = new Vector<Major>();
    }

    Department(String name){

        name = "name";
        majorList = new Vector<Major>();
    }
}
