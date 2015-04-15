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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class CourseAddActivity extends ActionBarActivity {

    List<Course> courseList = new ArrayList<Course>();

    Course algo = new Course("CSE 100","Algorithms","4","11111");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcourse);

        ListView classList = (ListView)findViewById(R.id.ClassList);


        classList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(CourseAddActivity.this,"myPos" + position, Toast.LENGTH_LONG).show();
            }
        });


        String [] Majors = { // list of all available classes
                "Computer Science and Engineering",
                "Mechanical Engineering",
                "Bio-Engineering",
                "Material Science and Engineering"
                //add more to list of majors here
        };

        ArrayAdapter<String> adapter_spinner = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,Majors);
        Spinner myDropDown = (Spinner)findViewById(R.id.MajorList);
        myDropDown.setAdapter(adapter_spinner);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
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

    public void InfoOnClick(View view) {
        Intent I = new Intent(this,RecommendationActivity.class);
        startActivity(I);
    }

    private class CourseListAdapter extends ArrayAdapter<Course> {

        public CourseListAdapter(){

            super (CourseAddActivity.this,R.layout.activity_addcourse);
        }

        @Override
        public View getView(int position, View view,ViewGroup parent){

            if(view == null)
                view = getLayoutInflater().inflate(R.layout.activity_addcourse,parent,false);


            Course currentCourse = courseList.get(position);

            return view;
        }
    }

}