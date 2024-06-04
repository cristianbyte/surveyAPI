package com.cristianbyte.survey.infrastructure.abstract_service;

import com.cristianbyte.survey.api.dto.request.UserRequest;
import com.cristianbyte.survey.api.dto.response.UserResponse;

public interface IUserService extends CrudAbstractService<UserRequest, UserResponse, Integer> {
    
}
