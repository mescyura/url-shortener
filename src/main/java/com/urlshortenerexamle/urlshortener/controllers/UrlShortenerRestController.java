package com.urlshortenerexamle.urlshortener.controllers;

import com.urlshortenerexamle.urlshortener.entity.Url;
import com.urlshortenerexamle.urlshortener.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class UrlShortenerRestController {

    private Map<String, Url> shortenUrlList = new HashMap<>();

    @PostMapping("/shortenurl")
    public ResponseEntity<Object> getShortenUrl(@RequestBody Url shortenUrl) {
        String shortKey = Util.getRandomChars();
        Util.setShortUrl(shortenUrlList, shortKey, shortenUrl);
        log.info("controller layer - full url :{} -> short url :{}", shortenUrl.getFullUrl(), shortenUrl.getShortUrl());
        return new ResponseEntity<Object>(shortenUrl, HttpStatus.OK);
    }

    @GetMapping("/s/{randomstring}")
    public void getFullUrl(HttpServletResponse response, @PathVariable("randomstring") String key) throws IOException {
        log.info("controller layer - redirecting from http://localhost:8080/s/:{} to :{}", key, shortenUrlList.get(key).getFullUrl());
        response.sendRedirect(shortenUrlList.get(key).getFullUrl());
    }
}