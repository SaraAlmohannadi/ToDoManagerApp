package m.todomanager;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sara on 11/10/17.
 */

class ListAdapter extends ArrayAdapter<Task> {
    private List<Task> tasks=new ArrayList();
    private LayoutInflater inflater;


    public ListAdapter( Context context,  int resource,  List<Task> tasks) {
        super(context, resource, tasks);
        this.tasks=tasks;
        inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public View getView(final int p, View v, ViewGroup vg){
        if(v==null){
            v=inflater.inflate(R.layout.task_in_list, vg, false);


        }





        TextView theTitle = (TextView)v.findViewById(R.id.tTitle);
        TextView theTime = (TextView)v.findViewById(R.id.tTime);
        TextView theDate = (TextView)v.findViewById(R.id.tDate);
        TextView thePriority = (TextView)v.findViewById(R.id.tPriority);
        CheckBox checkb = (CheckBox) v.findViewById(R.id.checkBox1) ;
        theTitle.setText(tasks.get(p).getTitle());
        theTime.setText("Time:"+String.valueOf(tasks.get(p).getTheTime()));
        theDate.setText("Date:"+tasks.get(p).getTheDate());
        thePriority.setText("Priority:"+tasks.get(p).getPriority());





        final View temp = v;

        checkb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked == true){

                    temp.setBackgroundColor(Color.parseColor("#7F7F7F"));
                }
                else{

                    temp.setBackgroundColor(Color.parseColor("#FFFFFF"));
                }
            }
        });




        String s = tasks.get(p).getStatus();
        if ("Done".equals(s)) {
            v.setBackgroundColor(Color.parseColor("#7F7F7F"));
            checkb.setChecked(true);
        } else{
            checkb.setChecked(false);
            v.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }



        return v;

    }
}