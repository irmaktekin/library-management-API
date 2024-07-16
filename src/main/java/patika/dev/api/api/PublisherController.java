package patika.dev.api.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import patika.dev.api.business.abstratcs.IPublisherService;
import patika.dev.api.core.config.modelMapper.IModelMapper;
import patika.dev.api.core.result.Data;
import patika.dev.api.core.result.Result;
import patika.dev.api.dto.request.publisher.PublisherSaveRequest;
import patika.dev.api.dto.response.publisher.PublisherResponse;
import patika.dev.api.entities.Publisher;

@RestController
@RequestMapping("/v1/publishers")
public class PublisherController {
    private final IPublisherService iPublisherService;
    private final IModelMapper iModelMapper;


    public PublisherController(IPublisherService iPublisherService, IModelMapper iModelMapper) {
        this.iPublisherService = iPublisherService;
        this.iModelMapper = iModelMapper;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Data<PublisherResponse> save(@Valid @RequestBody PublisherSaveRequest publisherSaveRequest){
        Publisher savePublisher = this.iModelMapper.forRequest().map(publisherSaveRequest,Publisher.class);
        this.iPublisherService.save(savePublisher);
        PublisherResponse publisherResponse = this.iModelMapper.forResponse().map(savePublisher,PublisherResponse.class);
        return new Data<>(true,"Data is created","201",publisherResponse);
    }
}
