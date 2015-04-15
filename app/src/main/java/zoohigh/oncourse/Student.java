package zoohigh.oncourse;

import java.util.Vector;

/**
 * Created by Shan Fernando on 4/9/2015.
 */

public class Student {

    Vector<Course> studentCourseList;
    String name;
    Major major;


    Student(){

        name = "name";
        studentCourseList = new Vector<Course>();
    }

    Student(String Name, Major majors){

        name = Name;
        major = majors;
    }

}
