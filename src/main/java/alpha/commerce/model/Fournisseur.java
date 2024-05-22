package alpha.commerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter @EqualsAndHashCode @ToString
@AllArgsConstructor
@NoArgsConstructor @Builder
@Table(name = "fournisseur")
public class Fournisseur extends AbstractEntity{
    private String code;
    @Column(nullable = false, length = 30)
    private String lastName;
    @Column(nullable = false, length = 100)
    private String firstName;
    private String photo;
    private String businessCode;
    @Embedded
    private Address address;

    @OneToMany(mappedBy = "fournisseur")
    private List<CommandeFournisseur> commandeFournisseurs;
}
