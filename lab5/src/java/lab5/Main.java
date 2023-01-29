package lab5;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        LinkedHashSet<Worker> set = new LinkedHashSet<>();
        //String start = Commands.open("input.csv");
        //String env = System.getenv("Javahome");
        //System.out.println(env + " env");
       // String start = Commands.open(System.getenv("Path"));
        try {
            String start = Commands.open("save.csv");
            Commands.begin(start, set);
        }
        catch (NullPointerException e){
            System.out.println("no such file");
            String start = Commands.open("save.csv");
            Commands.begin(start, set);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        InputStream inputStream = System.in;
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        try{

        while (true) {
            System.out.print("Write a command: ");
            String input = bufferedReader.readLine();
            Commands.runCommandFromString(set, input.trim());}
        }
        catch (NullPointerException | NoSuchElementException e){
            Commands.funExit();

        }
    }

}

