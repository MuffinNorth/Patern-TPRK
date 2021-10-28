package ru.muffi.state;

public interface State {
    void doWork();
    void connectContext(Context ctx);
}
