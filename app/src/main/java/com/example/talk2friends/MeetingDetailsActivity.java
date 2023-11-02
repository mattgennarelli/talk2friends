package com.example.talk2friends;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MeetingDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_details);

        TextView topicTextView = findViewById(R.id.topicTextView);
        TextView timeTextView = findViewById(R.id.timeTextView);
        TextView locationTextView = findViewById(R.id.locationTextView);
        TextView linkTextView = findViewById(R.id.linkTextView);

        // Retrieve the selected meeting from the intent
        MeetingManager.Meeting meeting = (MeetingManager.Meeting) getIntent().getSerializableExtra("meeting");

        // Set the meeting details to the corresponding TextViews
        if (meeting != null) {
            topicTextView.setText(meeting.getTopic());
            timeTextView.setText(meeting.getTime());
            locationTextView.setText(meeting.getLocation());
            linkTextView.setText(meeting.getMeetingLink());
        }
    }
}
