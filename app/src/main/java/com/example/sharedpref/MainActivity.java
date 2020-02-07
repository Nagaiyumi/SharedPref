package com.example.sharedpref;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save(view);
            }
        });

        final Button displayButton = findViewById(R.id.displayButton);
        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display(view);
            }
        });

    }

    public void save(View view) {
        final EditText firstName = findViewById(R.id.firstName); // Access first name EditTet field
        final EditText lastName = findViewById(R.id.lastName); // Access first name EditTet field

        SharedPreferences pref = getSharedPreferences("userdetails", MODE_PRIVATE);
        // Add user first and last name data to shared pref file
        pref.edit().putString("firstname", firstName.getText().toString())
                .putString("lastname", lastName.getText().toString()).apply();
        // Display saved message
        Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_SHORT).show();
    }

    public void display(View view) {
        SharedPreferences pref = getSharedPreferences("userdetails", MODE_PRIVATE);
        String firstName = pref.getString("firstname", "");
        String lastName = pref.getString("lastname", "");

        TextView displayFirst = findViewById(R.id.displayFirst);
        TextView displayLast = findViewById(R.id.displayLast);

        displayFirst.setText(firstName);
        displayLast.setText(lastName);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
