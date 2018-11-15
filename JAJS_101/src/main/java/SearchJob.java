import com.google.common.collect.Multimap;
import javax.swing.*;

import java.util.*;

public class SearchJob {

    public void SearchJobUtil(SaveToHashTable hashTable, AddJob addJob){

        JFrame f=new JFrame();
        String Lang=JOptionPane.showInputDialog(f,"Enter Language");
        String[] data = Lang.split(" ");
        int exper=Integer.parseInt(JOptionPane.showInputDialog(f,"Enter Experience"));
        /* Each entry of data will contain name of Language/Technology*/
        for(int i=0;i<data.length;i++){
            System.out.println(data[i]);
        }

        Multimap<String, Pair> Language = hashTable.Language;
        HashMap<Integer,String> Jobtable = addJob.Jobtable;

        // tMap contains frequency of each JOB as value and JOBID as Key

        TreeMap<Integer,Integer> tMap= new TreeMap<>();
        System.out.println("The following jobs are available for your search");
        for(int i=0;i<data.length;i++) {
            Collection<Pair> pairCollection = Language.get(data[i]);
            for (Pair pp : pairCollection) {
                if (pp.second <= exper) {
                    int JID = pp.first;

                    if(tMap.containsKey(JID)){
                        int priority=tMap.get(JID);
                        tMap.put(JID,priority+1);
                    }
                    else{
                        tMap.put(JID,1);
                    }
                }
            }
        }
        if(tMap.size()==0){
            System.out.println("No Jobs Found");
            System.exit(0);
        }
        Set<Map.Entry<Integer, Integer>> set = tMap.entrySet();
        // List Ranking will help in sorting according to Ranking criteria mentioned in assignment
        List<Pair> Ranking = new ArrayList<>();
        for(Map.Entry<Integer,Integer> it : set){

            Pair tmp= new Pair(it.getValue(),it.getKey());

            Ranking.add(tmp);


        }

        Collections.sort(Ranking,Collections.<Pair>reverseOrder());

        for(Pair tmp: Ranking){
            System.out.println(Jobtable.get(tmp.second));
        }

        System.exit(0);


    }
}
