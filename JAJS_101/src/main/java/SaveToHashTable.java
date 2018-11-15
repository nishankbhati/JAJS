import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.io.*;
import java.util.Scanner;

public class SaveToHashTable {
    public Multimap<String, Pair> Language = ArrayListMultimap.create();
    /*
    * In the preprocessing phase all the mentioned languages will be stored in multimap
    * */

    void preprocess() throws IOException {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("LanguagesList.txt").getFile());

        FastReader in = new FastReader(new FileInputStream(file));
        while (in.ready()) {
            String s = in.nextLine();
            Language.put(s, new Pair(-1, 100));
        }
//        System.out.println("-----------------------------1-----------------------------");
//        printLanguageMap();
    }
    /*
    * Read only valid character from strings.
    * For example a JD may have languages listed as C++, JAVA, Python. This will be parsed to C++ JAVA Python <Space separated>
    * */
    public static String reformat(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0;i < s.length(); ++i) {
            char ch = Character.toLowerCase(s.charAt(i));
            if (ch >= 'a' && ch <= 'z' || ( ch>='A' && ch<='Z') || ch=='+') stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }

    public void printLanguageMap() {
        for (String s : Language.keySet()) System.out.println(s + " " + Language.get(s));
    }

}
