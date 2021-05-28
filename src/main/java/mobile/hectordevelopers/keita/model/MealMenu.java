package mobile.hectordevelopers.keita.model;

import mobile.hectordevelopers.keita.enums.MenuStatus;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name = "menu")
public class MealMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String menuName;
    private String menuPrice;
    private String menuDescription;
    private String category;
    private String size;
    private String proteinType;
    private MenuStatus status;

    @OneToOne(fetch = FetchType.LAZY)
    private Image menuImage;
/*
    private byte[] mymenuImage;

    public byte[] getMymenuImage() {
        return mymenuImage;
    }

    public void setMymenuImage(byte[] mymenuImage) {
        this.mymenuImage = mymenuImage;
    }
    */

    public MealMenu() {
    }

    public MealMenu(String menuName, String menuPrice, String menuDescription, String category, String size, String proteinType, MenuStatus status, Image menuImage) {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuDescription = menuDescription;
        this.category = category;
        this.size = size;
        this.proteinType = proteinType;
        this.status = status;
        this.menuImage = menuImage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public Image getMenuImage() {
        return menuImage;
    }

    public void setMenuImage(Image menuImage) {
        this.menuImage = menuImage;
    }
}