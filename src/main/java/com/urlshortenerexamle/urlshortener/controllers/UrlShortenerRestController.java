package com.urlshortenerexamle.urlshortener.controllers;


import com.urlshortenerexamle.urlshortener.urlEntity.Url;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UrlShortenerRestController {

    private Map<String, Url> shortenUrlList = new HashMap<>();

    @PostMapping("/shortenurl")
    public ResponseEntity<Object> getShortenUrl(@RequestBody Url shortenUrl) {
        String shortKey = getRandomChars();
        setShortUrl(shortKey, shortenUrl);
        return new ResponseEntity<Object>(shortenUrl, HttpStatus.OK);
    }

    @GetMapping("/s/{randomstring}")
    public void getFullUrl(HttpServletResponse response, @PathVariable("randomstring") String randomString) throws IOException {
        response.sendRedirect(shortenUrlList.get(randomString).getFullUrl());
    }

    private void setShortUrl(String randomChar, Url shortUrl) {
        shortUrl.setShortUrl("http://localhost:8080/s/" + randomChar);
        shortenUrlList.put(randomChar, shortUrl);
    }

    private String getRandomChars() {
        String randomStr = "";
        String possibleChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        for (int i = 0; i < 5; i++)
            randomStr += possibleChars.charAt((int) Math.floor(Math.random() * possibleChars.length()));
        return randomStr;
    }
}