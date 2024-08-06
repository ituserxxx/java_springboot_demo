package org.example.xcx.dto.overview;
import lombok.Data;
@Data
public class UserResp {
    public int usersTotal;
    public int projectUsersNum;
    public int projectNum;
    public int deviceNum;
    public int activeUsers;
    public double activityRate;
    public int newUsers;
    public double newUsersRate;
    public int lostUsers;
    public double lostUsersRate;

    public int getLostUsers() {
        return lostUsers;
    }

    public int getActiveUsers() {
        return activeUsers;
    }

    public int getUsersTotal() {
        return usersTotal;
    }

    public int getNewUsers() {
        return newUsers;
    }

    public void setUsersTotal(int usersTotal) {
        this.usersTotal = usersTotal;
    }

    public void setProjectUsersNum(int projectUsersNum) {
        this.projectUsersNum = projectUsersNum;
    }

    public void setProjectNum(int projectNum) {
        this.projectNum = projectNum;
    }

    public void setDeviceNum(int deviceNum) {
        this.deviceNum = deviceNum;
    }

    public void setActiveUsers(int activeUsers) {
        this.activeUsers = activeUsers;
    }

    public void setActivityRate(double activityRate) {
        this.activityRate = activityRate;
    }

    public void setNewUsers(int newUsers) {
        this.newUsers = newUsers;
    }

    public void setNewUsersRate(double newUsersRate) {
        this.newUsersRate = newUsersRate;
    }

    public void setLostUsers(int lostUsers) {
        this.lostUsers = lostUsers;
    }

    public void setLostUsersRate(double lostUsersRate) {
        this.lostUsersRate = lostUsersRate;
    }
}
