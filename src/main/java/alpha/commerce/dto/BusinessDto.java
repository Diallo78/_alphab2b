package alpha.commerce.dto;

import alpha.commerce.model.Business;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode @ToString
public class BusinessDto {
    private Long id;
    private String code;
    private String nameBusiness;
    private String description;
    private String codeFiscal;
    private String siteWeb;
    private String photo;
    private AddressDto address;
    @JsonIgnore
    private List<CustomerDto> customers;

    // Mapping Business -> BusinessDto (Front <- Back-end)
    public static BusinessDto fromEntity(Business business){
        if(business == null){
            return null;
        }

        return BusinessDto.builder()
                .id(business.getId())
                .code(business.getCode())
                .nameBusiness(business.getNameBusiness())
                .description(business.getDescription())
                .codeFiscal(business.getCodeFiscal())
                .siteWeb(business.getSiteWeb())
                .photo(business.getPhoto())
                .address(AddressDto.fromEntity(business.getAddress()))
                .build();

    }

    // Mapping Business -> BusinessDto (Front -> Back-end)
    public static Business toEntity(BusinessDto dto){
        if (dto == null){
            return null;
        }

        Business business = new Business();
        business.setId(dto.getId());
        business.setCode(dto.getCode());
        business.setNameBusiness(dto.getNameBusiness());
        business.setDescription(dto.getDescription());
        business.setCodeFiscal(dto.getCodeFiscal());
        business.setSiteWeb(dto.getSiteWeb());
        business.setPhoto(dto.getPhoto());
        business.setAddress(AddressDto.toEntity(dto.getAddress()));
        return business;
    }
}
