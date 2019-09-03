package pubsub;

import pubsub.consumer.Consumer;
import pubsub.core.Broker;

/**
 * Created by mudit.rg on 9/3/19.
 */
public class TestConsumer implements Consumer {

    private final String name;

    public TestConsumer(String name) {
        this.name = name;
    }

    @Override
    public void consume(String msg) {
        System.out.println(name + " consumed " + msg + " " + Thread.currentThread());
    }
}
