package com.koscom.hackathon1.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document(collection = "ipo_book")
public class IPOAsset {
    @Id
    private ObjectId id;
    @Field("ipo_id")
    private long ipoId;
    private String name;
    private String address;
    @Field("target_amount")
    private Long targetAmount;
    @Field("current_amount")
    private Long currentAmount;
    @Field("unit_price")
    private Long unitPrice;
    @Field("due_date")
    private LocalDateTime dueDate;
    @Field("image_url")
    private String imageUrl;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public long getIpoId() {
        return ipoId;
    }

    public void setIpoId(Long ipoId) {
        this.ipoId = ipoId;
    }

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

    public Long getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(Long targetAmount) {
        this.targetAmount = targetAmount;
    }

    public Long getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(Long currentAmount) {
        this.currentAmount = currentAmount;
    }

    public Long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Long unitPrice) {
        this.unitPrice = unitPrice;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "IPOAsset{" +
                "id=" + id +
                ", ipoId='" + ipoId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", targetAmount=" + targetAmount +
                ", currentAmount=" + currentAmount +
                ", unitPrice=" + unitPrice +
                ", dueDate=" + dueDate +
                ", imageUrl=" + imageUrl +
                '}';
    }
}
