package com.example.ma18room;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ItemsDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseClient dbClinet = DatabaseClient.getInstance(getApplicationContext());
        db = dbClinet.getItemsDatabase();

//        saveItem("ost");
//        saveItem("sallad");
//        saveItem("lök");


        getItems();
    }


    private void saveItem(final String name) {

        class SaveTask extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void...voids) {

                Item item = new Item();
                item.setName(name);
                item.setDone(false);

                db.itemDao().insert(item);

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_SHORT).show();
            }
        }

        SaveTask st = new SaveTask();
        st.execute();
    }

    private void getItems() {
        class GetItemstask extends AsyncTask<Void, Void, List<Item>> {

            @Override
            protected List<Item> doInBackground(Void... voids) {
                List<Item> taskList = db.itemDao().getAll();


                return taskList;
            }

            @Override
            protected void onPostExecute(List<Item> items) {
                super.onPostExecute(items);

                for (Item item : items) {
                    Log.d("!!!", item.getName());
                }
            }
        }

        GetItemstask gt = new GetItemstask();
        gt.execute();

    }




}
