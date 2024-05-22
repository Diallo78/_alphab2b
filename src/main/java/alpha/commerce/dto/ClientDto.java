package alpha.commerce.dto;

import alpha.commerce.model.Client;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter @EqualsAndHashCode @ToString
public class ClientDto {
    private Long id;
    private String code;
    private String lastName;
    private String firstName;
    private AddressDto address;
    @JsonIgnore
    private List<CommandeDto> commandes;
    private String photo;

    // Mapping form client entity to client dto relation back-end -
    public static ClientDto fromEntity(Client client){
        if(client == null){
            return null;
        }

        return ClientDto.builder()
                .id(client.getId())
                .code(client.getCode())
                .lastName(client.getLastName())
                .firstName(client.getFirstName())
                .address(AddressDto.fromEntity(client.getAddress()))
                .photo(client.getPhoto())
                .build();
    }

    public static Client toEntity(ClientDto dto){
        if (dto == null){
            return null;
        }

        Client client = new Client();
        client.setId(dto.getId());
        client.setCode(dto.getCode());
        client.setLastName(dto.getLastName());
        client.setFirstName(dto.getFirstName());
        client.setAddress(AddressDto.toEntity(dto.getAddress()));
        client.setPhoto(dto.getPhoto());

        return client;
    }

}
