package com.priyambad.dbcheck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    DBHandler db;
    EditText e;
    TextView t;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e=(EditText)findViewById(R.id.editText);
        t=(TextView)findViewById(R.id.disp);
        t1=(TextView)findViewById(R.id.result);
        db=new DBHandler(this,null,null,1);
        printDatabase();
    }
    public void add(View view){
        String s=e.getText().toString();
        if(s!=null) {
            db.addProduct(s);
            printDatabase();
            t1.setText("");
        }
        else
            e.setText("PLEASE ENTER VALUE FIRST!!!!");
    }
    public void delete(View view){
        String s=e.getText().toString();
        db.deleteProduct(s);
        printDatabase();
        t1.setText("");
        e.setText("");
    }
    public void printDatabase(){
        String s=db.databaseToString();
        t.setText(s);
        t1.setText("");
    }
    public void check(View view){
        String s=e.getText().toString();
        if(s!=null) {
            String s1 = "";
            if (db.exist(s))
                s1 += "VALUE EXIST";
            else
                s1 += "VALUE DOESN'T EXIST";
            t1.setText(s1);
            e.setText("");
        }
        else
            t1.setText("PLEASE ENTER VALUE FIRST!!!");
    }
}
