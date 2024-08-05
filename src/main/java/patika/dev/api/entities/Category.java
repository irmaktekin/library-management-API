package patika.dev.api.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int id;

    @ManyToMany(mappedBy = "categoryList")
    private List<Book> books;

    @Column(name = "category_name",length = 100, nullable = false)
    private String categoryName;

    @Column(name = "category_description",length = 300, nullable = false)
    private String categoryDescription;

}
