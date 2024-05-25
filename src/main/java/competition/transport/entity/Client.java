package competition.transport.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String pin;
    private LocalDate dob;
    private String transactionPin = "123456";
    private String accountNumber;
    private Double balance = 2500.0;
    private Boolean verifiedStatus = false;
    private Boolean emailVerificationStatus = false;
}

