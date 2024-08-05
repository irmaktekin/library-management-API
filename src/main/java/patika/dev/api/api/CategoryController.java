package patika.dev.api.api;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import patika.dev.api.business.abstratcs.ICategoryService;
import patika.dev.api.core.config.modelMapper.IModelMapper;
import patika.dev.api.core.result.ResultData;
import patika.dev.api.core.result.ResultHelper;
import patika.dev.api.dto.request.category.CategorySaveRequest;
import patika.dev.api.dto.response.book.BookResponse;
import patika.dev.api.dto.response.category.CategoryResponse;
import patika.dev.api.dto.response.publisher.PublisherResponse;
import patika.dev.api.entities.Book;
import patika.dev.api.entities.Category;
import patika.dev.api.entities.Publisher;

@RestController
@RequestMapping("/v1/category")
public class CategoryController {
    private final ICategoryService iCategoryService;
    private final IModelMapper iModelMapper;

    public CategoryController(ICategoryService iCategoryService, IModelMapper iModelMapper) {
        this.iCategoryService = iCategoryService;
        this.iModelMapper = iModelMapper;
    }
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<dev.patika.vetmanagement.dto.response.CursorResponse<CategoryResponse>> cursor(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize
    ) {
        Page<Category> categoryPage = this.iCategoryService.cursor(page, pageSize);
        Page<CategoryResponse> categoryResponsePage = categoryPage
                .map(category -> this.iModelMapper.forResponse().map(category, CategoryResponse.class));
        return ResultHelper.cursor(categoryResponsePage);
    }


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<CategoryResponse> save(@Valid @RequestBody CategorySaveRequest categorySaveRequest){
        Category category = this.iModelMapper.forRequest().map(categorySaveRequest,Category.class);
        this.iCategoryService.save(category);
        CategoryResponse categoryResponse = this.iModelMapper.forResponse().map(category,CategoryResponse.class);
        return new ResultData<>("Data is created","201",true,categoryResponse);
    }
}
