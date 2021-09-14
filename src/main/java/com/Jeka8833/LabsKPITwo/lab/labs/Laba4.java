package com.Jeka8833.LabsKPITwo.lab.labs;

import com.Jeka8833.LabsKPITwo.Column;
import com.Jeka8833.LabsKPITwo.ForceStopException;
import com.Jeka8833.LabsKPITwo.Reader;
import com.Jeka8833.LabsKPITwo.Writer;
import com.Jeka8833.LabsKPITwo.lab.Lab;

public class Laba4 implements Lab {

    @Override
    public String getName() {
        return "No 4. Розв’язання нелінійних рівнянь з одним невідомим. Метод поділу навпіл (бісекції)";
    }

    @Override
    public void run() throws ForceStopException {
        final double a = Reader.readDouble("Введите a: ");
        final double b = Reader.readDouble("Введите b: ");
        final double e = Reader.readDouble("Введите e: ");
        final double res = calc(a, b, e);

        if (Double.isNaN(res)) {
            System.out.println("ErrCode = -1");
            System.out.println("Знаки должны отличатся a(" + a + ") = " + F(a) + " b(" + b + ") = " + F(b));
            return;
        }
        Writer.saveResult();

        System.out.println("Ответ x: " + res);
    }

    public static double calc(double a, double b, final double e) {
        if (Math.signum(F(a)) == Math.signum(F(b)))
            return Double.NaN;
        Writer.add(new Column("i", Integer.class), new Column("|b - a|", Double.class),
                new Column("a", Double.class), new Column("x", Double.class), new Column("b", Double.class),
                new Column("f(x)", Double.class));
        final double sfa = Math.signum(F(a));
        int i = 1;
        do {
            final double x = a + (b - a) / 2;
            Writer.add(i++, Math.abs(b - a), a, x, b, F(x));
            if (Math.signum(F(x)) == sfa)
                a = x;
            else
                b = x;
        } while (Math.abs(b - a) > e);
        return a + (b - a) / 2;
    }

    public static double F(final double value) {
        return Laba3.F(value);
    }
}
