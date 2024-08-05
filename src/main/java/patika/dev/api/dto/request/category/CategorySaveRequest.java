package patika.dev.api.dto.request.category;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import patika.dev.api.entities.Book;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategorySaveRequest {

    @NotNull(message = "Book ID must have value")
    private List<Long> bookId;
    @NotNull(message = "Category name must have value")
    private String categoryName;
    @NotNull(message = "Description must have value")
    private String categoryDescription;

}
