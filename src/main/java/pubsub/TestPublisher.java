package pubsub;

import pubsub.core.Broker;
import pubsub.publisher.Publisher;

/**
 * Created by mudit.rg on 9/3/19.
 */
public class TestPublisher implements Publisher {

    private final Broker broker;

    public TestPublisher(Broker broker) {
        this.broker = broker;
    }

    @Override
    public void publish(String channel, String message) {
        broker.publish(channel, message);
    }
}
