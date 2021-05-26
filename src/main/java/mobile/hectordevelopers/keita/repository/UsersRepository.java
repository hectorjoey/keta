package mobile.hectordevelopers.keita.repository;

import mobile.hectordevelopers.keita.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*created by Hector Developers
06-08-2019
*/
@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    Users findByEmail(String email);

//    List<Users> findByUserId(Long userId);
}