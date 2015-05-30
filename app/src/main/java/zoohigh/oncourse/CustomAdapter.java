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
public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        convertView = inflater.inflate(R.layout.row, parent, false);

        TextView name = (TextView) convertView.findViewById(R.id.textView1);
        final CheckBox cb = (CheckBox) convertView.findViewById(R.id.checkBox1);
        name.setText(modelItems[position].getName());

    cb.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //Toast.makeText(getApplicationContext(), "Your classes have been added.", Toast.LENGTH_SHORT).show();

            if(modelItems[position].getValue() == 1){
                modelItems[position].setValue(0);
                System.out.println("Value was 1, value now set to: " + modelItems[position].getValue());
            }
            else{
                modelItems[position].setValue(1);
                System.out.println("Value is 0, value now set to: " + modelItems[position].getValue());
            }
            //System.out.println("Clicked " + modelItems[position].getName() + " has value " + modelItems[position].getValue());
        }

    });



        if(modelItems[position].getValue() == 1)
        cb.setChecked(true);
        else
        cb.setChecked(false);



        return convertView;
        }
}