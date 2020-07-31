package com.github.fabriciolfj.aws.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsConfig {

    @Value("${aws.accessKeyId}")
    private String acessId;

    @Value("${aws.secretAccessKey}")
    private String secretKey;

    @Value("${aws.s3.regiao}")
    private String regiao;

    @Bean
    public AmazonS3 amazonS3() {
        final BasicAWSCredentials credentials = new BasicAWSCredentials(acessId, secretKey);
        return AmazonS3ClientBuilder
                .standard()
                .withRegion(regiao)
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();

    }
}
