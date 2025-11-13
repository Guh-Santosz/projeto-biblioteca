import java.io.Serializable;
import java.time.LocalDate;

public class Reservation implements Serializable
{
    private static final long serialVersionUID = 1L;
    private int reservationId;
    private User user;
    private Book book;
    private LocalDate date;
    private boolean returnedBook;
    private boolean reservationCanceled;

    public Reservation(int reservationId, User user, Book book) 
    {
        this.reservationId = reservationId;
        this.book = book;
        this.user = user;
        date = LocalDate.now().plusWeeks(2);
        returnedBook = false;
        reservationCanceled = false;
    }

    public int getReservationId() {return reservationId;}

    public void setReservationId(int reservationId) {this.reservationId = reservationId;}
    
    public User getUser() {return user;}

    public void setUser(User user) {this.user = user;}

    public Book getBook() {return book;}

    public void setBook(Book book) {this.book = book;}

    public LocalDate getDate() {return date;}

    public void setDate(LocalDate date) {this.date = date;}

    public boolean isReturnedBook() {return returnedBook;}

    public boolean reservationExpired() {return getDate().isBefore(LocalDate.now());}

    public void markAsReturned() {returnedBook = true;}

    public boolean isReservationCanceled() {return reservationCanceled;}

    public void setReservationCanceled(boolean reservationCanceled) {this.reservationCanceled = reservationCanceled;}

    public String toString(Messages msg)
    {
        if (msg.getLanguage() == 1) return "|RESERVATION ID: " + getReservationId() + (reservationCanceled ? "| (X) - CANCELED\n" : "|\n") + "\n> BOOK: |ID: " + book.getBookId() + "| |Book name: " + book.getName() +"|\n\n" +"> USER: |ID: " + user.getId() + "| |Username: " + user.getName() + "|\n\n" + "> STATUS: |Returned: " + (isReturnedBook() ? "Yes|" : "No|") + "\n\n> RETURN DATE: |" + Utilities.formatDate(msg, date) + "|" + (isReservationCanceled() ? "\n\n> CANCELED: |Yes|" : "");
        else return "|ID RESERVA: " + getReservationId() + (reservationCanceled ? "| (X) - CANCELADA\n" : "|\n") + "\n> LIVRO: |ID: " + book.getBookId() + "| |Nome do livro: " + book.getName() +"|\n\n" +"> USUÁRIO: |ID: " + user.getId() + "| |Nome do usuário: " + user.getName() + "|\n\n" + "> STATUS: |Devolvido: " + (isReturnedBook() ? "Sim|" : "Não|") + "\n\n> DATA DE RETORNO: |" + Utilities.formatDate(msg, date) + "|" + (isReservationCanceled() ? "\n\n> CANCELADO: |Sim|" : "");
    }
}