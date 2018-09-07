import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        String line="+447849686610";
        String [] ifNumver=line.split("");
        String backLine=null;
        List<String> arrayList = new ArrayList<>();
        if(ifNumver[0].equals("+"))  {

            arrayList.addAll(Arrays.asList(line.split("")).subList(2,line.length()));
            arrayList.set(0,"0");
            arrayList.add(arrayList.size(),";");
            backLine=arrayList.toString().replaceAll("[,\\s\\[\\]]", "");
        }
        if (((ifNumver[0].equals("0"))&&(ifNumver[1].equals("0")))){
            arrayList.addAll(Arrays.asList(line.split("")).subList(3,line.length()));
            arrayList.set(0,"0");
            arrayList.add(arrayList.size(),";");
            backLine=arrayList.toString().replaceAll("[,\\s\\[\\]]", "");
        }
//        else {
//            backLine=line;
//            System.out.println("1   ="+backLine);
//        }
//        System.out.println(backLine);
    }
}
