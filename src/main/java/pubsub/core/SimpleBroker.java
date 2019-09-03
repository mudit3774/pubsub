package pubsub.core;

import pubsub.consumer.Consumer;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by mudit.rg on 9/3/19.
 */
public class SimpleBroker implements Broker {

    private final ChannelManager channelManager;
    private final ConsumerManager consumerManager;

    private Map<String, List<UUID>> consumerToChannelMap;

    public SimpleBroker() {
        this.channelManager = new SimpleChannelManager();
        this.consumerManager = new SimpleConsumerManager();

        consumerToChannelMap = new ConcurrentHashMap<>();
    }

    @Override
    public int createChannel(String channel, long ttlInSeconds) {
        return channelManager.createChannel(channel, ttlInSeconds);
    }

    @Override
    public UUID registerConsumer(Consumer consumer, String chan) {
        UUID consumerUuid = consumerManager.registerConsumer(consumer);

        if(consumerToChannelMap.containsKey(chan)) {
            consumerToChannelMap.get(chan).add(consumerUuid);
        } else {
            List<UUID> list =  new ArrayList<>();

            consumerToChannelMap.put(chan, list);
            consumerToChannelMap.get(chan).add(consumerUuid);
        }

        return consumerUuid;
    }

    @Override
    public int deRegisterConumer(UUID uuid) {
        return 0;
    }

    @Override
    public int publish(String channel, String msg) {
        channelManager.publishToChannel(channel, msg);
        consumerManager.notifyAllConsumers(consumerToChannelMap.get(channel), msg);
        return  1;
    }
}
