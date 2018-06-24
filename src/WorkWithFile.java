import java.io.*;
import java.util.LinkedList;
import java.util.List;

// Olexandr Rudyy 23.06.2018
// rudojs@gmail.com

public class WorkWithFile {
    public static final String TEXT ="src/originText.txt";
    public static final String TEXTmodified ="src/modifiedText.txt";
    private static BufferedReader br;
    private static List<String> lines;



    public static void main(String[] args) {
        readFile();
        System.out.println("Input file: "+lines);
        writerFile();
    }

   private static void readFile(){
        List<String> lines =new LinkedList<>();
        String line=null;
        try {
            br = new BufferedReader(new FileReader(TEXT));

            while ((line=br.readLine())!= null) {

                lines.add(line);
            }
            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static  void writerFile(){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(TEXTmodified);
            BufferedWriter bw=new BufferedWriter(fileWriter);

            for(int i =lines.size()-1; i>=0; i-- ){
                bw.write(lines.get(i)+";"+"\n");
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
