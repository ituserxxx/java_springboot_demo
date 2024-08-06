package org.example.xcx.threePak.utDevice;

public class CameraInfo {
    private String id;
    private String name;
    private String channelId;
    private int status;

    public CameraInfo() {
        // Default constructor
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    // Override toString method for debugging purposes
    @Override
    public String toString() {
        return "CameraInfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", channelId='" + channelId + '\'' +
                ", status=" + status +
                '}';
    }
}
