package br.com.jmsstudio.singleton;

public class MessageSingleton {
    private static MessageSingleton instance;

    private MessageSingleton() {
    }

    public static MessageSingleton getInstance() {
        if (instance == null) {
            instance = new MessageSingleton();
        }

        return instance;
    }
}
