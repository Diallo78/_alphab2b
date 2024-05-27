package alpha.commerce.services.impl;

import alpha.commerce.dto.ClientDto;
import alpha.commerce.exception.EntityNotFoundException;
import alpha.commerce.exception.ErrorCodes;
import alpha.commerce.exception.InvalidEntityException;
import alpha.commerce.model.Client;
import alpha.commerce.repository.ClientRepository;
import alpha.commerce.services.ClientService;
import alpha.commerce.validator.ClientValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {
    private ClientRepository repository;
    @Override
    public ClientDto save(ClientDto clientDto) {
        List<String> errors = ClientValidator.validateClient(clientDto);
        if (!errors.isEmpty()){
            log.error("Client is not valid {} ", clientDto);
            throw new InvalidEntityException("Client is invalid :) !", ErrorCodes.CLIENT_NOT_VALID, errors);
        }
        Client client = repository.save(ClientDto.toEntity(clientDto));
        return  ClientDto.fromEntity(client);
    }

    @Override
    public ClientDto findByCodeClient(String code) {
        if (code == null && !code.isBlank()){
            log.error("Client `ID` is not null");
            return null;
        }

        Optional<Client> client = repository.findClientByCode(code);

        return client.map(ClientDto::fromEntity).orElseThrow(()->
            {
                throw new EntityNotFoundException("Aucun Client avec le `CODE` = " + code + "n'est trouve dans la BDD",
                        ErrorCodes.CLIENT_NOT_FOUND);
            }
        );
        /* ClientDto clientDto = ClientDto.fromEntity(client.get());
        return Optional.of(clientDto).orElseThrow(()->
                {
                    throw new EntityNotFoundException("Aucun Client avec le `CODE` = " + code + "n'est trouve dans la BDD",
                            ErrorCodes.CLIENT_NOT_FOUND);
                }
            );*/
    }

    @Override
    public List<ClientDto> findByBusinessCode(String businessCode) {
        if (businessCode == null && !businessCode.isBlank()){
            log.error("Client `Business Code` is not null");
            return null;
        }
        List<Client> clients = repository.findClientByBusinessCodeIsIgnoreCase(businessCode);
        if (clients.isEmpty()){
            throw new EntityNotFoundException("Data client is empty", ErrorCodes.CLIENT_NOT_FOUND);
        }
        return clients.stream().map(ClientDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public List<ClientDto> findAll() {
        List<Client> clients = repository.findAll();

        if (clients.isEmpty()){
            throw new EntityNotFoundException("Data client is empty", ErrorCodes.CLIENT_NOT_FOUND);
        }

        return clients
                .stream()
                .map(ClientDto::fromEntity)
                .collect(Collectors.toList());
    }


}
