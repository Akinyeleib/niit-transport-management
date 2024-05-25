package competition.transport.controller;

import competition.transport.entity.Client;
import competition.transport.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class ClientController {
    @Autowired
    private ClientService clientService;
    @GetMapping
    public List<Client> welcome() {
        return clientService.getUsers();
    }

    @PostMapping
    public Client createClient(@RequestBody Client client) throws Exception {
        return clientService.saveClient(client);
    }

}
