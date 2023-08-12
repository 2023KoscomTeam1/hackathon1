package com.koscom.hackathon1.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Document(collection = "user_infos")
public class UserInfo implements UserDetails {
    @Id
    private ObjectId _id;
    @Field("user_id")
    private String userId;
    @Field("user_name")
    private String userName;
    private String password;
    @Field("user_place")
    private PlaceType userPlace;
    @Field("user_assets")
    private List<HoldingAsset> userAssets;
    private int balance;
    @Field("user_type")
    private UserType userType;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PlaceType getUserPlace() {
        return userPlace;
    }

    public void setUserPlace(PlaceType userPlace) {
        this.userPlace = userPlace;
    }

    public List<HoldingAsset> getUserAssets() {
        return userAssets;
    }

    public void setUserAssets(List<HoldingAsset> userAssets) {
        this.userAssets = userAssets;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(ROLE));
        return authorities;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", userPlace=" + userPlace +
                ", userAssets=" + userAssets +
                ", balance=" + balance +
                ", userType=" + userType +
                '}';
    }

    public enum PlaceType {
        SEOUL,
        INCHEON,
        DAEJEON,
        DAEGU,
        ULSAN,
        PUSAN,
        KWANGJU,
        SEJONG,
        KYUNGI,
        CHOONGCHUNG,
        JEONLA,
        KYUNGSANG,
        KANGWON
    }

    public enum UserType {
        PERSONAL, COMPANY
    }

    static final String ROLE = "ROLE_USER";
}