package ru.mtuci.antivirus.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mtuci.antivirus.configuration.JwtTokenProvider;
import ru.mtuci.antivirus.models.User;
import ru.mtuci.antivirus.requests.AuthenticationRequest;
import ru.mtuci.antivirus.models.AuthenticationResponse;
import ru.mtuci.antivirus.repository.UserRepository;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> username(@RequestBody AuthenticationRequest request) {
        try {
            String username = request.getUsername();

            User user = userRepository.findByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));

            authenticationManager
                    .authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    username, request.getPassword())
                    );

            String token = jwtTokenProvider
                    .createToken(username, user.getRole().getGrantedAuthorities());

            return ResponseEntity.ok(new AuthenticationResponse(username, token));
        } catch (AuthenticationException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid login or password");
        }
    }
}
