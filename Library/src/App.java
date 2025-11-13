import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Sumário de funções:

// 1ª - selectLanguage
// 2ª - searchForUser
// 3ª - searchForbook
// 4ª - setBookAvailable
// 5ª - mainMenu
// 6ª - userMenu
// 7ª - newUser
// 8ª - showUsers
// 9ª - searchUsers
// 10ª - editUsers
// 11ª - removeUsers
// 12ª - bookMenu
// 13ª - newBook
// 14ª - showBooks
// 15ª - searchBooks
// 16ª - editBooks
// 17ª - removeBooks
// 18ª - reservationMenu
// 19ª - newReservation
// 20ª - showResPending
// 21ª - showResOverdue
// 22ª - showResHistory
// 23ª - markResAsReturned
// 24ª - searchReservation
// 25ª - cancelReservation
// 26ª -  removeResFromHistory

// Lista de ids em Mensagens:

// Títulos: 

// 0 -> select language(somente ingles)
// 1 -> despedida(somente ingles)
// 2 -> menu principal
// 3 -> menu user
// 4 -> novo usuário
// 5 -> mostrar usuários
// 6 -> pesquisar usuários
// 7 -> editar usuários
// 8 -> remover usuários
// 9 -> menu book
// 10 -> novo livro
// 11 -> mostrar livros
// 12 -> pesquisar livros
// 13 -> editar livros
// 14 -> remover livros
// 15 -> gerenciador de reservas
// 16 -> adicionar reserva
// 17 -> mostrar reservas pendentes
// 18 -> mostrar reservas atrasadas
// 19 -> mostrar histórico de reservas
// 20 -> dar baixa em reserva
// 21 -> pesquisar por reserva
// 22 -> cancelar reserva

// Avisos:

// 0 -> idoma invalido(somente ingles)
// 1 -> encerramento de programa
// 2 -> numero valido
// 3 -> nome invalido
// 4 -> idade invalida
// 5 -> usuario cadastrado com sucesso
// 6 -> erro ao salvar arquivo
// 7 -> não há usuários cadastrados
// 8 -> id inválido
// 9 -> usuário encontrado
// 10 -> usuário não encontrado
// 11 -> digitar novos dados
// 12 -> usuário removido com sucesso
// 13 -> livro registrado com sucesso
// 14 -> não há livros cadastrados
// 15 -> descrição inválida
// 16 -> livro encontrado
// 17 -> livro não encontrado
// 18 -> livro removido com sucesso
// 19 -> livro editado com sucesso
// 20 -> não há usuários ou livros cadastrados
// 21 -> reserva feita com sucesso
// 22 -> usuário ou livro não encontrados
// 23 -> não há reservas cadastradas
// 24 -> não há reservas vencidas
// 25 -> não há reservas pendentes
// 26 -> reserva não encontrada
// 27 -> reserva devolvida com sucesso
// 28 -> reserva cancelada com sucesso

// Menus:

// 0 -> escolha idioma(somente ingles)
// 1 -> menu principal
// 2 -> gestão de usuários
// 3 -> gestão de reservas

// Inputs:

// 0 -> nome de usuário
// 1 -> idade do usuário
// 2 -> id do usuário
// 3 -> editar nome de usuário
// 4 -> nova idade
// 5 -> nome do livro
// 6 -> nome do autor
// 7 -> descrição
// 8 -> ano de lançamento
// 9 -> id do livro
// 10 -> novo nome de livro
// 11 -> novo nome do autor
// 12 -> nova descrição de livro
// 13 -> novo ano do livro
// 14 -> usuário para reserva
// 15 -> livro para a reserva
//16 -> Digite o id da reserva

public class App 
{
    static String usersFileName = "data/Users.bin";
    static String booksFileName = "data/Books.bin";
    static String reservationsFileName = "data/Reservations.bin";

    public static int selectLanguage(Scanner sc, Messages msg)
    {
        int menuChoose = 1;
        boolean isValid = false;
        do
        {
            Utilities.consoleClear();
            msg.titles(0);
            if (isValid || menuChoose != 1 && menuChoose != 2 && menuChoose != 0) msg.warnings(0);//Avisa o usuário caso o numero digitado seja invalido
            msg.menus(0); 
            String input = sc.nextLine();
            
            if (Utilities.intTryParse(input)) menuChoose = Integer.parseInt(input);//Se o valor digitado for válido, logo é convertido para uma variavel de tipo int
            else isValid = true;

        }while (menuChoose != 1 && menuChoose != 2 && menuChoose != 0);

        return menuChoose;
    }

