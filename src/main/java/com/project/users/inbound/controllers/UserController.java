package com.project.users.inbound.controllers;

import com.project.users.exceptions.UserNotFoundException;
import com.project.users.inbound.responses.UserDetailsResponse;
import com.project.users.services.UserInfoService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Data
@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/v1/admin/users")
public class UserController {

    private final UserInfoService userInfoService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDetailsResponse> getUserDetails (
            @PathVariable String id
    ) throws UserNotFoundException {
        log.info("Retrieving User Details");
        return ResponseEntity.ok(userInfoService.getUserDetails(id));
    }

}
