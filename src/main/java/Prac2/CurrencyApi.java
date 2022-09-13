package Prac2;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;

public class CurrencyApi {

    public static ResponseEntity<String> getCurrencyList() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.apilayer.com/currency_data/list";
        String apiKey = "ROIHOFgZPI9ep8Zk6TSxVrdRqVXZCJkX";
        HttpHeaders headers = new HttpHeaders();
        headers.add("apikey", apiKey);

        HttpEntity<Object> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
    }
}
