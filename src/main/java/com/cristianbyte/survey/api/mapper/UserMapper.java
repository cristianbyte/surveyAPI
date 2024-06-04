package com.cristianbyte.survey.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import com.cristianbyte.survey.api.dto.request.UserRequest;
import com.cristianbyte.survey.api.dto.response.UserResponse;
import com.cristianbyte.survey.domain.entities.User;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    
    User userRequestToUser(UserRequest userRequest);
    
    UserResponse userToUserResponse(User user);
    
    @Mapping(target = "password", ignore = true)
    void updateFromUserRequest(UserRequest request, @MappingTarget User user);
}
