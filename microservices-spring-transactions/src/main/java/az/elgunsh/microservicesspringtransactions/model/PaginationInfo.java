package az.elgunsh.microservicesspringtransactions.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Data
@ToString
public class PaginationInfo {
    private int totalPages;

    private int totalItems;

    private int page;

    private int perPage;

    private boolean hasNextPage;

    private boolean hasPreviousPage;
}
