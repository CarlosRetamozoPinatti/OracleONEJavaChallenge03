package com.forohub.ForoHub.controller;

import com.forohub.ForoHub.domain.users.User;
import com.forohub.ForoHub.domain.users.UserAuthenticationData;
import com.forohub.ForoHub.infra.security.DataJWTtoken;
import com.forohub.ForoHub.infra.security.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Operation(
            summary = "Authenticate a user",
            description = "This endpoint allows users to authenticate and obtain a JWT token.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = UserAuthenticationData.class)
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successful authentication, returns a JWT token"),
                    @ApiResponse(responseCode = "401", description = "Invalid credentials")
            }
    )
    @PostMapping
    public ResponseEntity authenticateUser(@RequestBody @Valid UserAuthenticationData userAuthenticationData) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(
                userAuthenticationData.email(),
                userAuthenticationData.password()
        );
        var userAuthenticated = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generToken((User) userAuthenticated.getPrincipal());
        return ResponseEntity.ok(new DataJWTtoken(JWTtoken));
    }
}
