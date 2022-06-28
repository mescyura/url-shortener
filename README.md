# url-shortener

Url shortener is a service that converts long urls into short aliases.
When user opens short url, it will be automatically redirected to original (long) url.

# How to use 

```sh
$ git clone https://github.com/mescyura/url-shortener.git
$ run it
```
    - use postman or insomnia to reack endpoints
####**1.Shorten URL POST**
```
POST http://localhost:8080/api/v1/shortenurl - make a short url
```
**Example Request:**
```
{
    "fullUrl":"https://docs.google.com/document/u/0/d/12ENUq_DSzDJSdZO_HCcrL6XYMDCO7E8fD40ULTtVrQA/mobilebasic"
} 

--header "Content-Type:application/json" 
http://54.200.113.144:8080/api/v1/shorten
authorization credentials
$ username - test
$ password - test

```
**Response :**
```
{
    "fullUrl": "https://docs.google.com/document/u/0/d/12ENUq_DSzDJSdZO_HCcrL6XYMDCO7E8fD40ULTtVrQA/mobilebasic",
    "shortUrl": "http://localhost:8080/s/VT2xR"
}
```
####**1.Shorten URL GET ALL**
```
GET http://localhost:8080/api/v1/shortenurllist - get all shorten urls
```

**Response :**
```
{
    "MSK20": {
        "fullUrl": "https://docs.google.com/document/u/0/d/12ENUq_DSzDJSdZO_HCcrL6XYMDCO7E8fD40ULTtVrQA/mobilebasic",
        "shortUrl": "http://localhost:8080/s/MSK20"
    },
    "vTTN6": {
        "fullUrl": "https://docs.google.com/document/u/0/d/12ENUq_DSzDJSdZO_HCcrL6XYMDCO7E8fD40ULTtVrQA/mobilebasic",
        "shortUrl": "http://localhost:8080/s/vTTN6"
    },
    "HXlhD": {
        "fullUrl": "https://docs.google.com/document/u/0/d/12ENUq_DSzDJSdZO_HCcrL6XYMDCO7E8fD40ULTtVrQA/mobilebasic",
        "shortUrl": "http://localhost:8080/s/HXlhD"
    }
}
```
####**1.Shorten URL Use short url**
```
pass the short url in u'r default browser tab and it will redirect u to the original url
```