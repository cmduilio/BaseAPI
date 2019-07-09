package entrypoints.dtos;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Charge {

    @SerializedName("event_id")
    private Long eventId;
    private Double amount;
    @SerializedName("user_id")
    private Long userId;
    @SerializedName("event_type")
    private String eventType;
    private Date date;

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
