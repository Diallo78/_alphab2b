package alpha.commerce.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Builder
public class Business extends AbstractEntity{
    private String code;
    private String nameBusiness;
    private String description;
    private String codeFiscal;
    private String siteWeb;
    private String photo;
    @Embedded
    private Address address;

    @OneToMany(mappedBy = "business")
    private List<Customer> customers;


}
