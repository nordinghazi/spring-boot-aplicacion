package com.example.concesionario.login;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
@Service
public class adminService {

    private final adminRepository adminRepository;

    public List<admin> allAdmins() {
        return adminRepository.findAll();
    }

    public admin login(admin adminLogin) throws NoSuchAlgorithmException {
        return adminRepository.findByEmailAndPassword(adminLogin.getEmail(), encodePassword(adminLogin.getPassword()))
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Correo y/o contraseña no válidos"));
    }

    public admin insert(admin u) throws NoSuchAlgorithmException {
        u.setPassword(encodePassword(u.getPassword()));
        return adminRepository.save(u);
    }

    public void delete(int id) throws IllegalArgumentException {
        adminRepository.deleteById(id);
    }

    public void delete(String email) throws IllegalArgumentException {
        adminRepository.deleteByEmail(email);
    }

    private String encodePassword(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        String encodedPass = Base64.getEncoder().encodeToString(hash);
        return encodedPass;
    }

}
