package com.koscom.hackathon1.controller;

import com.koscom.hackathon1.response.IPOResponse;
import com.koscom.hackathon1.service.IPOAssetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/{ipoId}")
    public IPOResponse get(@PathVariable Long ipoId) {
        IPOResponse ipoResponse = new IPOResponse();
        ipoResponse.setIpoAsset(ipoAssetService.findBy(ipoId));

        return ipoResponse;
    }
}
