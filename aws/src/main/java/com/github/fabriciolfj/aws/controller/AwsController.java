package com.github.fabriciolfj.aws.controller;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/aws/s3")
public class AwsController {

    private final AmazonS3 amazonS3;

    private final AmazonSQSAsync sqsAsync;

    @PostMapping("/note")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void note(@RequestParam String name, @RequestParam String content) {
        /*amazonS3.createBucket("fabriciospring");
        amazonS3.putObject("fabriciospring", name + ".txt", content);*/

        new QueueMessagingTemplate(sqsAsync).convertAndSend("TESTE", content);
    }

    @SqsListener(value = "TESTE")
    public void consumir(String message) {
        System.out.println(message);
    }

}
