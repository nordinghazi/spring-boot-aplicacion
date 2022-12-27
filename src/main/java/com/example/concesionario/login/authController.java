package com.example.concesionario.login;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class authController {
    private final adminService adminService;

    @GetMapping("/admins")
    private List<admin> allAdmins() {
        return adminService.allAdmins();
    }

    @PostMapping("/login")
    public respuestaToken login(@RequestBody @Valid admin adminLogin) throws NoSuchAlgorithmException {
        admin u = adminService.login(adminLogin);
        String token = getToken(u);
        return new respuestaToken(token);
    }

    @PostMapping("/registrar")
    @ResponseStatus(HttpStatus.CREATED)
    public void registro(@RequestBody @Valid admin userRegister) throws NoSuchAlgorithmException {
        adminService.insert(userRegister);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable int id) {
        adminService.delete(id);
    }

    @DeleteMapping("/borrar")
    public void borrar(@RequestParam String email) {
        adminService.delete(email);
    }

    private String getToken(admin user) {
        Algorithm algorithm = Algorithm.HMAC256("token101");
        String token = JWT.create()
                .withIssuer("nordin")
                .withClaim("id", user.getEmail())
                .withIssuedAt(new Date(System.currentTimeMillis()))
                .withExpiresAt(new Date(System.currentTimeMillis() + (24 * 60 * 60 * 1000))) // Caduca en un día
                .sign(algorithm);

        return token;
    }
}