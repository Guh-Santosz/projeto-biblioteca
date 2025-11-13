import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Utilities 
{
    public static void consoleClear()
    {
        try
        {
            if(System.getProperty("os.name").contains("Windows"))
            {
                new ProcessBuilder("cmd", "/c", "cls")
                .inheritIO().start().waitFor();
            }
            else
            {
                new ProcessBuilder("clear")
                .inheritIO().start().waitFor();
            }
        }
        catch(IOException e)
        {
            System.out.println("Error cleaning terminal " + e.getMessage());
        }
        catch(InterruptedException e)
        {
            System.out.println("Process stopped " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    } 
    public static void pause(Scanner sc, Messages msg)
    {
        if (msg.getLanguage() == 1) System.out.print("Press [ENTER] to continue... ");  
        else System.out.print("Pressione [ENTER] para continuar... ");
        sc.nextLine();
    }
    public static boolean intTryParse(String input)
    {
        if (input.isEmpty()) return false;
        try
        {
            Integer.parseInt(input); 
            return true;
        }
        catch(NumberFormatException e)
        {
            return false;
        }
    }
    public static boolean isOnlyLetters(String word) 
    {   
        if(word == null) return false;
        word = word.trim().replaceAll("\\s{2,}", " ");

        return word.length() >= 2 && word.length() <= 50 && word.trim().matches("[A-Za-zÀ-ÿ ]+");
    }
    public static boolean containsLettersAndNumbers(String word)
    {
        if (word.isEmpty()) return false;
        else 
        {
            for (int i = 0; i < word.length(); i++)
                if (!Character.isLetterOrDigit(word.charAt(i)) && word.charAt(i) != ' ')  
                    return false;

            return true;
        }
    }
    public static String formatDate(Messages msg, LocalDate date)
    {
        DateTimeFormatter format;
        if (msg.getLanguage() == 1) format = DateTimeFormatter.ofPattern("MM/dd/yyyy"); 
        else format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return date.format(format);
    }
}