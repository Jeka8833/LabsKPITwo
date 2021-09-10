package com.Jeka8833.LabsKPITwo.lab;

import com.Jeka8833.LabsKPITwo.ForceStopException;
import com.Jeka8833.LabsKPITwo.Reader;
import com.Jeka8833.LabsKPITwo.lab.labs.Laba4;
import com.Jeka8833.LabsKPITwo.lab.labs.Laba3;
import com.Jeka8833.LabsKPITwo.lab.labs.Laba5;
import com.Jeka8833.LabsKPITwo.lab.labs.Laba6;

import java.util.ArrayList;
import java.util.List;

public class LabManager {

    public static final List<Lab> labs = new ArrayList<>();

    public static void init() {
        labs.add(new Laba3());
        labs.add(new Laba4());
        labs.add(new Laba5());
        labs.add(new Laba6());
    }

    public static void draw() {
        System.out.println("Список доступных лаб, пожалуйста выберите номер работы");
        for (int i = 0; i < labs.size(); i++) {
            System.out.println((i + 1) + " -> " + labs.get(i).getName());
        }
        System.out.println("Чтобы закрыть программу напишите 'exit'");
        System.out.println();
        try {
            final int value = Reader.readInt("Выберите номер лабы: ");
            if (value > 0 && value <= labs.size()) {
                while (true) {
                    System.out.println("Лаба: " + labs.get(value - 1).getName());
                    System.out.println("Команда break для выхода в меню!!!!!!!");
                    System.out.println("==================================================");
                    System.out.println();

                    labs.get(value - 1).run();
                }
            } else {
                System.out.println("Неа, нету такого номера....");
                System.out.println();
            }

        } catch (ForceStopException e) {
            System.out.println("Остановка выполнения лабы");
            System.out.println();
        }
    }
}
