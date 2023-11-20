package com.example.todo.user.auth;


import com.example.todo.user.auth.dto.TokenRefreshDto;
import com.example.todo.user.domain.jwt.Jwt;
import com.example.todo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    @GetMapping("/admin")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("ok");
    }

    @PostMapping("/refresh/token")
    public ResponseEntity<Jwt> tokenRefresh(@RequestBody TokenRefreshDto tokenRefreshDto) {
        Jwt jwt = userService.refreshToken(tokenRefreshDto.getRefreshToken());
        if (jwt == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(null);
        }
        return ResponseEntity.ok(jwt);
    }
}
