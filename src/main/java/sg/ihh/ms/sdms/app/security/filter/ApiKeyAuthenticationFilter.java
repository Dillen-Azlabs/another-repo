package sg.ihh.ms.sdms.app.security.filter;

import java.io.IOException;
import java.util.Optional;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import sg.ihh.ms.sdms.app.rest.model.BaseResponse;
import sg.ihh.ms.sdms.app.security.model.ApiKeyAuthenticationToken;
import sg.ihh.ms.sdms.app.util.json.JsonUtil;
import sg.ihh.ms.sdms.app.util.xml.XmlUtil;

public class ApiKeyAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    public ApiKeyAuthenticationFilter(AuthenticationManager authenticationManager) {
        super("/**");
        this.setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {

        Optional<String> apiKeyOptional = Optional.ofNullable(request.getHeader("x-api-key"));

        ApiKeyAuthenticationToken token =
                apiKeyOptional.map(ApiKeyAuthenticationToken::new).orElse(new ApiKeyAuthenticationToken());

        final String path = request.getRequestURI().replaceFirst(request.getContextPath(), "");

        if (path.equals("/actuator/health")) {
            return new ApiKeyAuthenticationToken("unauth", true);
        } else {
            return getAuthenticationManager().authenticate(token);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authResult) throws IOException, ServletException {
        SecurityContextHolder.getContext().setAuthentication(authResult);
        chain.doFilter(request, response);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException failed) throws IOException, ServletException {

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        BaseResponse sr = new BaseResponse(HttpStatus.UNAUTHORIZED);

        if (request.getHeader("accept").contains("xml")) {
            response.setContentType("application/xml");
            response.getWriter().print(XmlUtil.toXml(sr));
        } else {
            response.setContentType("application/json");
            response.getWriter().print(JsonUtil.toJson(sr));
        }
    }

}
