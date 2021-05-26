package mobile.hectordevelopers.keita.model;

import mobile.hectordevelopers.keita.enums.MenuStatus;

import javax.persistence.*;

@Entity
@Table(name = "menu")
public class MealMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String menu_name;
    private String menu_price;
    private String category;
    private String size;
    private String proteinType;
    private MenuStatus status;
    private String menuImage;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getMenuImage() {
        return menuImage;
    }

    public void setMenuImage(String menuImage) {
        this.menuImage = menuImage;
    }
}