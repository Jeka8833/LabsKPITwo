package com.Jeka8833.LabsKPITwo.lab.labs;

import com.Jeka8833.LabsKPITwo.ForceStopException;
import com.Jeka8833.LabsKPITwo.Reader;
import com.Jeka8833.LabsKPITwo.lab.Lab;

public class Laba4 implements Lab {
    @Override
    public String getName() {
        return "No 4. Розв’язання нелінійних рівнянь з одним невідомим. Метод поділу навпіл (бісекції)";
    }

    @Override
    public void run() throws ForceStopException {
        double a = Reader.readDouble("Введите a: ");
        double b = Reader.readDouble("Введите b: ");
        final double e = Reader.readDouble("Введите e: ");

        final double sfa = Math.signum(Laba3.calculateF(a));
        do {
            final double x = a + (b - a) / 2;
            if(Math.signum(Laba3.calculateF(x)) == sfa)
                a = x;
            else
                b = x;
        } while (Math.abs(a - b) > e);
        System.out.println("Ответ x: " + (a + (b - a) / 2));
    }
}
