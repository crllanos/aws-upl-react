package cl.crllanos.awsuplreact.service;

import cl.crllanos.awsuplreact.entity.UserProfileEntity;
import cl.crllanos.awsuplreact.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserProfileService {

    private final UserProfileRepository userProfileRepository;

    public List<UserProfileEntity> getUserProfileList(){
        return userProfileRepository.getUserProfileList();
    }

    public void uploadUserImage(UUID userId, MultipartFile file) {
        /**
         * - not empty
         * - check img
         * - user exists
         * - metadata
         * - store img on s3
         * - update img s3 link value
         */
    }
}
