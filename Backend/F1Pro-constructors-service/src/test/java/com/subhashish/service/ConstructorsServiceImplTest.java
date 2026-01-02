package com.subhashish.service;

import com.subhashish.entity.Constructors;
import com.subhashish.repository.ConstructorsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Year;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ConstructorsServiceImplTest {

    @Mock
    private ConstructorsRepository constructorsRepository;

    @InjectMocks
    private ConstructorsServiceImpl constructorsService;

    @Test
    void testgetByIdSuccessTest() {

        int constructorId = 11;
        Constructors mockConstructor = new Constructors();
        mockConstructor.setId(constructorId);
        mockConstructor.setName("Ferrari");
        mockConstructor.setYear(Year.of(2025));


        when(constructorsRepository.findById(constructorId)).thenReturn(Optional.of(mockConstructor));

        Optional<Constructors> result = constructorsService.getById(constructorId);

        assertNotNull(result);
        assertEquals("Ferrari",result.get().getName());
        verify(constructorsRepository,times(1)).findById(constructorId);
    }

    @Test
    void testGetByIdFailureTest() {
        int constructorId = 11;

        when(constructorsRepository.findById(constructorId)).thenReturn(Optional.empty());
        Optional<Constructors> result = constructorsService.getById(constructorId);

        assertTrue(result.isEmpty());
        verify(constructorsRepository, times(1)).findById(constructorId);
    }

    @Test
    void testgetByConstructorName() {
        String constructorName = "Ferrari";

        Constructors mockConstructor = new Constructors();
        mockConstructor.setId(3);
        mockConstructor.setName("Ferrari");
        mockConstructor.setYear(Year.of(2025));


        when(constructorsRepository.findByNameIgnoreCase(constructorName)).thenReturn(Collections.singletonList(mockConstructor));

        Constructors result = constructorsService.getByConstructorName(constructorName);

        assertEquals(result.getId(),mockConstructor.getId());
        verify(constructorsRepository, times(1)).findByNameIgnoreCase(constructorName);
    }

    @Test
    void testgetByConstructorNameFailureTest(){
        String constructorName = "Ferrari";

        when(constructorsRepository.findByNameIgnoreCase(constructorName)).thenReturn(Collections.emptyList());

        Constructors result = constructorsService.getByConstructorName(constructorName);

        assertNull(result);
    }
}