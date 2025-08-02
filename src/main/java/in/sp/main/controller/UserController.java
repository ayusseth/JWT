package in.sp.main.controller;



import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.*;

@RestController
@SecurityRequirement(name = "bearerAuth")   //This forces Swagger to add the lock 🔒 icon and enable JWT header.
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/me")
    public String getCurrentUser() {
        return "This is a protected user endpoint";
    }
}
