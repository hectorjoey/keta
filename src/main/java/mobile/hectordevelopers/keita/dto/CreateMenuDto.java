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
    private String menu_name;
    private String menu_price;
    private String category;
    private String size;
    private String proteinType;
    private MenuStatus status;
    private MultipartFile menuImage;

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public String getMenu_price() {
        return menu_price;
    }

    public void setMenu_price(String menu_price) {
        this.menu_price = menu_price;
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
