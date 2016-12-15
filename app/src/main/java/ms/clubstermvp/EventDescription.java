package ms.clubstermvp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class EventDescription extends AppCompatActivity {

    public String CLUB_NAME="club_name";
    public String EVENT_NAME="event_name";
    public String EVENT_DATE="event_date";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_description);
        setTitle("Успех");
        Intent intent=getIntent();
        String clName=intent.getStringExtra(CLUB_NAME);
        String evName=intent.getStringExtra(EVENT_NAME);
        String evDate= intent.getStringExtra(EVENT_DATE);

        TextView evNameText= (TextView) findViewById(R.id.evName);
        TextView evDateText= (TextView) findViewById(R.id.evDate);
        TextView clNameText= (TextView) findViewById(R.id.clName);

        clNameText.setText(clName);
        evNameText.setText(evName);
        evDateText.setText(evDate);
    }

    public void finish(View view){
        Intent intent=new Intent(EventDescription.this,ClubSelector.class);
        startActivity(intent);
    }
}
