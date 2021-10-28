package ru.muffi.state.list;

import ru.muffi.state.Context;
import ru.muffi.state.MultiTool;
import ru.muffi.state.State;

public class DrillState implements State {
    private Context context;

    @Override
    public void doWork() {
        String sound = "Drrrrr";
        MultiTool.powerState power = ((MultiTool) context.getContextObject()).getPowerLayer();
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < power.getPower(); i++) {
            out.append(sound);
            out.append(" ");
        }
        System.out.println(out.toString());
    }

    @Override
    public void connectContext(Context ctx) {
        context = ctx;
    }

    @Override
    public String toString() {
        return "Дрель";
    }
}
