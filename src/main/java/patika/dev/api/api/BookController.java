package patika.dev.api.api;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import patika.dev.api.business.abstratcs.IBookService;
import patika.dev.api.core.config.modelMapper.IModelMapper;
import patika.dev.api.core.result.ResultData;
import patika.dev.api.core.result.ResultHelper;
import patika.dev.api.dto.request.book.BookSaveRequest;
import patika.dev.api.dto.request.publisher.PublisherSaveRequest;
import patika.dev.api.dto.response.book.BookResponse;
import patika.dev.api.dto.response.publisher.PublisherResponse;
import patika.dev.api.entities.Book;
import patika.dev.api.entities.Publisher;

@RestController
@RequestMapping("/v1/books")
public class BookController {
    private final IBookService iBookService;
    private final IModelMapper iModelMapper;

    public BookController(IBookService iBookService, IModelMapper iModelMapper) {
        this.iBookService = iBookService;
        this.iModelMapper = iModelMapper;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<dev.patika.vetmanagement.dto.response.CursorResponse<BookResponse>> cursor(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize
    ) {
        Page<Book> animalPage = this.iBookService.cursor(page, pageSize);
        Page<BookResponse> animalResponsePage = animalPage
                .map(animal -> this.iModelMapper.forResponse().map(animal, BookResponse.class));
        return ResultHelper.cursor(animalResponsePage);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<BookResponse> save(@Valid @RequestBody BookSaveRequest bookSaveRequest){
        Book book = this.iModelMapper.forRequest().map(bookSaveRequest,Book.class);
        this.iBookService.save(book);
        BookResponse bookResponse = this.iModelMapper.forResponse().map(book,BookResponse.class);
        return new ResultData<>("Data is created","201",true,bookResponse);
    }

}