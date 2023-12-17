package edu.utsa.cs3443.eventtab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageButton;

import java.util.ArrayList;

import edu.utsa.cs3443.eventtab.controller.EventTabController;
import edu.utsa.cs3443.eventtab.model.Event;

public class EventTabActivity extends AppCompatActivity {

    ArrayList<Event> events = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_tab);

        // Create an instance of the MainController to handle button clicks.
        EventTabController controller = new EventTabController(this);

        // Find and configure the "button1" in the layout.
        ImageButton button1 = findViewById(R.id.imageButton1);
        button1.setOnClickListener(controller);// Assign the MainController as the click listener.

        // Find and configure the "button2" in the layout.
        ImageButton button2 = findViewById(R.id.imageButton2);
        button2.setOnClickListener(controller);// Assign the MainController as the click listener.

        ///THIS IS FOR THE RECYCLER VIEWWW>>>>>>>>>>>
        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);

        events = EventTabController.getEvents();

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, events);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void setEvents(){

    }

}