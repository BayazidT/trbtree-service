package com.trbtree.service.modules.protfolio.controller;import com.fasterxml.jackson.databind.ObjectMapper;
import com.trbtree.service.modules.protfolio.dto.ProfileResponse;
import com.trbtree.service.modules.protfolio.service.ProfileService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProfileController.class)
class ProfileControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ProfileService profileService; // Injected mock from configuration

    @Configuration
    static class TestConfig {
        @Bean
        public ProfileService profileService() {
            return Mockito.mock(ProfileService.class);
        }
    }

    private UUID profileId;

    @BeforeEach
    void setup() {
        profileId = UUID.randomUUID();
    }

    @Test
    void getProfile() throws Exception {
//        ProfileResponse profile = new ProfileResponse(profileId, "Bayazid", "bayazid@example.com");
//        when(profileService.getProfile(profileId)).thenReturn(profile);
//
//        mockMvc.perform(get("/profile/" + profileId))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(profileId.toString()))
//                .andExpect(jsonPath("$.name").value("Bayazid"))
//                .andExpect(jsonPath("$.email").value("bayazid@example.com"));
//
//        verify(profileService).getProfile(profileId);
    }

    @Test
    void updateProfile() throws Exception {
//        ProfileResponse updatedProfile = new ProfileResponse(profileId, "Bayazid Talukder", "bayazidtr@gmail.com");
//        when(profileService.updateProfile(profileId, updatedProfile)).thenReturn(updatedProfile);
//
//        mockMvc.perform(put("/profile/" + profileId)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(updatedProfile)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(profileId.toString()))
//                .andExpect(jsonPath("$.name").value("Bayazid Talukder"))
//                .andExpect(jsonPath("$.email").value("bayazidtr@gmail.com"));
//
//        verify(profileService).updateProfile(profileId, updatedProfile);
    }
}