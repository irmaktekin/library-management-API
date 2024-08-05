package patika.dev.api.business.concretes;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import patika.dev.api.business.abstratcs.BookBorrowingService;
import patika.dev.api.core.exception.NotFoundException;
import patika.dev.api.dao.BookBorrowingRepo;
import patika.dev.api.entities.BookBorrow;
import patika.dev.api.entities.Publisher;

@Service
public class BookBorrowManager implements BookBorrowingService {
    private final BookBorrowingRepo bookBorrowingRepo;

    public BookBorrowManager(BookBorrowingRepo bookBorrowingRepo) {
        this.bookBorrowingRepo = bookBorrowingRepo;
    }


    @Override
    public BookBorrow save(BookBorrow bookBorrowing) {
        return this.bookBorrowingRepo.save(bookBorrowing);
    }

    @Override
    public Page<BookBorrow> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page,pageSize);
        Page<BookBorrow> bookBorrowings = this.bookBorrowingRepo.findAll(pageable);
        if (bookBorrowings.isEmpty()) {
            throw new NotFoundException("No book is borrowed.");
        }
        return bookBorrowings;
    }
    @Override
    public BookBorrow update(BookBorrow bookBorrow) {
        if(!bookBorrowingRepo.existsById(Math.toIntExact(bookBorrow.getId()))) {
            throw new NotFoundException("Book borrowing with book ID " + bookBorrow.getId() + " does not exist");
        }
        this.get(bookBorrow.getId());
        return this.bookBorrowingRepo.save(bookBorrow);
    }

    @Override
    public BookBorrow get(long id) {
        return this.bookBorrowingRepo.findById((int)id).orElseThrow(() -> new NotFoundException("Borrowing for book " + id + " does not exist"));
    }
}
