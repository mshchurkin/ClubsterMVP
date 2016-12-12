package ms.clubstermvp;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

public class Clubster_Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubster__login);
        setTitle("Вход");
//        Thread welcomeThread = new Thread() {
//
//            @Override
//            public void run() {
//                try {
//                    super.run();
//                    sleep(10000);  //Delay of 10 seconds
//                } catch (Exception e) {
//
//                } finally {
//
//                    Intent i = new Intent(Clubster_Login.this,
//                            loading.class);
//                    startActivity(i);
//                    finish();
//                }
//            }
//        };
//        welcomeThread.start();
    }

    public void login(View view){
        EditText pn = (EditText) findViewById(
                R.id.phone);
        EditText ps = (EditText) findViewById(
                R.id.pswd);
        if((pn.getText().length()>0)&&(ps.getText().length()>0)){
            Intent clubSlctr=new Intent(this,ClubSelector.class);
            startActivity(clubSlctr);
        }
        else
        {
            AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
            dlgAlert.setMessage("Не все поля заполнены");
            dlgAlert.setTitle("Ошибка");
            dlgAlert.setPositiveButton("OK", null);
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();
        }
    }

    public void Registration(View view)
    {
        Intent regScreen =new Intent(this, RegistrationActivity.class);
        startActivity(regScreen);
    }
}
