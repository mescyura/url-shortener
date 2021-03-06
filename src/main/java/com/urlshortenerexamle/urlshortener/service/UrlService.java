package com.urlshortenerexamle.urlshortener.service;

import com.urlshortenerexamle.urlshortener.entity.Url;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@Slf4j
public class UrlService {

    static public void setShortUrl(Map<String, Url> shortenUrlList, String randomChar, Url url) {
        if(url.getFullUrl() == null || url.getFullUrl().isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid URL");
        } else {
            url.setShortUrl("http://localhost:8080/s/" + randomChar);
            shortenUrlList.put(randomChar, url);
            log.info("util layer - added url :{} , key :{}", url.getFullUrl(), randomChar);
        }
    }


    static public String getRandomChars() {
        String randomStr = "";
        String possibleChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        for (int i = 0; i < 5; i++)
            randomStr += possibleChars.charAt((int) Math.floor(Math.random() * possibleChars.length()));
        return randomStr;
    }
}