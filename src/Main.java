import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Создание структуры Map<время, программа> и наполнение данными
        Map<BroadcastsTime, Program> programSchedule = new TreeMap<>();
        Scanner s = null;
        try {
            s = new Scanner(new File("schedule.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        List<String> list = new ArrayList<String>();
        while (s.hasNext()){
            list.add(s.next());
        }
        s.close();

        for (String line : list) {
            Program program = ProgramParser.parseProgramString(line);
            programSchedule.put(program.getTime(), program);
        }

        try {
            List<String> testList = Files.readAllLines(new File("schedule.txt").toPath(), Charset.defaultCharset());
            Collections.sort(testList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }




        //Создание List<Program> со всеми программами всех каналов
        List<Program> allPrograms = new ArrayList<>();
        for (List<Program> programs : programSchedule.values()) {
            allPrograms.addAll(programs);
        }

        //Вывод всех программ в порядке возрастания канал, время показа
        Collections.sort(allPrograms, Comparator.comparing(Program::getChannel).thenComparing(Program::getTime));
        for (Program program : allPrograms) {
            System.out.println(program.getChannel() + " " + program.getTime() + " " + program.getName());
        }


    }
}