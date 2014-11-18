package com.example.zkropotkine.secondapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.zkropotkine.secondapp.list.ListItem;

import java.util.ArrayList;


public class MainActivity extends Activity {
    public final static String SHARED_LIST_KEY = "com.example.zkropotkine.secondapp.SHARED_LIST_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showAddActivity(View view)
    {
        Intent intent = new Intent(this, AddCompany.class);
        //EditText editText = (EditText) findViewById(R.id.edit_message);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void showCompanies(View view)
    {
        Intent intent = new Intent(this, SeeCompanies.class);
        //EditText editText = (EditText) findViewById(R.id.edit_message);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);

        ArrayList<ListItem> mArraylist = new ArrayList<ListItem>();
        ListItem listItem = new ListItem();
        listItem.setImageUser(getResources().getDrawable(R.drawable.ic_launcher));
        listItem.setHeader("Daniel");
        listItem.setSubHeader("Rodriguez");

        ListItem listItem2 = new ListItem();
        listItem2.setImageUser(getResources().getDrawable(R.drawable.ic_launcher));
        listItem2.setHeader("Laura");
        listItem2.setSubHeader("Elisa");
        mArraylist.add(listItem);
        mArraylist.add(listItem2);


        intent.putParcelableArrayListExtra(SHARED_LIST_KEY, mArraylist);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
