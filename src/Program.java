import java.util.List;

public class Program {
    private String channel;
    private BroadcastsTime time;
    private String name;

    public Program(String channel, String name, BroadcastsTime time) {
        this.channel = channel;
        this.name = name;
        this.time = time;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public BroadcastsTime getTime() {
        return time;
    }

    public void setTime(BroadcastsTime time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
