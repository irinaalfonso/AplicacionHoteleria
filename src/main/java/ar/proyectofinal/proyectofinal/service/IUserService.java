package ar.proyectofinal.proyectofinal.service;

import ar.proyectofinal.proyectofinal.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface IUserService {
    public void createUser(User user);
    public List<User> getUsers();

}
