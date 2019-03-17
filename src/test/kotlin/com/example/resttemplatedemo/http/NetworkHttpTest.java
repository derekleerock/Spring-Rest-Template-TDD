package com.example.resttemplatedemo.http;

import com.example.resttemplatedemo.jsonplaceholderapi.JSONPlaceholderAPICompany;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class NetworkHttpTest {
    @Test
    public void get_hits_correct_endpoint() {
        RestTemplate mockRestTemplate = mock(RestTemplate.class);
        ResponseEntity mockResponseEntity = mock(ResponseEntity.class);
        doReturn(mockResponseEntity).when(mockRestTemplate).exchange(anyString(), any(), any(), (Class<?>) any());

        when(mockResponseEntity.getBody()).thenReturn("");

        NetworkHttp<String> networkHttp = new NetworkHttp<>(mockRestTemplate);


        networkHttp.get("/someresource/12345", String.class);


        ArgumentCaptor<String> urlArgumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(mockRestTemplate).exchange(urlArgumentCaptor.capture(), any(), any(), (Class<?>) any());
        assertThat(urlArgumentCaptor.getValue(), equalTo("/someresource/12345"));
    }

    @Test
    public void get_makes_http_method_get_request() {
        RestTemplate mockRestTemplate = mock(RestTemplate.class);
        ResponseEntity mockResponseEntity = mock(ResponseEntity.class);
        doReturn(mockResponseEntity).when(mockRestTemplate).exchange(anyString(), any(), any(), (Class<?>) any());

        when(mockResponseEntity.getBody()).thenReturn("");

        NetworkHttp<String> networkHttp = new NetworkHttp<>(mockRestTemplate);


        networkHttp.get("", String.class);


        ArgumentCaptor<HttpMethod> httpMethodArgumentCaptor = ArgumentCaptor.forClass(HttpMethod.class);
        verify(mockRestTemplate).exchange(anyString(), httpMethodArgumentCaptor.capture(), any(), (Class<?>) any());
        assertThat(httpMethodArgumentCaptor.getValue(), equalTo(HttpMethod.GET));
    }

    @Test
    public void get_requests_response_type_matching_specified_class() {
        RestTemplate mockRestTemplate = mock(RestTemplate.class);
        ResponseEntity mockResponseEntity = mock(ResponseEntity.class);
        doReturn(mockResponseEntity).when(mockRestTemplate).exchange(anyString(), any(), any(), (Class<?>) any());

        when(mockResponseEntity.getBody()).thenReturn("");

        NetworkHttp<JSONPlaceholderAPICompany> networkHttp = new NetworkHttp<>(mockRestTemplate);


        networkHttp.get("", JSONPlaceholderAPICompany.class);


        ArgumentCaptor<Class> classArgumentCaptor = ArgumentCaptor.forClass(Class.class);
        verify(mockRestTemplate).exchange(anyString(), any(), any(), (Class<?>) classArgumentCaptor.capture());
        assertThat(classArgumentCaptor.getValue(), equalTo(JSONPlaceholderAPICompany.class));
    }
}
