package competition.transport.utils;

import competition.transport.errors.BadRequestException;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class Utils {
    public void checkPhoneNumber(String phone) {
        // todo: logic to test nigerian phone number
        boolean valid = Pattern.matches("(\\+?234|0)[7-9][01]\\d{8}", phone);
        if (!valid) {
            throw new BadRequestException("Invalid nigerian phone number");
        }
    }
}
