package com.example.resttemplatedemo.http;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.http.HttpStatus;
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

        when(mockResponseEntity.getBody()).thenReturn("Sample responsne");

        NetworkHttp<String> networkHttp = new NetworkHttp<>(mockRestTemplate);


        networkHttp.get("/someresource/12345", String.class);


        ArgumentCaptor<String> urlArgumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(mockRestTemplate).exchange(urlArgumentCaptor.capture(), any(), any(), (Class<?>) any());
        assertThat(urlArgumentCaptor.getValue(), equalTo("/someresource/12345"));
    }
}
