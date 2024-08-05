package patika.dev.api.business.abstratcs;

import org.springframework.data.domain.Page;
import patika.dev.api.entities.Category;
import patika.dev.api.entities.Publisher;

public interface ICategoryService {
    Category save (Category category);
    Page<Category> cursor (int page, int pageSize);


}
