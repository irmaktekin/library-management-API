package patika.dev.api.business.abstratcs;

import org.springframework.data.domain.Page;
import patika.dev.api.entities.Book;
import patika.dev.api.entities.Category;

import java.util.List;

public interface IBookService {
    Book save (Book book);
    Page<Book> cursor (int page, int pageSize);


}
