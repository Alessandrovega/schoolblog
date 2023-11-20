package pe.edu.upc.schoolblog.security.middleware;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pe.edu.upc.schoolblog.security.domain.model.entity.Role;
import pe.edu.upc.schoolblog.security.domain.model.entity.User;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

public class UserDetailsImpl2 implements UserDetails {

    private  User user;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
       return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Set<Role> getRole(){
        return user.getRoles();

    }
}
