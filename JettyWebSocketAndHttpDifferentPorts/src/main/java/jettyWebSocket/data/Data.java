package jettyWebSocket.data;

/**
 * Data is a wrapper for transmittable object between client and server.
 * @author heucles.junior
 */
public class Data {
    public static final int AUTHENTICATION_LOGIN = 1;

    public static final int MESSAGING_SEND = 101;

    public int operation;
    public User user;
    public Message message;
    public String session;
}