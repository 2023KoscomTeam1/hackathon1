package com.koscom.hackathon1.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class HoldingIPO {
    @JsonProperty("ipo_id")
    private Long ipoId;
    private Long count;

    public Long getIpoId() {
        return ipoId;
    }

    public void setIpoId(Long ipoId) {
        this.ipoId = ipoId;
    }
    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "HoldingIPO{" +
                "ipoId=" + ipoId +
                ", count=" + count +
                '}';
    }
}
