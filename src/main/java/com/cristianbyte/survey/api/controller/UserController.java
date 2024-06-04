package com.cristianbyte.survey.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cristianbyte.survey.api.dto.request.UserRequest;
import com.cristianbyte.survey.api.dto.response.UserResponse;
import com.cristianbyte.survey.infrastructure.abstract_service.IUserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/users")
@AllArgsConstructor
@Tag(name = "Users")
public class UserController {
    @Autowired
    private final IUserService userService;

    @Operation(summary="Get all users", description="get all users paginated: require a page and the number of users")
    @GetMapping
    public Page<UserResponse> getAll(
        @RequestParam(defaultValue = "1") int page, 
        @RequestParam(defaultValue = "10") int size) {
        return this.userService.getAll(page, size);
    }

    @GetMapping("/{id}")
    @Operation(summary="Get user by id", description="get user by id")
    public  ResponseEntity<UserResponse> getMethodName(@PathVariable Integer id) {
        return ResponseEntity.ok(this.userService.getById(id));
    }

    @Operation(summary="Create a user", description="create a user")
    @PostMapping
    public ResponseEntity<UserResponse> create(@Validated @RequestBody UserRequest request) {
        return ResponseEntity.ok(this.userService.create(request));
    }
}
