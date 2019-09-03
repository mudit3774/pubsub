package pubsub.core;

import pubsub.consumer.Consumer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * Created by mudit.rg on 9/3/19.
 */
public class SimpleConsumerManager implements ConsumerManager {

    Map<UUID, Consumer> consumerMap;

    public SimpleConsumerManager() {
        this.consumerMap = new HashMap<>();
    }

    @Override
    public UUID registerConsumer(Consumer consumer) {
        UUID uuid = UUID.randomUUID();
        consumerMap.put(uuid, consumer);

        System.out.println("consumer registered : " + consumer.toString() + " with uuid " + uuid);

        return uuid;
    }

    @Override
    public int deRegisterConumer(UUID uuid) {
        return 0;
    }

    @Override
    public void notifyAllConsumers(List<UUID> consumers, String message) {
        if(consumers == null) {
            return;
        }

        System.out.println(consumerMap.toString());
        System.out.println("notifying consumers : " + consumerMap.keySet() + " with message " + message);

        for(UUID consumer:consumers) {
            CompletableFuture.runAsync(() -> consumerMap.get(consumer).consume(message));
        }
    }
}