    public static User searchForUser(int userId, List<User> users)
    {
        for (User u : users)
            if (u.getId() == userId) return u;
        
        return null;
    }

    public static Book searchForBook(int bookId, List<Book> books)
    {
        for (Book b : books)
            if (b.getBookId() == bookId) return b;
        
        return null;
    }

    public static List<Book> setBookAvailable(List<Book> books, Book foundBook)
    {
        for (Book b : books)
        {
            if (b.getBookId() == foundBook.getBookId())
            {
                b.setAvailable(true);
            }
        } 

        return books;
    }

    public static void mainMenu(Scanner sc, Messages msg, List<User> users, List<Book> books, List<Reservation> reservations)
    {
        int menuChoose = 0;
        do
        {
            Utilities.consoleClear();
            msg.titles(2);
            msg.menus(1);

            String input = sc.nextLine();
            if (Utilities.intTryParse(input)) menuChoose = Integer.parseInt(input);
            
            Utilities.consoleClear();
            switch (menuChoose) 
            {
                case 1 -> userMenu(sc, msg, users);
                case 2 -> bookMenu(sc, msg, books);
                case 3 -> reservationMenu(sc, msg, reservations, users, books);
                case 0 -> 
                {
                    msg.titles(2);
                    msg.warnings(1);
                }
                default -> 
                {
                    msg.titles(2);
                    msg.warnings(2);
                    System.out.println();
                    Utilities.pause(sc, msg);
                    Utilities.consoleClear();
                }
            }
        }while (menuChoose != 0);
    }

    public static void userMenu(Scanner sc, Messages msg, List<User> users)
    {
        int menuChoose = 0;
            
        do
        {
            Utilities.consoleClear();
            msg.titles(3);
            msg.menus(2);
                
            String input = sc.nextLine();
            if (Utilities.intTryParse(input)) menuChoose = Integer.parseInt(input);
            Utilities.consoleClear();
                
            switch (menuChoose)
            {
                case 1 -> newUser(sc, users, msg);
                case 2 -> showUsers(sc, users, msg);
                case 3 -> searchUsers(sc, users, msg);
                case 4 -> editUsers(sc, users, msg);
                case 5 -> removeUsers(sc, users, msg);
                case 0 -> {}
                default -> 
                {
                    msg.titles(3);
                    msg.warnings(2);
                    System.out.println();
                    Utilities.pause(sc, msg);
                    Utilities.consoleClear();
                }
            }
        }while(menuChoose != 0);   
    }

    public static void newUser(Scanner sc, List<User> users, Messages msg)
    {
        boolean isValid = true;
        String name, input;
        int age = 0;

        do
        {
            Utilities.consoleClear();
            msg.titles(4);
            if (!isValid) 
            {
                msg.warnings(3);
                System.out.println();
            }
            msg.inputs(0);
            name = sc.nextLine();
            isValid = Utilities.isOnlyLetters(name);

        }while (!isValid);
    
        name = name.trim().replaceAll("\\s{2,}", " ");

        do
        {
            Utilities.consoleClear();
            msg.titles(4);
            if (!isValid) 
            {
                msg.warnings(4);
                System.out.println();
            }
            msg.inputs(1);
            input = sc.nextLine();
            isValid = Utilities.intTryParse(input);
            if (isValid)
            {
                age = Integer.parseInt(input);
                if (age < 10 || age > 120) isValid = false;
            }
        }while (!isValid);

        if(users.isEmpty())users.add(new User(1, name, age));
        else
        {
            int newId = users.get(users.size() - 1).getId() + 1;
            users.add(new User(newId, name, age));
        }

        Utilities.consoleClear();
        msg.titles(4);
        if (BinaryFile.saveUserData(users, usersFileName)) msg.warnings(5);
        else msg.warnings(6);
        System.out.println();
        Utilities.pause(sc, msg);
        Utilities.consoleClear();
    } 

