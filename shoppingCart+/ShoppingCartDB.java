import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.List;
import java.io.BufferedReader;
import java.util.ArrayList;


public class ShoppingCartDB {

    public List<String> loadCart(File file, String username) throws IOException{
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader (fr);
        String dataRead = "";
        //System.out.println(username + ", your cart contains the following items");
        List <String> cart = new ArrayList<>();
        while ((dataRead = br.readLine())!= null) {
            String [] loadedItem = dataRead.split(". ", 2);
            cart.add(loadedItem[1]);
        } if (cart.isEmpty()) { 
            System.out.println("There is nothing in your cart");
        } 
        br.close();
        fr.close();
       
        return cart;
    }

    public void saveCart(File file, List<String> cart) throws IOException {
        FileWriter fw = new FileWriter(file, false);
                for (int z = 0; z < cart.size(); z++) {
                    String list = z+1 + ". " + cart.get(z) + "\n";
                    fw.write(list);
                }
                
                fw.flush();
                fw.close();

    }

    public List<String> getUsers(String dirPath) {
        List <String> users = new ArrayList<>();
        File directory = new File(dirPath);
        File[] fileList = directory.listFiles();
        for (File file: fileList) {
            String filename = file.getName();
            int indexOfDb = filename.lastIndexOf(".db");

            users.add(filename.substring(0, indexOfDb));
        }
        return users;
    }
}