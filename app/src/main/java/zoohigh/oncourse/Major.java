package zoohigh.oncourse;

import java.io.Serializable;
import java.util.Vector;

public class Major implements Serializable{

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
