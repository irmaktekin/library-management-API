package patika.dev.api.business.abstratcs;

import org.springframework.stereotype.Service;
import patika.dev.api.entities.Publisher;

public interface IPublisherService {
    Publisher save (Publisher publisher);
}
