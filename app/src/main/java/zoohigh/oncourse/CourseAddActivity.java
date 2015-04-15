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
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class CourseAddActivity extends ActionBarActivity {

    List<Course> courseList = new ArrayList<Course>();

    Course intro = new Course("CSE 20","Intro to Programming","4","11111");


    ListView myList;
    Model[] myItems;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_courseadd);

        myList = (ListView) findViewById(R.id.ClassList);
        myItems = new Model[1];
        myItems[0] = new Model("CSE20",1,intro);
     /*   myItems[1] = new Model("CSE21", 1);
        myItems[2] = new Model("CSE30", 1);
        myItems[3] = new Model("CSE31", 0);
        myItems[4] = new Model("CSE100", 1);
        myItems[5] = new Model("CSE120", 1);
        myItems[6] = new Model("CSE135", 1);
        myItems[7] = new Model("CSE160", 1);
        myItems[8] = new Model("CSE175", 1);
        myItems[9] = new Model("CSE180", 1);
*/
        CustomAdapter adapter = new CustomAdapter(this, myItems);
        myList.setAdapter(adapter);

/*
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Model model = (Model) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),"clicked On Row" + model.getName(),Toast.LENGTH_LONG).show();
                //Toast.makeText(CourseAddActivity.this,"myPos" + position, Toast.LENGTH_LONG).show();
            }
        });
*/



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

    Major CSE = new Major("Computer Science and Engineering");
    Student mark = new Student("Mark",CSE);


    public void InfoOnClick(View view) {
        Intent I = new Intent(this,RecommendationActivity.class);

        //Adding checkmarked courses to student course list

        for(int i = 0;i < myItems.length;i++){

            if(myItems[i].getValue() == 1){

                mark.addStudentCourse(myItems[i].getCourse());
                //mark.addStudentCourse(intro);
            }
        }

        I.putExtra("mark",mark);

        startActivity(I);




    }

}
