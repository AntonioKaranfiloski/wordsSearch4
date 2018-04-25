package com.anton.example.pmpdomasna;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
FirebaseDatabase database;
DatabaseReference myRef;
Button btnAdd;
TextView txtView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = FirebaseDatabase.getInstance();

        myRef = FirebaseDatabase.getInstance().getReference();

        btnAdd = (Button) findViewById(R.id.btn_add);

        txtView = (TextView) findViewById(R.id.textView);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editFirst = (EditText) findViewById(R.id.edt_word);
                EditText editSecond = (EditText) findViewById(R.id.edt_description);

                myRef = database.getReference("Word");
                String child = editFirst.getText().toString();
                myRef = database.getReference("Word").child(child);

                myRef.child("description").setValue(editSecond.getText().toString());

                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Map<String, String> map = (Map<String, String>) dataSnapshot.getValue();
                        String description = map.get("description");
                        Log.v("description", description);

                        TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText(description);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        }
                });

            }
        });
    }}
