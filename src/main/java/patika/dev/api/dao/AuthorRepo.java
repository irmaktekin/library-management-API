package patika.dev.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import patika.dev.api.entities.Author;

@Repository
public interface AuthorRepo extends JpaRepository<Author,Integer> {
}
