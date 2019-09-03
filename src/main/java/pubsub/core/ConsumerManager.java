package pubsub.core;

import pubsub.consumer.Consumer;

import java.util.List;
import java.util.UUID;

/**
 * Created by mudit.rg on 9/3/19.
 */
public interface ConsumerManager {
    UUID registerConsumer(Consumer consumer);
    int deRegisterConumer(UUID uuid);
    void notifyAllConsumers(List<UUID> consumers, String msg);
}