    public static void showUsers(Scanner sc, List<User> users, Messages msg)
    {
        msg.titles(5);
        if (users.isEmpty()) msg.warnings(7);
        else 
        {
            users = BinaryFile.readUserData(usersFileName);
            for (User u : users) System.out.println(u.toString(msg));
        }
        System.out.println();
        Utilities.pause(sc, msg);
        Utilities.consoleClear();
    } 

    public static void searchUsers(Scanner sc, List<User> users, Messages msg)
    {
        boolean isValid = true;
        msg.titles(6);
        if (users.isEmpty()) msg.warnings(7);
        else
        {
            String input;
            do
            {
                Utilities.consoleClear();
                msg.titles(6);
                if (!isValid)
                {
                    msg.warnings(8);
                    System.out.println();
                } 
                msg.inputs(2);
                input = sc.nextLine();
                
                isValid = Utilities.intTryParse(input);

            }while (!isValid);

            Utilities.consoleClear();
            isValid = false;
            msg.titles(6);
            int searchId = Integer.parseInt(input);

            User foundUser = searchForUser(searchId, users);
            
            if (foundUser != null)
            {
                msg.warnings(9);
                System.out.println();
                System.out.println(foundUser.toString(msg));
                isValid = true;
            }
            
        }
        if(!isValid) msg.warnings(10);
        System.out.println();
        Utilities.pause(sc, msg);
        Utilities.consoleClear();
    } 

    public static void editUsers(Scanner sc, List<User> users, Messages msg)
    {
        boolean isValid = true;
        msg.titles(7);
        if (users.isEmpty()) 
        {
            msg.warnings(7);
            isValid = false;
        }
        else
        {
            String input;
            do
            {
                Utilities.consoleClear();
                msg.titles(7);
                if (!isValid)
                {
                    msg.warnings(8);
                    System.out.println();
                } 
                msg.inputs(2);
                input = sc.nextLine();
                
                isValid = Utilities.intTryParse(input);

            }while (!isValid);

            isValid = true;
            int searchId = Integer.parseInt(input);

            Utilities.consoleClear();
            msg.titles(7);
            for (User u : users)
            {
                if (u.getId() == searchId)
                {
                    String newName, inputAge;

                    do
                    {
                        Utilities.consoleClear();
                        msg.titles(7);
                        msg.warnings(11);
                        System.out.println();
                        if (!isValid)
                        {
                            msg.warnings(3);
                            System.out.println();
                        } 
                        msg.inputs(3);
                        newName = sc.nextLine();
                        if (newName.trim().isEmpty()) break;
            
                        isValid = Utilities.isOnlyLetters(newName);
                        if (isValid) u.setName(newName.trim().replaceAll("\\s{2,}", " ")); 
                    }while (!isValid);
                    
                    isValid = true;
                    int newAge = 0; 

                    do
                    {
                        Utilities.consoleClear();
                        msg.titles(7);
                        msg.warnings(11);
                        System.out.println();
                        if (!isValid)
                        {
                            msg.warnings(4);
                            System.out.println();
                        }
                        msg.inputs(4);
                        inputAge = sc.nextLine();
                        if (inputAge.trim().isEmpty())
                        {
                            newAge = u.getAge();
                            break;
                        } 
                        isValid = Utilities.intTryParse(inputAge);    
                        if (isValid)
                        {
                            newAge = Integer.parseInt(inputAge);
                            if (newAge < 10 || newAge > 120) isValid = false;
                        }
                    }while (!isValid); 
                        
                    u.setAge(newAge);

                    isValid = false;
                    Utilities.consoleClear();
                    msg.titles(7);
                    msg.warnings(5);
                }
            }
            BinaryFile.saveUserData(users, usersFileName);
        }
        if (isValid) msg.warnings(10);
        System.out.println();
        Utilities.pause(sc, msg);
        Utilities.consoleClear();
    } 

