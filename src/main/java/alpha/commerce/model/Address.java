package alpha.commerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @Builder
public class Address implements Serializable {
    @Column(nullable = false)
    private String Country;
    @Column(nullable = false)
    private String city;
    private String postcode;
    @Column(nullable = false)
    private String address1;
    private String address2;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String phone;
}
