package com.example.demo.disruptor;

public class LongEvent{
    public Long eventId;

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    @Override
    public String toString() {
        return "LongEvent{" + "value : " + eventId + "}";
    }
}
