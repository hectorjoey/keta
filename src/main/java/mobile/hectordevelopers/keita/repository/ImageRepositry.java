package mobile.hectordevelopers.keita.repository;

import mobile.hectordevelopers.keita.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Abbas Irekeola
 * @Email abbasirekeola@gmail.com
 * 26/05/2021-21:26
 */

@Repository
public interface ImageRepositry extends JpaRepository<Image, Long> {


}
