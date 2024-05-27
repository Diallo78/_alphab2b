package alpha.commerce.dto;

import alpha.commerce.model.Address;
import alpha.commerce.model.Business;
import alpha.commerce.model.Customer;
import lombok.*;

import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter @EqualsAndHashCode @ToString
public class CustomerDto {
    private Long id;
    private String lastName;
    private String firstName;
    private Instant dateOfBirth;
    private String mdp;
    private String photo;
    private AddressDto address;
    private BusinessDto business;
    private List<RoleDto> roles;

    public static CustomerDto fromEntity(Customer customer){
        if (customer == null){
            return null;
        }
        return CustomerDto.builder()
                .id(customer.getId())
                .lastName(customer.getLastName())
                .firstName(customer.getFirstName())
                .dateOfBirth(customer.getDateOfBirth())
                .mdp(customer.getMdp())
                .photo(customer.getPhoto())
                .address(AddressDto.fromEntity(customer.getAddress()))
                .business(BusinessDto.fromEntity(customer.getBusiness()))
//                .roles(customer.getRoles() != null ?
//                        customer.getRoles().stream()
//                                .map(rol -> RoleDto.formEntity(rol))
//                                .collect(Collectors.toList()) : null
//                        )
                .roles(customer.getRoles() != null ?
                        customer.getRoles().stream()
                                .map(RoleDto::formEntity)
                                .collect(Collectors.toList()) : null
                        )
                .build();
    }

    public static Customer toEntity(CustomerDto dto){
        if(dto == null){
            return null;
        }

        Customer customer = new Customer();
        customer.setId(dto.getId());
        customer.setLastName(dto.getLastName());
        customer.setFirstName(dto.getFirstName());
        customer.setDateOfBirth(dto.getDateOfBirth());
        customer.setMdp(dto.getMdp());
        customer.setPhoto(dto.getPhoto());
        customer.setAddress(AddressDto.toEntity(dto.getAddress()));
        customer.setBusiness(BusinessDto.toEntity(dto.getBusiness()));
        customer.setRoles(Collections.singletonList(RoleDto.toEntity((RoleDto) dto.getRoles())));
        return customer;
    }


}
