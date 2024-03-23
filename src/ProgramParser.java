public class ProgramParser {
    public static Program parseProgramString(String programString) {
        String[] parts = programString.split(" ");
        String channel = parts[1].replace(":", "");
        String name = parts[3];
        String[] timeParts = parts[5].split(":");
        int hour = Integer.parseInt(timeParts[0]);
        int minute = Integer.parseInt(timeParts[1]);
        BroadcastsTime time = null;
        time = new BroadcastsTime((byte) hour, (byte) minute);
        return new Program(channel, name, time);
    }
}