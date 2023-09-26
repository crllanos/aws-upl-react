package cl.crllanos.awsuplreact.enums;

public enum BucketName {

    PROFILE_IMAGE("aws-upl-react");

    private final String bucketName;

    BucketName (String bucketName){
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
