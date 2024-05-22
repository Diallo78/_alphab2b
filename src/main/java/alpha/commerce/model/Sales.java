package alpha.commerce.model;

import jakarta.persistence.Entity;
import lombok.*;

import java.time.Instant;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @EqualsAndHashCode(callSuper = true)
@Builder
public class Sales extends AbstractEntity{
    private String code;
    private Instant dateSales;
    private String comment; // commantaire
}
