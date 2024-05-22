package alpha.commerce.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @Builder
@Table(name = "role")
public class Role extends AbstractEntity{

    @Column(nullable = false)
    private String nameRole;

    @ManyToMany(mappedBy = "roles")
    private List<Customer> customers;
}
