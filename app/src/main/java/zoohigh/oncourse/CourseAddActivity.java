package zoohigh.oncourse;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;


public class CourseAddActivity extends ActionBarActivity {

    ListView myList;
    Model[] myItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

}
