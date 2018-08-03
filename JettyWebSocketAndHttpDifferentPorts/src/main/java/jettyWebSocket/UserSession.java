package jettyWebSocket;

import jettyWebSocket.data.User;

/**
 * UserSession is an interface to track every client connection.
 * @author heucles.junior
 */

public interface UserSession {
    void receiveText(String text) throws Exception;
    void setCurrentUser(User user);
    void disconnect(int status, String reason);
}
