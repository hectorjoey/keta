package mobile.hectordevelopers.keita.dto;

import mobile.hectordevelopers.keita.enums.MenuStatus;
import mobile.hectordevelopers.keita.model.Image;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.FetchType;
import javax.persistence.OneToOne;

/**
 * @author Abbas Irekeola
 * @Email abbasirekeola@gmail.com
 * 27/05/2021-15:34
 */
public class CreateMenuDto {
    private String menuName;
    private String menuPrice;
    private String menuDescription;
    private String category;
    private String size;
    private String proteinType;
    private MenuStatus status;
    private MultipartFile menuImage;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(String menuPrice) {
        this.menuPrice = menuPrice;
    }

    public String getMenuDescription() {
        return menuDescription;
    }

    public void setMenuDescription(String menuDescription) {
        this.menuDescription = menuDescription;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getProteinType() {
        return proteinType;
    }

    public void setProteinType(String proteinType) {
        this.proteinType = proteinType;
    }

    public MenuStatus getStatus() {
        return status;
    }

    public void setStatus(MenuStatus status) {
        this.status = status;
    }

    public MultipartFile getMenuImage() {
        return menuImage;
    }

    public void setMenuImage(MultipartFile menuImage) {
        this.menuImage = menuImage;
    }
}
