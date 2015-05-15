package zoohigh.oncourse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by Shan Fernando on 4/9/2015.
 */

public class Student implements Serializable{

    ArrayList<Course> studentCourseList;

    String name;
    Major major;
    OFFERED starting_semester;
    int unit_cap;
    boolean taking_summer;



    Student(){

        name = "name";
        starting_semester = OFFERED.FALL;
        unit_cap = 12;
        taking_summer = false;
        studentCourseList = new ArrayList<Course>();
    }

    Student(String Name, Major majors,OFFERED Starting_semester,int Unit_cap,boolean Taking_summer){

        name = Name;
        major = majors;
        starting_semester = Starting_semester;
        unit_cap = Unit_cap;
        taking_summer = Taking_summer;
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

    void printStudentCourseList(){
        System.out.println("STUDENT COURSES");
        for(int i = 0;i < studentCourseList.size();i++){

            System.out.println(studentCourseList.get(i).getName());
        }
    }
}