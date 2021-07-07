package com.example.backend.service;

import com.example.backend.entity.Customer;
import com.example.backend.entity.Document;
import com.example.backend.repository.CustomerRepository;
import com.example.backend.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {
    @Autowired
    DocumentRepository repository;
    @Autowired
    CustomerRepository customerRepository;

    public Document saveFile(MultipartFile file, int customerId){
        Customer customer = customerRepository.findById(customerId).get();
        if(!customer.equals(null)){
            try{
                Document document = new Document(file.getOriginalFilename(), file.getContentType(), file.getBytes(), customer);
                return repository.save(document);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }

    public Optional<Document> getFileById(int id){
        return repository.findById(id);
    }

    public List<Document> getAllFiles(){
        return repository.findAll();
    }

    public List<Document> findAllByCustomerId(int id){
        return repository.findAllByCustomerId(id);
    }


    public Document updateFile(Document file){
        Document existingFile = repository.findById(file.getId()).orElse(null);
        if(existingFile.equals(null))
            return  null;
        existingFile.setName(file.getName());
        existingFile.setType(file.getType());
        existingFile.setData(file.getData());
        existingFile.setCustomer(file.getCustomer());
        return repository.save(existingFile);
    }

    public String deleteFile(int id){
        repository.deleteById(id);
        return "The file with id: " + id + " was deleted!!";
    }


}
