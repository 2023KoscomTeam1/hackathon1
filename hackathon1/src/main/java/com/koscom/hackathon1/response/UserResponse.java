package com.koscom.hackathon1.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.koscom.hackathon1.domain.*;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
public class UserResponse {
    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("user_name")
    private String userName;
    @JsonProperty("user_place")
    private PlaceType placeType;
    @JsonProperty("user_assets")
    private List<HoldingAsset> userAssets;
    private Long balance;
    @JsonProperty("user_ipos")
    private List<HoldingIPO> userIPOs;
    @JsonProperty("user_type")
    private UserInfo.UserType userType;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public PlaceType getPlaceType() {
        return placeType;
    }

    public void setPlaceType(PlaceType placeType) {
        this.placeType = placeType;
    }

    public List<HoldingAsset> getUserAssets() {
        return userAssets;
    }

    public void setUserAssets(List<HoldingAsset> userAssets) {
        this.userAssets = userAssets;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public List<HoldingIPO> getUserIPOs() {
        return userIPOs;
    }

    public void setUserIPOs(List<HoldingIPO> userIPOs) {
        this.userIPOs = userIPOs;
    }

    public UserInfo.UserType getUserType() {
        return userType;
    }

    public void setUserType(UserInfo.UserType userType) {
        this.userType = userType;
    }

    public static UserResponse from(UserInfo userInfo) {
        UserResponse userResponse = new UserResponse();

        userResponse.setPlaceType(userInfo.getUserPlace());
        userResponse.setUserAssets(userInfo.getUserAssets());
        userResponse.setUserName(userInfo.getUsername());
        userResponse.setUserId(userInfo.getUserId());
        userResponse.setBalance(userInfo.getBalance());
        userResponse.setUserType(userInfo.getUserType());
        userResponse.setUserIPOs(userInfo.getUserIPOs());

        return userResponse;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", placeType=" + placeType +
                ", userAssets=" + userAssets +
                ", balance=" + balance +
                ", userIPOs=" + userIPOs +
                ", userType=" + userType +
                '}';
    }
}
