package patika.dev.api.dto.request.author;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorSaveRequest {
    private Date birthDate;
    @NotNull(message = "Author name cannot be null")

    private String author_name;
    @NotNull(message = "Author country cannot be null")

    private String author_country;
}
