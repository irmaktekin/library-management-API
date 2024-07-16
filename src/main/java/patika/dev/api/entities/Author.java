package patika.dev.api.entities;


import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private int id;

    @OneToMany(mappedBy = "author",cascade = CascadeType.PERSIST,fetch =FetchType.EAGER)
    private List<Book> books;

    @Column(name = "author_name",length = 100, nullable = false)
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date", nullable = false)
    private java.util.Date birthDate;

    @Column(name = "author_country", nullable = false)
    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author() {
    }
    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", country='" + country + '\'' +
                '}';
    }
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
