public class Event {
    
    private long fromProcessId;
    private long toProcessId;
    private String message;
    private int timeStamp;

    public long getFromProcessId() {
        return fromProcessId;
    }

    public void setFromProcessId(long fromProcessId) {
        this.fromProcessId = fromProcessId;
    }

    public long getToProcessId() {
        return toProcessId;
    }

    public void setToProcessId(long toProcessId) {
        this.toProcessId = toProcessId;
    }

    public int getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(int timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Event(long fromProcessId, long toProcessId, int timeStamp) {
        this.fromProcessId = fromProcessId;
        this.toProcessId = toProcessId;
        this.timeStamp = timeStamp;
    }

    public void PrintEvent(Event event) {
        event.message = fromProcessId == toProcessId ? "Internal task of " + fromProcessId : "Message sent from " + fromProcessId + " to " + toProcessId;
        System.out.println("Event: " + event.message + ", Time Stamp: " + event.timeStamp);
    }
}
