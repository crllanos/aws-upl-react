package cl.crllanos.awsuplreact.enums;

public enum BucketName {

    PROFILE_IMAGE("NOMBRE BUCKET EN AWS S3");

    private final String bucketName;

    BucketName (String bucketName){
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
