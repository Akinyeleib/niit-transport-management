package competition.transport.controller;

import competition.transport.dto.LoginDto;
import competition.transport.entity.Client;
import competition.transport.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        return authService.login(loginDto);
    }
    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody Client client) throws Exception {
        return authService.signUp(client);
    }
}
