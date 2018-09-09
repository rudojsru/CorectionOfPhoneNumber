import java.io.BufferedReader;
        import java.io.FileNotFoundException;
        import java.io.FileReader;
        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.List;
public class PracaZPlikem {
    public static final String TEXT="Text.txt";
    private BufferedReader br;

    public PracaZPlikem(){
    }

    public void openFile(){
        try{
            br=new BufferedReader(new FileReader(TEXT));
            System.out.println("Fileisopen");
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public String wczytaj(){
        if(br==null){
//jeslizamkniety
            openFile();
        }
        try{
            String linia=br.readLine();
            if(linia==null){
                przevinPlik();
                linia=br.readLine();
            }
            return linia;
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public void przevinPlik(){
        closeFile();
        openFile();
    }

    public void closeFile(){
        System.out.println("file is clouse");
        try{
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void pominLinije(){
        System.out.println("Pominlinije");
        wczytaj();

    }

    public void pominNLinij(int n){
        System.out.println("Pomineliem"+n+"linij");
        for(int i=0;i<n;i++){
            wczytaj();
        }
    }

    public List<String>wczytajNLinij(int n){
        List<String>wczytaj=new ArrayList<String>();
        for(int i=0;i<n;i++){
            wczytaj.add(wczytaj());

        }
        return wczytaj;
    }
}
