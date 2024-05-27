package alpha.commerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter @EqualsAndHashCode(callSuper = true) @ToString
@AllArgsConstructor
@NoArgsConstructor @Builder
@Table(name = "client")
public class Client extends AbstractEntity{
    private String code;
    private String lastName;
    private String firstName;
    private String photo;
    @Embedded
    private Address address;
    private String businessCode;
    @OneToMany(mappedBy = "client")
    private List<Commande> commandes; // = all Commande client

}
