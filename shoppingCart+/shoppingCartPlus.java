import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class shoppingCartPlus{
    
    public static void main(String[] args) throws IOException {
        
        //Directory creation
        String dirPath;
        if (args.length == 0) {
            dirPath = "db";
        } else {
            dirPath = args[0];
            File directory = new File (dirPath);
            if (!directory.exists()) {
                directory.mkdir();
            } else {
                System.out.println("Your cart will be saved in " + dirPath);
            }
        }

        

        System.out.println("Welcome to your shopping cart");
        Scanner input = new Scanner(System.in);
        
        //System.out.println("Login to cart by entering your name: ");
        //String username = input.next();
    
        List<String> cart = new ArrayList<>();
        ShoppingCartDB scdb = new ShoppingCartDB();
        
        String lowerAction = "";
        String username = "";
        String dirPathFilename = dirPath + File.separator + username + ".db";
        File file = new File(dirPathFilename);


        while (!lowerAction.equals("quit")) {
            System.out.print("> ");
            String action = input.next();
            lowerAction = action.toLowerCase();    
            String itemString = input.nextLine();
            String[] items = itemString.split(",");
            

            //declaring and intialising file
            
            
           

            if (lowerAction.equals("login")) {
                username = itemString.trim();
                dirPathFilename = dirPath + File.separator + username + ".db";
                file = new File(dirPathFilename);
                //Creating new file or reading existing file
                if (file.exists()) {
                    System.out.println("File " + file.toString() + " has already been created.");
                    System.out.printf("%s, your cart contains the following items \r\n", username);
                    cart = scdb.loadCart(file, username);
                    //print cart using for loop
                    for (int y = 0; y < cart.size(); y++) {
                        System.out.println(y+1 + ". " + cart.get(y));
                    }
                    
                    
                } else {
                    file.createNewFile();
                    System.out.println("Hello " + username + ", your cart is empty.");
                }


            } else if (lowerAction.equals("list") && cart.isEmpty()) {
                System.out.println("Your cart is empty! Add items to your cart!");
            } else if (lowerAction.contains("add")) {
            for (int i = 0; i < items.length; i++) {
                if (cart.contains(items[i].trim())) {
                    System.out.println(items[i].trim() + " already in cart");
                    continue;
                    } else {
                    cart.add(items[i].trim());
                    System.out.println(items[i].trim() + " added to cart");
                    } 
                }
            } else if (lowerAction.equals("list") && !cart.isEmpty()) {
                for (int j= 0; j < cart.size(); j++ ) {
                    String list = j+1 + ". " + cart.get(j);
                    System.out.println(list); 
                } 
            } else if (lowerAction.contains("delete")) {            
                    int itemNum = Integer.parseInt(itemString.trim());
                    if (itemNum <0 || itemNum > cart.size()) {
                        System.out.println("That is not a valid list number");
                    } else { System.out.println(cart.get(itemNum -1) + " removed from cart");
                    cart.remove(itemNum -1);
                    } 
            } else if (lowerAction.equals("save")) {
                if (username.equals("")) {
                    System.out.println("Please login before saving your cart.");
                } else {
                    scdb.saveCart(file, cart);
                    System.out.println("Your cart has been saved.");
                }
                
               
            } else if (lowerAction.equals("users")) { 
                List <String> usersList = scdb.getUsers(dirPath);
                System.out.println("The following users are registered");
                for (int x = 0; x < usersList.size(); x++ ) {
                    System.out.println(x+1 + ". " + usersList.get(x));
                }
                
            } else if (lowerAction.equals("quit")) {
                System.out.println("Bye bye");
            } 
            else System.out.println("Sorry, I don't understand. Please try again.");
        } 
 
        input.close();
    }
}
