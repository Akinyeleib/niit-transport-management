package competition.transport.service;

import competition.transport.dto.LoginDto;
import competition.transport.entity.Client;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<String> login(LoginDto loginDto);
    ResponseEntity<String> signUp(Client client) throws Exception;
    String logout(String token);
}
