package com.lephuocviet.forum.controller;

import com.lephuocviet.forum.dto.requests.UserRequest;
import com.lephuocviet.forum.dto.responses.UserResponse;
import com.lephuocviet.forum.exception.ApiResponses;
import com.lephuocviet.forum.service.IUserService;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@CrossOrigin(origins = "*")
public class UserController {

    IUserService userService;

    @PostMapping
    ResponseEntity<ApiResponses<UserResponse>> create(@RequestBody UserRequest userRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponses.<UserResponse>builder()
                .result(userService.createUser(userRequest))
                .build());

    }

    @GetMapping("/my-infor")
    ResponseEntity<ApiResponses<UserResponse>> getMyInfor() {
        return ResponseEntity.ok(ApiResponses.<UserResponse>builder()
                .result(userService.getMyInformation())
                .build());
    }

}
