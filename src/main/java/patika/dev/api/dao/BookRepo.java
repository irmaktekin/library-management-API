package patika.dev.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import patika.dev.api.entities.Book;

import java.util.List;

public interface BookRepo extends JpaRepository<Book,Long> {

}
