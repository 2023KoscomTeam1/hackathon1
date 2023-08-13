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
    private long targetAmount;
    @Field("current_amount")
    private long currentAmount;
    @Field("unit_price")
    private long unitPrice;
    @Field("due_date")
    private LocalDateTime dueDate;

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

    public long getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(long targetAmount) {
        this.targetAmount = targetAmount;
    }

    public long getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(long currentAmount) {
        this.currentAmount = currentAmount;
    }

    public long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(long unitPrice) {
        this.unitPrice = unitPrice;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
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
                '}';
    }
}