    public static void removeUsers(Scanner sc, List<User> users, Messages msg)
    {
        boolean isValid = true, emptyList = false;
        msg.titles(8);
        if (users.isEmpty()) 
        {
            msg.warnings(7);
            emptyList = true;
        }
        else
        {
            String input;
            do
            {
                Utilities.consoleClear();
                msg.titles(8);
                if (!isValid)
                {
                    msg.warnings(8);
                    System.out.println();
                } 
                msg.inputs(2);
                input = sc.nextLine();
                isValid = Utilities.intTryParse(input);
            }while (!isValid);

            int searchId = Integer.parseInt(input);

            Utilities.consoleClear();
            msg.titles(8);

            final int finalSearchId = searchId;
            isValid = users.removeIf(user -> user.getId() == finalSearchId);
        }
        if (isValid && !emptyList)
        {
            msg.warnings(12);
            BinaryFile.saveUserData(users, usersFileName);
        } 
        else if (!isValid && !emptyList) msg.warnings(10);
        System.out.println();
        Utilities.pause(sc, msg);
        Utilities.consoleClear();
    } 

    public static void bookMenu(Scanner sc, Messages msg, List<Book> books)
    {
        int menuChoose = 0;
            
        do
        {
            Utilities.consoleClear();
            msg.titles(9);
            msg.menus(3);
            
            String input = sc.nextLine();
            if (Utilities.intTryParse(input)) menuChoose = Integer.parseInt(input);
            Utilities.consoleClear();
                
            switch (menuChoose)
            {
                case 1 -> newBook(sc, books, msg);
                case 2 -> showBooks(sc, books, msg);
                case 3 -> searchBooks(sc, books, msg);
                case 4 -> editBooks(sc, books, msg);
                case 5 -> removeBooks(sc, books, msg);
                case 0 -> {}
                default -> 
                {
                    msg.titles(9);
                    msg.warnings(2);
                    System.out.println();
                    Utilities.pause(sc, msg);
                    Utilities.consoleClear();
                }
            }
        }while(menuChoose != 0);  
    }

    public static void newBook(Scanner sc, List<Book> books, Messages msg)
    {
        boolean isValid = true;
        String name, inputYear, descrip, author;
        LocalDate dateNow = LocalDate.now();
        int year = 0;

        do
        {
            Utilities.consoleClear();
            msg.titles(10);
            if (!isValid) 
            {
                msg.warnings(3);
                System.out.println();
            }
            msg.inputs(5);
            name = sc.nextLine();
            isValid = Utilities.containsLettersAndNumbers(name.trim());

        }while (!isValid);
    
        name = name.trim().replaceAll("\\s{2,}", " ");
        
        do
        {
            Utilities.consoleClear();
            msg.titles(10);
            if (!isValid) 
            {
                msg.warnings(3);
                System.out.println();
            }
            msg.inputs(6);
            author = sc.nextLine();
            isValid = Utilities.isOnlyLetters(author);

        }while (!isValid);

        author = author.trim().replaceAll("\\s{2,}", " ");

        do
        {
            Utilities.consoleClear();
            msg.titles(10);
            if (!isValid) 
            {
                msg.warnings(15);
                System.out.println();
            }
            msg.inputs(7);
            descrip = sc.nextLine();
            isValid = Utilities.isOnlyLetters(descrip);

        }while (!isValid);

        descrip = descrip.trim().replaceAll("\\s{2,}", " ");   
    
        do
        {
            Utilities.consoleClear();
            msg.titles(10);
            if (!isValid) 
            {
                msg.warnings(2);
                System.out.println();
            }
            msg.inputs(8);
            inputYear = sc.nextLine();
            isValid = Utilities.intTryParse(inputYear);
            if (isValid)
            {
                year = Integer.parseInt(inputYear);
               if (year < 1455 || year > dateNow.getYear()) isValid = false; 
            }
        }while (!isValid);

        if(books.isEmpty())books.add(new Book(1, name.toUpperCase(), author.toUpperCase(), descrip, year, true));
        else
        {
            int newId = books.get(books.size() - 1).getBookId() + 1;
            books.add(new Book(newId, name, author, descrip, year, true));
        }

        Utilities.consoleClear();
        msg.titles(10);
        if (BinaryFile.saveBookData(books, booksFileName)) msg.warnings(13);
        else msg.warnings(6);
        System.out.println();
        Utilities.pause(sc, msg);
        Utilities.consoleClear();
    }

