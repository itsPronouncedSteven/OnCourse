package zoohigh.oncourse;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class for each course added
 *
 */
 enum OFFERED {FALL,SPRING,SUMMER}
 

public class Course implements Serializable{

    private String name,title,crn,description;
    int credit_hours;
    ArrayList<OFFERED> offered;
    ArrayList<Course> prereqs;

    public Course(){
        name = "Course Name";
        title = "title";
        credit_hours = 0;
        crn = "00000";
        prereqs = new ArrayList<>();
        offered = new ArrayList<>();
    }

    public Course(String Name, String Title, int Credit_hours,String CRN){

        name = Name;
        title = Title;
        credit_hours = Credit_hours;
        crn = CRN;
        
        prereqs = new ArrayList<>();
        offered = new ArrayList<>();

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

    public int getCredit_hours(){

        return credit_hours;
    }

    public void setCredit_hours(int credit_hours){
        this.credit_hours = credit_hours;
    }

    public String getCrn(){
        return crn;
    }

    public void setCrn(String crn){
        this.crn = crn;
    }

    void setPrereqs(Course course){
        prereqs.add(course);
    }

}
