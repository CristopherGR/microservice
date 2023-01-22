package com.devsu.microservice.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

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

import com.devsu.microservice.service.MovementService;
import com.devsu.microservice.service.dto.AccountDto;
import com.devsu.microservice.service.dto.MovementDto;
import com.devsu.microservice.utils.ResponseMessage;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class MovementControllerTest {
	
	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovementService movementService;
    
    @Test
    @DisplayName("POST /api/movimientos/crear - Success")
    void givenMovement_WhenCreateMovement_ThenCreateWithStatus201() throws Exception{
        // Setup account to create 
        MovementDto movementDto = new MovementDto(100L, "Credito", new Date(), 100, 0, new AccountDto());
       
        ResponseMessage mockResponseMessage = new ResponseMessage("Movimiento registrado con exito");
        doReturn(mockResponseMessage).when(movementService).create(any());

        // POST request
        mockMvc.perform(post("/api/movimientos/crear")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(movementDto)))
        		
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        		.andExpect(jsonPath("$.message", is("Movimiento registrado con exito")));
    }
    
    @Test
    @DisplayName("POST /api/movimientos/crear - failed")
    void givenMovement_WhenCreateMovement_ThenCreateWithStatus400() throws Exception{
        // Setup account to create 
    	AccountDto accountDto =  new AccountDto();
    	accountDto.setAccountNumber(1L);
    	
    	MovementDto movementDto = new MovementDto(100L, "Creditos", new Date(), 100, 0, accountDto);
    	
    	ResponseMessage mockResponseMessage = new ResponseMessage("Tipo de movimiento incorrecto");
        doReturn(mockResponseMessage).when(movementService).create(any());
        // POST request
        mockMvc.perform(post("/api/movimientos/crear")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(movementDto)))
        		
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message", is("Tipo de movimiento incorrecto")));
    }
    
    static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
