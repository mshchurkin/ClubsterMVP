package ms.clubstermvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ClubSelector extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_selector);
        setTitle("Выбор заведения");

       // String[] clubArray=new String[]{ "M5","Q2","Дом культуры"};

       // ListView lv=(ListView) findViewById(R.id.list);
        //ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,R.layout.simple_list_item_1,clubArray);
    }
}
