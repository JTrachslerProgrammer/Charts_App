package com.charsapp.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import java.io.IOException;

@RestController
public class pdfController {

    @GetMapping("/api/pdf/{pdfName}")
    public ResponseEntity<Resource> getPdf(@PathVariable String pdfName) {
        try {
            // Pfad zum PDF im Ressourcenordner
            ClassPathResource pdfResource = new ClassPathResource("pdfs/" + pdfName);
            System.out.println("Looking for PDF: " + pdfName); // Log-Ausgabe

            if (pdfResource.exists()) {
                System.out.println("PDF gefunden: " + pdfResource.getPath()); // Log-Ausgabe
                return ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_PDF)
                        .body(pdfResource);
            } else {
                System.out.println("PDF nicht gefunden: " + pdfName); // Log-Ausgabe
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (IOException e) {
            System.out.println("Fehler beim Laden der PDF: " + e.getMessage()); // Log-Ausgabe
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
