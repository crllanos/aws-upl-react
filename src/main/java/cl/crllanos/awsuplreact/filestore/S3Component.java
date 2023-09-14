package cl.crllanos.awsuplreact.filestore;

import com.amazonaws.services.s3.AmazonS3;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class S3Component {

    private final AmazonS3 S3;

}
