package patika.dev.api.business.abstratcs;

import org.springframework.data.domain.Page;
import patika.dev.api.entities.Author;
import patika.dev.api.entities.BookBorrow;

public interface BookBorrowingService {
    BookBorrow save (BookBorrow bookBorrowing);
    Page<BookBorrow> cursor (int page, int pageSize);
    BookBorrow update(BookBorrow bookBorrow);
    BookBorrow get(long id);

}
