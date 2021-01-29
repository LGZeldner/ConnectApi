package com.example.connectapi;

public class ApiKey { /*описание ключа из данных API*/
    private String name; // название
    private String value;  // значение


    public ApiKey(String name, String value){
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
