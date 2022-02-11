/*Author: Dillon Crowshoe-Patterson
Course: CMPP-264-A
Instructor:Harvey Peters
Due Date: Oct 4 2021*/

package com.example.javaday12agentshandin;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final String NAME = "TravelExpertsSqlLite.db";
    private static final int VERSION = 1;

    public DBHelper(@Nullable Context context) {
        super(context, NAME, null, VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE  Agents (" +
                "AgentId INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                " AgtFirstName VARCHAR(20)," +
                " AgtMiddleInitial VARCHAR(5)," +
                " AgtLastName VARCHAR(20)," +
                " AgtBusPhone VARCHAR(20)," +
                " AgtEmail VARCHAR(50)," +
                " AgtPosition VARCHAR(20)," +
                " AgencyId INT" +
                ")";

        sqLiteDatabase.execSQL(sql);
        sql = "insert into Agents values (null, 'Janet', '', 'Delton', '403-210-7801', 'janet.delton@travelexperts.com', 'Senior Agent', 1)";
        sqLiteDatabase.execSQL(sql);
        sql = "insert into Agents values (null, 'Judy', '', 'Lisle', '403-210-7802', 'judy.lisle@travelexperts.com', 'Intermediate Agent', 1)";
        sqLiteDatabase.execSQL(sql);
        sql = "insert into Agents values (null, 'Dennis', 'C', 'Reynolds', '403-210-7843', 'dennis.reynolds@travelexperts.com', 'Junior Agent', 1)";
        sqLiteDatabase.execSQL(sql);
        sql = "insert into Agents values (null, 'John', '', 'Coville', '403-210-7823', 'johh.coville@travelexperts.com', 'Intermediate Agent', 1)";
        sqLiteDatabase.execSQL(sql);
        sql = "insert into Agents values (null, 'Janice', 'W', 'Dahl', '403-210-7865', 'janice.dahl@travelexperts.com', 'Senior Agent', 1)";
        sqLiteDatabase.execSQL(sql);
        sql = "insert into Agents values (null, 'Bruce', 'J', 'Dixon', '403-210-7867', 'bruce.dixon@travelexperts.com', 'Intermediate Agent', 2)";
        sqLiteDatabase.execSQL(sql);
        sql = "insert into Agents values (null, 'Beverly', 'S', 'Jones', '403-210-7812', 'beverly.jones@travelexperts.com', 'Intermediate Agent', 2)";
        sqLiteDatabase.execSQL(sql);
        sql = "insert into Agents values (null, 'Jane', '', 'Merrill', '403-210-7868', 'jane.merrill@travelexperts.com', 'Senior Agent', 2)";
        sqLiteDatabase.execSQL(sql);
        sql = "insert into Agents values (null, 'Brian', 'S', 'Peterson', '403-210-7833', 'brian.peterson@travelexperts.com', 'Junior Agent', 2)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table Agents");
        onCreate(sqLiteDatabase);
    }
}
