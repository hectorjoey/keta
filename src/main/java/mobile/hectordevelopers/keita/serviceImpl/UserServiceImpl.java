package mobile.hectordevelopers.keita.serviceImpl;

/*created by Hector Developers
06-08-2019
*/
import mobile.hectordevelopers.keita.dto.LoginDto;
import mobile.hectordevelopers.keita.model.Users;
import mobile.hectordevelopers.keita.repository.UsersRepository;
import mobile.hectordevelopers.keita.response.ApiResponse;
import mobile.hectordevelopers.keita.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class UserServiceImpl implements UsersService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final UsersRepository usersRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UsersRepository usersRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usersRepository = usersRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    public ApiResponse login(LoginDto loginDto) {
        Users user = usersRepository.findByEmail(loginDto.getEmail());
        if (user == null) {
            throw new IllegalArgumentException(String.format("User with email %s does not exist!.", loginDto.getEmail()));
        }
        if (!BCrypt.checkpw(loginDto.getPassword(),user.getPassword())) {

            throw new RuntimeException("Password mismatch!.");
        }
        return new ApiResponse(200, "Login success!", null, user.getUserType(), user.getEmail(),user.getFirstname(), user.getId());

    }

    @Override
    public boolean isUserAlreadyPresent(Users users) {
        boolean isUserAlreadyExists = false;
        Users existingUser = usersRepository.findByEmail(users.getEmail());
        // If user is found in database, then then user already exists.
        if (existingUser != null) {
            isUserAlreadyExists = true;
        }
        return isUserAlreadyExists;
    }


    @Override
    public void save(Users users) {
        users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
        users.setReferralCode(users.getReferralCode());
        usersRepository.save(users);
    }

    @Override
    public Users updateUser(Users users) {
        return null;
    }

    @Override
    public Users deleteUser(String username) {
        return null;
    }
}
