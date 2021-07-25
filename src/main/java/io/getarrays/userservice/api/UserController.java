package io.getarrays.userservice.api;

import io.getarrays.userservice.domain.Role;
import io.getarrays.userservice.domain.User;
import io.getarrays.userservice.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userservice;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userservice.getUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userservice.saveUser(user));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRol(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(userservice.saveRole(role));
    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm roleToUserForm) {
        userservice.addRoleToUser(roleToUserForm.getUsername(), roleToUserForm.getRolename());
        return ResponseEntity.ok().build();
    }

}

@Data
class RoleToUserForm{
    private String username;

    private String rolename;
}
