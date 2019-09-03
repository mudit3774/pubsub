package pubsub.core;

/**
 * Created by mudit.rg on 9/3/19.
 */
public interface ChannelManager {
    int createChannel(String channel, long ttlInSeconds);
    int publishToChannel(String channel, String msg);
}
