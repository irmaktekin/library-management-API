package patika.dev.api.business.concretes;

import org.springframework.stereotype.Service;
import patika.dev.api.business.abstratcs.IPublisherService;
import patika.dev.api.dao.PublisherRepo;
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
}
