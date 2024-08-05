package patika.dev.api.core.result;
import dev.patika.vetmanagement.dto.response.CursorResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public class ResultHelper {
    public static <T> ResultData<T> created(T data){
        return new ResultData<>(Message.CREATED,"201",true,data);
    }
    public static <T> ResultData<T> validateError(T data){
        return new ResultData<>(Message.VALIDATE_ERROR,"400",false,data);
    }
    public static Result invalidEnum(String message){
        return new Result(false,"400",message);
    }
    public static <T> ResultData<T> duplicateRecord(T data){
        return new ResultData<>(Message.DUPLICATE_VALUES,"400",false,data);
    }
    public static <T> ResultData<T> success(T data){

        return new ResultData<>(Message.OK,"200",true,data);
    }
    public static Result ok(){
        return new Result(true,"200",Message.OK);
    }
    public static Result notFoundError(String msg){
        return new Result(false,"404",msg);
    }
    public static <T> ResultData<CursorResponse<T>> cursor(Page<T> pageData){
        CursorResponse<T> cursor = new CursorResponse<>();
        cursor.setItems(pageData.getContent());
        cursor.setPageNumber(pageData.getNumber());
        cursor.setPageSize(pageData.getSize());
        cursor.setTotalElements(pageData.getTotalElements());
        return ResultHelper.success(cursor);
    }
    public static <T> ResultData<List<T>> successList(List<T> data) {
        return new ResultData<>(Message.OK, "200", true, data);
    }
}
