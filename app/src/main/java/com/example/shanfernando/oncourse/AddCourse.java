package com.example.shanfernando.oncourse;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;



public class AddCourse extends ActionBarActivity {

    EditText class_name_txt,class_title_txt,credit_hours_txt, crn_txt;
    List<Course> courseList = new ArrayList<Course>();
    ListView courseListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);

        class_name_txt      = (EditText) findViewById(R.id.txt_class_name);
        class_title_txt     = (EditText) findViewById(R.id.txt_class_title);
        credit_hours_txt    = (EditText) findViewById(R.id.txt_credit_hours);
        crn_txt             = (EditText) findViewById(R.id.txt_crn);
        courseListView      = (ListView) findViewById(R.id.listView);
        TabHost tabHost     = (TabHost)  findViewById(R.id.tabHost);


        tabHost.setup();
        TabHost.TabSpec tabSpec = tabHost.newTabSpec("create");
        tabSpec.setContent(R.id.Create);
        tabSpec.setIndicator("Create");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("view");
        tabSpec.setContent(R.id.View);
        tabSpec.setIndicator("View");
        tabHost.addTab(tabSpec);


        final Button button_add   = (Button)   findViewById(R.id.add_button);
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Toast.makeText(getApplicationContext(),"Your course has been created.",Toast.LENGTH_SHORT).show();
                addCourse(class_name_txt.getText().toString(),class_title_txt.getText().toString(),credit_hours_txt.getText().toString(),crn_txt.getText().toString());
                populateList();
            }

        });

        class_name_txt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                button_add.setEnabled(!class_name_txt.getText().toString().trim().isEmpty());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_course, menu);
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

    private void populateList(){

        ArrayAdapter<Course> adapter = new CourseListAdapter();
        courseListView.setAdapter(adapter);

    }

    private void addCourse(String Name, String Title, String Credit_hours,String CRN){

        courseList.add(new Course(Name,Title,Credit_hours,CRN));

    }

    private class CourseListAdapter extends ArrayAdapter<Course> {

        public CourseListAdapter(){

            super (AddCourse.this,R.layout.listview_item,courseList);
        }

        @Override
        public View getView(int position, View view,ViewGroup parent){

            if(view == null)
                view = getLayoutInflater().inflate(R.layout.listview_item,parent,false);

            Course currentCourse = courseList.get(position);

            TextView course_name = (TextView) view.findViewById(R.id.list_course_name);
            course_name.setText(currentCourse.getName());
            TextView course_title = (TextView) view.findViewById(R.id.list_course_title);
            course_title.setText(currentCourse.getTitle());
            TextView credit_hours = (TextView) view.findViewById(R.id.list_credit_hours);
            credit_hours.setText(currentCourse.getCredit_hours());
            TextView crn = (TextView) view.findViewById(R.id.list_crn);
            crn.setText(currentCourse.getCrn());



                return view;
        }
    }
}
