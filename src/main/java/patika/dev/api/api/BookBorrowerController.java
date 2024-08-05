package patika.dev.api.api;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import patika.dev.api.business.abstratcs.BookBorrowingService;
import patika.dev.api.core.config.modelMapper.IModelMapper;
import patika.dev.api.core.result.ResultData;
import patika.dev.api.core.result.ResultHelper;
import patika.dev.api.dto.request.bookBorrow.BookBorrowSaveRequest;
import patika.dev.api.dto.request.bookBorrow.BookBorrowUpdateRequest;
import patika.dev.api.dto.request.publisher.PublisherUpdateRequest;
import patika.dev.api.dto.response.bookBorrow.BookBorrowResponse;
import patika.dev.api.dto.response.publisher.PublisherResponse;
import patika.dev.api.entities.Book;
import patika.dev.api.entities.BookBorrow;
import patika.dev.api.entities.Publisher;

@RestController
@RequestMapping("/v1/bookBorrowings")
public class BookBorrowerController {
    private final BookBorrowingService bookBorrowingService;
    private final IModelMapper iModelMapper;

    public BookBorrowerController(BookBorrowingService bookBorrowingService, IModelMapper iModelMapper) {
        this.bookBorrowingService = bookBorrowingService;
        this.iModelMapper = iModelMapper;
    }
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<dev.patika.vetmanagement.dto.response.CursorResponse<BookBorrowResponse>> cursor(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize
    ) {
        Page<BookBorrow> bookBorrows = this.bookBorrowingService.cursor(page, pageSize);
        Page<BookBorrowResponse> bookBorrowResponses = bookBorrows
                .map(bookBorrow -> this.iModelMapper.forResponse().map(bookBorrow, BookBorrowResponse.class));
        return ResultHelper.cursor(bookBorrowResponses);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<BookBorrowResponse> save(@Valid @RequestBody BookBorrowSaveRequest bookSaveRequest){
        BookBorrow bookBorrow = this.iModelMapper.forRequest().map(bookSaveRequest,BookBorrow.class);
        this.bookBorrowingService.save(bookBorrow);
        BookBorrowResponse bookResponse = this.iModelMapper.forResponse().map(bookBorrow,BookBorrowResponse.class);
        return new ResultData<>("Data is created","201",true,bookResponse);
    }
    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<BookBorrowResponse> update(@Valid @RequestBody BookBorrowUpdateRequest bookBorrowUpdateRequest){

        BookBorrow bookBorrow = this.iModelMapper.forRequest().map(bookBorrowUpdateRequest,BookBorrow.class);
        this.bookBorrowingService.update(bookBorrow);
        return ResultHelper.success(this.iModelMapper.forResponse().map(bookBorrow, BookBorrowResponse.class));
    }
}
