package cl.crllanos.awsuplreact.controller;

import cl.crllanos.awsuplreact.entity.UserProfileEntity;
import cl.crllanos.awsuplreact.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/user-profile")
@RequiredArgsConstructor
public class UserProfileController {

    private final UserProfileService userProfileService;

    @GetMapping
    public List<UserProfileEntity> listUserProfile(){
            return userProfileService.getUserProfileList();
    }
}
