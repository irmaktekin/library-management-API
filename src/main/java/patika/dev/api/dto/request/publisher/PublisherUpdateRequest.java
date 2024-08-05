package patika.dev.api.dto.request.publisher;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublisherUpdateRequest {
    @NotNull
    private Long id;
    private String publisherName;
    private java.util.Date establishYear;
    private String publisherAddress;
}
