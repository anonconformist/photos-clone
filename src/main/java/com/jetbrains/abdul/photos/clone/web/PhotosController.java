package com.jetbrains.abdul.photos.clone.web;

import com.jetbrains.abdul.photos.clone.model.Photo;
import com.jetbrains.abdul.photos.clone.service.PhotosService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.*;

@RestController
public class PhotosController {
    private final PhotosService photosService;

    public PhotosController(PhotosService photosService) {
        this.photosService = photosService;
    }

    @GetMapping("/")
    public String hello(){
        return  "hello world";
    }

    @GetMapping("/photos")
    public Collection<Photo> get(){
        return  photosService.get();
    }

    @GetMapping("/photos/{id}")
    public Photo get(@PathVariable String id){
        Photo photo = photosService.get(id);
        if(photo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return  photo;
    }

    @DeleteMapping("/photos/{id}")
    public void delete(@PathVariable String id){
        Photo photo = photosService.remove(id);
        if(photo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/photos")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException { //file uploads
        Photo photo = photosService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
        return photo;
    }
}
