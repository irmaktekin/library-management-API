package patika.dev.api.core.result;


import lombok.Getter;

@Getter
public class ResultData<T> extends Result{
    private T data;
    public ResultData(String message,  String httpCode,boolean status,T data) {
        super(status, message, httpCode);
        this.data = data;
    }
}
