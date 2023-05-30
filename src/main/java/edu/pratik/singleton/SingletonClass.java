package edu.pratik.singleton;

import java.io.ObjectStreamException;

public class SingletonClass {
    //Eager/early initialization
    private static final SingletonClass INSTANCE = new SingletonClass();
    private SingletonClass() {
        // Check if we already have an instance
        if (INSTANCE != null) {
            throw new IllegalStateException("Singleton instance already created.");
        }
    }
    //to get singleton instance
    public static final SingletonClass getInstance() {
        return INSTANCE;
    }
    //To prevent creation of new object by deserializing
    private Object readResolve() throws ObjectStreamException {
        return INSTANCE;
    }
    //write the same object instead of replacement object while serializing
    private Object writeReplace() throws ObjectStreamException {
        return INSTANCE;
    }
    //prevent object from cloning
    public Object clone() throws CloneNotSupportedException {
        // return INSTANCE
        throw new CloneNotSupportedException();
    }

    public void task() {
        System.out.println("Task performed by singleton class.");
    }
}
