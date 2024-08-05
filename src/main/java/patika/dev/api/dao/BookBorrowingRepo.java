package patika.dev.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import patika.dev.api.entities.BookBorrow;

@Repository
public interface BookBorrowingRepo extends JpaRepository<BookBorrow,Integer> {
}
