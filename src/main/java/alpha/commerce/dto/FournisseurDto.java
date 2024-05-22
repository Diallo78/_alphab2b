package alpha.commerce.dto;

import alpha.commerce.model.Fournisseur;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode @ToString
public class FournisseurDto {
    private Long id;
    private String code;
    private String lastName;
    private String firstName;
    private String photo;
    private AddressDto address;
    @JsonIgnore
    private List<CommandeFournisseurDto> commandeFournisseurs;

    // Mapping CommandeFournisseur -> CommandeFournisseurDto (Front-end <- Back-end)
    public static FournisseurDto FromEntity(Fournisseur fournisseur){

        if (fournisseur == null){
            return null;
        }
        return FournisseurDto.builder()
                .id(fournisseur.getId())
                .code(fournisseur.getCode())
                .lastName(fournisseur.getLastName())
                .firstName(fournisseur.getFirstName())
                .photo(fournisseur.getPhoto())
                .address(AddressDto.fromEntity(fournisseur.getAddress()))
                .build();
    }

    // Mapping CommandeFournisseurDto -> CommandeFournisseur (Front-end -> Back-end)
    public static Fournisseur toEntity(FournisseurDto dto){
        if (dto == null){
            return null;
        }

        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setId(dto.getId());
        fournisseur.setCode(dto.getCode());
        fournisseur.setLastName(dto.getLastName());
        fournisseur.setFirstName(dto.getFirstName());
        fournisseur.setPhoto(dto.getPhoto());
        fournisseur.setAddress(AddressDto.toEntity(dto.getAddress()));

        return fournisseur;
    }
}
