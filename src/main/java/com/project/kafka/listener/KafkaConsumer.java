package com.project.kafka.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    @KafkaListener(topicPartitions = @TopicPartition(topic = "test",
            partitionOffsets = {
                    @PartitionOffset(partition = "0", initialOffset = "0"),
                    @PartitionOffset(partition = "3", initialOffset = "0")}))
    public void listenWithHeaders(
            @Payload String message,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        System.out.println(
                "Received Message: " + message + " from partition: " + partition);
    }
}
