package ar.proyectofinal.proyectofinal.service;

import ar.proyectofinal.proyectofinal.model.User;
import ar.proyectofinal.proyectofinal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements IUserService, UserDetailsService {
    @Autowired
    private UserRepository repository;

    public void createUser(User user){
        if(repository.findByEmail(user.getEmail()) == null)
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            repository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User u = repository.findByEmail(s);
        if (u != null){
            return u;
        }
        else
            throw new UsernameNotFoundException("There's no user with that email");
    }

    public List<User> getUsers(){
        return repository.findAll();
    }

}
