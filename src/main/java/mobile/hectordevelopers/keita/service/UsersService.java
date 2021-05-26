package mobile.hectordevelopers.keita.service;


import mobile.hectordevelopers.keita.dto.LoginDto;
import mobile.hectordevelopers.keita.model.Users;
import mobile.hectordevelopers.keita.response.ApiResponse;
import org.springframework.stereotype.Service;


/*created by Hector Developers
06-08-2019
*/

@Service
public interface UsersService {

    ApiResponse login(LoginDto loginDto);

    boolean isUserAlreadyPresent(Users users);

    void save(Users users);

    Users updateUser(Users users);

    Users deleteUser(String email);


}