    public static void showBooks(Scanner sc, List<Book> books, Messages msg)
    {
        msg.titles(11);
        if (books.isEmpty()) msg.warnings(14);
        else 
        {
            books = BinaryFile.readBookData(booksFileName);
            for (Book b : books)
            {
                System.out.print("----------------------------------------------\n");
                System.out.println(b.toString(msg));
                System.out.print("----------------------------------------------\n");
            } 
        }
        System.out.println();
        Utilities.pause(sc, msg);
        Utilities.consoleClear(); 
    }

    public static void searchBooks(Scanner sc, List<Book> books, Messages msg)
    {
        boolean isValid = true;
        msg.titles(12);
        if (books.isEmpty()) msg.warnings(14);
        else
        {
            String input;
            do
            {
                Utilities.consoleClear();
                msg.titles(12);
                if (!isValid)
                {
                    msg.warnings(8);
                    System.out.println();
                } 
                msg.inputs(9);
                input = sc.nextLine();
                
                isValid = Utilities.intTryParse(input);

            }while (!isValid);

            Utilities.consoleClear();
            isValid = false;
            msg.titles(12);
            int searchId = Integer.parseInt(input);

            Book bookFound = searchForBook(searchId, books);
            if (bookFound != null)
            {
                msg.warnings(16);
                System.out.println();
                System.out.println(bookFound.toString(msg));
                isValid = true;
            }

        }
        if (!isValid) msg.warnings(17);
        System.out.println();
        Utilities.pause(sc, msg);
        Utilities.consoleClear();
    }

    public static void editBooks(Scanner sc, List<Book> books, Messages msg)
    {
        msg.titles(13);
        if (books.isEmpty()) msg.warnings(14);
        else
        {
            boolean isValid = true, bookFound = false;
            String input;
            do
            {
                Utilities.consoleClear();
                msg.titles(13);
                if (!isValid)
                {
                    msg.warnings(8);
                    System.out.println();
                } 
                msg.inputs(9);
                input = sc.nextLine();
                
                isValid = Utilities.intTryParse(input);

            }while (!isValid);

            int searchId = Integer.parseInt(input);

            Utilities.consoleClear();
            msg.titles(13);
            for (Book b : books)
            {
                if (b.getBookId() == searchId)
                {
                    bookFound = true;
                    String newBookName, newBookAuthor, newBookDescrip, inputNewYear;
                    int newYear;
                    LocalDate dateNow = LocalDate.now();

                    do
                    {
                        Utilities.consoleClear();
                        msg.titles(13);
                        msg.warnings(11);
                        System.out.println();
                        if (!isValid)
                        {
                            msg.warnings(3);
                            System.out.println();
                        } 
                        msg.inputs(10);
                        newBookName = sc.nextLine();
                        if (newBookName.trim().isEmpty()) break;

                        isValid = Utilities.containsLettersAndNumbers(newBookName);
                    }while (!isValid);

                    b.setName(newBookName.trim().replaceAll("\\s{2,}", " ").toUpperCase()); 

                    do
                    {
                        Utilities.consoleClear();
                        msg.titles(13);
                        msg.warnings(11);
                        System.out.println();
                        if (!isValid)
                        {
                            msg.warnings(3);
                            System.out.println();
                        }
                        msg.inputs(11);
                        newBookAuthor = sc.nextLine();
                        if (newBookAuthor.trim().isEmpty()) break;
                        
                        isValid = Utilities.isOnlyLetters(newBookAuthor);
                    }while (!isValid); 

                    b.setAuthor(newBookAuthor.trim().replaceAll("\\s{2,}", " ").toUpperCase());

                    do
                    {
                        Utilities.consoleClear();
                        msg.titles(13);
                        msg.warnings(11);
                        System.out.println();
                        if (!isValid)
                        {
                            msg.warnings(15);
                            System.out.println();
                        }
                        msg.inputs(12);
                        newBookDescrip = sc.nextLine();
                        if (newBookDescrip.trim().isEmpty()) break;
                        
                        isValid = Utilities.isOnlyLetters(newBookDescrip);
                    }while (!isValid); 

                    b.setDescription(newBookDescrip.trim().replaceAll("\\s{2,}", " "));

                    do
                    {
                        Utilities.consoleClear();
                        msg.titles(13);
                        msg.warnings(11);
                        System.out.println();
                        if (!isValid)
                        {
                            msg.warnings(2);
                            System.out.println();
                        }
                        msg.inputs(13);
                        inputNewYear = sc.nextLine();
                        if (inputNewYear.trim().isEmpty()) break;
                        
                        isValid = Utilities.intTryParse(inputNewYear);
                        if (isValid) 
                        {
                            newYear = Integer.parseInt(inputNewYear);
                            if (newYear < 1455 || newYear > dateNow.getYear()) isValid = false; 
                            else b.setYear(newYear);
                        }
                    }while (!isValid); 
                }
            }
            Utilities.consoleClear();
            msg.titles(13);
            if (bookFound) 
            {
                msg.warnings(19);
                BinaryFile.saveBookData(books, booksFileName);
            }
            else msg.warnings(17);
        }
        System.out.println();
        Utilities.pause(sc, msg);
        Utilities.consoleClear();
    }

