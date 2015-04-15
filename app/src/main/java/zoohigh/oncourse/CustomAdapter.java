package zoohigh.oncourse;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class CustomAdapter extends ArrayAdapter{
        Model[] modelItems = null;
        Context context;
public CustomAdapter(Context context, Model[] resource) {
        super(context,R.layout.row,resource);
        // TODO Auto-generated constructor stub
        this.context = context;
        this.modelItems = resource;
        }

private class ViewHolder{
    TextView code;
    CheckBox name;
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

       // ViewHolder holder = null;

        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        convertView = inflater.inflate(R.layout.row, parent, false);
/*
        holder = new ViewHolder();
        holder.name = (CheckBox) convertView.findViewById(R.id.checkBox1);
        convertView.setTag(holder);

        holder.name.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){

                CheckBox cb = (CheckBox) v;
                Model model = (Model)cb.getTag();
                Toast.makeText(getApplicationContext(),"clicked on check box" + cb.getText() + "is" cb.isChecked(),Toast.LENGTH_LONG).show();
            }

        });
*/
        TextView name = (TextView) convertView.findViewById(R.id.textView1);
        CheckBox cb = (CheckBox) convertView.findViewById(R.id.checkBox1);
        name.setText(modelItems[position].getName());
        if(modelItems[position].getValue() == 1)
        cb.setChecked(true);
        else
        cb.setChecked(false);



        return convertView;
        }
}