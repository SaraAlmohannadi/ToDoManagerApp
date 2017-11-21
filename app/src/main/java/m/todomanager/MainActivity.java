package m.todomanager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static m.todomanager.R.id.parent;

public class MainActivity extends Activity {

    Button b1;
    ListView mylist;
    ArrayList<Task> myTasks = null;
    ListAdapter listAdapter =null;
     Context context = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myTasks = new ArrayList<Task>();

        mylist = (ListView)findViewById(R.id.todosList);




        context = getApplicationContext();

        listAdapter = new ListAdapter(this, R.layout.task_in_list, myTasks);
        mylist.setAdapter(listAdapter);
        View footerView = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.footer, null, false);

        Button addTask = (Button) footerView.findViewById(R.id.New);
        addTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ToDoInfo.class);
                startActivityForResult(intent,1);
            }
        });

        mylist.addFooterView(footerView);





    }



    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){

                String getDate = getIntent().getStringExtra("Date");
                String getTime = getIntent().getStringExtra("Time");
                String getPriority = getIntent().getStringExtra("Priority");
                String getTitle = getIntent().getStringExtra("Title");
                String getStatus = getIntent().getStringExtra("Status");
                 Task t = new Task(getTitle, getStatus, getPriority, getTime, getDate);
                myTasks.add(t);

                listAdapter.notifyDataSetChanged();
            }

        }
    }
}
