package PROYECTO_TSI.PROYECTO_TSI.CONTROLLERS;

import PROYECTO_TSI.PROYECTO_TSI.INTERFACES.ComentarioService;
import PROYECTO_TSI.PROYECTO_TSI.INTERFACES.UserDetailsImp;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.*;
import PROYECTO_TSI.PROYECTO_TSI.REPOSITORIES.ComentarioRepository;
import PROYECTO_TSI.PROYECTO_TSI.REPOSITORIES.RoleRepository;
import PROYECTO_TSI.PROYECTO_TSI.REPOSITORIES.UserRepository;
import PROYECTO_TSI.PROYECTO_TSI.Security.JwtUtils;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.validation.Valid;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ComentarioRepository comentarioRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    ServletContext context;
    @Autowired
    PasswordEncoder encoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;


    /*@GetMapping(path = {"/getprofile/{username}"})
    public UserProfileResponse listarId(@PathVariable("username") String username) {
        Optional<Role> s;
        Set<Role> brands;
        List<String>roles=new ArrayList<>();
        Optional<User> user=userRepository.findByUsername(username);
        brands=user.get().getRoles();
        s=brands.stream().findFirst();
        roles.add(s.get().getName().toString());
        //System.out.println("roles"+roles.get(0));

        UserProfileResponse userProfileResponse=new UserProfileResponse(user.get().getId(),user.get().getUsername(),user.get().getEmail(),user.get().getPassword(),user.get().getNombre(),user.get().getApellido(),user.get().getFecha_nacimiento(),user.get().getTelefono(),user.get().getPerfil(),user.get().getGenero(),user.get().getLugar_acogida(),roles);
       return userProfileResponse;

        // return userRepository.findByUsername(username);
    }*/
    @GetMapping(path = {"/getprofile/{username}"})
    public Optional<User> listarId(@PathVariable("username") String username) {
        //User user=
        // Optional<User> user=userRepository.findByUsername(username);

        return userRepository.findByUsername(username);
    }


    @GetMapping(value = "/getModersPhotos")
    @CrossOrigin
    public ResponseEntity<List<String>> getModersPhotos() {
        List<User> lista=userRepository.findAll();
        List<User>returnlist=new ArrayList<>();
        Optional<Role> s;
        Set<Role> brands;
        for (User u:lista){
            brands=u.getRoles();
            s=brands.stream().findFirst();
            if (s.get().getName().equals(ERole.ROLE_MODERATOR)){
                returnlist.add(u);
            }
        }
        List<String> historiaHVA=new ArrayList<String>();
        String filesPath =context.getRealPath("/profiles");

        /////////////////////////////////////////////////////

        ///////////////////////////////////////////////////
        File folder =new File(filesPath);
        File filefolder =new File(filesPath);


        if (filefolder!=null){
            for (User o:returnlist){
                for (final File file:filefolder.listFiles()){

                    if (o.getPerfil().equals(file.getName())){
                        if(!file.isDirectory()){
                            String encodeBase64=null;
                            try{
                                String extension=FilenameUtils.getExtension(file.getName());
                                FileInputStream fileInputStream=new FileInputStream(file);
                                byte[]bytes=new byte[(int)file.length()];
                                fileInputStream.read(bytes);
                                encodeBase64= Base64.getEncoder().encodeToString(bytes);
                                historiaHVA.add("data:image/"+extension+";base64,"+encodeBase64);
                                fileInputStream.close();;

                            }catch(Exception e){


                            }
                        }
                    }

                }
            }

        }

        return new ResponseEntity<List<String>>(historiaHVA,HttpStatus.OK);
    }

    @GetMapping(value = "/getUsersPhotos")
    @CrossOrigin
    public ResponseEntity<List<String>> getUsersPhotos() {
        List<User> lista=userRepository.findAll();
        List<User>returnlist=new ArrayList<>();
        Optional<Role> s;
        Set<Role> brands;
        for (User u:lista){
            brands=u.getRoles();
            s=brands.stream().findFirst();
            if (s.get().getName().equals(ERole.ROLE_USER)){
                returnlist.add(u);
            }
        }
        List<String> historiaHVA=new ArrayList<String>();
        String filesPath =context.getRealPath("/profiles");

        /////////////////////////////////////////////////////

        ///////////////////////////////////////////////////
        File folder =new File(filesPath);
        File filefolder =new File(filesPath);

        if (filefolder!=null){
            for (User o:returnlist){
                for (final File file:filefolder.listFiles()){

                    if (o.getPerfil().equals(file.getName())){
                        if(!file.isDirectory()){
                            String encodeBase64=null;
                            try{
                                String extension=FilenameUtils.getExtension(file.getName());
                                FileInputStream fileInputStream=new FileInputStream(file);
                                byte[]bytes=new byte[(int)file.length()];
                                fileInputStream.read(bytes);
                                encodeBase64= Base64.getEncoder().encodeToString(bytes);
                                historiaHVA.add("data:image/"+extension+";base64,"+encodeBase64);
                                fileInputStream.close();;

                            }catch(Exception e){


                            }
                        }
                    }

                }
            }

        }

        return new ResponseEntity<List<String>>(historiaHVA,HttpStatus.OK);
    }

    @GetMapping(path = {"/getprofilephoto/{username}"})
    @CrossOrigin
    public ResponseEntity<List<String>>getprofile(@PathVariable("username") String username) {
        List<User> lista=userRepository.findAll();
        Optional<User>userOptional=userRepository.findByUsername(username);
        String profiles=userOptional.get().getPerfil();
        String filesPath =context.getRealPath("/profiles");

        /////////////////////////////////////////////////////
        //List<User> lista = new ArrayList<User>();
        List<String>returnlist=new ArrayList<>();

        ///////////////////////////////////////////////////
        File folder =new File(filesPath);
        File filefolder =new File(filesPath);


        if (filefolder!=null){

                for (final File file:filefolder.listFiles()){

                    if (file.getName().equals(profiles)) {

                        if (!file.isDirectory()) {
                            String encodeBase64 = null;
                            try {
                                String extension = FilenameUtils.getExtension(file.getName());
                                FileInputStream fileInputStream = new FileInputStream(file);
                                byte[] bytes = new byte[(int) file.length()];
                                fileInputStream.read(bytes);
                                encodeBase64 = Base64.getEncoder().encodeToString(bytes);
                                returnlist.add("data:image/" + extension + ";base64," + encodeBase64);
                                fileInputStream.close();
                                ;

                            } catch (Exception e) {


                            }

                        }


                }
            }

        }

        return new ResponseEntity<List<String>>(returnlist,HttpStatus.OK);

    }


    @GetMapping(value = "/getprofilesModerator")
    @CrossOrigin
    public ResponseEntity<List<String>> getAllprofiles() {
        List<User> lista=userRepository.findAll();
        List<User>returnlist=new ArrayList<>();
        Optional<Role> s;
        Set<Role> brands;
        for (User u:lista){
            brands=u.getRoles();
            s=brands.stream().findFirst();
            if (s.get().getName().equals(ERole.ROLE_MODERATOR)){
                returnlist.add(u);
            }
        }
        List<String> profiles=new ArrayList<String>();
        String filesPath =context.getRealPath("/profiles");

        /////////////////////////////////////////////////////
        List<User>list=userRepository.findAll();
        //List<User> lista = new ArrayList<User>();
        int aux=1;
        int lenght=list.size();
        for( User o:returnlist){
            lista.add(returnlist.get(lenght-aux));
            aux++;
        }
        ///////////////////////////////////////////////////
        File folder =new File(filesPath);
        File filefolder =new File(filesPath);


        if (filefolder!=null){
            for (User o:lista){
                for (final File file:filefolder.listFiles()){

                    if (o.getPerfil().equals(file.getName())){
                        if(!file.isDirectory()){
                            String encodeBase64=null;
                            try{
                                String extension=FilenameUtils.getExtension(file.getName());
                                FileInputStream fileInputStream=new FileInputStream(file);
                                byte[]bytes=new byte[(int)file.length()];
                                fileInputStream.read(bytes);
                                encodeBase64= Base64.getEncoder().encodeToString(bytes);
                                profiles.add("data:image/"+extension+";base64,"+encodeBase64);
                                fileInputStream.close();;

                            }catch(Exception e){


                            }
                        }
                    }

                }
            }

        }

        return new ResponseEntity<List<String>>(profiles,HttpStatus.OK);
    }


    @PostMapping(value = "UpdateUserFile")
    public ResponseEntity<Response> UpdateAudioFile(@RequestParam("photo") Optional<MultipartFile> file2, @RequestParam("user")String audio)throws JsonParseException, JsonMappingException, IOException
    {
        User user=new ObjectMapper().readValue(audio,User.class);
        //user.setPerfil(file2.getOriginalFilename());
        Optional<User> user2=userRepository.findByUsername(user.getUsername());
        user.setPassword(user2.get().getPassword());

        if (file2.isPresent()) {
            MultipartFile file = file2.get();
            if (user.getPerfil().equals(file.getOriginalFilename())) {
                userRepository.save(user);
                return new ResponseEntity<Response>(new Response("user saved succesfull"), HttpStatus.OK);
            }
            else{
                if (user.getPerfil().equals(file.getOriginalFilename()))
                {
                    userRepository.save(user);
                    return new ResponseEntity<Response>(new Response("user saved succesfull"), HttpStatus.OK);
                }
                else{

                    String auxiliar = user.getPerfil();
                    File fileToDelete = new File("src/main/webApp/profiles/"+auxiliar);
                    fileToDelete.delete();

                    user.setPerfil(file.getOriginalFilename());

                    boolean isExist = new java.io.File(context.getRealPath("/profiles/")).exists();
                    if(!isExist){
                        new java.io.File(context.getRealPath("/profiles/")).mkdir();
                    }
                    String filename = file.getOriginalFilename();
                    String modifiedFilename= FilenameUtils.getBaseName(filename)+"_"+System.currentTimeMillis()+"."+FilenameUtils.getExtension(filename);

                    File serverfile=new java.io.File(context.getRealPath("/profiles/"+ java.io.File.separator+modifiedFilename));

                    try{
                        FileUtils.writeByteArrayToFile(serverfile,file.getBytes());
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    user.setPerfil(modifiedFilename);
                    User historiaVidaAudio1= userRepository.save(user);

                }
            }
        }

        else
        {
            userRepository.save(user);
            return new ResponseEntity<Response>(new Response(" saved succesfull"), HttpStatus.OK);
        }
        if(user!=null){
            return new ResponseEntity<Response>(new Response(" saved succesfull"), HttpStatus.OK);

        }else{
            return new ResponseEntity<Response>(new Response(" not saved"), HttpStatus.BAD_REQUEST);

        }
    }


    @PostMapping(value = "saveProfilePhoto")
    public ResponseEntity<Response> saveProfilePhoto(@RequestParam("photo") MultipartFile file, @RequestParam("user")String audio)throws JsonParseException, JsonMappingException, IOException
    {
        User user=new ObjectMapper().readValue(audio,User.class);
        user.setPerfil(file.getOriginalFilename());
        Optional<User> user2=userRepository.findByUsername(user.getUsername());
        user.setPassword(user2.get().getPassword());

        boolean isExist = new java.io.File(context.getRealPath("/profiles/")).exists();
        if(!isExist){
            new java.io.File(context.getRealPath("/profiles/")).mkdir();
        }
        String filename = file.getOriginalFilename();
        String modifiedFilename= FilenameUtils.getBaseName(filename)+"_"+System.currentTimeMillis()+"."+FilenameUtils.getExtension(filename);

        File serverfile=new java.io.File(context.getRealPath("/profiles/"+ java.io.File.separator+modifiedFilename));
        try{
            FileUtils.writeByteArrayToFile(serverfile,file.getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }
        user.setPerfil(modifiedFilename);


        User historiaVidaAudio1=userRepository.save(user);
        if(user!=null){
            return new ResponseEntity<Response>(new Response("User saved succesfull"), HttpStatus.OK);

        }else{
            return new ResponseEntity<Response>(new Response("User not saved"), HttpStatus.BAD_REQUEST);

        }
    }





    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }
    @GetMapping("/getallusers")
    public List<User> listarAllUsers() {
        List<User> lista=userRepository.findAll();
        List<User>returnlist=new ArrayList<>();
        Optional<Role> s;
        Set<Role> brands;
        for (User u:lista){
            brands=u.getRoles();
            s=brands.stream().findFirst();
            if (s.get().getName().equals(ERole.ROLE_USER)){
                returnlist.add(u);
            }
        }
        return returnlist;
    }

    @GetMapping("/getallmoderator")
    public List<User> getallmoderator() {
        List<User> lista=userRepository.findAll();
        List<User>returnlist=new ArrayList<>();
        Optional<Role> s;
        Set<Role> brands;
        for (User u:lista){
            brands=u.getRoles();
            s=brands.stream().findFirst();
            if (s.get().getName().equals(ERole.ROLE_MODERATOR)){
                returnlist.add(u);
            }
        }
        return returnlist;
    }


    @DeleteMapping(path = {"/deleteuser/{username}"})
    public User deleteuser(@PathVariable("username") String username) {
        Optional<User> user= userRepository.findByUsername(username);
        List<Comentario>comentarioList=comentarioRepository.findAll();
        User user2=user.get();
        if (user2!=null){
            for (Comentario c:comentarioList){
                if (c.getUser().getId()==user2.getId()){
                    comentarioRepository.delete(c);
                }
            }
            user2.getRoles().clear();
            userRepository.delete(user2);
        }
        return user2;
    }

    @PostMapping("/updateprofile")
    public ResponseEntity<?> editprofile(@RequestBody UpdateRequest signUpRequest) {
        Optional<User> prueba2=userRepository.findById(signUpRequest.getId());
        if (!(prueba2.get().getUsername().equals(signUpRequest.getUsername()))){
            if (userRepository.existsByUsername(signUpRequest.getUsername())) {
                return ResponseEntity
                        .badRequest()
                        .body(new MessageResponse("Error: Username is already taken!"));
            }
            else{
                LoginRequest loginRequest=new LoginRequest();
                loginRequest.setPassword(signUpRequest.getPassword());
                loginRequest.setUsername(signUpRequest.getUsername());

            ///////////////////////////////////////////////////////////////////////



                if (!(prueba2.get().getEmail().equals(signUpRequest.getEmail()))){

                    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
                        return ResponseEntity
                                .badRequest()
                                .body(new MessageResponse("Error: Email is already in use!"));
                    }
                }
                User user = new User(signUpRequest.getUsername(),
                        signUpRequest.getEmail(),
                        encoder.encode(signUpRequest.getPassword()));

                Set<String> strRoles = signUpRequest.getRole();
                Set<Role> roles2 = new HashSet<>();

                Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                        .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                roles2.add(userRole);
                user.setPerfil(signUpRequest.getPerfil());
                user.setGenero(signUpRequest.getGenero());
                user.setTelefono(signUpRequest.getTelefono());
                user.setNombre(signUpRequest.getNombre());
                user.setApellido(signUpRequest.getApellido());
                user.setLugar_acogida(signUpRequest.getLugar_acogida());
                String prueba=signUpRequest.getFecha_nacimiento();
                prueba=prueba.substring(0,10);
                Date fechaprueba=Date.valueOf(prueba);
                user.setFecha_nacimiento(fechaprueba);
                user.setRoles(roles2);
                user.setId(signUpRequest.getId());
                userRepository.save(user);

               AuthController authController=new AuthController();
               authController.authenticateUser(loginRequest);

                ResponseEntity.ok(new MessageResponse("USUARIO REGISTRADO EXITOSAMENTE!"));
                //////////////////////////////////////////////////////////////////////
            }
        }

        if (!(prueba2.get().getEmail().equals(signUpRequest.getEmail()))){
            if (userRepository.existsByEmail(signUpRequest.getEmail())) {
                    return ResponseEntity
                            .badRequest()
                            .body(new MessageResponse("Error: Correo ya en uso!"));
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

        user.setPerfil(signUpRequest.getPerfil());
        user.setGenero(signUpRequest.getGenero());
        user.setTelefono(signUpRequest.getTelefono());
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
    @PostMapping("/updateprofilemoderator")
    public ResponseEntity<?> updateprofilemoderator(@Valid @RequestBody UpdateRequest signUpRequest) {

        Optional<User> prueba2=userRepository.findById(signUpRequest.getId());

        if (!(prueba2.get().getUsername().equals(signUpRequest.getUsername()))){
            if (userRepository.existsByUsername(signUpRequest.getUsername())) {
                return ResponseEntity
                        .badRequest()
                        .body(new MessageResponse("Error: Username is already taken!"));
            }
            else{
                LoginRequest loginRequest=new LoginRequest();
                loginRequest.setPassword(signUpRequest.getPassword());
                loginRequest.setPassword(signUpRequest.getUsername());

                ///////////////////////////////////////////////////////////////////////

                Authentication authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

                SecurityContextHolder.getContext().setAuthentication(authentication);
                String jwt = jwtUtils.generateJwtToken(authentication);

                UserDetailsImp userDetails = (UserDetailsImp) authentication.getPrincipal();
                List<String> roles = userDetails.getAuthorities().stream()
                        .map(item -> item.getAuthority())
                        .collect(Collectors.toList());

                if (!(prueba2.get().getEmail().equals(signUpRequest.getEmail()))){

                    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
                        return ResponseEntity
                                .badRequest()
                                .body(new MessageResponse("Error: Email is already in use!"));
                    }
                }
                User user = new User(signUpRequest.getUsername(),
                        signUpRequest.getEmail(),
                        encoder.encode(signUpRequest.getPassword()));

                Set<String> strRoles = signUpRequest.getRole();
                Set<Role> roles2 = new HashSet<>();

                Role userRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                        .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                roles2.add(userRole);
                user.setPerfil(signUpRequest.getPerfil());
                user.setGenero(signUpRequest.getGenero());
                user.setTelefono(signUpRequest.getTelefono());
                user.setNombre(signUpRequest.getNombre());
                user.setApellido(signUpRequest.getApellido());
                user.setLugar_acogida(signUpRequest.getLugar_acogida());
                String prueba=signUpRequest.getFecha_nacimiento();
                prueba=prueba.substring(0,10);
                Date fechaprueba=Date.valueOf(prueba);
                user.setFecha_nacimiento(fechaprueba);
                user.setRoles(roles2);
                user.setId(signUpRequest.getId());
                userRepository.save(user);
                return ResponseEntity.ok(new JwtResponse(jwt,
                        userDetails.getId(),
                        userDetails.getUsername(),
                        userDetails.getEmail(),
                        roles));
                //////////////////////////////////////////////////////////////////////
            }
        }

        if (!(prueba2.get().getEmail().equals(signUpRequest.getEmail()))){

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

        Role userRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(userRole);

        user.setPerfil(signUpRequest.getPerfil());
        user.setGenero(signUpRequest.getGenero());
        user.setTelefono(signUpRequest.getTelefono());
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
    @PostMapping("/updateprofileadmin")
    public ResponseEntity<?> updateprofileadmin(@Valid @RequestBody UpdateRequest signUpRequest) {

        Optional<User> prueba2=userRepository.findById(signUpRequest.getId());

        if (!(prueba2.get().getUsername().equals(signUpRequest.getUsername()))){
            if (userRepository.existsByUsername(signUpRequest.getUsername())) {
                return ResponseEntity
                        .badRequest()
                        .body(new MessageResponse("Error: Username is already taken!"));
            }
            else{
                LoginRequest loginRequest=new LoginRequest();
                loginRequest.setPassword(signUpRequest.getPassword());
                loginRequest.setPassword(signUpRequest.getUsername());

                ///////////////////////////////////////////////////////////////////////

                Authentication authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

                SecurityContextHolder.getContext().setAuthentication(authentication);
                String jwt = jwtUtils.generateJwtToken(authentication);

                UserDetailsImp userDetails = (UserDetailsImp) authentication.getPrincipal();
                List<String> roles = userDetails.getAuthorities().stream()
                        .map(item -> item.getAuthority())
                        .collect(Collectors.toList());

                if (!(prueba2.get().getEmail().equals(signUpRequest.getEmail()))){

                    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
                        return ResponseEntity
                                .badRequest()
                                .body(new MessageResponse("Error: Email is already in use!"));
                    }
                }
                User user = new User(signUpRequest.getUsername(),
                        signUpRequest.getEmail(),
                        encoder.encode(signUpRequest.getPassword()));

                Set<String> strRoles = signUpRequest.getRole();
                Set<Role> roles2 = new HashSet<>();

                Role userRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                        .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                roles2.add(userRole);
                user.setPerfil(signUpRequest.getPerfil());
                user.setGenero(signUpRequest.getGenero());
                user.setTelefono(signUpRequest.getTelefono());
                user.setNombre(signUpRequest.getNombre());
                user.setApellido(signUpRequest.getApellido());
                user.setLugar_acogida(signUpRequest.getLugar_acogida());
                String prueba=signUpRequest.getFecha_nacimiento();
                prueba=prueba.substring(0,10);
                Date fechaprueba=Date.valueOf(prueba);
                user.setFecha_nacimiento(fechaprueba);
                user.setRoles(roles2);
                user.setId(signUpRequest.getId());
                userRepository.save(user);
                return ResponseEntity.ok(new JwtResponse(jwt,
                        userDetails.getId(),
                        userDetails.getUsername(),
                        userDetails.getEmail(),
                        roles));
                //////////////////////////////////////////////////////////////////////
            }
        }

        if (!(prueba2.get().getEmail().equals(signUpRequest.getEmail()))){

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

        Role userRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(userRole);

        user.setPerfil(signUpRequest.getPerfil());
        user.setGenero(signUpRequest.getGenero());
        user.setTelefono(signUpRequest.getTelefono());
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
        return ResponseEntity.ok(new MessageResponse("ADMINISTRADOR ACTUALIZADO EXITOSAMENTE!"));
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
