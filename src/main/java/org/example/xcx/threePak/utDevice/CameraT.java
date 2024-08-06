package org.example.xcx.threePak.utDevice;

import java.util.List;

public class CameraT {
    private String ipAddress;
    private String deviceId;
    private int port;
    private List<SipChannel> sipChannels;
    private DeviceInfo deviceInfo;
    private String registerTime;
    private String username;
    private String password;
    private String keepAliveTime;
    private int keepAliveLostTime;
    private DeviceStatus deviceStatus;
    private boolean isReday;

    // Constructors, getters, and setters

    public List<SipChannel> getSipChannels() {
        return sipChannels;
    }

    public String getUsername() {
        return username;
    }

    public DeviceStatus getDeviceStatus() {
        return deviceStatus;
    }

    public static class SipChannel {
        private String ssrcId;
        private String stream;
        private String parentId;
        private String deviceId;
        private String pushStatus;
        private String lastUpdateTime;
        private String sipChannelType;

        public String getSipChannelStatus() {
            return sipChannelStatus;
        }

        private String sipChannelStatus;
        private SipChannelDesc sipChannelDesc;

        // Constructors, getters, and setters

        public String getSsrcId() {
            return ssrcId;
        }

        public SipChannelDesc getSipChannelDesc() {
            return sipChannelDesc;
        }

        public static class SipChannelDesc {
            private String channelID;
            private String name;
            private String manufacturer;
            private String model;
            private String owner;
            private String civilCode;
            private String address;
            private int parental;
            private String parentalValue;
            private int safetyWay;
            private String safetyWayValue;
            private int registerWay;
            private String registerWayValue;
            private int secrecy;
            private String secrecyValue;
            private String status;
            private String parentID;

            // Constructors, getters, and setters

            public String getChannelID() {
                return channelID;
            }

            public String getName() {
                return name;
            }

            public String getStatus() {
                return status;
            }
        }
    }

    public static class DeviceInfo {
        private int cmdType;
        private int sn;
        private String deviceID;
        private String result;
        private String manufacturer;
        private String model;
        private String firmware;
        private int channel;
        private String deviceName;

        // Constructors, getters, and setters
    }

    public static class DeviceStatus {
        private String cmdType;
        private int sn;
        private String deviceID;
        private String result;
        private String online;
        private String status;
        private String deviceTime;
        private List<Object> alarmstatus; // Adjust type as necessary
        private String encode;
        private String record;

        // Constructors, getters, and setters
    }

}
