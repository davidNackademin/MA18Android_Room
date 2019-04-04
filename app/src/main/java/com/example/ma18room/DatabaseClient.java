package com.example.ma18room;

import android.arch.persistence.room.Room;
import android.content.Context;

public class DatabaseClient {
    private Context context;

    private static DatabaseClient instance;

    private ItemsDatabase itemsDatabase;


    private DatabaseClient(Context context) {
        this.context = context;

        itemsDatabase = Room.databaseBuilder(context, ItemsDatabase.class, "MyItems" )
                .fallbackToDestructiveMigration()
                .build();
    }

    public static synchronized DatabaseClient getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseClient(context);
        }

        return instance;
    }

    public ItemsDatabase getItemsDatabase() {
        return itemsDatabase;
    }


}
