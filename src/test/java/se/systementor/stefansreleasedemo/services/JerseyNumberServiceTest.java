package se.systementor.stefansreleasedemo.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import se.systementor.stefansreleasedemo.models.FakePlayerRepository;
import se.systementor.stefansreleasedemo.models.Player;

import java.util.List;

import static org.awaitility.Awaitility.given;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class JerseyNumberServiceTest {

    @Mock
    private FakePlayerRepository fakePlayerRepository;

    @InjectMocks
    private JerseyNumberService sut;


    @Test
    void isJerseyTaken_should_return_true_when_used_by_any_player() {
        when(fakePlayerRepository.findAll()).thenReturn(List.of(Player.builder().jerseyNumber(9).build(),Player.builder().jerseyNumber(12).build()));
        boolean isTaken = sut.isJerseyTaken(12);

        assertTrue(isTaken);

    }
    @Test
    void isJerseyTaken_should_return_false_when_not_used() {
        when(fakePlayerRepository.findAll()).thenReturn(List.of(Player.builder().jerseyNumber(9).build(),Player.builder().jerseyNumber(12).build()));
        boolean isTaken = sut.isJerseyTaken(11);

        assertFalse(!isTaken);
    }
}