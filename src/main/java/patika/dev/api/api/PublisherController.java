package patika.dev.api.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import patika.dev.api.business.abstratcs.IPublisherService;
import patika.dev.api.entities.Publisher;

@RestController
@RequestMapping("/v1/publishers")
public class PublisherController {
    private final IPublisherService iPublisherService;


    public PublisherController(IPublisherService iPublisherService) {
        this.iPublisherService = iPublisherService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher save(@RequestBody Publisher publisher){
        return this.iPublisherService.save(publisher);
    }
}
