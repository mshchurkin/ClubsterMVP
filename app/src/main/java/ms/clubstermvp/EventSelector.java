package ms.clubstermvp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventSelector extends AppCompatActivity {

    public String cN;
    String []evNames;
    String[] evDates;
    public String CLUB_NAME="club_name";
    public String EVENT_NAMES="event_names";
    public String EVENT_DATES="event_dates";
    public String EVENT_NAME="event_name";
    public String EVENT_DATE="event_date";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_selector);
        Intent intent=getIntent();
        cN=intent.getStringExtra(CLUB_NAME);
        evNames=intent.getStringArrayExtra(EVENT_NAMES);
        evDates= intent.getStringArrayExtra(EVENT_DATES);
        setTitle(cN);

        ListView lv=(ListView) findViewById(R.id.eventlist);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,evNames);
        lv.setAdapter(arrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(EventSelector.this, EventDescription.class);
                intent.putExtra(CLUB_NAME, cN);
                intent.putExtra(EVENT_NAME,evNames[position]);
                intent.putExtra(EVENT_DATE,evDates[position]);
                startActivity(intent);
            }
        });
    }
}
