package com.jetbrains.abdul.photos.clone;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class DownloadController {
    private final PhotosService photosService;

    public DownloadController(PhotosService photosService) {
        this.photosService = photosService;
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable String id){
        byte[] data = new byte[0];
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<> (data, headers, HttpStatus.OK);
    }
}
