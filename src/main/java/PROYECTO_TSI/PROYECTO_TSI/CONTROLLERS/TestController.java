package PROYECTO_TSI.PROYECTO_TSI.CONTROLLERS;

import PROYECTO_TSI.PROYECTO_TSI.MODELS.*;
import PROYECTO_TSI.PROYECTO_TSI.REPOSITORIES.RoleRepository;
import PROYECTO_TSI.PROYECTO_TSI.REPOSITORIES.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }
    @GetMapping("/getallusers")
    public List<User> listarAllUsers() {
        //User user=
        return userRepository.findAll();
    }

    @GetMapping(path = {"/getprofile/{username}"})
    public Optional<User> listarId(@PathVariable("username") String username) {
        //User user=
        return userRepository.findByUsername(username);
    }
    @DeleteMapping(path = {"/deleteuser/{username}"})
    public User deleteuser(@PathVariable("username") String username) {
        Optional<User> user= userRepository.findByUsername(username);
        User user2=user.get();
        if (user2!=null){
            userRepository.delete(user2);
        }
        System.out.println("id es"+user2.getId());
        return user2;
    }

    @PutMapping ("/updateprofile")
    public ResponseEntity<?> editprofile(@Valid @RequestBody UpdateRequest signUpRequest) {
        //User user=
        /*System.out.println("this is the id"+signUpRequest.getId());
        System.out.println("this is the id"+signUpRequest.getEmail());
        System.out.println("this is the id"+signUpRequest.getUsername());
        System.out.println("this is the id"+signUpRequest.getNombre());
        System.out.println("this is the id"+signUpRequest.getApellido());
        System.out.println("this is the id"+signUpRequest.getPassword());
*/
        Optional<User> prueba2=userRepository.findById(signUpRequest.getId());

        if (!(prueba2.get().getUsername().equals(signUpRequest.getUsername()))){
            System.out.println("entra a username diferente");
            if (userRepository.existsByUsername(signUpRequest.getUsername())) {
                return ResponseEntity
                        .badRequest()
                        .body(new MessageResponse("Error: Username is already taken!"));
            }
        }

        if (!(prueba2.get().getEmail().equals(signUpRequest.getEmail()))){
            System.out.println("entra a email diferente");

            if (userRepository.existsByEmail(signUpRequest.getEmail())) {
                    return ResponseEntity
                            .badRequest()
                            .body(new MessageResponse("Error: Email is already in use!"));
                }
        }



        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(userRole);

        user.setNombre(signUpRequest.getNombre());
        user.setApellido(signUpRequest.getApellido());
        user.setLugar_acogida(signUpRequest.getLugar_acogida());
        String prueba=signUpRequest.getFecha_nacimiento();
        prueba=prueba.substring(0,10);
        Date fechaprueba=Date.valueOf(prueba);
        user.setFecha_nacimiento(fechaprueba);
        user.setRoles(roles);
        user.setId(signUpRequest.getId());
        userRepository.save(user);
        return ResponseEntity.ok(new MessageResponse("USUARIO REGISTRADO EXITOSAMENTE!"));
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String userAccess() {
        return "User Content.";
    }

    @GetMapping("/mod")
    @PreAuthorize("hasRole('MODERATOR')")
    public String moderatorAccess() {
        return "Moderator Board.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }
}
