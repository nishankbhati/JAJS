import com.google.common.collect.Multimap;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.*;

/*
* This class adds the JOB
* */

public class AddJob {

    static int id = 100000000;
    HashMap<Integer,String> Jobtable = new HashMap<>();

    public void AddJobUtil(SaveToHashTable hashTable) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("JobDescriptions.txt").getFile());



        FastReader in = new FastReader(new FileInputStream(file));


        Multimap<String, Pair> Language = hashTable.Language;


        // Company, Exp u years,  JD[" "]
        while (in.ready()) {
            String detail = in.nextLine();
            String[] data = detail.split(" ");
            System.out.println("{{" + detail + "}}");
            String companyName = data[0];
            Jobtable.put(id,companyName);
            int exp = Integer.parseInt(data[1]);
            for (int i = 2;i < data.length; ++i) {
                String d = SaveToHashTable.reformat(data[i]);
                if (Language.containsKey(d)) {
                    Language.put(d, new Pair(id, exp));
                }

            }
            id++;
        }

        hashTable.printLanguageMap();
    }
}
