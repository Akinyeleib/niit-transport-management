package competition.transport.repository;

import competition.transport.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClientRepo extends JpaRepository<Client, UUID> {
    Boolean existsByEmail(String Email);
    Boolean existsByEmailIgnoreCase(String Email);
    Client findByEmail(String email);
    Client findByEmailIgnoreCase(String email);
}
