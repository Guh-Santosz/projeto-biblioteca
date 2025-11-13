import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BinaryFile 
{
    public static boolean saveUserData(List<User> users, String fileName)
    {
        try
        {
            File file = new File(fileName);
            File parent = file.getParentFile();
            if (parent != null) {parent.mkdirs();} 
        
            try(ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream(file))) {save.writeObject(users);}
            return true;
        }
        catch (IOException e) 
        {
            e.printStackTrace();
            return false;
        }
    }

    @SuppressWarnings("unchecked")

    public static List<User> readUserData(String fileName)
    {
        List<User> users = new ArrayList<>();
        
        try (ObjectInputStream read = new ObjectInputStream(new FileInputStream(fileName))) {users = (List<User>) read.readObject();}
        catch (IOException | ClassNotFoundException e) {e.printStackTrace();}

        return users;
    }
    public static boolean saveBookData(List<Book> books, String fileName)
    {
        try 
        {
            File file = new File(fileName);
            File parent = file.getParentFile();
            if (parent != null) {parent.mkdirs();}

            try (ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream(file))) {save.writeObject(books);}
            return true;
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Book> readBookData(String fileName)
    {
        List<Book> books = new ArrayList<>();
        
        try (ObjectInputStream read = new ObjectInputStream(new FileInputStream(fileName))) {books = (List<Book>) read.readObject();}
        catch (IOException | ClassNotFoundException e) {e.printStackTrace();}

        return books;
    }

    public static boolean saveReservationData(List<Reservation> reservations, String fileName)
    {
        try
        {
            File file = new File(fileName);
            File parent = file.getParentFile();
            if (parent != null) {parent.mkdirs();} 
        
            try(ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream(file))) {save.writeObject(reservations);}
            return true;
        }
        catch (IOException e) 
        {
            e.printStackTrace();
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Reservation> readReservationData(String fileName)
    {
        List<Reservation> reservations = new ArrayList<>();
        
        try (ObjectInputStream read = new ObjectInputStream(new FileInputStream(fileName))) {reservations = (List<Reservation>) read.readObject();}
        catch (IOException | ClassNotFoundException e) {e.printStackTrace();}

        return reservations;
    }
}