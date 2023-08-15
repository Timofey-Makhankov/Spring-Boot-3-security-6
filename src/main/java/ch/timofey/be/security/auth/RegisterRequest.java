package ch.timofey.be.security.auth;

import ch.timofey.be.domain.role.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegisterRequest {
    private String username;
    private String password;
    private Role role;
}
