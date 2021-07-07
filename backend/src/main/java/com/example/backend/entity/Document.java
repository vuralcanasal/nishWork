package com.example.backend.entity;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@Entity
@Table(name="document")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String  type;

    @Lob
    private byte[] data;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Document(){
    }

    public Document(String name, String type, byte[] data, Customer customer) {
        this.name = name;
        this.type = type;
        this.data = data;
        this.customer = customer;
    }
}
