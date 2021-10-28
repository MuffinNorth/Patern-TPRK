package ru.muffi.application;

import ru.muffi.state.MultiTool;
import ru.muffi.state.StateFabric;
import ru.muffi.state.list.DrillState;
import ru.muffi.state.list.PuncherState;
import ru.muffi.state.list.WrenchState;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        MultiTool tool = new MultiTool();
        StateFabric fabric = new StateFabric(tool.getContext());
        tool.changeState(fabric.getStateByClassName(DrillState.class));
        int answer;
        Scanner input = new Scanner(System.in);
        while (true){
            System.out.println("_________________________________________");
            System.out.println("|Текущее состояние инструмента: " + tool.getStateName());
            System.out.println("|Текущая мощность инструмента: " + tool.getPowerLayer());
            System.out.println("_________________________________________");
            System.out.println("|Выберите действие:");
            System.out.println("|[1] Режим дрели");
            System.out.println("|[2] Режим перфоратора");
            System.out.println("|[3] Режим гайковерта");
            System.out.println("|[4] Мощность на low");
            System.out.println("|[5] Мощность на medium");
            System.out.println("|[6] Мощность на high");
            System.out.println("|[7] Поработать инструментом");
            System.out.println("|[0] Выход");
            System.out.println("_________________________________________");
            System.out.print("-->");
            answer = input.nextInt();
            switch (answer) {
                case 1 -> tool.changeState(fabric.getStateByClassName(DrillState.class));
                case 2 -> tool.changeState(fabric.getStateByClassName(PuncherState.class));
                case 3 -> tool.changeState(fabric.getStateByClassName(WrenchState.class));
                case 4 -> tool.setPowerLayer(MultiTool.powerState.low);
                case 5 -> tool.setPowerLayer(MultiTool.powerState.medium);
                case 6 -> tool.setPowerLayer(MultiTool.powerState.high);
                case 7 -> {
                    System.out.print("Результат работы: ");
                    tool.doWork();
                    System.in.read();
                }
                case 0 -> System.exit(0);
                default -> System.out.println("Команда отсутствует!");
            }

        }
    }
}
