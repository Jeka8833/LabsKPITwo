package com.Jeka8833.LabsKPITwo.lab.labs;

import com.Jeka8833.LabsKPITwo.Column;
import com.Jeka8833.LabsKPITwo.ForceStopException;
import com.Jeka8833.LabsKPITwo.Reader;
import com.Jeka8833.LabsKPITwo.Writer;
import com.Jeka8833.LabsKPITwo.lab.Lab;

public class Laba15 implements Lab {
    @Override
    public String getName() {
        return "No 15. Інтерполяція даних. Рівномірне (чебишовське) наближення функцій";
    }

    @Override
    public void run() throws ForceStopException {
        final int n = Reader.readInt("Введите n: ");
        final double a = Reader.readDouble("Введите a: ");
        final double b = Reader.readDouble("Введите b: ");
        Writer.add(new Column("i", Integer.class), new Column("xi", Double.class), new Column("yi", Double.class));
        for (int i = 1; i <= n; i++) {
            final double xi = strip(a, b, i);
            Writer.add(i, xi, Laba3.F(xi));
        }
        Writer.add(new Column("x", Double.class), new Column("f(x)", Double.class),
                new Column("L(x)", Double.class), new Column("f(x) - L(x)", Double.class));

        for (int i = (int) (a * 10); i < b * 10; i++) {
            final double xi = a + (b - a) / ((b - a) * 10 - 1) * i;
            final double polinom = calcPolinom(a, b, n, xi);
            Writer.add(xi, Laba3.F(xi), polinom, Laba3.F(xi) - polinom);
        }

        Writer.saveResult();
    }

    private static double calcPolinom(final double a, final double b, final int n, final double xreal) {
        double sum = 0;
        for (int j = 1; j <= n; j++) {
            double dob = 1;
            for (int i = 1; i <= n; i++) {
                if (i == j) continue;
                dob *= (xreal - strip(a, b, i)) / (strip(a, b, j) - strip(a, b, i));
            }
            sum += dob * Laba3.F(strip(a, b, j));
        }
        return sum;
    }

    private static double strip(final double a, final double b, final int i) {
        return a + (b - a) / (i);
    }
}
