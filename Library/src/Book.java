import java.io.Serializable;

public class Book implements Serializable
{
    private static final long serialVersionUID = 1L;
    private int bookId;
    private String name;
    private String author;
    private String description;
    private int year;
    private boolean available;
    
    public Book(int bookId, String name, String author, String description, int year, boolean available)
    {
        if(bookId > 0)this.bookId = bookId;
        if(!name.isEmpty()) this.name = name;
        if(!author.isEmpty()) this.author = author;
        if(!description.isEmpty()) this.description = description;
        if(year > 0) this.year = year;
        this.available = available;
    }

    public String getName() {return name;}

    public void setName(String name) {if(!name.isEmpty()) this.name = name;}

    public String getAuthor() {return author;}

    public void setAuthor(String author) {if(!author.isEmpty()) this.author = author;}
    
    public String getDescription() {return description;}

    public void setDescription(String description) {if(!description.isEmpty()) this.description = description;}
    
    public int getYear() {return year;}

    public void setYear(int year) {if(year > 0) this.year = year;}
    
    public boolean getAvailable() {return available;}

    public void setAvailable(boolean available) {this.available = available;}

    public int getBookId() {return bookId;}

    public String toString(Messages msg)
    {
        if (msg.getLanguage() == 1) return "|ID : " + bookId + "\n|Name: " + name + "\n|Author: " + author + "\n|Description: " + description + "\n|Launch year: " + year + "\n|Available: " +  ((available) ? "Yes" : "No");
        else return "|ID : " + bookId + "\n|Nome: " + name + "\n|Autor: " + author + "\n|Descrição: " + description + "\n|Ano: " + year + "\n|Disponível: " +  ((available) ? "Sim" : "Não");
    }
}
