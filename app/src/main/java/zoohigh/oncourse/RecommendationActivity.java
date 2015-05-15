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


    ArrayList<Course> unique = new ArrayList<>();
    ListView courseListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendation);

        courseListView = (ListView) findViewById(R.id.listView_recommend);

        Intent I = getIntent();
        Student student = (Student)I.getSerializableExtra("student");

        Schedule schedule = new Schedule();
        schedule.BuildSchedule(student.getMajor().majorCourseList,student);
        //schedule.printSchedule();


        //unique = removeDuplicates(recommendedCourses);
        unique = schedule.recommendedList;

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

        //TextView test = (TextView)  findViewById(R.id.textView);
        //test.setText(recommendedCourses.get(7).getName());
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
