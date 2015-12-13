package com.example.watcher5_1_1.watcher5_1_1;

import android.os.Bundle;
import android.app.Activity;
import android.os.Parcelable;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.InputStream;
import java.util.List;


public class station extends Activity {

    private ListView listView;
    private ItemArrayAdapter itemArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout);

        listView = (ListView) findViewById(R.id.listViewStation);
        itemArrayAdapter = new ItemArrayAdapter(getApplicationContext(),R.layout.single_list_item);

        Parcelable state = listView.onSaveInstanceState();
        listView.setAdapter(itemArrayAdapter);
        listView.onRestoreInstanceState(state);

        InputStream inputStream = getResources().openRawResource(R.raw.wl);
        CSVReader csv = new CSVReader(inputStream);
        List<String[]> scoreList = csv.read();

  //      for (String[] scoreData : scoreList) {
  //          ItemArrayAdapter.add(scoreData);
 //       }
    }
}

