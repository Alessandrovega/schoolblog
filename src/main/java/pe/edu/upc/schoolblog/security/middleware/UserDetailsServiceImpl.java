package pe.edu.upc.schoolblog.security.middleware;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pe.edu.upc.schoolblog.security.domain.persistence.UserRepository;

public class UserDetailsServiceImpl {

    private UserRepository userRepository;

   // @Override
   // public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    //    userRepository.findOneByUsername(username).orElseThrow(()-->new UsernameNotFoundException("el usuario con username : "+ username+ " no existe"));}
}
