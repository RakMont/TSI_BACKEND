package PROYECTO_TSI.PROYECTO_TSI.CONTROLLERS;
import java.io.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import PROYECTO_TSI.PROYECTO_TSI.INTERFACES.UserDetailsImp;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.ERole;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.Role;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.User;
import PROYECTO_TSI.PROYECTO_TSI.REPOSITORIES.RoleRepository;
import PROYECTO_TSI.PROYECTO_TSI.REPOSITORIES.UserRepository;
import PROYECTO_TSI.PROYECTO_TSI.Security.JwtUtils;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.apache.commons.io.FileUtils;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.commons.io.FileUtils;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ServletContext context;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;


    public String createdefaultprofile(String genero)throws IOException{
        String nameofprofileimage;
        File file;
        if (genero.equals("Masculino")){
            file = new File("src/main/webApp/statics/Masculino.jpg");

        }
        else{
            if (genero.equals("Femenino")){
                file = new File("src/main/webApp/statics/Femenino.jpg");

            }
            else{
                file = new File("src/main/webApp/statics/otro.jpg");
            }
        }

        nameofprofileimage=file.getName();

        String modifiedFilename= FilenameUtils.getBaseName(nameofprofileimage)+"_"+System.currentTimeMillis()+"."+FilenameUtils.getExtension(nameofprofileimage);

        File serverfile=new java.io.File(context.getRealPath("/profiles/"+ java.io.File.separator+modifiedFilename));
        try{
            copyFileUsingStream(file,new File("src/main/webApp/profiles/"+modifiedFilename));
        }catch (IOException e){
            e.printStackTrace();
        }
        nameofprofileimage=modifiedFilename;

        return nameofprofileimage;

    }
    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        System.out.println("username " +loginRequest.getUsername()+"  password " + loginRequest.getPassword());

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImp userDetails = (UserDetailsImp) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) throws JsonParseException, JsonMappingException, IOException {

        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Nombre de usuario ocupado!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: correo ya esta en uso!"));
        }
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "mod":
                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }


        user.setNombre(signUpRequest.getNombre());

        user.setApellido(signUpRequest.getApellido());
        user.setLugar_acogida(signUpRequest.getLugar_acogida());
        String prueba=signUpRequest.getFecha_nacimiento();
        if (signUpRequest.getFecha_nacimiento().equals(null)){
            user.setFecha_nacimiento(null);

        }
        else{
            prueba=prueba.substring(0,10);
            Date fechaprueba=Date.valueOf(prueba);
            user.setFecha_nacimiento(fechaprueba);
        }

        user.setRoles(roles);
        user.setGenero(signUpRequest.getGenero());
        user.setTelefono(signUpRequest.getTelefono());
        user.setPerfil(signUpRequest.getPerfil());
        String var=user.getGenero();
        var=createdefaultprofile(var);
        user.setPerfil(var);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("USUARIO REGISTRADO EXITOSAMENTE!"));
    }
}

