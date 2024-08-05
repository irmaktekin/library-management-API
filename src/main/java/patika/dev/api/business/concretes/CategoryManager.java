package patika.dev.api.business.concretes;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import patika.dev.api.business.abstratcs.ICategoryService;
import patika.dev.api.core.exception.NotFoundException;
import patika.dev.api.dao.CategoryRepo;
import patika.dev.api.dao.PublisherRepo;
import patika.dev.api.entities.Book;
import patika.dev.api.entities.Category;
import patika.dev.api.entities.Publisher;

@Service
public class CategoryManager implements ICategoryService {
    private final CategoryRepo categoryRepo;

    public CategoryManager(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }


    @Override
    public Category save(Category category) {
        return this.categoryRepo.save(category);
    }
    public Page<Category> cursor(int page, int pageSize) {

        Pageable pageable = PageRequest.of(page,pageSize);
        Page<Category> categoryPage = this.categoryRepo.findAll(pageable);
        if (categoryPage.isEmpty()) {
            throw new NotFoundException("No categories found");
        }
        return categoryPage;
    }

}
