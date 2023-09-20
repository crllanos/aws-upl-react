package cl.crllanos.awsuplreact.service;

import cl.crllanos.awsuplreact.entity.UserProfileEntity;
import cl.crllanos.awsuplreact.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProfileService {

    private final UserProfileRepository userProfileRepository;

    public List<UserProfileEntity> getUserProfileList(){
        return userProfileRepository.getUserProfileList();
    }
}
