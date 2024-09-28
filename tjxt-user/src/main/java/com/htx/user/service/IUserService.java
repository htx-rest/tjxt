package com.htx.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.htx.api.dto.user.LoginFormDTO;
import com.htx.api.dto.user.UserDTO;
import com.htx.common.domain.dto.LoginUserDTO;
import com.htx.user.domain.dto.UserFormDTO;
import com.htx.user.domain.po.User;
import com.htx.user.domain.vo.UserDetailVO;

/**
 * <p>
 * 学员用户表 服务类
 * </p>
 */
public interface IUserService extends IService<User> {
    LoginUserDTO queryUserDetail(LoginFormDTO loginDTO, boolean isStaff);

    void resetPassword(Long userId);

    UserDetailVO myInfo();

    void addUserByPhone(User user, String code);

    void updatePasswordByPhone(String cellPhone, String code, String password);

    Long saveUser(UserDTO userDTO);

    void updateUser(UserDTO userDTO);

    void updateUserWithPassword(UserFormDTO userDTO);
}
