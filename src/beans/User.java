/*
 * User类定义了客户的相关属性：用户名、IP地址、端口号
 * 以及对属性的相关get、set方法
 */
package beans;
/**
 *
 * @author ws
 */
public class User{
    private String username;
    private String ip;
    private int port;

    public User(String username, String ip, int port)
    {
        this.username=username;
        this.ip=ip;
        this.port=port;
    }
    
    public String toString()
    {
        return this.username;
    }
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
}
