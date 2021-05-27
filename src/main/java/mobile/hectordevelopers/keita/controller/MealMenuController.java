package mobile.hectordevelopers.keita.controller;

import mobile.hectordevelopers.keita.dto.CreateMenuDto;
import mobile.hectordevelopers.keita.enums.MenuStatus;
import mobile.hectordevelopers.keita.exception.ResourceNotFoundException;
import mobile.hectordevelopers.keita.model.Image;
import mobile.hectordevelopers.keita.model.MealMenu;
import mobile.hectordevelopers.keita.repository.ImageRepositry;
import mobile.hectordevelopers.keita.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/")
public class MealMenuController {
    @Autowired
    MenuRepository menuRepository;
    @Autowired
    ImageRepositry imageRepositry;

    @GetMapping("menu")
    List<MealMenu> getAllMenus() {
        return menuRepository.findAll();
    }

    @PostMapping(value = "menu", consumes = "multipart/form-data")
    //
    public ResponseEntity<Object> createMenu(@Valid CreateMenuDto mealMenu) throws IOException {
        mealMenu.setStatus(MenuStatus.ORDERED);


        System.out.println("Menu Name" + mealMenu.getMenu_name());
        System.out.println("Menu Price" + mealMenu.getMenu_price());
        System.out.println("Menu Size" + mealMenu.getSize());
        System.out.println("Menu category" + mealMenu.getCategory());
        System.out.println("Menu Protein" + mealMenu.getProteinType());
        System.out.println("Menu Image" + mealMenu.getMenuImage());
try {
//   InputStream initialStream = file.getInputStream();
//   byte[] buffer = new byte[initialStream.available()];

//   System.out.println(buffer.length);
    Image image =new Image();
    image.setContentType(mealMenu.getMenuImage().getContentType()==null?"":mealMenu.getMenuImage().getContentType());
    image.setData(mealMenu.getMenuImage().getBytes());
    image.setInUse(true);
     imageRepositry.save(image);


}catch(Exception e){
  //  e
    //
    // .printStackTrace();
}
       // 1. do we  save in database
        /*
        * going with 1 would just be for us to find out how spring saves file in db
        * mind you your db file size grows
        *
        *
        * */


        // 2. do we save in file path
        /*
        * going with 2
        * first save the recdrd
        * get the id of the saveed record
        * write the byte[] variable to a file
        * update th menuImage value with the id.
        * your databse would have something like 1.jpeg for menuImage.
        * */
       MealMenu menu =  new MealMenu();
       menu.setMenu_name(mealMenu.getMenu_name());
       menu.setMenu_price(mealMenu.getMenu_price());
       menu.setCategory(mealMenu.getCategory());
       menu.setSize(mealMenu.getSize());
       menu.setProteinType(mealMenu.getProteinType());
       menu.setStatus(MenuStatus.ORDERED);

        Image image = new Image();
        image.setData(mealMenu.getMenuImage().getBytes());
        image.setDescription( mealMenu.getMenu_name() +"Menu Image");
        image.setInUse(true);
        image.setContentType(mealMenu.getMenuImage().getContentType());
        imageRepositry.save(image);


        menu.setMenuImage(image);

        return new ResponseEntity<>(menuRepository.save(menu), HttpStatus.CREATED);
    }


    //delete menu
    @DeleteMapping("menu/{id}")
    public Map<String, Boolean> deleteMenu(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        MealMenu mealMenu = menuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("MealMenu not found for this id :: " + id));
        menuRepository.delete(mealMenu);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @PutMapping("menu/{id}")
    MealMenu updateMenu(@Valid MealMenu newMealMenu, @PathVariable Long id) {

        return menuRepository.findById(id)
                .map(mealMenu -> {
                    mealMenu.setStatus(newMealMenu.getStatus());
                    return menuRepository.save(mealMenu);
                })
                .orElseGet(() -> {
                    newMealMenu.setId(id);
                    return menuRepository.save(newMealMenu);
                });
    }

    @PatchMapping("menu/{id}")
    public MealMenu updateMenuStatus(@Valid MealMenu newMealMenu, @PathVariable Long id) {

        return menuRepository.findById(id)
                .map(mealMenu -> {
                    mealMenu.setCategory(newMealMenu.getCategory());
                    mealMenu.setMenu_name(newMealMenu.getMenu_name());
                    mealMenu.setMenu_price(newMealMenu.getMenu_price());
                    mealMenu.setProteinType(newMealMenu.getProteinType());
                    return menuRepository.save(mealMenu);
                })
                .orElseGet(() -> {
                    newMealMenu.setId(id);
                    return menuRepository.save(newMealMenu);
                });
    }
}
