package patika.dev.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import patika.dev.api.entities.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Integer> {
}
