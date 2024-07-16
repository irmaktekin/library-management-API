package patika.dev.api.entities;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Entity
@Table(name = "book_borrowing")
public class BookBorrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int id;

    @Column(name = "borrower_name",length = 100, nullable = false)
    private String borrowerName;

    @Temporal(TemporalType.DATE)
    @Column(name = "borrowing_date", nullable = false)
    private java.util.Date borrowingDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "return_date")
    private java.util.Date returnDate;

    @ManyToOne
    @JoinColumn(name="borrowing_book_id", referencedColumnName ="book_id")
    private Book book;

    public Date getBorrowingDate() {
        return borrowingDate;
    }

    public void setBorrowingDate(Date borrowingDate) {
        this.borrowingDate = borrowingDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BookBorrowing() {
    }
}

