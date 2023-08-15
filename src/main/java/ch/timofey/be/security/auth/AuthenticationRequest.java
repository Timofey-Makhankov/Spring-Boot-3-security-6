package ch.timofey.be.security.auth;

import lombok.*;

@Getter
@Setter
@Builder
public class AuthenticationRequest {
    private String username;
    private String password;
}
