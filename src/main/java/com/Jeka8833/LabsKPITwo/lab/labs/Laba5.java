package com.Jeka8833.LabsKPITwo.lab.labs;

import com.Jeka8833.LabsKPITwo.Column;
import com.Jeka8833.LabsKPITwo.ForceStopException;
import com.Jeka8833.LabsKPITwo.Reader;
import com.Jeka8833.LabsKPITwo.Writer;
import com.Jeka8833.LabsKPITwo.lab.Lab;

public class Laba5 implements Lab {

    @Override
    public String getName() {
        return "No 5. Розв’язання нелінійних рівнянь з одним невідомим. Метод простих ітерацій";
    }

    @Override
    public void run() throws ForceStopException {
        final double x = Reader.readDouble("Введите x: ");
        final double e = Reader.readDouble("Введите e: ");
        final double res = calc(x, e);
        Writer.saveResult();
        if (Double.isNaN(res))
            System.out.println("Ошибка: превышено количество итераций");
        else if (Double.isInfinite(res))
            System.out.println("Ошибка: невозможный результат");
        else
            System.out.println("Ответ x: " + res);
    }

    public static double calc(final double x, final double e) {
        Writer.add(new Column("i", Integer.class), new Column("gamma", Double.class), new Column("x", Double.class));
        double xt = x;
        int i = 0;
        double gamma = 0;
        do {
            if (i++ > 100_000)
                return Double.NaN;

            final double func = F(xt);
            gamma = func - xt;
            xt = func;
            Writer.add(i, gamma, xt);
        } while (Math.abs(gamma) > e);
        return xt;
    }

    public static double F(final double value) {
        return Math.sqrt((Math.sinh(value) + 3) / 2);
    }
}
