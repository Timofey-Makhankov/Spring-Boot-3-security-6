package ch.timofey.be.domain.role;

import ch.timofey.be.domain.authority.Authority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static ch.timofey.be.domain.authority.Authority.*;

public enum Role {
    USER(Set.of(USER_READ)),
    ADMIN(Set.of(ADMIN_READ, ADMIN_CREATE, ADMIN_UPDATE, ADMIN_DELETE));

    Role(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    private final Set<Authority> authorities;

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public List<SimpleGrantedAuthority> getPermissions(){
        var permissions = getPermissions().stream()
                .map( permission -> new SimpleGrantedAuthority(permission.getAuthority()))
                .collect(Collectors.toList());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
