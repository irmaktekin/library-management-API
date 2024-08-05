package patika.dev.api.business.abstratcs;

import org.springframework.data.domain.Page;
import patika.dev.api.entities.Author;
import patika.dev.api.entities.Book;

public interface IAuthorService{
    Author save (Author author);
    Author update(Author author);
    Author get(long id);
    Page<Author> cursor (int page, int pageSize);



}
