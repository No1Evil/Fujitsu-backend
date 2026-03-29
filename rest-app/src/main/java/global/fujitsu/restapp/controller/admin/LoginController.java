package global.fujitsu.restapp.controller.admin;

import java.time.Instant;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/** Provides authentication endpoint. */
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public final class LoginController {

  private final JwtEncoder encoder;
  private final AuthenticationConfiguration authConfig;

  /** {@return authorized jwt token} */
  @PostMapping("/login")
  public String login(@RequestParam String username, @RequestParam String password) {
    Authentication auth = authConfig.getAuthenticationManager().authenticate(
        new UsernamePasswordAuthenticationToken(username, password)
    );

    Instant now = Instant.now();

    String roles = auth.getAuthorities().stream()
        .map(GrantedAuthority::getAuthority).filter(Objects::nonNull)
        .collect(Collectors.joining(" "));

    JwtClaimsSet claims = JwtClaimsSet.builder()
        .issuer("self")
        .claim("roles", roles)
        .issuedAt(now)
        .expiresAt(now.plusSeconds(3600))
        .subject(auth.getName())
        .build();

    JwsHeader jwsHeader = JwsHeader.with(MacAlgorithm.HS256).build();
    return this.encoder.encode(JwtEncoderParameters.from(jwsHeader, claims)).getTokenValue();
  }
}
