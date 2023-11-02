package com.example.talk2friends;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MeetingDetailsActivity extends AppCompatActivity {
    private MeetingManager.Meeting meeting;
    private TextView registeredUsersTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_details);

        TextView topicTextView = findViewById(R.id.topicTextView);
        TextView timeTextView = findViewById(R.id.timeTextView);
        TextView locationTextView = findViewById(R.id.locationTextView);
        TextView linkTextView = findViewById(R.id.linkTextView);

        // Retrieve the selected meeting from the intent
        meeting = (MeetingManager.Meeting) getIntent().getSerializableExtra("meeting");
        registeredUsersTextView = findViewById(R.id.registeredUsersTextView);


        // Set the meeting details to the corresponding TextViews
        if (meeting != null) {
            topicTextView.setText(meeting.getTopic());
            timeTextView.setText(meeting.getTime());
            locationTextView.setText(meeting.getLocation());
            linkTextView.setText(meeting.getMeetingLink());
            displayRegisteredUsers();

        }

    }
    public void registerForMeeting(View view) {
        if (meeting != null) {
            String userName = "UserXYZ"; // Replace with the actual user name
            meeting.registerUser(userName);
            Toast.makeText(this, "You have successfully registered for the meeting!", Toast.LENGTH_SHORT).show();
            displayRegisteredUsers();
        }
    }
    private void displayRegisteredUsers() {
        List<String> registeredUsers = meeting.getRegisteredUsers();
        if (!registeredUsers.isEmpty()) {
            StringBuilder usersBuilder = new StringBuilder();
            for (String user : registeredUsers) {
                usersBuilder.append(user).append("\n");
            }
            registeredUsersTextView.setText(usersBuilder.toString());
        } else {
            registeredUsersTextView.setText("No users registered for this meeting yet.");
        }
    }
}
