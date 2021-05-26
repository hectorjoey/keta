package mobile.hectordevelopers.keita.controller;

import mobile.hectordevelopers.keita.dto.LoginDto;
import mobile.hectordevelopers.keita.response.ApiResponse;
import mobile.hectordevelopers.keita.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/")
public class LoginController {

@Autowired
    UsersService usersService;

    @PostMapping("login")
    public ApiResponse login(@Valid LoginDto loginDto){
        return usersService.login(loginDto);
    }
}
