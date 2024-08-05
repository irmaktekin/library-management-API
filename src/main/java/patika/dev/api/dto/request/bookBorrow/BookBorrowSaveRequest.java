package patika.dev.api.dto.request.bookBorrow;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBorrowSaveRequest {
    @NotNull
    private String borrowerName;
    @NotNull
    private java.util.Date borrowingDate;
    @NotNull
    private Long bookId;
}
