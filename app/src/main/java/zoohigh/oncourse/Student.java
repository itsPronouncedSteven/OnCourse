package zoohigh.oncourse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by Shan Fernando on 4/9/2015.
 */

public class Student implements Serializable{

    public ArrayList<Course> studentCourseList;
    String name;
    Major major;


    Student(){

        name = "name";
        studentCourseList = new ArrayList<Course>();
    }

    Student(String Name, Major majors){

        name = Name;
        major = majors;
        studentCourseList = new ArrayList<Course>();
    }

    void addStudentCourse(Course course){

        studentCourseList.add(course);
    }

    String getName(){

        return name;
    }

    Major getMajor(){

        return major;
    }



}
