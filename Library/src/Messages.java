public class Messages 
{
    private int language;

    public Messages() {language = 1;}

    public Messages(int language) {this.language = language;}

    public void setLanguage(int language) {this.language = language;}

    public int getLanguage() {return language;}
    
    public void titles(int titleId)
    {
        if(language == 1)
        {
            switch (titleId) 
            {
                case 0 -> System.out.println("\t---'SELECT LANGUAGE'---\n");
                case 1 -> System.out.println("\t---'GOOD BYE'---\n");
                case 2 -> System.out.println("\t---'MAIN MENU'---\n");
                case 3 -> System.out.println("\t---'USER MANAGER'---\n");
                case 4 -> System.out.println("\t---'NEW USER'---\n");
                case 5 -> System.out.println("\t---'SHOW USERS'---\n");
                case 6 -> System.out.println("\t---'SEARCH USERS'---\n");
                case 7 -> System.out.println("\t---'EDIT USERS'---\n");
                case 8 -> System.out.println("\t---'REMOVE USERS'---\n");
                case 9 -> System.out.println("\t---'BOOK MANAGER'---\n");
                case 10 -> System.out.println("\t---'NEW BOOK'---\n");
                case 11 -> System.out.println("\t---'SHOW BOOKS'---\n");
                case 12 -> System.out.println("\t---'SEARCH BOOKS'---\n");
                case 13 -> System.out.println("\t---'EDIT BOOKS'---\n");
                case 14 -> System.out.println("\t---'REMOVE BOOKS'---\n");
                case 15 -> System.out.println("\t---'MANAGE RESERVATIONS'---\n");
                case 16 -> System.out.println("\t---'NEW RESERVATION'---\n");
                case 17 -> System.out.println("\t---'SHOW PENDING RESERVATIONS'---\n");
                case 18 -> System.out.println("\t---'SHOW OVERDUE RESERVATIONS'---\n");
                case 19 -> System.out.println("\t---'SHOW RESERVATION HISTORY'---\n");
                case 20 -> System.out.println("\t---'MARK RESERVATION AS RETURNED'---\n");
                case 21 -> System.out.println("\t---'SEARCH RESERVATION'---\n");
                case 22 -> System.out.println("\t---'CANCEL RESERVATION'---\n");
                case 23 -> System.out.println("\t---'REMOVE RESERVATION'---\n");
                default -> System.out.println("[Error finding title]");
            }
        }
        else
        {
            switch (titleId) 
            {
                case 2 -> System.out.println("\t---'MENU PRINCIPAL'---\n");
                case 3 -> System.out.println("\t---'GERENCIADOR DE USUÁRIOS'---\n");
                case 4 -> System.out.println("\t---'NOVO USUÁRIO'---\n");
                case 5 -> System.out.println("\t---'MOSTRAR USUÁRIOS'---\n");
                case 6 -> System.out.println("\t---'PESQUISAR USUÁRIOS'---\n");
                case 7 -> System.out.println("\t---'EDITAR USUÁRIOS'---\n");
                case 8 -> System.out.println("\t---'REMOVER USUÁRIOS'---\n");
                case 9 -> System.out.println("\t---'GERENCIADOR DE LIVROS---\n");
                case 10 -> System.out.println("\t---'NOVO LIVRO'---\n");
                case 11 -> System.out.println("\t---'MOSTRAR LIVROS'---\n");
                case 12 -> System.out.println("\t---'PESQUISAR LIVROS'---\n");
                case 13 -> System.out.println("\t---'EDITAR LIVROS'---\n");
                case 14 -> System.out.println("\t---'REMOVER LIVROS'---\n");
                case 15 -> System.out.println("\t---'GERENCIADOR DE RESERVAS'---\n");
                case 16 -> System.out.println("\t---'NOVA RESERVA'---\n");
                case 17 -> System.out.println("\t---'MOSTRAR RESERVAS PENDENTES'---\n");
                case 18 -> System.out.println("\t---'MOSTRAR RESERVAS ATRASADAS'---\n");
                case 19 -> System.out.println("\t---'MOSTRAR HISTÓRICO DE RESERVAS'---\n");
                case 20 -> System.out.println("\t---'DAR BAIXA EM RESERVA'---\n");
                case 21 -> System.out.println("\t---'PESQUISAR RESERVA'---\n");
                case 22 -> System.out.println("\t---'CANCELAR RESERVA'---\n");
                case 23 -> System.out.println("\t---'REMOVER RESERVA'---\n");
                default -> System.out.println("[Erro ao encontrar titulo]");
            }
        }
    }
    public void warnings(int warningId)
    {
        if(language == 1)
        {
            switch (warningId)
             {
                case 0 -> System.out.println("> Enter a valid language!\n");
                case 1 -> System.out.println("> System closed!");
                case 2 -> System.out.println("> Enter a valid number!");
                case 3 -> System.out.println("> Enter a valid name!");
                case 4 -> System.out.println("> Enter a valid age!");
                case 5 -> System.out.println("> User successfully registered!");
                case 6 -> System.out.println("> Error saving file!");
                case 7 -> System.out.println("> There are no registered users!");
                case 8 -> System.out.println("> Enter a valid ID!");
                case 9 -> System.out.println("> User found!");
                case 10 -> System.out.println("> User not found!");
                case 11 -> System.out.println("> Enter the new data (Press ENTER to keep it as is):");
                case 12 -> System.out.println("> User sucessfully removed!");
                case 13 -> System.out.println("> Book sucessfully registered!");
                case 14 -> System.out.println("> There are no registered books!");
                case 15 -> System.out.println("> Enter a valid description!");
                case 16 -> System.out.println("> Book found!");
                case 17 -> System.out.println("> Book not found!");
                case 18 -> System.out.println("> Book sucessfully removed!");
                case 19 -> System.out.println("> Book sucessfully edited!");
                case 20 -> System.out.println("> There are no registered users or books!");
                case 21 -> System.out.println("> Reservation registered successfully!");
                case 22 -> System.out.println("> User or book not found!");
                case 23 -> System.out.println("> There are no registered reservations!");
                case 24 -> System.out.println("> There are no overdue reservations!");
                case 25 -> System.out.println("> There are no pending reservations!");
                case 26 -> System.out.println("> Reservation not found!");
                case 27 -> System.out.println("> Reservation returned sucessfully!");
                case 28 -> System.out.println("> Reservation canceled sucessfully!");
                case 29 -> System.out.println("> Reservation removed sucessfully!");
                default -> System.out.println("[Error finding warning]");
            }
        }
        else
        {
            switch (warningId) 
            {
                case 1 -> System.out.println("> Sistema encerrado!");
                case 2 -> System.out.println("> Digite um número válido!");
                case 3 -> System.out.println("> Digite um nome válido!");
                case 4 -> System.out.println("> Digite uma idade válida!");
                case 5 -> System.out.println("> Usuário registrado com sucesso!");
                case 6 -> System.out.println("> Erro ao salvar arquivo!");
                case 7 -> System.out.println("> Não há usuários cadastrados!");
                case 8 -> System.out.println("> Digite um ID válido!");
                case 9 -> System.out.println("> Usuário encontrado!");
                case 10 -> System.out.println("> Usuário não encontrado!");
                case 11 -> System.out.println("> Digite os novos dados(Pressione ENTER para mantê-los como estão):");
                case 12 -> System.out.println("> Usuário removido com sucesso!");
                case 13 -> System.out.println("> Livro registrado com sucesso!");
                case 14 -> System.out.println("> Não há livros cadastrados!");
                case 15 -> System.out.println("> Digite uma descrição válida!");
                case 16 -> System.out.println("> Livro encontrado!");
                case 17 -> System.out.println("> Livro não encontrado!");
                case 18 -> System.out.println("> Livro removido com sucesso!");
                case 19 -> System.out.println("> Livro editado com sucesso!");
                case 20 -> System.out.println("> Não há usuários ou livros cadstrados!");
                case 21 -> System.out.println("> Reserva registrada com sucesso!");
                case 22 -> System.out.println("> Usuário ou livro não encontrado!");
                case 23 -> System.out.println("> Não há reservas cadastradas!");
                case 24 -> System.out.println("> Não há reservas vencidas!");
                case 25 -> System.out.println("> Não há reservas pendentes!");
                case 26 -> System.out.println("> Reserva não encontrada!");
                case 27 -> System.out.println("> Reserva retornada com sucesso!");
                case 28 -> System.out.println("> Reserva cancelada com sucesso!");
                case 29 -> System.out.println("> Reserva removida com sucesso!");
                default -> System.out.println("[Erro ao encontrar aviso]");
            }
        }
    }
    public void menus(int menuId)
    {
        if(language == 1)
        {
            switch (menuId) 
            {
                case 0 -> {
                    System.out.println("[1] - English");
                    System.out.println("[2] - Português");
                    System.out.println("[0] - Exit\n");
                    System.out.print("|: ");
                }

                case 1 -> {
                    System.out.println("[1] - Manage Users");
                    System.out.println("[2] - Manage Books");
                    System.out.println("[3] - Manage Reservations");
                    System.out.println("[0] - Exit\n");
                    System.out.print("|: ");
                }
                case 2 -> {
                    System.out.println("[1] - New user");
                    System.out.println("[2] - Show users");
                    System.out.println("[3] - Search users");
                    System.out.println("[4] - Edit users");
                    System.out.println("[5] - Remove users");
                    System.out.println("[0] - Back");
                    System.out.print("\n|: ");
                }
                case 3 -> {
                    System.out.println("[1] - New book");
                    System.out.println("[2] - Show books");
                    System.out.println("[3] - Search books");
                    System.out.println("[4] - Edit books");
                    System.out.println("[5] - Remove books");
                    System.out.println("[0] - Back");
                    System.out.print("\n|: ");
                }
                case 4 -> {
                    System.out.println("[1] - New reservation");
                    System.out.println("[2] - Show pending reservations");
                    System.out.println("[3] - Show overdue reservations");
                    System.out.println("[4] - Show reservation history");
                    System.out.println("[5] - Mark reservation as returned");
                    System.out.println("[6] - Search reservation");
                    System.out.println("[7] - Cancel reservation");
                    System.out.println("[8] - Remove reservation from history");
                    System.out.println("[0] - Back");
                    System.out.print("\n|: ");
                }
                default -> System.out.println("[Error finding menu]");
            }
        }
        else
        {
            switch (menuId)
             {
                case 1 -> {
                    System.out.println("[1] - Gerenciar usuários");
                    System.out.println("[2] - Gerenciar livros");
                    System.out.println("[3] - Gerenciar reservas");
                    System.out.println("[0] - Sair");
                    System.out.print("\n|: ");
                }
                case 2 -> {
                    System.out.println("[1] - Novo usuário");
                    System.out.println("[2] - Mostrar usuários");
                    System.out.println("[3] - Pesquisar usuários");
                    System.out.println("[4] - Editar usuários");
                    System.out.println("[5] - Remover usuários");
                    System.out.println("[0] - Voltar");
                    System.out.print("\n|: ");
                }
                case 3 -> {
                    System.out.println("[1] - Novo livro");
                    System.out.println("[2] - Mostrar livros");
                    System.out.println("[3] - Pesquisar livros");
                    System.out.println("[4] - Editar livros");
                    System.out.println("[5] - Remover livros");
                    System.out.println("[0] - Voltar");
                    System.out.print("\n|: ");
                }
                case 4 -> {
                    System.out.println("[1] - Nova reserva");
                    System.out.println("[2] - Mostrar reservas pendentes");
                    System.out.println("[3] - Mostrar reservas atrasadas");
                    System.out.println("[4] - Mostrar histórico de reservas");
                    System.out.println("[5] - Dar baixa em reserva");
                    System.out.println("[6] - Pesquisar reserva");
                    System.out.println("[7] - Cancelar reserva");
                    System.out.println("[8] - Remover reserva do histórico");
                    System.out.println("[0] - Voltar");
                    System.out.print("\n|: ");
                }
                default -> System.out.println("[Erro ao encontrar menu]");
            }
        }
    }
    public void inputs(int inputId)
    {
        if (language == 1)
        {
            switch (inputId)
            {
                case 0 -> System.out.print("|Enter username: ");
                case 1 -> System.out.print("|Enter user age: ");
                case 2 -> System.out.print("|Enter user ID: ");
                case 3 -> System.out.print("|Enter new username: ");
                case 4 -> System.out.print("|Enter new age: ");
                 case 5 -> System.out.print("|Enter book name: ");
                case 6 -> System.out.print("|Enter author name: ");
                case 7 -> System.out.print("|Enter book description: ");
                case 8 -> System.out.print("|Enter book release year: ");
                case 9 -> System.out.print("|Enter book ID: ");
                case 10 -> System.out.print("|Enter new book name: ");
                case 11 -> System.out.print("|Enter new author name: ");
                case 12 -> System.out.print("|Enter new book description: ");
                case 13 -> System.out.print("|Enter new book release year: ");
                case 14 -> System.out.print("|Enter the user ID for the reservation: ");
                case 15 -> System.out.print("|Enter the book ID for the reservation: ");
                case 16 -> System.out.print("|Enter reservation ID: ");
                default -> System.out.println("[Error finding input]");
            }
        }
        else
        {
            switch (inputId)
            {
                case 0 -> System.out.print("|Digite o nome do usuário: ");
                case 1 -> System.out.print("|Digite a idade do usuário: ");
                case 2 -> System.out.print("|Digite o ID do usuário: ");
                case 3 -> System.out.print("|Digite o novo nome: ");
                case 4 -> System.out.print("|Digite a nova idade: ");
                case 5 -> System.out.print("|Digite o nome do livro: ");
                case 6 -> System.out.print("|Digite o nome do autor: ");
                case 7 -> System.out.print("|Digite a descrição: ");
                case 8 -> System.out.print("|Digite o ano do livro(lançamento): ");
                case 9 -> System.out.print("|Digite o ID do livro: ");
                case 10 -> System.out.print("|Digite o novo nome do livro: ");
                case 11 -> System.out.print("|Digite o novo nome do autor: ");
                case 12 -> System.out.print("|Digite a nova descrição do livro: ");
                case 13 -> System.out.print("|Digite o novo ano do livro(lançamento): ");
                case 14 -> System.out.print("|Digite o ID do usuário para a reserva: ");
                case 15 -> System.out.print("|Digite o ID do livro para a reserva: ");
                case 16 -> System.out.print("|Digite o ID da reserva: ");
                default -> System.out.println("[Erro ao encontrar input]");
            }
        }
    }
}
