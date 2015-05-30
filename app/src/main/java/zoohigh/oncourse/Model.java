package zoohigh.oncourse;

/**
 * Created by Owen on 4/15/2015.
 */
public class Model {
    String name;
    public int value; /* 0 -&gt; checkbox disable, 1 -&gt; checkbox enable */
    Course course;

    Model(String name, int value,Course course){
        this.name = name;
        this.value = value;
        this.course = course;
    }
    public String getName(){
        return this.name;
    }
    public int getValue(){
        return this.value;
    }

    public void setValue(int check){
        this.value = check;
    }


    public Course getCourse(){

        return this.course;
    }

}
