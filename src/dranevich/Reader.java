package dranevich;

import java.io.*;
import java.util.*;

/*
  Created by Andrey on 29.10.2016
*/

class Reader {
    static List<String> readFile(String way) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(new File(way)));
        String line;
        List<String> itemsList = new ArrayList<String>();
        while ((line = in.readLine()) != null)
            itemsList.add(line);
        in.close();
        return itemsList;
    }

    static void writeFile(String way, List<String> list) throws IOException {
        File file = new File(way);
        file.createNewFile();
        FileWriter fw = new FileWriter(way);
        for (String s : list) {
            fw.write(s + "\r\n");
        }
        fw.close();
    }

    static void writeFileStr(String way, String str) throws IOException {
        File file = new File(way);
        file.createNewFile();
        FileWriter fw = new FileWriter(way);
        fw.write(str);
        fw.close();
    }
}
