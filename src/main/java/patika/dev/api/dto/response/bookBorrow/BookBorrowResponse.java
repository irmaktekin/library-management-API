package patika.dev.api.dto.response.bookBorrow;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBorrowResponse {
    @NotNull
    private Long id;
    @NotNull
    private String borrowerName;
    @NotNull
    private java.util.Date borrowingDate;
    @NotNull
    private java.util.Date returnDate;
    @NotNull
    private Long bookId;
}
