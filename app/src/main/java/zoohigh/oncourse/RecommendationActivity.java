package zoohigh.oncourse;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;


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

    ArrayList<Course> recommendedCourses = new ArrayList<>();
    ArrayList<Course> unique = new ArrayList<>();
    ListView courseListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendation);


        TextView test = (TextView)  findViewById(R.id.textView);
        courseListView      = (ListView) findViewById(R.id.listView_recommend);

        Intent I = getIntent();
        Student mark = (Student)I.getSerializableExtra("mark");

        //hardcoded course information
        Course cse20 = new Course("CSE 20","Intro to Programming","4","11111");
        Course cse21 = new Course("CSE 21","Intro to Programming","4","11111");
        Course cse30 = new Course("CSE 30","Data Structures","4","11111");
        cse30.setPrereqs(cse21);
        Course cse31 = new Course("CSE 31","Intro II","4","11111");
        cse31.setPrereqs(cse30);
        Course cse100 = new Course("CSE 100","Algorithm Design and Analysis","4","11111");
        cse100.setPrereqs(cse31);
        Course cse160 = new Course("CSE 160","Networks","4","11111");
        cse160.setPrereqs(cse31);
        Course cse120 = new Course("CSE 120","Software Engineering","4","11111");
        cse120.setPrereqs(cse160);
        Course cse135 = new Course("CSE 135","Intro to Theory of Computation","4","11111");
        cse135.setPrereqs(cse160);
        Course cse175 = new Course("CSE 175","Intro to AI","4","11111");
        cse175.setPrereqs(cse20);
        cse175.setPrereqs(cse21);
        Course cse180 = new Course("CSE 180","Intro to Robotics","4","11111");
        cse180.setPrereqs(cse31);

        ArrayList<Course> catalog = new ArrayList<>();
        catalog.add(cse20);
        catalog.add(cse21);
        catalog.add(cse30);
        catalog.add(cse31);
        catalog.add(cse100);
        catalog.add(cse160);
        catalog.add(cse120);
        catalog.add(cse135);
        catalog.add(cse175);
        catalog.add(cse180);


        recommendedCourses = catalog;

        for(int i=0;i<recommendedCourses.size();i++){
            for(int j=0;j<mark.studentCourseList.size();j++){
                if(recommendedCourses.get(i).getName().equals(mark.studentCourseList.get(j).getName())){

                        recommendedCourses.remove(catalog.get(i));
                }
            }
        }

        /*
        //recommendedCourses = getRecommended(mark,catalog);
        for(int i=0;i<catalog.size();i++){
            for(int j=0;j<mark.studentCourseList.size();j++){
                if(!catalog.get(i).getName().equals(mark.studentCourseList.get(j).getName())){

                    if(!(recommendedCourses.contains(mark.studentCourseList.get(j))))
                        recommendedCourses.add(catalog.get(i));
                }
            }
        }
        */


        unique = removeDuplicates(recommendedCourses);

        ArrayAdapter<Course> adapter = new CourseListAdapter();
        courseListView.setAdapter(adapter);

        courseListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> arg0, View view,
                                            int position, long id) {
                        // TODO Auto-generated method stub
                        Course course = (Course)courseListView.getItemAtPosition(position);
                        Intent intent = new Intent(RecommendationActivity.this,CourseDetail.class);
                        intent.putExtra("course",course);
                        startActivity(intent);



                    }
                }
        );

        //test.setText(recommendedCourses.get(7).getName());

        //Course course = mark.studentCourseList.get(0);

        //String name = mark.studentCourseList.get(0).getName();
       //test.setText(mark.studentCourseList.get(2).getName());

    }

    ArrayList<Course> removeDuplicates(ArrayList<Course> list) {

        // Store unique items in result.
        ArrayList<Course> result = new ArrayList<>();

        // Record encountered Strings in HashSet.
        HashSet<Course> set = new HashSet<>();

        // Loop over argument list.
        for (Course item : list) {

            // If String is not in set, add it to the list and the set.
            if (!set.contains(item)) {
                result.add(item);
                set.add(item);
            }
        }
        return result;
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

    private class CourseListAdapter extends ArrayAdapter<Course> {

        public CourseListAdapter(){

            super (RecommendationActivity.this,R.layout.coursename,unique);
        }

        @Override
        public View getView(int position, View view,ViewGroup parent){

            if(view == null)
                view = getLayoutInflater().inflate(R.layout.coursename,parent,false);

            Course currentCourse = unique.get(position);

            TextView course_name = (TextView) view.findViewById(R.id.textView1);
            course_name.setText(currentCourse.getName());




            return view;
        }


    }
}
