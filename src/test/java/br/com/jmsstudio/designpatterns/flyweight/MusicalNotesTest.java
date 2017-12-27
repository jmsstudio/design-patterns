package br.com.jmsstudio.designpatterns.flyweight;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static br.com.jmsstudio.designpatterns.flyweight.MusicalNotes.*;
import static org.junit.Assert.assertEquals;

public class MusicalNotesTest {

    @Test
    public void createMusicUsingTheSameInstanceOfObjects() {
        List<MusicalNotes> notes = Arrays.asList(DO, RE, MI, FA, FA, FA);

        List<String> decodedNotes = notes.stream().map(n -> n.getMusicalNote().getSymbol()).collect(Collectors.toList());

        assertEquals("C D E F F F", decodedNotes.toString().replace("[", "").replace("]", "").replace(",", ""));

    }
}
