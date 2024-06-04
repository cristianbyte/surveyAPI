package com.cristianbyte.survey.infrastructure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.cristianbyte.survey.api.dto.request.UserRequest;
import com.cristianbyte.survey.api.dto.response.UserResponse;
import com.cristianbyte.survey.api.mapper.UserMapper;
import com.cristianbyte.survey.domain.repositories.UserRepository;
import com.cristianbyte.survey.infrastructure.abstract_service.IUserService;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class UserService implements IUserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final UserMapper userMapper;

    @Override
    public Page<UserResponse> getAll(int page, int size) {
                if (page <0) page = 0;

        PageRequest pagination = PageRequest.of(page -1, size);
        
        return this.userRepository.findAll(pagination)
                .map(userMapper::userToUserResponse);
    }

    @Override
    public UserResponse getById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public UserResponse create(UserRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public UserResponse update(Integer id, UserRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
