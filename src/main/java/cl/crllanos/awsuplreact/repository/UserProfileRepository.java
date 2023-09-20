package cl.crllanos.awsuplreact.repository;

import cl.crllanos.awsuplreact.entity.UserProfileEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserProfileRepository {

    private final UserProfileRepositoryMock userProfileRepositoryMock;

    public List<UserProfileEntity> getUserProfileList(){
        return userProfileRepositoryMock.getUserProfileList();
    }

}
