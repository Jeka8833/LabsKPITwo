package com.Jeka8833.LabsKPITwo.lab.labs;

import com.Jeka8833.LabsKPITwo.Column;
import com.Jeka8833.LabsKPITwo.ForceStopException;
import com.Jeka8833.LabsKPITwo.Reader;
import com.Jeka8833.LabsKPITwo.Writer;
import com.Jeka8833.LabsKPITwo.lab.Lab;

import java.util.function.DoubleUnaryOperator;

public class Laba18 implements Lab {
    @Override
    public String getName() {
        return "No 18. Чисельне інтегрування. Формули прямокутників, трапецій, Сімпсона";
    }

    @Override
    public void run() throws ForceStopException {
        final int n = Reader.readInt("Введите n: ");
        final double a = Reader.readDouble("Введите a: ");
        final double b = Reader.readDouble("Введите b: ");
        final double real = extractIntegral(a, b);
        Writer.add(new Column("n", Integer.class), new Column("real", Double.class),
                new Column("value", Double.class), new Column("e", Double.class));
        for (int i = 1; i <= n; i += 10) {
            final double tmp = calc(a, b, i, Laba3::F);
            Writer.add(i, real, tmp, real - tmp);
        }
        Writer.saveResult();
    }

    public static double calc(final double a, final double b, final double n, final DoubleUnaryOperator operator) {
        final double step = ((b - a) / n);

        double sum = 0;
        for (int i = 1; i < n - 1; i++)
            sum += operator.applyAsDouble(a + step * i);
        return step / 2 * (operator.applyAsDouble(a) + 2 * sum + operator.applyAsDouble(b));
    }

    public static double extractIntegral(final double down, final double up) {
        return (2 * Math.pow(down, 3)) / 3 - 3 * down - Math.cosh(down) - (2 * Math.pow(up, 3)) / 3 + 3 * up + Math.cosh(up);
    }
}
