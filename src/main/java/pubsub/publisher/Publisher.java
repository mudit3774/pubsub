package pubsub.publisher;

import pubsub.core.Broker;

/**
 * Created by mudit.rg on 9/3/19.
 */
public interface Publisher {
    void publish(String channel, String message);
}
