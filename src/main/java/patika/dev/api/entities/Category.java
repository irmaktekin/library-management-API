package patika.dev.api.entities;

import jakarta.persistence.*;

import java.util.List;

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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public Category() {
    }
}
