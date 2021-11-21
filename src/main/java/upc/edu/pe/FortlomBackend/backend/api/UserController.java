package upc.edu.pe.FortlomBackend.backend.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.FortlomBackend.backend.domain.service.UserService;
import upc.edu.pe.FortlomBackend.backend.mapping.UserMapper;
import upc.edu.pe.FortlomBackend.backend.resource.CreateUserResource;
import upc.edu.pe.FortlomBackend.backend.resource.UpdateUserResource;
import upc.edu.pe.FortlomBackend.backend.resource.UserResource;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper mapper;


    @GetMapping
    public Page<UserResource> getAllUsers(Pageable pageable) {
        return mapper.modelListToPage(userService.getAll(), pageable);
    }
    @GetMapping("{userId}")
    public UserResource getUserById(@PathVariable("userId") Long userId) {
        return mapper.toResource(userService.getById(userId));
    }
    @PostMapping
    public UserResource createUser(@RequestBody CreateUserResource request) {

        return mapper.toResource(userService.create(mapper.toModel(request)));
    }
    @PutMapping("{userId}")
    public UserResource updateUser(@PathVariable Long userId, @RequestBody UpdateUserResource request) {
        return mapper.toResource(userService.update(userId, mapper.toModel(request)));
    }
    @DeleteMapping("{userId}")
    public ResponseEntity<?> deletePost(@PathVariable Long userId) {
        return userService.delete(userId);
    }







}
