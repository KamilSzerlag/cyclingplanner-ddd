package pl.ksz.cyclingplanner.template.infrastructure.security;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;


public class AthleteEntity extends User{

    public AthleteEntity(String username, String password, boolean enabled,
            boolean accountNonExpired,
            boolean credentialsNonExpired, boolean accountNonLocked,
            Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired,
                accountNonLocked,
                authorities);
    }
}
