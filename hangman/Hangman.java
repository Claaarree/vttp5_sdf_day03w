package hangman;

import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Hangman {
    public static Console console = System.console();
    public static void main(String[] args) throws IOException {
        String menuInput = "";
        while (!menuInput.equals("2")) {
            System.out.println("Welcome, please choose and option below:");
            System.out.println("1. Play");
            System.out.println("2. Quit");
            System.out.println("Option number: ");
            menuInput = console.readLine();
            if (menuInput.equals("1")) {
                play();
            }
        }
        if (menuInput.equals("2")) {
            System.out.println("Bye bye!");
        }
        
    }
    
    public static String randomWordSelector() throws IOException {
        List <String> words = new ArrayList<>();

        File wordList = new File("hangman" + File.separator + "wordList.txt");
        //System.out.println(wordList.getAbsolutePath());
        FileReader fr = new FileReader(wordList);
        BufferedReader br = new BufferedReader(fr);
        String dataRead = "";
        while ((dataRead = br.readLine()) != null) {
            //System.out.println(dataRead); 
            words.add(dataRead);
        }
        br.close();
        fr.close();

        int indexGenerated = (int)(Math.random() * words.size());
        //System.out.println(indexGenerated);
        String word = words.get(indexGenerated);
        
        //System.out.println(word);
        return word;
    }

    // public static void play1() throws IOException {
    //     String wordToGuess = randomWordSelector();
    //     System.out.println(wordToGuess);
    //     char [] wordSplit = wordToGuess.toCharArray();   
    //     System.out.println(wordSplit);   
    //     for (char c: wordSplit) {
    //         System.out.print("_");
    //     }
                
    //     String input = console.readln("\nGuess a letter or the word:");
    //     int inputLength = input.length();
    //     while (inputLength == 1) {   
    //         // for (char c: wordSplit) {
    //         //     System.out.print("_");
    //         //}        
    //         char guess = input.charAt(0);
    //         for (int i = 0; i < wordSplit.length; i++) {
    //             String blank = "_";
    //             System.out.println(wordSplit[i]); 
    //             if (guess == wordSplit[i]) {                    
                     
    //                 String correctLetter = blank.replace("_", Character.toString(guess));
    //                 System.out.print(correctLetter);             
                    
    //             } else {
    //                 for (char c: wordSplit) {
    //                     System.out.print("_");
    //                 }
    //                 System.out.println("\nSorry! The word does not contain " + guess + ".");
                    
    //             } 
                
    //         }
            
    //         input = console.readln("\nGuess a letter or the word:");
    //         inputLength = input.length();
    //     } 
    //     if (input.equals(wordToGuess)) {
    //         System.out.println("Congratulations! You found the word!");
    //     } else {
    //         System.out.println("Input error. Please try again.");
    //     }
       
        
    //}
    public static void play() throws IOException {
        String wordToGuess = randomWordSelector();
        char [] wordSplit = wordToGuess.toCharArray();   
        char [] currAns = new char[wordToGuess.length()];
        for (int i =0; i<wordToGuess.length();i++){
            currAns[i] = '_';
        }
        System.out.print(currAns);
                
        String input ="";
        int livesLeft = 5;

        while (livesLeft > 0 && Arrays.compare(currAns, wordSplit)!=0){
            System.out.println("\nGuess a letter or the word:");
            input = console.readLine().trim();
            int inputLength = input.length();
            if(inputLength ==1){
                boolean isGuessCorrect = false;
                char guess = input.charAt(0);
                for (int i = 0; i < wordSplit.length; i++) {
                    if (guess == wordSplit[i]) {                    
                        currAns[i] = guess;    
                        isGuessCorrect= true;      
                    } 
                }
                if(!isGuessCorrect){
                    System.out.println("\nSorry! The word does not contain " + guess + ".");
                    livesLeft--;
                    System.out.println("You have " + livesLeft + " lives left.");
                } 
                System.out.println(currAns);
                
            } else if (inputLength>1) {
                if (input.equals(wordToGuess)) {
                    System.out.println("Congratulations! You found the word!");
                    currAns = wordSplit;
                } else {
                    System.out.println("You guessed wrong");
                    livesLeft--;
                    System.out.println("You have " + livesLeft + " lives left.");
                }
            }
        }
        if (livesLeft > 0) {
            System.out.println("Good Job!");
        } else {
            System.out.println("The word was " + wordToGuess);
            System.out.println("Try Again!");
        }
        
       
        
    }
}