    public static void removeBooks(Scanner sc, List<Book> books, Messages msg)
    {
        msg.titles(14);
        if (books.isEmpty()) msg.warnings(14);
        else
        {
            boolean isValid = true;
            String input;
            do
            {
                Utilities.consoleClear();
                msg.titles(14);
                if (!isValid)
                {
                    msg.warnings(8);
                    System.out.println();
                } 
                msg.inputs(9);
                input = sc.nextLine();
                isValid = Utilities.intTryParse(input);
            }while (!isValid);

            int searchId = Integer.parseInt(input);

            Utilities.consoleClear();
            msg.titles(14);

            final int finalSearchId = searchId;
            isValid = books.removeIf(book -> book.getBookId() == finalSearchId);

            if (isValid)
            {
                msg.warnings(18);
                BinaryFile.saveBookData(books, booksFileName);
            } 
            else msg.warnings(17);
        }
        System.out.println();
        Utilities.pause(sc, msg);
        Utilities.consoleClear();
    }

    public static void reservationMenu(Scanner sc, Messages msg, List<Reservation> reservations, List<User> users, List<Book> books)
    {
        int menuChoose = 0;
            
        do
        {
            Utilities.consoleClear();
            msg.titles(15);
            msg.menus(4);
                
            String input = sc.nextLine();
            if (Utilities.intTryParse(input)) menuChoose = Integer.parseInt(input);
            Utilities.consoleClear();
                
            switch (menuChoose)
            {
                case 1 -> newReservation(sc, reservations, msg, users, books);
                case 2 -> showResPending(sc, reservations, msg);
                case 3 -> showResOverdue(sc, reservations, msg);
                case 4 -> showResHistory(sc, reservations, msg);
                case 5 -> markResAsReturned(sc, reservations, msg, books);
                case 6 -> searchReservation(sc, reservations, msg);
                case 7 -> cancelReservation(sc, reservations, msg, books);
                case 8 -> removeResFromHistory(sc, reservations, msg, books);
                case 0 -> { }
                default -> 
                {
                    msg.titles(9);
                    msg.warnings(2);
                    System.out.println();
                    Utilities.pause(sc, msg);
                    Utilities.consoleClear();
                }
            }
            
        }while(menuChoose != 0);  
    }

    public static void newReservation(Scanner sc, List<Reservation> reservations, Messages msg, List<User> users, List<Book> books)
    {
        msg.titles(16);
        if (users.isEmpty() || books.isEmpty()) msg.warnings(20);
        else
        {
            boolean isValid = true;
            String input;
            do
            {
                Utilities.consoleClear();
                msg.titles(16);
                if (!isValid)
                {
                    msg.warnings(8);
                    System.out.println();
                } 
                msg.inputs(14);
                input = sc.nextLine();
                
                isValid = Utilities.intTryParse(input);

            }while (!isValid);

            isValid = true;
            int searchUserId = Integer.parseInt(input);

            do
            {
                Utilities.consoleClear();
                msg.titles(16);
                if (!isValid)
                {
                    msg.warnings(8);
                    System.out.println();
                } 
                msg.inputs(15);
                input = sc.nextLine();
                
                isValid = Utilities.intTryParse(input);

            }while (!isValid);

            int searchBookId = Integer.parseInt(input);

            User foundUser = searchForUser(searchUserId, users);
            Book foundBook = searchForBook(searchBookId, books);

            Utilities.consoleClear();
            msg.titles(16);

            if (foundUser != null && foundBook != null && foundBook.getAvailable())
            {
                if (reservations.isEmpty()) reservations.add(new Reservation(1, foundUser, foundBook));
                else
                {
                    int newId = reservations.get(reservations.size() - 1).getReservationId() + 1;
                    reservations.add(new Reservation(newId, foundUser, foundBook));
                }

                BinaryFile.saveReservationData(reservations, reservationsFileName);
                books = setBookAvailable(books, foundBook);
                BinaryFile.saveBookData(books, booksFileName);
                msg.warnings(21);
            }
            else msg.warnings(22);
        }
        System.out.println();
        Utilities.pause(sc, msg);
        Utilities.consoleClear();
    }

