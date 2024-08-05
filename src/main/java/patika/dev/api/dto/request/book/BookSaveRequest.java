package patika.dev.api.dto.request.book;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookSaveRequest {
    @NotNull
    private String name;
    @NotNull
    private Integer publication_year;
    @NotNull
    private Long author;
    @NotNull
    private Long  publisher;
    @NotNull
    private Integer book_stock;

}
