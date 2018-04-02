package com.newland.cxfbasesb.vo;

import javax.persistence.*;

@Entity
@Table(name="demo_people")
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    @SequenceGenerator(sequenceName = "MYSEQ", allocationSize = 1, name = "CUST_SEQ")
    @Column(name = "PEOPLE_ID")
    private Long id;
    @Column(name = "PEOPLE_NAME")
    private String name;
    private Long status;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
