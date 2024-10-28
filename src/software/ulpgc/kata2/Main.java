package software.ulpgc.kata2;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        TitleReader file = new TsvFileTitleReader(new File("title.basics.tsv"));
        List<Title> titles = file.load();
        HashMap<String, String> map = new HashMap<>();
        for (Title title : titles) {
            map.put(title.getOriginalTitle(),title.getGenres());
        }
        for(String key:map.keySet()) {
            System.out.println(key+"\t"+map.get(key));
        }
    }
}
