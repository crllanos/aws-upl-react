package cl.crllanos.awsuplreact.repository;

import cl.crllanos.awsuplreact.entity.UserProfileEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class UserProfileRepositoryMock {

    private static final List<UserProfileEntity> USER_PROFILE = new ArrayList<>();

    static {
        USER_PROFILE.add(UserProfileEntity.builder()
                .profileId(UUID.randomUUID())
                .username("bwayne")
                .imageUrl(null)
                .build());
        USER_PROFILE.add(UserProfileEntity.builder()
                .profileId(UUID.randomUUID())
                .username("ckent")
                .imageUrl(null)
                .build());
    }

    public List<UserProfileEntity> getUserProfileList(){
        return USER_PROFILE;
    }
}








