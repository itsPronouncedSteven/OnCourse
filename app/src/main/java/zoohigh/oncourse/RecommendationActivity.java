package zoohigh.oncourse;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;


public class RecommendationActivity extends ActionBarActivity {

/*
   public  ArrayList<Course> getRecommended(Student student, ArrayList<Course> catalog){

        //Recommended results
        ArrayList<Course> recommendedCourses = new ArrayList<>();

        //List of courses student has taken
        ArrayList<Course> takenCourses = student.studentCourseList;

       //check prereqs of each course against student taken courses
        //if student has not taken course and taken all prereqs, add course to recCourses
        for(int i=0;i<catalog.size();i++){
            //for(int j=0;j<takenCourses.size();j++){
            int check = takenCourses.indexOf(catalog.get(i));
            //int checkPre;
            if (check == -1){
                for(int j=0;j<catalog.get(i).prereqs.size();j++){
                    int checkPre = takenCourses.indexOf(catalog.get(i).prereqs.get(j));
                    if(checkPre != -1)
                        recommendedCourses.add(catalog.get(i));
                }
            }
            //}
        } //Loop through all courses


        return recommendedCourses;
    }
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendation);


        TextView test = (TextView)  findViewById(R.id.textView);
        Intent I = getIntent();
        Student mark = (Student)I.getSerializableExtra("mark");

        Course cse21 = new Course("CSE 21","intro","4","11111");
        Course intro = new Course("CSE 20","Intro to Programming","4","11111");
        cse21.setPrereqs(intro);
        ArrayList<Course> catalog = new ArrayList<>();
        catalog.add(intro);
        catalog.add(cse21);

        ArrayList<Course> recommendedCourses = new ArrayList<>();
        //recommendedCourses = getRecommended(mark,catalog);
        for(int i=0;i<catalog.size();i++){
            for(int j=0;j<mark.studentCourseList.size();j++){
                if(!catalog.get(i).getName().equals(mark.studentCourseList.get(j).getName())){
                    recommendedCourses.add(catalog.get(i));
                }
            }
        }

        test.setText(recommendedCourses.get(0).getName());

        //Course course = mark.studentCourseList.get(0);

        //String name = mark.studentCourseList.get(0).getName();
       //test.setText(mark.studentCourseList.get(0).getName());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_recommendation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
