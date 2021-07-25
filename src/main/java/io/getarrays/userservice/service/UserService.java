package io.getarrays.userservice.service;

import io.getarrays.userservice.domain.Role;
import io.getarrays.userservice.domain.User;

import java.util.List;

public interface UserService {

    User saveUSer(User user);

    Role saveRole(Role rol);

    void addRoleToUser(String username, String roleName);

    User getUser(String username);

    List<User> getUsers();
}
