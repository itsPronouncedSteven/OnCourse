package zoohigh.oncourse;

import java.util.Vector;

/**
 * Class for each course added
 *
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

    public void setName(String name){
        this.name = name;
    }

    public String getTitle(){

        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getCredit_hours(){

        return credit_hours;
    }

    public void setCredit_hours(String credit_hours){
        this.credit_hours = credit_hours;
    }

    public String getCrn(){
        return crn;
    }

    public void setCrn(String crn){
        this.crn = crn;
    }

}
