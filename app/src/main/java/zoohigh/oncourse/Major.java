package zoohigh.oncourse;

import java.io.Serializable;
import java.util.ArrayList;

public class Major implements Serializable{

    ArrayList<Course> majorCourseList;
    String name;

    Major(){

        name = "name";
        majorCourseList = new ArrayList<Course>();
    }

    Major(String Name){

        name = Name;
        majorCourseList = new ArrayList<Course>();
    }

}
