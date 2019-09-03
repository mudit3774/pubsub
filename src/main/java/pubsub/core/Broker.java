package pubsub.core;

import pubsub.consumer.Consumer;

import java.util.UUID;

/**
 * Created by mudit.rg on 9/3/19.
 */
public interface Broker {

    int createChannel(String channel, long ttlInSeconds);

    UUID registerConsumer(Consumer consumer, String chan);

    int deRegisterConumer(UUID uuid);

    int publish(String channel, String msg);
}
