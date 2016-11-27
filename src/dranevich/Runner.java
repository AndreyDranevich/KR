package dranevich;



import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Andrey on 19.11.2016.
 */

public class Runner {
    public static void main(String[] args) throws IOException {
        List<String> list = Reader.readFile("bytes.in");
        List<Arrays> arrays = initClass(list);
        writeBytes1(arrays);
        writeBytes2(arrays);
        writeBytes3(arrays);
    }

    private static List<Arrays> initClass(List<String> list) {
        List<Arrays> arrays = new ArrayList<>();
        for (String s : list) {
            Arrays ar = new Arrays();
            StringTokenizer st = new StringTokenizer(s, " []");
            ar.initType(st.nextToken());
            ar.initName(st.nextToken());
            String temp = "";
            while (st.hasMoreTokens()) {
                temp += st.nextToken() + " ";
            }
            ar.initSize(temp);
            arrays.add(ar);
        }
        return arrays;
    }

    private static void writeBytes1(List<Arrays> arrays) throws IOException {
        List<String> list = new ArrayList<>();
        for (Arrays s : arrays) {
            list.add(s.getName());
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        Reader.writeFile("bytes1.out", list);
    }

    private static void writeBytes2(List<Arrays> arrays) throws IOException {
        Collections.sort(arrays, new Comparator<Arrays>() {
            @Override
            public int compare(Arrays o1, Arrays o2) {
                return sizeOfType(o1.getType()) - sizeOfType(o2.getType());
            }
        });
        List<String> list = new ArrayList<>();
        for (Arrays s : arrays) {
            list.add(s.getName());
        }

        Reader.writeFile("bytes2.out", list);
    }

    private static void writeBytes3(List<Arrays> arrays) throws IOException {
        List<String> numbers = new ArrayList<>();
        List<String> type = new ArrayList<>();
        for (Arrays s : arrays) {
            numbers.add(s.getSize());
            type.add(s.getType());
        }

        File file = new File("bytes3.out");
        file.createNewFile();
        FileWriter fw = new FileWriter("bytes3.out");
        int[] size;
        int i = 0;
        int j = 0;
        int k = 0;

        Pattern p = Pattern.compile("\\d+");
        for (String s : numbers) {
            Matcher m = p.matcher(s);
            while (m.find()) {
                i++;
            }
            m.reset();
            size = new int[i];
            while (m.find()) {
                size[j++] = Integer.parseInt(m.group());

            }
            j = 0;
            i = 0;
            fw.write(String.valueOf(addSize(type.get(k), size) + "\n"));
            k++;
        }
        fw.close();

    }

    private static int addSize(String type, int[] ar) {
        int cSize = 4 + 16 + 4;
        int sType = sizeOfType(type);
        switch (ar.length) {
            case 1:
                return cSize + sType * ar[0];
            case 2:
                return cSize + ar[1] * (cSize + sType * ar[0]);
            case 3:
                return cSize + ar[2] * (cSize + ar[1] * (cSize + sType * ar[0]));
            case 4:
                return cSize + ar[3] * (cSize + ar[2] * (cSize + ar[1] * (cSize + sType * ar[0])));
            case 5:
                return cSize + ar[4] * (cSize + ar[3] * (cSize + ar[2] * (cSize + ar[1] * (cSize + sType * ar[0]))));
            default:
                return 0;
        }

    }

    private static int sizeOfType(String s) {
        switch (s) {
            case "double":
                return 8;
            case "int":
                return 4;
            case "char":
                return 2;
            case "float":
                return 4;
            case "byte":
                return 1;
            case "short":
                return 2;
            case "long":
                return 8;
            case "boolean":
                return 1;
            default:
                return 0;
        }
    }

}






