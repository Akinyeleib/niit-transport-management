package competition.transport.auth;

import competition.transport.utils.Utils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Slf4j
public class TokenInterceptor implements HandlerInterceptor {
    private final Utils utils = new Utils();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authHeader = request.getHeader("rapid-transit");
        if (authHeader == null || authHeader.isBlank()) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Missing token");
            return false;
        }
        if (utils.validateEmailFromToken(authHeader)) {
            log.info("authHeader: " + utils.decode(authHeader));
            return true;
        }
        response.sendError(HttpServletResponse.SC_FORBIDDEN,"Invalid token");
        return false;
    }
}
