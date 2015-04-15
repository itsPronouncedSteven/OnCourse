package zoohigh.oncourse;

import java.util.Vector;

public class Major {

    Vector<Course> majorCourseList;
    String name;

    Major(){

        name = "name";
        majorCourseList = new Vector<Course>();
    }

    Major(String Name){

        name = Name;
        majorCourseList = new Vector<Course>();
    }

}
