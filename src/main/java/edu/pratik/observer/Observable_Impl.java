package edu.pratik.observer;

public class Observable_Impl implements IObservable{
    String data;

    @Override
    public void subscribe(IObserver observer) {
        if(!observers.contains(observer))
            observers.add(observer);
    }

    @Override
    public void unsubscribe(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifySubscriber() {
        for(IObserver observer: observers)
            observer.update(data);
    }

    @Override
    public void setData(String data) {
        this.data = data;
        notifySubscriber();
    }

    @Override
    public String getData() {
        return data;
    }
}
