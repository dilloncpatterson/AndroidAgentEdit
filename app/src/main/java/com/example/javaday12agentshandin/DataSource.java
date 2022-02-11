/*Author: Dillon Crowshoe-Patterson
Course: CMPP-264-A
Instructor:Harvey Peters
Due Date: Oct 4 2021*/

package com.example.javaday12agentshandin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.Serializable;
import java.util.ArrayList;

public class DataSource {
    private Context context;
    private SQLiteDatabase db;
    private DBHelper helper;

    public DataSource(Context context) {
        this.context = context;
        helper = new DBHelper(context);
        db = helper.getWritableDatabase();
    }
    public Agent getAgent(int agentId)
    {
        String sql = "select * from Agents where AgentId=?";
        String [] args = { agentId + "" };
        Cursor cursor = db.rawQuery(sql, args);
        cursor.moveToNext();
        return new Agent(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4),
                cursor.getString(5), cursor.getString(6), cursor.getInt(7));
    }

    //write getAgent, getAllAgents, insertAgent, updateAgent and deleteAgent
    public ArrayList<Agent> getAllAgents() {
        ArrayList<Agent> list = new ArrayList<>();
        String [] columns = { "AgentId", "AgtFirstName", "AgtMiddleInitial", "AgtLastName", "AgtBusPhone", "AgtEmail", "AgtPosition", "AgencyId" };
        Cursor cursor = db.query("Agents", columns, null, null, null, null, null);
        while (cursor.moveToNext())
        {
            list.add(new Agent(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4),
                    cursor.getString(5), cursor.getString(6), cursor.getInt(7)));
            /*list.add(new Agent(cursor.getInt(0), cursor.getString(1)));*/
        }
        return list;
    }

    public int updateAgent(Agent agent) {
        ContentValues cv = new ContentValues();
        cv.put("AgtFirstName", agent.getAgtFirstName());
        //
        cv.put("AgtMiddleInitial", agent.getAgtMiddleInitial());
        cv.put("AgtLastName", agent.getAgtLastName());
        cv.put("AgtBusPhone", agent.getAgtBusPhone());
        cv.put("AgtEmail", agent.getAgtEmail());
        cv.put("AgtPosition", agent.getAgtPosition());
        cv.put("AgencyId", agent.getAgencyId());
        //
        String [] args = { agent.getAgentId() + ""};
        String where = "AgentId=?";
        return db.update("Agents", cv, where, args);
    }

    public long insertAgent(Agent agent) {
        ContentValues cv = new ContentValues();

        cv.put("AgtFirstName", agent.getAgtFirstName());
        //
        cv.put("AgtMiddleInitial", agent.getAgtMiddleInitial());
        cv.put("AgtLastName", agent.getAgtLastName());
        cv.put("AgtBusPhone", agent.getAgtBusPhone());
        cv.put("AgtEmail", agent.getAgtEmail());
        cv.put("AgtPosition", agent.getAgtPosition());
        cv.put("AgencyId", agent.getAgencyId());
        //

        return db.insert("Agents", null, cv);
    }

    public int deleteAgent(int agentId) {
        String [] args = { agentId + "" };
        String where = "AgentId = ?";
        return db.delete("Agents", where, args);
    }


}
