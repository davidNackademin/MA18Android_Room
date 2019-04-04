package com.example.ma18room;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Item.class}, version = 2)
public abstract class ItemsDatabase extends RoomDatabase {
    public abstract ItemDao itemDao();
}
