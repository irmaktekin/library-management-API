package patika.dev.api.core.result;


import lombok.Getter;

@Getter
public class Data<T> extends Result{
    private T data;
    public Data(boolean status, String message, String httpCode, T data) {
        super(status, message, httpCode);
        this.data = data;
    }
}
