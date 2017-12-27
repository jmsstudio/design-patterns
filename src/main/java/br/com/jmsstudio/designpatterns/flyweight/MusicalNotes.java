package br.com.jmsstudio.designpatterns.flyweight;

public enum MusicalNotes {
    DO(new Do()),
    RE(new Re()),
    MI(new Mi()),
    FA(new Fa()),
    SOL(new Sol()),
    LA(new La()),
    SI(new Si());

    private MusicalNote musicalNote;

    MusicalNotes(MusicalNote musicalNote) {
        this.musicalNote = musicalNote;
    }

    public MusicalNote getMusicalNote() {
        return musicalNote;
    }
}
