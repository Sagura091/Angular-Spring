package HelloWorld.HelloWorld;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.joran.action.LoggerAction;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("employees/auth")
public class AuthController {
    

    private static final Logger logger = LoggerFactory.getLogger(jwtUtils.class);
    @Autowired
    AuthenticationManager authenticationManager;
    
    @Autowired
    usersRepository userRepo;
    @Autowired
    RoleRepository roleRepo;

    @Autowired
    PasswordEncoder encode;


    @Autowired
	private jwtUtils jwtTokenUtil;


 @PostMapping("/signin")
 public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest)
 {
     Authentication authentication = authenticationManager.authenticate(
         new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
     );
     SecurityContextHolder.getContext().setAuthentication(authentication);
     String jwt = jwtTokenUtil.generateJwtToken(authentication);
     
     usersDetailsImpl userDetails = (usersDetailsImpl) authentication.getPrincipal();    
     List<String> roles = userDetails.getAuthorities().stream()
         .map(item -> item.getAuthority())
         .collect(Collectors.toList());
 
     return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), 
                          userDetails.getUsername(), 
                          userDetails.getEmail(), 
                          roles));
 }

 @PostMapping("/signup")
 public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
   if (userRepo.existsByUsername(signUpRequest.getUsername())) {
     return ResponseEntity
         .badRequest()
         .body(new MessageResponse("Error: Username is already taken!"));
   }

   if (userRepo.existsByEmail(signUpRequest.getEmail())) {
     return ResponseEntity
         .badRequest()
         .body(new MessageResponse("Error: Email is already in use!"));
   }

   // Create new user's account
   users user = new users(signUpRequest.getUsername(), 
              signUpRequest.getEmail(),
              encode.encode(signUpRequest.getPassword()));

   Set<String> strRoles = signUpRequest.getRole();
   Set<Role> roles = new HashSet<>();

   if (strRoles == null) {
     Role userRole = roleRepo.findByName(ERole.ROLE_USER)
         .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
     roles.add(userRole);
   } else {
     strRoles.forEach(role -> {
       switch (role) {
       case "admin":
       logger.info("I FELL IN ADMIN");
         Role adminRole = roleRepo.findByName(ERole.ROLE_ADMIN)
             .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
         roles.add(adminRole);

         break;
       case "mod":
       logger.info("mod");
         Role modRole = roleRepo.findByName(ERole.ROLE_MODERATOR)
             .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
         roles.add(modRole);

         break;
       default:
      // logger.info("Role not found");
         Role userRole = roleRepo.findByName(ERole.ROLE_USER)
             .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
         roles.add(userRole);
       }
     });
   }

   user.setRoles(roles);
   userRepo.save(user);

   return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
 }

}
