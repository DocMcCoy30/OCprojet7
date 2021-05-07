package com.dmc30.userapi.service.contract;

import com.dmc30.userapi.shared.RoleDto;
import com.dmc30.userapi.shared.UsersDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsersService extends UserDetailsService {

    UsersDto createAbonne(UsersDto usersDto, Long paysId);
    UsersDto createEmploye(UsersDto usersDto);

    UsersDto getUserDetailsByEmail(String email);

}
