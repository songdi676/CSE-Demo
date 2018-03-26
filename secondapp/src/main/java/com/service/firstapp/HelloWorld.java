package com.service.firstapp;

public interface HelloWorld {
    static class Person{
        private String name;
        private String id;

        public String getId() { return id; }
        public void setId(String id) {this.id=id;}
        public String getName() {
            return name;
        }
        public void setName(String name) {this.name=name;}
    }
    public String helloworld(Person name);
}
