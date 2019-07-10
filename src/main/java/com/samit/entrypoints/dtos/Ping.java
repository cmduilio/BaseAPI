package com.samit.entrypoints.dtos;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Ping {

    @SerializedName("event_id")
    private Long eventId;
    @SerializedName("message")
    private String message;

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
