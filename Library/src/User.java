import java.io.Serializable;

public class User implements Serializable
{
    private static final long serialVersionUID = 1L;
    private final int id;
    private String name;
    private int age;
    
    public User(int id, String name, int age)
    {
        this.id = id;
        if (!name.isEmpty()) this.name = name.toUpperCase();
        if (age > 0) this.age = age;
    }
    public String getName() {return name;}

    public void setName(String name) {if (!name.isEmpty()) this.name = name.toUpperCase();}

    public int getAge() {return age;}

    public void setAge(int age) {if (age > 0) this.age = age;}
    
    public int getId() {return id;}

    public String toString(Messages msg) 
    {
        if (msg.getLanguage() == 1) return "|ID: " + id + " |Name: " + name + " |Age: " + age + " |";
        else return "|ID: " + id + " |Nome: " + name + " |Idade: " + age + " |";
    }
}
