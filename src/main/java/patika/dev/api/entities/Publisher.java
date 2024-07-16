package patika.dev.api.entities;


import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "publisher")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id")
    private int id;

    @OneToMany(mappedBy = "publisher",cascade = CascadeType.PERSIST, fetch =FetchType.EAGER)
    private List<Book> books;

    @Column(name = "publisher_name",length = 100, nullable = false)
    private String publisherName;

    @Temporal(TemporalType.DATE)
    @Column(name = "establish_year", nullable = false)
    private java.util.Date establishYear;

    @Column(name = "publisher_address",length = 200, nullable = false)
    private String publisherAddress;

    public Date getEstablishYear() {
        return establishYear;
    }

    public void setEstablishYear(Date establishYear) {
        this.establishYear = establishYear;
    }

    public String getPublisherAddress() {
        return publisherAddress;
    }

    public void setPublisherAddress(String publisherAddress) {
        this.publisherAddress = publisherAddress;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Publisher() {
    }

}

