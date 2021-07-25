package io.getarrays.userservice.service;

import io.getarrays.userservice.domain.Role;
import io.getarrays.userservice.domain.User;
import io.getarrays.userservice.repository.RoleRepository;
import io.getarrays.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    @Override
    public User saveUSer(User user) {
        log.info("Saving new User {} to the database", user.getName());
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role rol) {
        log.info("Saving new Rol {} to the database", rol.getName());
        return roleRepository.save(rol);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {

        log.info("Add rol {}  to user  {} to the database", roleName, username);

        User user = userRepository.fingByUsername(username);
        Role role = roleRepository.findByName(roleName);

        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        log.info("Fetching user {} ",username);
        return userRepository.fingByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }
}