    public static void showResPending(Scanner sc, List<Reservation> reservations, Messages msg)
    {
        msg.titles(17);
        if (reservations.isEmpty()) msg.warnings(23);
        else
        {
            boolean findPending = false;
            for(Reservation r : reservations)
            {
                if (!r.reservationExpired() && !r.isReturnedBook() && !r.isReservationCanceled())
                {
                    System.out.print("----------------------------------------------\n");
                    System.out.println(r.toString(msg));
                    System.out.print("----------------------------------------------\n");
                    findPending = true;
                }
            }
            if (!findPending) msg.warnings(25); 
        }
        System.out.println();
        Utilities.pause(sc, msg);
        Utilities.consoleClear();
    }

    public static void showResOverdue(Scanner sc, List<Reservation> reservations, Messages msg)
    {
        msg.titles(18);
        if (reservations.isEmpty()) msg.warnings(23);
        else
        {
            boolean foundOverdue = false;
            for(Reservation r : reservations)
            {
                if (r.reservationExpired() && !r.isReturnedBook() && !r.isReservationCanceled())
                {
                    System.out.print("----------------------------------------------\n");
                    System.out.println(r.toString(msg));
                    System.out.print("----------------------------------------------\n");
                    foundOverdue = true;
                }
            }
            if(!foundOverdue) msg.warnings(24);
        }
        System.out.println();
        Utilities.pause(sc, msg);
        Utilities.consoleClear();
    }

    public static void showResHistory(Scanner sc, List<Reservation> reservations, Messages msg)
    {
        msg.titles(19);
        if (reservations.isEmpty()) msg.warnings(25);
        else
        {
            for(Reservation r : reservations)
            {
                System.out.print("----------------------------------------------\n");
                System.out.println(r.toString(msg));
                System.out.print("----------------------------------------------\n");
            }
        }
        System.out.println();
        Utilities.pause(sc, msg);
        Utilities.consoleClear();
    }

    public static void markResAsReturned(Scanner sc, List<Reservation> reservations, Messages msg, List<Book> books)
    {
        msg.titles(20);
        if (reservations.isEmpty()) msg.warnings(23);
        else
        {
            boolean isValid = true, foundReservation = false;
            String input;
            do
            {
                Utilities.consoleClear();
                msg.titles(20);
                if (!isValid) 
                {
                    msg.warnings(8);
                    System.out.println();
                }
                msg.inputs(16);
                input = sc.nextLine();
                isValid = Utilities.intTryParse(input);

            }while (!isValid);

            int searchId = Integer.parseInt(input);

            Utilities.consoleClear();
            msg.titles(20);

            for (Reservation r : reservations)
            {
                if (r.getReservationId() == searchId && !r.isReservationCanceled() && !r.isReturnedBook())
                {
                    foundReservation = true;
                    r.markAsReturned();
                }
            }
            
            if (!foundReservation) msg.warnings(26);
            else
            {
                Book foundBook = searchForBook(searchId, books);
                books = setBookAvailable(books, foundBook);

                BinaryFile.saveReservationData(reservations, reservationsFileName);
                BinaryFile.saveBookData(books, booksFileName);
                msg.warnings(27);
            } 
        }
        System.out.println();
        Utilities.pause(sc, msg);
        Utilities.consoleClear();
    }

