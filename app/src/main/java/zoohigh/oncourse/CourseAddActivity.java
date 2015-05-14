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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class CourseAddActivity extends ActionBarActivity {

    ListView myList;
    Model[] myItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_courseadd);

        List<Course> courseList = new ArrayList<Course>();

        Course cse20 = new Course("CSE 20","Introduction to Computing I",2,"30427");
        cse20.offered.add(OFFERED.FALL);
        cse20.offered.add(OFFERED.SPRING);
        cse20.offered.add(OFFERED.SUMMER);

        Course cse21 = new Course("CSE 21","Introduction to Computing II",2,"30437");
        cse21.offered.add(OFFERED.FALL);
        cse21.offered.add(OFFERED.SPRING);
        cse21.offered.add(OFFERED.SUMMER);
        cse21.setPrereqs(cse20);

        Course cse30 = new Course("CSE 30","Data Structures",4,"10264");
        cse30.offered.add(OFFERED.FALL);
        cse30.offered.add(OFFERED.SPRING);
        cse30.offered.add(OFFERED.SUMMER);
        cse30.setPrereqs(cse21);

        Course cse31 = new Course("CSE 31","Intro to Comp Sci and Engin I",4,"10266");
        cse31.offered.add(OFFERED.FALL);
        cse31.offered.add(OFFERED.SPRING);
        cse31.offered.add(OFFERED.SUMMER);
        cse31.setPrereqs(cse30);

        Course cse100 = new Course("CSE 100","Algorithm Design and Analysis",4,"10696");
        cse100.offered.add(OFFERED.FALL);
        cse100.offered.add(OFFERED.SPRING);
        cse100.setPrereqs(cse31);

        Course cse160 = new Course("CSE 160","Networks",4,"00000");
        cse160.offered.add(OFFERED.FALL);
        cse160.setPrereqs(cse31);

        Course cse120 = new Course("CSE 120","Software Engineering",4,"14591");
        cse120.offered.add(OFFERED.SPRING);
        cse120.setPrereqs(cse160);

        Course cse135 = new Course("CSE 135","Intro to Theory of Computation",4,"14583");
        cse135.offered.add(OFFERED.SPRING);
        cse135.setPrereqs(cse160);

        Course cse175 = new Course("CSE 175","Intro to AI",4,"00001");
        cse175.offered.add(OFFERED.FALL);
        cse175.setPrereqs(cse20);
        cse175.setPrereqs(cse21);

        Course cse180 = new Course("CSE 180","Introduction to Robotics",4,"11182");
        cse135.offered.add(OFFERED.SPRING);
        cse180.setPrereqs(cse31);

        Major CSE = new Major("Computer Science and Engineering");
        final Student student = new Student("Student",CSE,OFFERED.FALL,12,false);

        CSE.majorCourseList.add(cse20);
        CSE.majorCourseList.add(cse21);
        CSE.majorCourseList.add(cse30);
        CSE.majorCourseList.add(cse31);
        CSE.majorCourseList.add(cse100);
        CSE.majorCourseList.add(cse160);
        CSE.majorCourseList.add(cse120);
        CSE.majorCourseList.add(cse135);
        CSE.majorCourseList.add(cse175);
        CSE.majorCourseList.add(cse180);

        student.addStudentCourse(cse20);
        student.addStudentCourse(cse21);
        student.addStudentCourse(cse30);
        student.addStudentCourse(cse31);



        myList = (ListView)findViewById(R.id.ClassList);
        myItems = new Model[10];
        myItems[0] = new Model("CSE20",1,cse20);
        myItems[1] = new Model("CSE21", 1,cse21);
        myItems[2] = new Model("CSE30", 1,cse30);
        myItems[3] = new Model("CSE31", 1,cse31);
        myItems[4] = new Model("CSE100", 0,cse100);
        myItems[5] = new Model("CSE120", 0,cse120);
        myItems[6] = new Model("CSE135", 0,cse135);
        myItems[7] = new Model("CSE160", 0,cse160);
        myItems[8] = new Model("CSE175", 0,cse175);
        myItems[9] = new Model("CSE180", 0,cse180);

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

        final Button continue_button = (Button)findViewById(R.id.SelectInfo);
        final Intent I = new Intent(this,RecommendationActivity.class);
        continue_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Your classes have been added.", Toast.LENGTH_SHORT).show();

                I.putExtra("student", student);
                startActivity(I);

            }

        });

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


/*
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
    */

}
