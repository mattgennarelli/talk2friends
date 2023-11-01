package com.example.talk2friends;

import java.util.ArrayList;
import java.util.List;

public class MeetingManager {
    private List<Meeting> meetings;

    public MeetingManager() {
        this.meetings = new ArrayList<>();
    }

    public void createMeeting(String meetingLink, String topic, String time, String location) {
        Meeting newMeeting = new Meeting(meetingLink, topic, time, location);
        meetings.add(newMeeting);
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }

    public static class Meeting {
        private String meetingLink;
        private String topic;
        private String time;
        private String location;

        public Meeting(String meetingLink, String topic, String time, String location) {
            this.meetingLink = meetingLink;
            this.topic = topic;
            this.time = time;
            this.location = location;
        }

        public String getMeetingLink() {
            return meetingLink;
        }

        public String getTopic() {
            return topic;
        }

        public String getTime() {
            return time;
        }

        public String getLocation() {
            return location;
        }
    }
}
