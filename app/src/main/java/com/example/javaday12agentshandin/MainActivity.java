/*Author: Dillon Crowshoe-Patterson
Course: CMPP-264-A
Instructor:Harvey Peters
Due Date: Oct 4 2021*/

package com.example.javaday12agentshandin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {
    DataSource dataSource;
    ListView lvAgents;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataSource = new DataSource(this);
        lvAgents = findViewById(R.id.lvAgents);
        btnAdd = findViewById(R.id.btnAdd);

        lvAgents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), AgentDBActivity.class);
                intent.putExtra("agent", (Agent)lvAgents.getAdapter().getItem(i));
                intent.putExtra("mode", "update");
                startActivity(intent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AgentDBActivity.class);
                intent.putExtra("mode", "insert");
                startActivity(intent);
            }
        });
        loadData();
    }

    private void loadData() {
        ArrayAdapter<Agent> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataSource.getAllAgents());
        lvAgents.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
    }
}