package ms.clubstermvp;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static android.R.id.message;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class ClubSelector extends AppCompatActivity {

    Club[] cA;
    public String CLUB_NAME="club_name";
    public String EVENT_NAMES="event_names";
    public String EVENT_DATES="event_dates";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_selector);
        setTitle("Выбор заведения");

        Event event1=new Event();
        event1.setEventDate(new Date(2016,12,25,17,0));
        event1.setEventName("Вечеринка 1");

        Event event2=new Event();
        event2.setEventDate(new Date(2016,12,25,17,45));
        event2.setEventName("Вечеринка 2");

        Club club1=new Club();
        club1.setName("M5");
        club1.setEventArray(new Event[]{event1,event2});

        Club club2=new Club();
        club2.setName("Q2");
        club2.setEventArray(new Event[]{event1,event2});

        Club club3=new Club();
        club3.setName("Дом культуры");
        club3.setEventArray(new Event[]{event1,event2});

        cA=new Club[]{club1,club2,club3};

        final String[] clubArray=new String[]{club1.getName(), club2.getName(), club3.getName()};

        ListView lv=(ListView) findViewById(R.id.list);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,clubArray);
        lv.setAdapter(arrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                String cN=clubArray[position];
                String []evNames=new String[cA[position].getEventArray().length];
                String[] evDates=new String[cA[position].getEventArray().length];
                for(int i=0;i<cA[position].getEventArray().length;i++) {
                    evNames[i]=cA[position].getEventArray()[i].getEventName();
                    evDates[i]=cA[position].getEventArray()[i].getEventDate().toString();
                }
                Intent eventSelect = new Intent(ClubSelector.this, EventSelector.class);
                eventSelect.putExtra(CLUB_NAME,clubArray[position]);
                eventSelect.putExtra(EVENT_NAMES,evNames);
                eventSelect.putExtra(EVENT_DATES,evDates);
                startActivity(eventSelect);
            }
        });
    }
}
