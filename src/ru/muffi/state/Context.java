package ru.muffi.state;

public class Context <T extends Object>{
    private T contextObject;
    private State state = null;

    public Context(T target){
        contextObject = target;
    }

    public T getContextObject(){
        return contextObject;
    }

    public void implementState() throws Exception {
        if(state != null){
            state.doWork();
        }else{
            throw new Exception("Not state");
        }
    }

    public void setState(State nextState){
        state = nextState;
    }
    public State getState(){
        return state;
    }
}
