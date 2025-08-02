package in.sp.main.service;



import in.sp.main.dto.*;
import in.sp.main.entity.User;
import in.sp.main.repository.UserRepository;
import in.sp.main.config.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authManager;
    private final JwtUtils jwtUtils;

    public void register(RegisterRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepo.save(user);
    }

    public AuthResponse login(AuthRequest request) {
        Authentication auth = new UsernamePasswordAuthenticationToken(
                request.getEmail(), request.getPassword());
        authManager.authenticate(auth);

        String token = jwtUtils.generateToken(request.getEmail());
        return new AuthResponse(token);
    }
}

