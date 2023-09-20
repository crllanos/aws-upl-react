package cl.crllanos.awsuplreact.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonConfig {

    @Value("app.config.amazon.key")
    private String key;

    @Value("app.config.amazon.secret")
    private String secret;

    @Bean
    public AmazonS3 s3(){
        return AmazonS3ClientBuilder.standard()
                .withRegion(Regions.SA_EAST_1)
                .withCredentials(
                        new AWSStaticCredentialsProvider(
                                new BasicAWSCredentials(key, secret)
                        ))
                .build();
    }


}
