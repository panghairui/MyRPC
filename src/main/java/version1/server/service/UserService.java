package version1.server.service;

import version1.server.domain.UserDTO;

public interface UserService {

    UserDTO getUserByUserId(Integer id);

}
