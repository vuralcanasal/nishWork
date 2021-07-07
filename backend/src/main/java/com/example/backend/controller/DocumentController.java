package com.example.backend.controller;

import com.example.backend.entity.Customer;
import com.example.backend.entity.Document;
import com.example.backend.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("api/")
public class DocumentController {
    @Autowired
    private DocumentService service;

    @PostMapping("/customers/{customerId}/uploadFile")
    public String uploadFiles(@RequestParam("documents")MultipartFile[]documents, @PathVariable int customerId){
        for(MultipartFile document: documents){
            service.saveFile(document,customerId);
        }
        return "redirect:/customers";
    }

    @GetMapping("/downloadFile/{id}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Integer id){
        Document file = service.getFileById(id).get();
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(file.getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+file.getName()+"\"")
                .body(new ByteArrayResource(file.getData()));
    }

    @GetMapping("/files")
    public List<Document> getAllFiles(){
        return service.getAllFiles();
    }

    @GetMapping("/customer/{id}/files")
    public List<Document> getAllFiles(@PathVariable int id){
        return service.findAllByCustomerId(id);
    }

    @GetMapping("/files/{id}")
    public Document getFileById(@PathVariable int id){
        return service.getFileById(id).get();
    }

    @PutMapping("/file/update")
    public Document updateFile(@RequestBody Document document){
        return service.updateFile(document);
    }

    @DeleteMapping("deleteFile/{id}")
    public String deleteFile(@PathVariable int id){
        return service.deleteFile(id);
    }
}
