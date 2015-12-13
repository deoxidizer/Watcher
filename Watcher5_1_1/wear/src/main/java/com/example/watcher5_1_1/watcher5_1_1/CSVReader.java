package com.example.watcher5_1_1.watcher5_1_1;

import android.app.ExpandableListActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by Deo on 13.12.2015.
 */
public class CSVReader {
    InputStream inputStream;

    public CSVReader(InputStream is){
        this.inputStream = is;
    }

    public List<String[]> read() {
        List<String[]> resultList = new ArrayList<String[]>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            String csvLine;
            while ((csvLine = reader.readLine()) !=null){
                String[] row = csvLine.split(";");
                resultList.add(row);
            }
        } catch (IOException ex){
            throw new RuntimeException("Error in reading CSV file:" + ex);
        } finally {
            try{
                inputStream.close();
            } catch (IOException e) {
                throw new RuntimeException("Error in reading CSV file:" + e);
            }
        }
        return resultList;
    }
}