    public static void searchReservation(Scanner sc, List<Reservation> reservations, Messages msg)
    {
        msg.titles(21);
        if (reservations.isEmpty()) msg.warnings(23);
        else
        {
            boolean isValid = true, reservationFound = false;
            String input;
            do
            {
                Utilities.consoleClear();
                msg.titles(21);
                if (!isValid)
                {
                    msg.warnings(8);
                    System.out.println();
                } 
                msg.inputs(14);
                input = sc.nextLine();
                
                isValid = Utilities.intTryParse(input);

            }while (!isValid);

            int searchId = Integer.parseInt(input);
            
            Utilities.consoleClear();
            msg.titles(21);

            for (Reservation r : reservations)
            {
                if (r.getReservationId() == searchId)
                {
                    reservationFound = true;
                    System.out.println(r.toString(msg));
                }
            }
            if (!reservationFound) msg.warnings(26);
        }
        System.out.println();
        Utilities.pause(sc, msg);
        Utilities.consoleClear();
    }

    public static void cancelReservation(Scanner sc, List<Reservation> reservations, Messages msg, List<Book> books)
    {
        msg.titles(22);
        if (reservations.isEmpty()) msg.warnings(23);
        else
        {
            boolean isValid = true, IsReservationValid = false;
            String input;
            do
            {
                Utilities.consoleClear();
                msg.titles(22);
                if (!isValid)
                {
                    msg.warnings(8);
                    System.out.println();
                } 
                msg.inputs(14);
                input = sc.nextLine();
                
                isValid = Utilities.intTryParse(input);

            }while (!isValid);

            int searchId = Integer.parseInt(input);
            
            Utilities.consoleClear();
            msg.titles(22);

            for (Reservation r : reservations)
            {
                if (r.getReservationId() == searchId && !r.isReturnedBook() && !r.isReservationCanceled())
                {
                    r.setReservationCanceled(true);   
                    IsReservationValid = true;
                }
            }

            if (IsReservationValid) 
            {
                msg.warnings(28);
                Book foundBook = searchForBook(searchId, books);
                books = setBookAvailable(books, foundBook);

                BinaryFile.saveBookData(books, booksFileName);
            }
            else msg.warnings(26);  
        }
        System.out.println();
        Utilities.pause(sc, msg);
        Utilities.consoleClear();
    }

    public static void removeResFromHistory(Scanner sc, List<Reservation> reservations, Messages msg, List<Book> books)
    {
        msg.titles(23);
        if (reservations.isEmpty()) msg.warnings(26);
        else
        {
            boolean isValid = true, IsRemoved;
            String input;
            do
            {
                Utilities.consoleClear();
                msg.titles(23);
                if (!isValid)
                {
                    msg.warnings(8);
                    System.out.println();
                } 
                msg.inputs(14);
                input = sc.nextLine();
                
                isValid = Utilities.intTryParse(input);

            }while (!isValid);

            int searchId = Integer.parseInt(input);
            
            Utilities.consoleClear();
            msg.titles(23);

            final int finalSearchId = searchId;
            IsRemoved = reservations.removeIf(Reservation -> Reservation.getReservationId() == finalSearchId);

            if (IsRemoved)
            {
                msg.warnings(29);
                
                Book foundBook = searchForBook(searchId, books);
                books = setBookAvailable(books, foundBook);

                BinaryFile.saveReservationData(reservations, reservationsFileName);
                BinaryFile.saveBookData(books, booksFileName);
            }
            else msg.warnings(26);
        }
        System.out.println();
        Utilities.pause(sc, msg);
        Utilities.consoleClear();
    }
    public static void main(String[] args)
    {
        {Scanner sc = new Scanner(System.in);
            
            Messages msg = new Messages();
            int language = selectLanguage(sc, msg);
            
            Utilities.consoleClear();

            if (language != 0)
            {
                List<User> users = new ArrayList<>(); 
                List<Book> books = new ArrayList<>();
                List<Reservation> reservations = new ArrayList<>();
                users = BinaryFile.readUserData(usersFileName);
                books = BinaryFile.readBookData(booksFileName);
                reservations = BinaryFile.readReservationData(reservationsFileName);
                msg.setLanguage(language);
                mainMenu(sc, msg, users, books, reservations);
            }
            else
            {
                msg.titles(1);
                msg.warnings(1);
                sc.close();
            }
        }
    }
}