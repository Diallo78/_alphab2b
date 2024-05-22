package alpha.commerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @Builder
@EqualsAndHashCode(callSuper = true)
@Table(name = "customer")
public class Customer extends AbstractEntity{

    private String lastName;
    private String firstName;
    private Instant dateOfBirth;
    private String mdp;
    private String photo;

    @Embedded
    private Address address;

    @ManyToOne
    @JoinColumn(name = "business_id")
    private Business business;

    @ManyToMany
    @JoinTable(name = "customer_roles",
            joinColumns = @JoinColumn(name = "customer_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "role_id", nullable = false))
    private List<Role> roles;

}
