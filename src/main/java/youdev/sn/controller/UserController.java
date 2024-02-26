package youdev.sn.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import youdev.sn.dto.RoleDto;
import youdev.sn.dto.UserDto;
import youdev.sn.services.RolesService;
import youdev.sn.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @GetMapping
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable("id") int id) {
        return userService.getUsers(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public UserDto createAppUser(@Valid @RequestBody UserDto userDto) {
        return userService.createUsers(userDto);
    }

    @PutMapping("/{id}")
    public UserDto  updateUser(@PathVariable("id") int id, @Valid @RequestBody UserDto userDto) {
        return userService.updateUsers(id,userDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        userService.deleteUsers(id);
    }
}
