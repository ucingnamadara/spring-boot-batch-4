package com.kawahedukasi.batch4.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kawahedukasi.batch4.model.dto.WilayahData;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Service
public class WilayahService {

    @Value("${wilayah.service.url}")
    String wilayahServiceUrl;

    @Value("${wilayah.service.provinsi}")
    String provinsiEndpoint;

    @Value("${wilayah.service.kota}")
    String kotaEndpoint;

    ObjectMapper objectMapper = new ObjectMapper();

    HttpClient httpClient = HttpClientBuilder.create().build();

    //java.net
    public List<WilayahData> provinsiListV1() throws IOException {
        URL url = new URL(wilayahServiceUrl+provinsiEndpoint);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");

        int statusCode = httpURLConnection.getResponseCode();
        if(statusCode == 200){
            InputStream inputStream = httpURLConnection.getInputStream();
            return objectMapper.readValue(inputStream, List.class);
        } else{
            throw new IOException("RESPONSE_FAILED");
        }
    }

    //java.net
    public List<WilayahData> kotaListV1() throws IOException {
        URL url = new URL(wilayahServiceUrl+kotaEndpoint);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");

        int statusCode = httpURLConnection.getResponseCode();
        if(statusCode == 200){
            InputStream inputStream = httpURLConnection.getInputStream();
            return objectMapper.readValue(inputStream, List.class);
        } else{
            throw new IOException("RESPONSE_FAILED");
        }
    }

    //apache
    public List<WilayahData> provinsiListV2() throws IOException {
        HttpGet httpGet = new HttpGet(wilayahServiceUrl+provinsiEndpoint);
        org.apache.http.HttpResponse httpResponse = httpClient.execute(httpGet);
        return objectMapper.readValue(EntityUtils.toString(httpResponse.getEntity()), List.class);
    }

    //apache
    public List<WilayahData> kotaListV2() throws IOException {
        HttpGet httpGet = new HttpGet(wilayahServiceUrl+kotaEndpoint);
        org.apache.http.HttpResponse httpResponse = httpClient.execute(httpGet);
        return objectMapper.readValue(EntityUtils.toString(httpResponse.getEntity()), List.class);
    }

    //unirest
    public List<WilayahData> provinsiListV3() throws IOException, UnirestException {
        HttpResponse<String> httpResponse = Unirest.get(wilayahServiceUrl+provinsiEndpoint).asString();
        return objectMapper.readValue(httpResponse.getBody(), List.class);
    }

    //unirest
    public List<WilayahData> kotaListV3() throws IOException, UnirestException {
        HttpResponse<String> httpResponse = Unirest.get(wilayahServiceUrl+kotaEndpoint).asString();
        return objectMapper.readValue(httpResponse.getBody(), List.class);
    }

}
