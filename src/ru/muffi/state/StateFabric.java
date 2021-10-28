package ru.muffi.state;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class StateFabric {
    private Context target;

    public StateFabric(Context ctx){
        target = ctx;
    }

    public State getStateByClassName(Class classname) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor stateConstructor = classname.getConstructor(null);
        State s = (State)  stateConstructor.newInstance();
        s.connectContext(target);
        return s;
    }
}
