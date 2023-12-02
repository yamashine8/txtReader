import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final String txtname  = "text.txt";
        List<String> list = txtRead(txtname);
        System.out.println("Simple text reader");
        for(String num : list){
            System.out.println(num);
        }
        List<String> list2 = txtRead2(txtname);
        System.out.println("Simple text reader 2");
        for(String num : list2){
            System.out.println(num);
        }
    }

    private static List<String> txtRead(String txtname) {
        List<String> res = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(txtname));){
            String temp;
            while ((temp = bufferedReader.readLine()) != null){
                res.add(temp);
            }
        }catch (IOException ex){
            ex.printStackTrace(System.out);
        }
        return res;
    }

    public static List<String> txtRead2(String txtname){
        try{
            return Files.readAllLines(Paths.get(txtname));
        } catch (IOException ex){
            ex.printStackTrace(System.out);
        }
        return Collections.EMPTY_LIST;
    }
}