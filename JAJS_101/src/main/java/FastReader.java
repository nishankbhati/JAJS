import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
* Java I/O is technically slow, this class will speed up I/O process
* */
public class FastReader {
    BufferedReader bufferedReader;
    StringTokenizer stringTokenizer;
    static final int BUFFER_SIZE = 32768;

    public FastReader(InputStream inputStream) {
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream), BUFFER_SIZE);
        stringTokenizer = null;
    }

    public String nextString() throws IOException {
        while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        }
        return stringTokenizer.nextToken();
    }

    public String nextLine() throws IOException {
        return bufferedReader.readLine();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(nextString());
    }

    public boolean ready() throws IOException {
        return bufferedReader.ready();
    }
}