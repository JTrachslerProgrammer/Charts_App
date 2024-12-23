package com.example.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@RestController
public class PdfController {

    private static final String GITHUB_API_URL = "https://api.github.com/repos/USERNAME/REPOSITORY/contents/pdfs/";

    @GetMapping("/api/pdf/{pdfName}")
    public ResponseEntity<byte[]> getPdf(@PathVariable String pdfName) {
        RestTemplate restTemplate = new RestTemplate();
        String pdfUrl = GITHUB_API_URL + pdfName;

        ResponseEntity<byte[]> pdfResponse = restTemplate.getForEntity(pdfUrl, byte[].class);
        return pdfResponse;
    }
}
