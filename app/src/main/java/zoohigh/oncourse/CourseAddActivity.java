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

<<<<<<< HEAD
    List<Course> courseList = new ArrayList<Course>();

    Course algo = new Course("CSE 100","Algorithms","4","11111");

=======
    ListView myList;
    Model[] myItems;
>>>>>>> 5d1e8fa120d5efa3446197770a37aa96c1d3107f


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
        setContentView(R.layout.activity_addcourse);

        ListView classList = (ListView)findViewById(R.id.ClassList);


        classList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(CourseAddActivity.this,"myPos" + position, Toast.LENGTH_LONG).show();
            }
        });

=======
        setContentView(R.layout.activity_courseadd);

        myList = (ListView) findViewById(R.id.ClassList);
        myItems = new Model[10];
        myItems[0] = new Model("CSE20", 0);
        myItems[1] = new Model("CSE21", 1);
        myItems[2] = new Model("CSE30", 1);
        myItems[3] = new Model("CSE31", 0);
        myItems[4] = new Model("CSE100", 1);
        myItems[5] = new Model("CSE120", 1);
        myItems[6] = new Model("CSE135", 1);
        myItems[7] = new Model("CSE160", 1);
        myItems[8] = new Model("CSE175", 1);
        myItems[9] = new Model("CSE180", 1);

        CustomAdapter adapter = new CustomAdapter(this, myItems);
        myList.setAdapter(adapter);

        /*
        String [] Classes = { // list of all available classes
                "CSE20",
                "CSE21",
                "CSE30",
                "CSE31",
                "CSE100",
                "more",
                "things",
                "to",
                "populate",
                "and",
                "fill",
                "this",
                "list"
        };

        ArrayAdapter<String> adapter_list = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,Classes);
        ListView myList = (ListView)findViewById(R.id.ClassList);
        myList.setAdapter(adapter_list);
        */
>>>>>>> 5d1e8fa120d5efa3446197770a37aa96c1d3107f

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
