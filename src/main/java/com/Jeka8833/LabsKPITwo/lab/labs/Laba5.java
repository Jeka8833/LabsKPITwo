package com.Jeka8833.LabsKPITwo.lab.labs;

import com.Jeka8833.LabsKPITwo.ForceStopException;
import com.Jeka8833.LabsKPITwo.Reader;
import com.Jeka8833.LabsKPITwo.lab.Lab;

public class Laba5 implements Lab {

    //Test https://planetcalc.ru/2824/

    @Override
    public String getName() {
        return "No 5. Розв’язання нелінійних рівнянь з одним невідомим. Метод простих ітерацій";
    }

    @Override
    public void run() throws ForceStopException {
        double x = Reader.readDouble("Введите x: ");
        final double e = Reader.readDouble("Введите e: ");
        int i = 0;
        double gamma = 0;
        System.out.printf("%10s | %10s | %10s\n", "Iteration", "x", "gamma");
        do {
            i++;
            System.out.printf("%10d | %10f | %10f\n", i, x, gamma);
            final double xTemp = x;
            x = F(x);
            gamma = x - xTemp;
        } while (Math.abs(gamma) > e);
        System.out.println("Ответ x: " + x);
    }

    public static double F(final double value) {
        return Math.cos(value) - value + 1;
    }

    public static double Fq(final double value) {
        return -Math.sin(value) - 1;
    }
}
