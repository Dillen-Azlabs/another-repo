package sg.ihh.ms.sdms.app.security.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import sg.ihh.ms.sdms.app.security.model.ApiKeyAuthenticationToken;

@Component
public class ApiKeyAuthenticationProvider implements AuthenticationProvider {

    @Value("${security.api-key}")
    private String validKey;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String apiKey = (String) authentication.getPrincipal();

        if (ObjectUtils.isEmpty(apiKey)) {
            throw new InsufficientAuthenticationException("No API key in request");
        } else {
            if (validKey.equals(apiKey)) {
                return new ApiKeyAuthenticationToken(apiKey, true);
            }
            throw new BadCredentialsException("API Key is invalid");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return ApiKeyAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
