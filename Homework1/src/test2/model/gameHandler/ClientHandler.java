package test2.model.gameHandler;

import java.io.*;
import java.net.*;
import java.util.*;

public class ClientHandler extends Thread{


    public static ArrayList<String> dictionary = new ArrayList<>();
    private static FileReader fileReader;
    private static BufferedReader bufferedFileReader;
    
 
    
    int cno;
   
    Socket s;
    
    public ClientHandler(Socket connection, int cno) {

	this.cno = cno;
	s = connection;
    }

    @Override
    public void run() {

	try {
	    System.out.println("Welcome user " + cno);
            //Initialize dictionary
            String start = "y";
            while (start.equalsIgnoreCase("y"))
            {            
            initializeStreams();
            String word = pickword();
            System.out.print("word is:");
            System.out.println(word);
            word = word.toLowerCase();
            
            int wordLength = word.length();
             char[] cArray = word.toCharArray();
                        
             ArrayList<String> GuessedFromUser = new ArrayList<>();
                        
            // declare new array for guessed letters
            char[] guessedLetters = new char[wordLength] ;
            for (int j = 0; j<wordLength; j++)
            {     guessedLetters[j] = '_';  
            //j++;
               // guessedLetters[j] = ' ';
            }
            String joinWord = String.valueOf(guessedLetters);
            int NumberOfAttempts = wordLength;
            joinWord = customizeword(joinWord);
            String nick = "-------WELCOME TO HANGMAN GAME---------\n "
                    + "Rules of the game:\n "
                    + "1- You need to guess one letter at a time.\n "
                    + "2- Number of wrong attempts is equal to number of letters in word.\n "
                    + "3- Enter quit to end the game.\n "
                    + "4- Game will end, once the user guesses the word right or number of attempts finish\n"
                    + "------Let's BEGIN the Game------\n  "
                    + "You Need To Guess Letters: ";
            //send word lenght to client for guessing            
            OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
            PrintWriter out = new PrintWriter(os);
            out.println(nick + wordLength + "\n" + joinWord);
            out.flush();
                    
            SendDataToClient(s,"guess word: ");   //add line for test
            int WinStatus = 0;
            String userInput = "";
            int g = 0;
            while(NumberOfAttempts!=0)
            {
                               
               int AlreadyGuess = 0;
                userInput = ReadFileFromClient(s);
                                                
                if (g == 1){
                    if(GuessedFromUser.contains(userInput)){
                        AlreadyGuess = 1;                        
                        SendDataToClient(s,"Already guessed, kindly guess the other letter: ");                        
                    }
                }
                    
                int passFail = 0;
                //compare word with array
                if(AlreadyGuess ==0)
                {
                    GuessedFromUser.add(userInput);
                    g= 1;
                    for (int k = 0; k<wordLength; k++)
                    {     
                        if(userInput.toCharArray()[0] == cArray[k] ) 
                        {
                          guessedLetters[k] = cArray[k];              
                          passFail = 1;
                          WinStatus++;
                          joinWord = String.valueOf(guessedLetters);}
                    }
                    joinWord = customizeword(joinWord);

                    if (passFail == 1)
                    {if (WinStatus == wordLength)
                       {   
                      
                      SendDataToClient(s,joinWord + "\n *****You have WON the Game****\n Write 'y' to continue and 'quit' to Quit game");
                      //s.close();
                      break;
                    
                       }
                    else {
                      SendDataToClient(s,"You have guessed the Right Letter: " + joinWord);
                      }             
                 }
                    //for (int m = 0; m<wordLength; m++)
                    //{ //System.out.print(guessedLetters[m]+" ");
                   // }

                    if (passFail == 0)
                    {
                      NumberOfAttempts--;             
                      if(NumberOfAttempts == 0){                  
                      joinWord = String.valueOf(guessedLetters);                    
                      SendDataToClient(s,"***you have LOOSE the game*** \n Write 'y' to continue and 'quit' to Quit game");
                     // s.close();
                      break;
                      //System.exit(0);
                      }     
                      else{
                      joinWord = String.valueOf(guessedLetters);
                      
                      SendDataToClient(s,"You have guessed the Wrong Letter, and remaining attempts are: " + NumberOfAttempts);
                           }
                    }
                }
            }
            start = ReadFileFromClient(s);
        }
        }
	catch (Exception e) {
	    System.err.println("Error here " +e);
    }
    
      
    }
    
     public static String customizeword(String joinWords)
        
        {
            char[] ConvertedArray = joinWords.toCharArray();
            int o = joinWords.length();
            int u = 0;
            char[] StoredArray = new char[o*2];
            for (int i= 0; i<o;i++)
            {
             StoredArray[u]=ConvertedArray[i];
             u++;
             StoredArray[u] = ' ';
             u++;
            joinWords = String.valueOf(StoredArray);
            }
            
            return joinWords;
        }
    

            
     public static void initializeStreams()// throws IOException {
    {
        try {
            File inFile = new File("words.txt");
            fileReader = new FileReader(inFile);
            bufferedFileReader = new BufferedReader(fileReader);
            String currentLine = bufferedFileReader.readLine();
            while (currentLine != null) {
                dictionary.add(currentLine);
                currentLine = bufferedFileReader.readLine();
            }
            bufferedFileReader.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.println("Could not get the Text File");
        }

    }

    public static String pickword() {
        Random random = new Random();
        //int radomNumber = random.nextInt() % dictionary.size();

        int radomNumber = Math.abs(random.nextInt()) % dictionary.size();
        String word = dictionary.get(radomNumber);
        return word;
    }
    
    public static String ReadFileFromClient(Socket s)
    {
        try{

        BufferedReader brt = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String wordFromClient = brt.readLine();
        //System.out.println("User entered Data:" + wordFromClient);
        return wordFromClient;
        }
        catch(IOException e)
        {
        }
         return "problem";
    }
    
    public static void SendDataToClient(Socket s, String str)
    {
        try{
        //code to send data from server
            String nick = str;
            OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
            PrintWriter out = new PrintWriter(os);
            out.println(nick);
            out.flush();
        }
        catch(IOException e)
        {}
    }
}
