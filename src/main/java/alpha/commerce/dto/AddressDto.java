package alpha.commerce.dto;

import alpha.commerce.model.Address;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter @EqualsAndHashCode
public class AddressDto {
    private String Country;
    private String city;
    private String postcode;
    private String address1;
    private String address2;
    private String email;
    private String phone;


    public static AddressDto fromEntity(Address address){
        if (address == null){
            return null;
            // TODO Throw Exception
        }
        return AddressDto.builder()
                .Country(address.getCountry())
                .city(address.getCity())
                .postcode(address.getPostcode())
                .address1(address.getAddress1())
                .address1((address.getAddress2()))
                .email(address.getEmail())
                .phone(address.getPhone())
                .build();
    }

    public static Address toEntity(AddressDto dto){
        if (dto == null){
            return null;
            // TODO Throw Exception
        }

        Address address = new Address();
        address.setCountry(dto.getCountry());
        address.setCity(dto.getCity());
        address.setPostcode(dto.getPostcode());
        address.setAddress1(dto.getAddress1());
        address.setAddress2(dto.getAddress2());
        address.setEmail(dto.getEmail());
        address.setPhone(dto.getPhone());
        return address;
    }
}
