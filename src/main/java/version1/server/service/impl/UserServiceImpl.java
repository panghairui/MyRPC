package version1.server.service.impl;

import version1.server.domain.UserDTO;
import version1.server.service.UserService;

import java.util.Random;
import java.util.UUID;

public class UserServiceImpl implements UserService {
    public UserDTO getUserByUserId(Integer id) {
        System.out.println("客户端查询了" + id + "的用户数据");
        // 模拟从数据库中取用户的行为
        Random random = new Random();
        UserDTO userDTO = UserDTO.builder()
                .id(id)
                .userName(UUID.randomUUID().toString())
                .sex(random.nextBoolean())
                .build();
        return userDTO;
    }
}
