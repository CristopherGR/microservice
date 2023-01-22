package com.devsu.microservice.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.devsu.microservice.service.AccountService;
import com.devsu.microservice.service.dto.AccountDto;
import com.devsu.microservice.service.dto.ClientDto;
import com.devsu.microservice.utils.ResponseMessage;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class AccountControllerTest {
	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;
    
    @Test
    @DisplayName("POST /api/cuentas/crear - Success")
    void givenAccount_WhenCreateAccount_ThenCreateWithStatus201() throws Exception{
        // Setup account to create 
        AccountDto postAccount = new AccountDto(100L, "Credito", 200, true, new ClientDto());
       
        ResponseMessage mockAResponseMessage = new ResponseMessage("Cuenta creada con exito");
        doReturn(mockAResponseMessage).when(accountService).create(any());

        // POST request
        mockMvc.perform(post("/api/cuentas/crear")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(postAccount)))
        		
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        		.andExpect(jsonPath("$.message", is("Cuenta creada con exito")));
    }
    
    @Test
    @DisplayName("POST /api/cuentas/crear - failed")
    void givenAccount_WhenCreateAccount_ThenFailedCreateWithStatus400() throws Exception{
        // Setup account to create 
    	ClientDto clientDto = new ClientDto();
    	clientDto.setIdClient(100L);
    	
        AccountDto postAccount = new AccountDto(100L, "Credito", 200, true, clientDto);

        // POST request
        mockMvc.perform(post("/api/cuentas/crear")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(postAccount.getAccountNumber())))
        		
                .andExpect(status().isBadRequest());
    }
    
    static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
