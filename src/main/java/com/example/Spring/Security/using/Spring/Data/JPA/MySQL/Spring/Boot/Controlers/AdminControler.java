package com.example.Spring.Security.using.Spring.Data.JPA.MySQL.Spring.Boot.Controlers;

import com.example.Spring.Security.using.Spring.Data.JPA.MySQL.Spring.Boot.Entities.AuthRequest;
import com.example.Spring.Security.using.Spring.Data.JPA.MySQL.Spring.Boot.Entities.User;
import com.example.Spring.Security.using.Spring.Data.JPA.MySQL.Spring.Boot.Repositories.UserRepository;
import com.example.Spring.Security.using.Spring.Data.JPA.MySQL.Spring.Boot.Util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
 public class AdminControler {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    /*Registration*/
    @PostMapping("/register")
    public String addUserByAdmin (@RequestBody User user) {
      String BcryptPassword =  bCryptPasswordEncoder.encode(user.getPassword());
      user.setPassword(BcryptPassword);

        Optional<User> existedMail =  userRepository.findByEmail(user.getEmail());


        if(existedMail.isEmpty()) {
            userRepository.save(user);
            return "user added successfully";
        } else {
            return   "User already registred !!!";
        }
    }

    @GetMapping("/")
    public String home(){
        return ("<h1>Welcome</h1>");
    }

    @GetMapping("/user")
    public String user(){
        return ("<h1>Welcome user</h1>");
    }

    @GetMapping("/admin")
    public String admin(){
        return ("<h1>Welcome admin</h1>");
    }


    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;



    /*login*/
    @PostMapping("/login")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(),authRequest.getPassword()));
        }
        catch (Exception ex){
            throw new Exception("invalid userName/password");
        }
        return jwtUtil.generateToken(authRequest.getEmail());
    }



















}
