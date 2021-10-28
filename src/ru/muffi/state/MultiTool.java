package ru.muffi.state;

public class MultiTool {
    public enum powerState{
        low(1),
        medium(2),
        high(3),
        maximum(4);

        private int power;

        powerState(int i) {
            power = i;
        }

        public int getPower() {
            return power;
        }
    }

    private Context<MultiTool> workTypeContext;
    private powerState powerLayer = powerState.low;

    public MultiTool(){
        workTypeContext = new Context(this);
    }

    public Context getContext(){
        return workTypeContext;
    }

    public void doWork() throws Exception {
        workTypeContext.implementState();
    }

    public String getStateName(){
        return workTypeContext.getState().toString();
    }

    public void changeState(State nextState){
        workTypeContext.setState(nextState);
    }

    public powerState getPowerLayer() {
        return powerLayer;
    }

    public void setPowerLayer(powerState powerLayer) {
        this.powerLayer = powerLayer;
    }


}
