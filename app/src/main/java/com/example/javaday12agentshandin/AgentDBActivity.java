/*Author: Dillon Crowshoe-Patterson
Course: CMPP-264-A
Instructor:Harvey Peters
Due Date: Oct 4 2021*/

package com.example.javaday12agentshandin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

//textView name, editText names, button names, and data source name
public class AgentDBActivity extends AppCompatActivity {
    TextView tvAgentId;
    EditText etAgtFirstName, etAgtMiddleInitial, etAgtLastName, etAgtBusPhone, etAgtEmail, etAgtPosition, etAgencyId;
    Button btnSave, btnDelete;
    DataSource dataSource;

//on create method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent_dbactivity);

        tvAgentId = findViewById(R.id.tvAgentId);
        etAgtFirstName = findViewById(R.id.etAgtFirstName);
        etAgtMiddleInitial = findViewById(R.id.etAgtMiddleInitial);
        etAgtLastName = findViewById(R.id.etAgtLastName);
        etAgtBusPhone = findViewById(R.id.etAgtBusPhone);
        etAgtEmail = findViewById(R.id.etAgtEmail);
        etAgtPosition = findViewById(R.id.etAgtPosition);
        etAgencyId = findViewById(R.id.etAgencyId);
        btnSave = findViewById(R.id.btnSave);
        btnDelete = findViewById(R.id.btnDelete);

        Intent intent = getIntent();
        String mode = intent.getStringExtra("mode");
        dataSource = new DataSource(this);
        if (mode.equals("update"))
        {
            Agent agent = (Agent)intent.getSerializableExtra("agent");
            tvAgentId.setText(agent.getAgentId() + "");
            etAgtFirstName.setText(agent.getAgtFirstName());
            etAgtMiddleInitial.setText(agent.getAgtMiddleInitial());
            etAgtLastName.setText(agent.getAgtLastName());
            etAgtBusPhone.setText(agent.getAgtBusPhone());
            etAgtEmail.setText(agent.getAgtEmail());
            etAgtPosition.setText(agent.getAgtPosition());
            etAgencyId.setText(agent.getAgencyId() + "");
        }

//ocClick event listener for save button
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mode.equals("update"))
                {
                    Agent agent = new Agent(Integer.parseInt(tvAgentId.getText().toString()), etAgtFirstName.getText().toString(),
                            etAgtMiddleInitial.getText().toString(), etAgtLastName.getText().toString(), etAgtBusPhone.getText().toString(),
                            etAgtEmail.getText().toString(), etAgtPosition.getText().toString(), Integer.parseInt(etAgencyId.getText().toString()));
                    dataSource.updateAgent(agent);
                }
                else
                {   Agent agent = new Agent (0, etAgtFirstName.getText().toString(),
                        etAgtMiddleInitial.getText().toString(), etAgtLastName.getText().toString(), etAgtBusPhone.getText().toString(),
                        etAgtEmail.getText().toString(), etAgtPosition.getText().toString(), Integer.parseInt(etAgencyId.getText().toString()));
                    dataSource.insertAgent(agent);
                }
            }
        });

//onClick event listener for delete button
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mode.equals("update"))
                {

                    dataSource.deleteAgent(Integer.parseInt(tvAgentId.getText().toString()));
                }
            }
        });
    }
}