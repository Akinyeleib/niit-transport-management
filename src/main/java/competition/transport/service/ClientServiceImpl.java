package competition.transport.service;

import competition.transport.entity.Client;
import competition.transport.errors.DuplicateRequestException;
import competition.transport.errors.NotFoundRequestException;
import competition.transport.repository.ClientRepo;
import competition.transport.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepo clientRepo;
    @Autowired
    private Utils utils;
    @Override
    public Client saveClient(Client client) throws Exception {
        utils.checkPhoneNumber(client.getPhone());
        emailNotPresent(client.getEmail());
        client.setEmail(client.getEmail().toLowerCase());
        return clientRepo.save(client);
    }

    @Override
    public List<Client> getUsers() {
        return clientRepo.findAll();
    }

    @Override
    public String deleteClient(String id) {
        userUUIDPresent(id);
        clientRepo.deleteById(UUID.fromString(id));
        return "User deleted successfully";
    }

    public boolean emailPresent(String email) {
        return clientRepo.existsByEmailIgnoreCase(email);
    }

    public void userUUIDPresent(String id) {
        boolean present = clientRepo.existsById(UUID.fromString(id));
        if (!present) {
            throw new NotFoundRequestException("no client with id: " + id);
        }
    }

    public void emailNotPresent(String email) {
        if (emailPresent(email)) {
            throw new DuplicateRequestException("Email already in use");
        }
    }

    public Client getByEmailorThrow(String email) {
        if (!emailPresent(email)) {
            throw new NotFoundRequestException("Email not found in records");
        }
        return clientRepo.findByEmailIgnoreCase(email);
    }

}
