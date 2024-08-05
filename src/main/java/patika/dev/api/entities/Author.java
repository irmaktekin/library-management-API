package patika.dev.api.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private int id;

    @OneToMany(mappedBy = "author",cascade = CascadeType.PERSIST,fetch =FetchType.EAGER)
    private List<Book> books;

    @Column(name = "author_name",length = 100, nullable = false)
    private String author_name;

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date", nullable = false)
    private java.util.Date birthDate;

    @Column(name = "author_country", nullable = false)
    private String author_country;


}
