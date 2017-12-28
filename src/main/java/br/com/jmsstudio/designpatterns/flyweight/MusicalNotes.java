package br.com.jmsstudio.designpatterns.flyweight;

public enum MusicalNotes {
    DO(Do.class),
    RE(Re.class),
    MI(Mi.class),
    FA(Fa.class),
    SOL(Sol.class),
    LA(La.class),
    SI(Si.class);

    private MusicalNote musicalNote;
    private Class<? extends MusicalNote> musicalNoteClass;

    MusicalNotes(Class<? extends MusicalNote> musicalNoteClass) {
        this.musicalNoteClass = musicalNoteClass;
    }

    private void instantiateMusicalNote() {
        if (this.musicalNote == null) {
            try {
                this.musicalNote = musicalNoteClass.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public MusicalNote getMusicalNote() {
        instantiateMusicalNote();
        return this.musicalNote;
    }
}
