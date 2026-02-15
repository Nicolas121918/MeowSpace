package com.kevin.catapi.web.controller;

import com.kevin.catapi.application.usecase.GetBreedByIdUseCase;
import com.kevin.catapi.domain.model.Breed;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CatController.class)
public class CatControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GetBreedByIdUseCase getBreedByIdUseCase;

    @Test
    @DisplayName("Debe retornar 200 y el gato cuando el ID existe")
    void shouldReturnOkWhenIdExists() throws Exception {
        // GIVEN: El UseCase devuelve un gato
        Breed mockBreed = new Breed("beng", "Bengal", "USA", "Dócil");
        when(getBreedByIdUseCase.execute("beng")).thenReturn(mockBreed);

        // WHEN & THEN: Hacemos la petición y verificamos el JSON
        mockMvc.perform(get("/cats/search")
                .param("id", "beng") // Otra forma de pasar parámetros
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("beng"))
                .andExpect(jsonPath("$.name").value("Bengal"))
                .andExpect(jsonPath("$.origin").value("USA"));

        // Verificamos que el UseCase se llamó exactamente una vez
        verify(getBreedByIdUseCase, times(1)).execute("beng");
    }

    @Test
    @DisplayName("Debe retornar 200 pero cuerpo vacío (o null) cuando el ID no existe")
    void shouldReturnEmptyWhenIdDoesNotExist() throws Exception {
        // GIVEN: El UseCase devuelve null para un ID falso
        when(getBreedByIdUseCase.execute("id_falso")).thenReturn(null);

        // WHEN & THEN: Verificamos que la respuesta sea exitosa pero sin contenido
        mockMvc.perform(get("/cats/search")
                .param("id", "id_falso"))
                .andExpect(status().isOk())
                .andExpect(content().string("")); // Verifica que el cuerpo esté vacío si devuelves null
    }
}