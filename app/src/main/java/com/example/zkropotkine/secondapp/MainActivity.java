package com.example.zkropotkine.secondapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.zkropotkine.secondapp.list.ListItem;

import java.util.ArrayList;


public class MainActivity extends Activity {
    public final static String SHARED_LIST_KEY = "com.example.zkropotkine.secondapp.SHARED_LIST_KEY";
    private ArrayList<ListItem> mArraylist = new ArrayList<ListItem>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showAddActivity(View view)
    {
        Intent intent = new Intent(this, AddCompany.class);
        intent.putExtra("companies_number", mArraylist.size());

        TextView txtCompanyName = (TextView) findViewById(R.id.company_legend);
        txtCompanyName.setText("");
        startActivityForResult(intent, 1);
    }

    public void showCompanies(View view)
    {
        Intent intent = new Intent(this, SeeCompanies.class);

        ListItem listItem = new ListItem();
        listItem.setImageUser(getResources().getDrawable(R.drawable.ic_launcher));
        listItem.setHeader("Daniel");
        listItem.setSubHeader("Rodriguez");

        ListItem listItem2 = new ListItem();
        listItem2.setImageUser(getResources().getDrawable(R.drawable.ic_launcher));
        listItem2.setHeader("Laura");
        listItem2.setSubHeader("Elisa");

        TextView txtCompanyName = (TextView) findViewById(R.id.company_legend);
        txtCompanyName.setText("");

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        TextView txtCompanyName = (TextView) findViewById(R.id.company_legend);

        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            String userName = data.getStringExtra("company_name");
            String businessLine = data.getStringExtra("business_line");

            ListItem listItem2 = new ListItem();
            listItem2.setImageUser(getResources().getDrawable(R.drawable.ic_launcher));
            listItem2.setHeader(userName);
            listItem2.setSubHeader(businessLine);

            mArraylist.add(listItem2);
            System.out.println(userName);
            System.out.println(businessLine);

            txtCompanyName.setText("The company was added");
        } else {
            txtCompanyName.setText("");
        }
    }
}
