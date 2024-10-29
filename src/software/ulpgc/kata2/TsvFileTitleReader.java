package software.ulpgc.kata2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TsvFileTitleReader implements TitleReader{
    private final File file;

    public TsvFileTitleReader(File file) {
        this.file = file;
    }

    @Override
    public List<Title> load() {
        try {
            return load(new FileReader(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Title> load(FileReader fileReader) throws IOException {
        return load(new BufferedReader(fileReader));
    }

    private List<Title> load(BufferedReader reader) throws IOException {
        reader.readLine();
        List<Title> titles = new ArrayList<>();
        while (true) {
            String line = reader.readLine();
            if (line == null) return titles;
            titles.add(toTitle(line));
        }
    }

    private Title toTitle(String line) {
        return toTile(line.split("\t"));
    }

    private Title toTile(String[] fields) {
        return new Title(
                fields[0],
                fields[1],
                fields[2],
                fields[3],
                fields[4],
                fields[5],
                fields[6],
                fields[7],
                fields[8]
        );
    }

}
