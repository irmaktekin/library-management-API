package patika.dev.api.business.concretes;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import patika.dev.api.business.abstratcs.IPublisherService;
import patika.dev.api.core.exception.NotFoundException;
import patika.dev.api.dao.PublisherRepo;
import patika.dev.api.entities.Author;
import patika.dev.api.entities.Book;
import patika.dev.api.entities.Publisher;

@Service
public class PublisherManager implements IPublisherService {
    private final PublisherRepo publisherRepo;

    public PublisherManager(PublisherRepo publisherRepo) {
        this.publisherRepo = publisherRepo;
    }

    @Override
    public Publisher save(Publisher publisher) {
        return this.publisherRepo.save(publisher);
    }
    public Page<Publisher> cursor(int page, int pageSize) {

        Pageable pageable = PageRequest.of(page,pageSize);
        Page<Publisher> publisherPage = this.publisherRepo.findAll(pageable);
        if (publisherPage.isEmpty()) {
            throw new NotFoundException("No publishers found");
        }
        return publisherPage;
    }
    @Override
    public Publisher update(Publisher publisher) {
        if(!publisherRepo.existsById(Math.toIntExact(publisher.getId()))) {
            throw new NotFoundException("Publisher with ID " + publisher.getId() + " does not exist");
        }
        this.get(publisher.getId());
        return this.publisherRepo.save(publisher);
    }

    @Override
    public Publisher get(long id) {
        return this.publisherRepo.findById((int)id).orElseThrow(() -> new NotFoundException("Publisher with ID " + id + " does not exist"));
    }

}
