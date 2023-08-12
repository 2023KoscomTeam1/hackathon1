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
}
