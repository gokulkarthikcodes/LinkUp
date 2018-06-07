package bean;

/**
 * Created by gokulkarthik on 2016/10/2 0002.
 */

public class MessageBean {
    String message;
    long dateline;
    boolean primary;

    public String getMessage() {
        return message;
    }

    public long getDateline() {
        return dateline;
    }

    public boolean isPrimary() {
        return primary;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDateline(long dateline) {
        this.dateline = dateline;
    }

    public void setPrimary(boolean primary) {
        this.primary = primary;
    }
}
