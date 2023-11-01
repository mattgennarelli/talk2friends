package com.example.talk2friends;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MeetingManagerActivity extends AppCompatActivity {

    private ListView meetingsListView;
    private MeetingManager meetingManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_manager);

        meetingsListView = findViewById(R.id.meetingsListView);
        meetingManager = new MeetingManager();

        // Add sample meetings
        meetingManager.createMeeting("https://zoom.us/meeting1", "English Practice", "5:00 PM", "Online");
        meetingManager.createMeeting("https://zoom.us/meeting2", "Language Exchange", "6:00 PM", "On Campus");

        Button backToMainButton = findViewById(R.id.backToMainButton);
        backToMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        displayMeetings();
    }

    private void displayMeetings() {
        List<MeetingManager.Meeting> meetings = meetingManager.getMeetings();
        StringBuilder meetingsBuilder = new StringBuilder();
        for (MeetingManager.Meeting meeting : meetings) {
            meetingsBuilder.append("Topic: ").append(meeting.getTopic()).append("\n")
                    .append("Time: ").append(meeting.getTime()).append("\n")
                    .append("Location: ").append(meeting.getLocation()).append("\n")
                    .append("Meeting Link: ").append(meeting.getMeetingLink()).append("\n\n");
        }
        TextView meetingsTextView = findViewById(R.id.meetingsTextView);
        meetingsTextView.setText(meetingsBuilder.toString());
        Linkify.addLinks(meetingsTextView, Linkify.WEB_URLS);
    }
}
