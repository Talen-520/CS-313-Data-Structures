import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader {
    BufferedReader br;

    public InputReader(String filename) {
        try {
            FileInputStream fstream = new FileInputStream(filename);
            br = new BufferedReader(new InputStreamReader(fstream));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public DynamicArrayQueue<String> readAndReturnFileLines() {
        DynamicArrayQueue<String> fileContent = new  DynamicArrayQueue<String>(); //create a empty DynamicArrayQueue
        String line;
        try{
        while ((line = br.readLine()) != null){
            fileContent.enqueue(line);
         } // adding every lines to DynamicArrayQueue by enqueue method
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
         return fileContent;

    }
}
