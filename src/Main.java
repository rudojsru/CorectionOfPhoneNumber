import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        final String TEXT = "src/originText.txt";   //C:\Tomek
        final String TEXTmodified = "src/modifiedText.txt";
        BufferedReader br;
        List<String> lines = new LinkedList<>();
        String line = null;

        try {
            br = new BufferedReader(new FileReader(TEXT));

            while ((line = br.readLine()) != null) {
                line=newPhoneNumber(line);
                lines.add(line);
            }
            br.close();
            System.out.println("input file: "+lines);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(TEXTmodified);
            BufferedWriter bw = new BufferedWriter(fileWriter);
             for (int i =0; i < lines.size(); i++) {
                String myString=lines.get(i);
                char[] myCharArray =myString.toCharArray();

                bw.write(lines.get(i) + "\n");

            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String newPhoneNumber(String line) {
        String [] ifNumver=line.split("");
        String backLine=null;
        List<String> arrayList = new ArrayList<>();
        if(ifNumver[0].equals("+"))  {



            arrayList.addAll(Arrays.asList(line.split("")).subList(2,line.length()));
            arrayList.set(0,"0");
            arrayList.add(arrayList.size(),";");
            backLine=arrayList.toString().replaceAll("[,\\s\\[\\]]", "");
        }else {
            backLine=line;
        }
        return backLine;
    }
}
