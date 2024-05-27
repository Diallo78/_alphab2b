package alpha.commerce.web.api;

import alpha.commerce.dto.ClientDto;

import java.util.List;

public interface ClientApi {
    public ClientDto save(ClientDto clientDto);
    public ClientDto findByCodeClient(String code);
    public List<ClientDto> findByBusinessCode(String businessCode);
    public List<ClientDto> findAll();
}
