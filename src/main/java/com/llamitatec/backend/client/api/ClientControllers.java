package com.llamitatec.backend.client.api;

import com.llamitatec.backend.client.domain.service.ClientService;
import com.llamitatec.backend.client.mapping.ClientMapper;
import com.llamitatec.backend.client.resource.ClientResource;
import com.llamitatec.backend.client.resource.CreateClientResource;
import com.llamitatec.backend.client.resource.UpdateClientResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/clients")
public class ClientControllers {
    private final ClientService clientService;
    private final ClientMapper mapper;


    public ClientControllers(ClientService clientService, ClientMapper mapper) {
        this.clientService = clientService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<ClientResource> getAllClients(Pageable pageable){
        return mapper.modelListPage(clientService.getAll(),pageable);
    }

    @GetMapping("{userId}")
    public ClientResource getClientByUserId(@PathVariable("userId") Long userId){
        return mapper.toResource(clientService.getByUserId(userId));
    }

    @PostMapping("{userId}")
    public ClientResource createClient(@PathVariable("userId") Long userId,@RequestBody CreateClientResource resource){
        return mapper.toResource(clientService.create(userId, mapper.toModel(resource)));
    }

    @PutMapping("{clientId}")
    private ClientResource updateClient(@PathVariable("clientId") Long clientId,@RequestBody UpdateClientResource resource){
        return mapper.toResource(clientService.update(clientId,mapper.toModel(resource)));
    }

    @DeleteMapping("{clientId}")
    public ResponseEntity<?> deleteClient(@PathVariable Long clientId){
        return clientService.delete(clientId);
    }
}
