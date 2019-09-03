package pubsub.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mudit.rg on 9/3/19.
 */
public class SimpleChannelManager implements ChannelManager {

    Map<String, List<String>> channels = new HashMap<>();

    @Override
    public int createChannel(String channel, long ttlInSeconds) {
        List<String> list = new ArrayList<>();
        channels.put(channel, list);

        System.out.println("channel created : " + channel + " with ttl " + ttlInSeconds + " " + list.toString() + channels.toString());

        return 1;
    }

    @Override
    public int publishToChannel(String channel, String msg) {
        channels.get(channel).add(msg);

        System.out.println("published to channel : " + channel + " msg " + msg + channels.get(channel).toString() + channels.toString());

        return 1;
    }
}
