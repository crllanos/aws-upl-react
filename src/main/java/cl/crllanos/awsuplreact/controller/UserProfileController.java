package cl.crllanos.awsuplreact.controller;

import cl.crllanos.awsuplreact.entity.UserProfileEntity;
import cl.crllanos.awsuplreact.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/user-profile")
@RequiredArgsConstructor
public class UserProfileController {

    private final UserProfileService userProfileService;

    @GetMapping
    public List<UserProfileEntity> listUserProfile(){
            return userProfileService.getUserProfileList();
    }

    @PostMapping(
            path = "{userId}/image/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void uploadUserImage(@PathVariable("userId") UUID userId,
                                @RequestParam("file") MultipartFile file){

        userProfileService.uploadUserImage(userId, file);
    }
}
