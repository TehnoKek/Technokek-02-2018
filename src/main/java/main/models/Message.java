package main.models;

import org.springframework.lang.Nullable;

public class Message<T> {
    private final T message;
    private boolean successful = true;

    public Message(boolean successful) {
        this.successful = successful;
        this.message = null;
    }

    public Message(boolean successful, @Nullable T message) {
        this.message = message;
        this.successful = successful;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        if ( ((Message<?>)obj).successful != this.successful)
            return false;
        if ( ((Message<?>)obj).message == this.message)
            return true;
        if ( !((Message<?>)obj).message.equals(this.message))
            return false;
        return true;


    }

    /*
    Без аннотации компилятор выдаст предупреждение о том,
    что локальная переменная s не используется. С аннотацией
    компилятор игнорирует это предупреждение для локального модуля
     */

    @SuppressWarnings("unused")
    public @Nullable
    T getMessage() {
        return message;
    }

    @SuppressWarnings("unused")
    public boolean isSuccessful() {
        return successful;
    }
}
