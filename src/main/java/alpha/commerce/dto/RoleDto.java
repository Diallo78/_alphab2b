package alpha.commerce.dto;

import alpha.commerce.model.Customer;
import alpha.commerce.model.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter @EqualsAndHashCode
public class RoleDto {
    private Long id;
    private String nameRole;
    @JsonIgnore
    private List<Customer> customers;

    public static RoleDto formEntity(Role role){
        if (role == null){
            return null;
        }

        return RoleDto.builder()
                .id(role.getId())
                .nameRole(role.getNameRole())
                .build();
    }

    public static Role toEntity(RoleDto dto){
        if (dto == null){
            return null;
        }

        Role role = new Role();
        role.setId(dto.getId());
        role.setNameRole(dto.getNameRole());

        return role;
    }
}
