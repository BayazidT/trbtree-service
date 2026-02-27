package com.trbtree.service.modules.protfolio.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trbtree.service.modules.protfolio.dto.ProfileRequest;
import com.trbtree.service.modules.protfolio.dto.ProfileResponse;
import com.trbtree.service.modules.protfolio.service.ProfileService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProfileController.class)
@AutoConfigureMockMvc(addFilters = false)
class ProfileControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ProfileService profileService; // injected mock

    private UUID profileId;
    private ProfileResponse profileDto;

    @Configuration
    static class TestConfig {
        @Bean
        public ProfileService profileService() {
            return Mockito.mock(ProfileService.class);
        }
    }

    @BeforeEach
    void setup() {
        profileId = UUID.randomUUID();

        profileDto = ProfileResponse.builder()
                .userId(profileId)
                .username("bayazid")
                .displayName("Bayazid Talukder")
                .email("bayazidtr@gmail.com")
                .phone("+491234567890")
                .headline("Software Engineer")
                .currentDesignation("Backend Developer")
                .profilePictureUrl("https://example.com/pic.jpg")
                .introduction("Passionate about coding and cybersecurity.")
                .openToWork(true)
                .linkedinUrl("https://linkedin.com/in/bayazid")
                .githubUrl("https://github.com/bayazidtr")
                .isPublic(true)
                .lastUpdatedAt(LocalDateTime.now())
                .build();
    }

    @Test
    void getProfile() throws Exception {
        when(profileService.getProfile(profileId)).thenReturn(profileDto);

        mockMvc.perform(get("/api/v1/profiles/" + profileId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value(profileId.toString()))
                .andExpect(jsonPath("$.username").value("bayazid"))
                .andExpect(jsonPath("$.displayName").value("Bayazid Talukder"))
                .andExpect(jsonPath("$.email").value("bayazidtr@gmail.com"))
                .andExpect(jsonPath("$.headline").value("Software Engineer"))
                .andExpect(jsonPath("$.currentDesignation").value("Backend Developer"))
                .andExpect(jsonPath("$.openToWork").value(true));

        verify(profileService).getProfile(profileId);
    }

    @Test
    void updateProfile() throws Exception {
        ProfileRequest updatedDto = ProfileRequest.builder()
                .userId(profileId)
                .username("bayazid")
                .displayName("Bayazid Talukder")
                .email("bayazidtr@gmail.com")
                .phone("+491234567890")
                .headline("Senior Software Engineer")
                .currentDesignation("Backend Lead")
                .profilePictureUrl("https://example.com/pic.jpg")
                .introduction("Passionate about coding and cybersecurity.")
                .openToWork(false)
                .linkedinUrl("https://linkedin.com/in/bayazid")
                .githubUrl("https://github.com/bayazidtr")
                .isPublic(true)
                .lastUpdatedAt(LocalDateTime.now())
                .build();

        when(profileService.updateProfile(profileId, updatedDto)).thenReturn(null);

        mockMvc.perform(put("/api/v1/profiles/" + profileId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.headline").value("Senior Software Engineer"))
                .andExpect(jsonPath("$.currentDesignation").value("Backend Lead"))
                .andExpect(jsonPath("$.openToWork").value(false));

        verify(profileService).updateProfile(profileId, updatedDto);
    }
}