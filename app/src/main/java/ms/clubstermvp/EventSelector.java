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

    public Club cOBJ;
    public String cN;
    public String CLUB_NAME="club_name";
    public String CLUB_OBJ="club_object";
    public String EVENT_DATE="event_date";
    public String EVENT_NAME="event_name";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_selector);
        Intent intent=getIntent();
        cOBJ=(Club)intent.getSerializableExtra(CLUB_OBJ);
        cN=cOBJ.getName();
        setTitle(cN);

        Event[] eventArray=cOBJ.getEventArray();
        final String[] eventNames=new String[eventArray.length];
        for(int i=0;i<cOBJ.getEventArray().length;i++){
            eventNames[i]=eventArray[i].getEventName();
        }
        final Date[] eventDates=new Date[cOBJ.getEventArray().length];
        for(int i=0;i<cOBJ.getEventArray().length;i++){
            eventDates[i]=cOBJ.getEventArray()[i].getEventDate();
        }
        ListView lv=(ListView) findViewById(R.id.eventlist);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,eventNames);
        lv.setAdapter(arrayAdapter);

//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position,
//                                    long id) {
//                Intent intent = new Intent(EventSelector.this, EventDescription.class);
//                intent.putExtra(CLUB_NAME, cN);
//                intent.putExtra(EVENT_NAME,eventNames[position]);
//                intent.putExtra(EVENT_DATE,eventDates[position]);
//                startActivity(intent);
//            }
//        });
    }
}
