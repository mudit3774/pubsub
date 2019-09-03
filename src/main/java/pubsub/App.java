package pubsub;

import pubsub.consumer.Consumer;
import pubsub.core.Broker;
import pubsub.core.ChannelManager;
import pubsub.core.SimpleBroker;
import pubsub.core.SimpleChannelManager;
import pubsub.publisher.Publisher;

/**
 * Created by mudit.rg on 9/3/19.
 */
public class App {
    public static void main(String[] args) {
        Broker broker = new SimpleBroker();

        broker.createChannel("test", 5);

        Publisher publisher = new TestPublisher(broker);

        publisher.publish("test", "A");
        publisher.publish("test", "B");
        publisher.publish("test", "C");
        publisher.publish("test", "D");

        Consumer consumer1 = new TestConsumer("C1");
        broker.registerConsumer(consumer1, "test");

        Consumer consumer2 = new TestConsumer("C2");
        broker.registerConsumer(consumer2, "test");

        publisher.publish("test", "E");
        publisher.publish("test", "F");

        Consumer consumer3 = new TestConsumer("C3");
        broker.registerConsumer(consumer3, "test");

        publisher.publish("test", "G");
        publisher.publish("test", "H");
    }
}
