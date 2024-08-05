package patika.dev.api.business.abstratcs;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import patika.dev.api.entities.Author;
import patika.dev.api.entities.Book;
import patika.dev.api.entities.Publisher;

public interface IPublisherService {
    Publisher save (Publisher publisher);
    Page<Publisher> cursor (int page, int pageSize);
    Publisher update(Publisher publisher);
    Publisher get(long id);

}
