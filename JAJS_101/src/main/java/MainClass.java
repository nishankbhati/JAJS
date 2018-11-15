import java.io.IOException;

public class MainClass {

    public static void main(String[] args) throws Exception {
        SaveToHashTable sth = new SaveToHashTable();

        try {
            sth.preprocess();
        } catch (IOException e) {
            throw new Exception();
        }
        AddJob addJob = new AddJob();
        addJob.AddJobUtil(sth);
        SearchJob searchJob= new SearchJob();
        searchJob.SearchJobUtil(sth,addJob);

    }

}
