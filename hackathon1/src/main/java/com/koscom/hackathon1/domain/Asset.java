package com.koscom.hackathon1.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "assets")
public class Asset {
    @Id
    private ObjectId id;
    private String name;
    private String address;
    @Field("image_url")
    private String imageUrl;
    @Field("whole_price")
    private long wholePrice;
    @Field("current_unit_price")
    private long currnetUnitPrice;
    @Field("end_price")
    private long endPrice;
    @Field("company_own_count")
    private long companyOwnCount;
    @Field("foreign_own_count")
    private long foreignOwnCount;
    @Field("personal_own_count")
    private long personalOwnCount;
    @Field("place_type")
    private PlaceType placeType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public long getWholePrice() {
        return wholePrice;
    }

    public void setWholePrice(int wholePrice) {
        this.wholePrice = wholePrice;
    }

    public long getCurrnetUnitPrice() {
        return currnetUnitPrice;
    }

    public void setCurrnetCurrntPrice(int currnetUnitPrice) {
        this.currnetUnitPrice = currnetUnitPrice;
    }

    public long getEndPrice() {
        return endPrice;
    }

    public void setEndPrice(int endPrice) {
        this.endPrice = endPrice;
    }

    public long getCompanyOwnCount() {
        return companyOwnCount;
    }

    public void setCompanyOwnCount(int companyOwnCount) {
        this.companyOwnCount = companyOwnCount;
    }

    public long getForeignOwnCount() {
        return foreignOwnCount;
    }

    public void setForeignOwnCount(int foreignOwnCount) {
        this.foreignOwnCount = foreignOwnCount;
    }

    public long getPersonalOwnCount() {
        return personalOwnCount;
    }

    public void setPersonalOwnCount(int personalOwnCount) {
        this.personalOwnCount = personalOwnCount;
    }

    public PlaceType getPlaceType() {
        return placeType;
    }

    public void setPlaceType(PlaceType placeType) {
        this.placeType = placeType;
    }

    @Override
    public String toString() {
        return "Assest{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", wholePrice=" + wholePrice +
                ", currnetUnitPrice=" + currnetUnitPrice +
                ", endPrice=" + endPrice +
                ", companyOwnCount=" + companyOwnCount +
                ", foreignOwnCount=" + foreignOwnCount +
                ", personalOwnCount=" + personalOwnCount +
                ", placeType=" + placeType +
                '}';
    }
}
