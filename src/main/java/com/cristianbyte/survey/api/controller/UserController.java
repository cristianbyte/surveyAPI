package com.cristianbyte.survey.api.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    private final IUserService userService;
    @Operation(summary="Get all users", description="get all users paginated: require a page and the number of users")
    @GetMapping(path = "class")
    public Page<UserResponse> getAll(
        @RequestParam(defaultValue = "1") int page, 
        @RequestParam(defaultValue = "10") int size) {
        return this.userService.getAll(page, size);
    }
}
