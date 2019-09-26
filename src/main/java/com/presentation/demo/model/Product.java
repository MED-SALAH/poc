package com.presentation.demo.model;

public class Product {

    private String id ;
    private String name;
    private String url ;
    private Description description;

    public Product(String id, String name, String url, Description description) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }


}
