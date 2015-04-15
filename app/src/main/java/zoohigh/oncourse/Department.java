package zoohigh.oncourse;

import java.io.Serializable;
import java.util.Vector;

public class Department implements Serializable{

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
