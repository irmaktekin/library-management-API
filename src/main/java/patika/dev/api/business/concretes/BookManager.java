package patika.dev.api.business.concretes;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import patika.dev.api.business.abstratcs.IBookService;
import patika.dev.api.core.exception.NotFoundException;
import patika.dev.api.dao.BookRepo;
import patika.dev.api.dao.CategoryRepo;
import patika.dev.api.entities.Book;
import patika.dev.api.entities.Category;

import java.util.List;

@Service
public class BookManager implements IBookService {
    private final BookRepo bookRepo;

    public BookManager(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }


    @Override
    public Book save(Book book) {
        return this.bookRepo.save(book);
    }

    public Page<Book> cursor(int page, int pageSize) {

        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Book> bookPage = this.bookRepo.findAll(pageable);
        if (bookPage.isEmpty()) {
            throw new NotFoundException("No books found");
        }
        return bookPage;
    }


}
