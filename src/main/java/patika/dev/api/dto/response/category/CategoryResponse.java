package patika.dev.api.dto.response.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponse {

        private int id;
        private String categoryName;
        private String categoryDescription;
        private List<Long> bookId;

}
