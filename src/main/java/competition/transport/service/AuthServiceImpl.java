package competition.transport.service;

import competition.transport.dto.LoginDto;
import competition.transport.entity.Client;
import competition.transport.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private ClientService clientService;
    @Autowired
    private Utils utils;

    @Override
    public ResponseEntity<String> login(LoginDto loginDto) {
        Client client = clientService.getByEmailorThrow(loginDto.getEmail());
        if (client.getPassword().equals(loginDto.getPassword())){
            return ResponseEntity.status(200).body(utils.encode(loginDto));
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }

    @Override
    public ResponseEntity<String> signUp(Client client) throws Exception {
        clientService.saveClient(client);
        return ResponseEntity.status(200).body("Account created successfully");
    }

    @Override
    public String logout(String token) {
        return null;
    }

}
