package competition.transport.service;

import competition.transport.entity.Client;

import java.util.List;

public interface ClientService {
    Client saveClient(Client client) throws Exception;

    List<Client> getUsers();
}
