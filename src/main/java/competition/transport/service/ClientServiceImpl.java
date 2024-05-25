package competition.transport.service;

import competition.transport.entity.Client;
import competition.transport.repository.ClientRepo;
import competition.transport.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepo clientRepo;
    @Autowired
    private Utils utils;
    @Override
    public Client saveClient(Client client) throws Exception {
        utils.checkPhoneNumber(client.getPhone());
        return clientRepo.save(client);
    }

    @Override
    public List<Client> getUsers() {
        return clientRepo.findAll();
    }

}
