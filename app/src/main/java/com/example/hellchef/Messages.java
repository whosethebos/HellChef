package com.example.hellchef;

public class Messages {
    String imageUrl;
    
    public Messages(){}
    public Messages(String imageUrl)
    {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl)
    {
        this.imageUrl = imageUrl;
    }
}
