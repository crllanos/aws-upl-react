package cl.crllanos.awsuplreact.service;

import cl.crllanos.awsuplreact.entity.UserProfileEntity;
import cl.crllanos.awsuplreact.enums.BucketName;
import cl.crllanos.awsuplreact.filestore.S3Component;
import cl.crllanos.awsuplreact.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

import static org.apache.http.entity.ContentType.*;

@Service
@RequiredArgsConstructor
public class UserProfileService {

    private final UserProfileRepository userProfileRepository;

    private final S3Component s3Component;

    public List<UserProfileEntity> getUserProfileList(){
        return userProfileRepository.getUserProfileList();
    }

    public void uploadUserImage(UUID userId, MultipartFile file) {

        isFile(file);
        isImage(file);
        Map<String, String> metadata = getMetadata(file);
        UserProfileEntity userExist = getUserProfile(userId);

        // store img on s3
        String path = String.format("%s/%s"
                , BucketName.PROFILE_IMAGE.getBucketName()
                , userExist.getProfileId());
        String name = String.format("%s/%s"
                , file.getOriginalFilename()
                , UUID.randomUUID());
        try {
            s3Component.save(path, name, Optional.of(metadata), file.getInputStream());
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }





    private static void isFile(MultipartFile file) {
        if(file.isEmpty()){
            //if (Objects.isNull(file)) {
            throw new IllegalArgumentException("must provide a File");
        }
    }


    private static void isImage(MultipartFile file) {
        //String ext = file.getOriginalFilename().split("\\.")[1];
        //List<String> extValid = Stream.of("png", "gif", "jpg", "jpeg")
        //        .filter(ext::equals)
        //        .collect(Collectors.toList());
        //if(extValid.size() != 1){ // kE Hordinariez
        if(!Arrays.asList(IMAGE_JPEG.getMimeType(), IMAGE_PNG.getMimeType(), IMAGE_GIF.getMimeType())
                .contains(file.getContentType())){
            throw new IllegalArgumentException("file must be a valid image");
        }
    }

    private static Map<String, String> getMetadata(MultipartFile file) {
        Map<String, String> metadata = new HashMap<>();
        metadata.put("Content-Name", file.getOriginalFilename());
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length", String.valueOf(file.getSize()));
        return metadata;
    }

    private UserProfileEntity getUserProfile(UUID userId) {
        // cambiar ezta bazofia por una llamada al repository, no el mock
        // List<UserProfileEntity> userExist = getUserProfileList().stream()
        //          .filter(u -> { return u.getProfileId().equals(userId) ; })
        //          .collect(Collectors.toList());
        // if(userExist.size() == 0){ // kE Hordinariez
        UserProfileEntity userExist = getUserProfileList()
                .stream()
                .filter(u -> u.getProfileId().equals(userId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("user ID %s not found", userId)));
        return userExist;
    }
}
