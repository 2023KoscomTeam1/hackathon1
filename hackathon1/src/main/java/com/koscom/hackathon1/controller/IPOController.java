package com.koscom.hackathon1.controller;

import com.koscom.hackathon1.domain.IPOAsset;
import com.koscom.hackathon1.service.IPOAssetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/ipo")
public class IPOController {
    private final IPOAssetService ipoAssetService;

    public IPOController(IPOAssetService ipoAssetService) {
        this.ipoAssetService = ipoAssetService;
    }

    @GetMapping("/list")
    public List<IPOAsset> list() {
        return ipoAssetService.findAll();
    }

    @GetMapping("/test")
    public void test() {
        IPOAsset ipoAsset = new IPOAsset();
        ipoAsset.setName("WS 뮤지엄");
        ipoAsset.setAddress("전라남도 담양군 담양읍 추성로");
        ipoAsset.setTargetAmount(1000000);
        ipoAsset.setCurrentAmount(100);
        ipoAsset.setUnitPrice(1000);
        ipoAsset.setDueDate(LocalDateTime.now());
        ipoAssetService.save(ipoAsset);
    }
}
