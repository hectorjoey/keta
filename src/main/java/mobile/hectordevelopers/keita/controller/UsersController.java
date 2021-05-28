package mobile.hectordevelopers.keita.controller;

import mobile.hectordevelopers.keita.enums.UserType;
import mobile.hectordevelopers.keita.exception.EmailExistsException;
import mobile.hectordevelopers.keita.exception.ResourceNotFoundException;
import mobile.hectordevelopers.keita.model.Users;
import mobile.hectordevelopers.keita.repository.UsersRepository;
import mobile.hectordevelopers.keita.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/api/v1/")
public class UsersController {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    UsersService usersService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @GetMapping("users")
    List<Users> getUsers() {
        return usersRepository.findAll();
    }

    //get User by Id
    @GetMapping("user/{id}")
    public ResponseEntity<Users> getMemberById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Users users = usersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));
        return ResponseEntity.ok().body(users);
    }

    @PostMapping("users")
    public ResponseEntity<Object> createUser(@Valid Users users) throws EmailExistsException {
        Users usersEmail = usersRepository.findByEmail(users.getEmail());
        if (usersEmail != null) {
            throw new EmailExistsException(String.format("User with email %s already exist", users.getEmail()));
        }
        users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
        users.setUserType(UserType.USER);

        // Generate random id, for example 283952-V8M32
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder((100000 + rnd.nextInt(900000)) + "-");
        for (int i = 0; i < 5; i++)
            sb.append(chars[rnd.nextInt(chars.length)]);

//        return sb.toString();
        users.setReferralCode(sb.toString());

        return new ResponseEntity<>(usersRepository.save(users), HttpStatus.CREATED);
    }


    //delete user
    @DeleteMapping("user/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Users user = usersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));
        usersRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @PutMapping("user/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable(value = "id") Long id,
                                            @Valid @RequestBody Users user) throws ResourceNotFoundException {
        Users user1 = usersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));

        user.setEmail(user.getEmail());
        user.setFirstname(user.getFirstname());
        user.setLastname(user.getLastname());
        final Users updatedUser = usersRepository.save(user1);
        return ResponseEntity.ok(updatedUser);
    }

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Welcome to keita Server!";
    }
}