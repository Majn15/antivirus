package ru.mtuci.antivirus.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public enum Role {
    USER(Set.of(Permissions.READ)),
    ADMIN(Set.of(Permissions.READ, Permissions.MODIFICATION));

    private final Set<Permissions> permissions;

    public Set<GrantedAuthority> getGrantedAuthorities() {
        Set<GrantedAuthority> grantedAuthorities = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + name()));
        return grantedAuthorities;
    }
}