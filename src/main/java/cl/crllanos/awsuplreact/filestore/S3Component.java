package cl.crllanos.awsuplreact.filestore;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.Map;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class S3Component {

    private final AmazonS3 s3;

    public void save(String path, String name,
                     Optional<Map<String, String>> optionalMetadata,
                     InputStream input){
        ObjectMetadata metadata = new ObjectMetadata();
        optionalMetadata.ifPresent(map -> {
            if (!map.isEmpty())
                map.forEach(metadata::addUserMetadata);
        });

        try {
            s3.putObject(path, name, input, metadata);
        } catch (Exception e){
            throw new IllegalStateException("Error al intentar subir archivo", e);
        }
    }
}
