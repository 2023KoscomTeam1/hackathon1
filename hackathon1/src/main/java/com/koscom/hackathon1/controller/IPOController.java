package com.koscom.hackathon1.controller;

import com.koscom.hackathon1.domain.IPOAsset;
import com.koscom.hackathon1.response.IPOResponse;
import com.koscom.hackathon1.service.IPOAssetService;
import org.springframework.http.ResponseEntity;
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

    IPOController(IPOAssetService ipoAssetService) {
        this.ipoAssetService = ipoAssetService;
    }

    @GetMapping("/list")
    public IPOResponse list() {
        IPOResponse ipoResponse = new IPOResponse();
        ipoResponse.setIpoAssets(ipoAssetService.findAll());

        return ipoResponse;
    }
}
