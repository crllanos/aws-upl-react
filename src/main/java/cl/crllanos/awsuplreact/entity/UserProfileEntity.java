package cl.crllanos.awsuplreact.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileEntity {
    private UUID profileId;
    private String username;
    private String imageUrl; //s3 key
}
