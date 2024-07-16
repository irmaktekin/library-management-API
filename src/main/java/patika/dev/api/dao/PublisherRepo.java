package patika.dev.api.dao;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import patika.dev.api.entities.Category;
import patika.dev.api.entities.Publisher;

@Repository
public interface PublisherRepo extends JpaRepository<Publisher, Integer> {
}
