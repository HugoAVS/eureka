package com.jeoldev.userinfo.mapper;

import com.jeoldev.userinfo.dto.UserDTO;
import com.jeoldev.userinfo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "usrId", target = "userId")
    @Mapping(source = "address", target = "address")
    UserDTO mapUserToUserDTO(User user);

    @Mapping(source = "userId", target = "usrId")
    @Mapping(source = "address", target = "address")
    User mapUserDTOToUser(UserDTO userDTO);
}
