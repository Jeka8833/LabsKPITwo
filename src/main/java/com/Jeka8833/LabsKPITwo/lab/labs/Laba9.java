package com.Jeka8833.LabsKPITwo.lab.labs;

import com.Jeka8833.LabsKPITwo.ForceStopException;
import com.Jeka8833.LabsKPITwo.Reader;
import com.Jeka8833.LabsKPITwo.Writer;
import com.Jeka8833.LabsKPITwo.lab.Lab;
import org.apache.commons.math3.util.MathArrays;

public class Laba9 implements Lab {
    @Override
    public String getName() {
        return "No 9. Розв’язання систем лінійних алгебраїчних рівнянь. Ітераційні методи Якобі та Гауса-Зейделя";
    }

    @Override
    public void run() throws ForceStopException {
        final int n = Reader.readInt("Введите n: ");
        final double[][] a = Reader.readMatrix(n, n, "Введём матрицу СЛАР A[" + n + "," + n + "], можно написать random - для авто заполнения матрицы");
        final double[] b = Reader.readMatrix(n, "Вектор B[" + n + "], можно написать random - для авто заполнения матрицы");
        final double e = Reader.readDouble("Введите e: ");
        Writer.addMatrix(a, "a-");
        Writer.addMatrix(b, "b-");
        final double[] res = calc(n, a, b, e);
        if (res == null) {
            System.out.println("Ошибка: превышено количество итераций");
            return;
        }
        Writer.addMatrix(res, "X-");
        Writer.saveResult();
    }

    public static double[] calc(final int n, final double[][] a, final double[] b, final double e) {
        double[] x = MathArrays.copyOf(b);
        final double[] xNew = new double[n];
        for (int itter = 0; itter < 100; itter++) {
            double eMax = 0;
            for (int i = 0; i < n; i++) {
                double sum = 0;
                for (int j = 0; j < n; j++) {
                    if (i == j)
                        continue;
                    sum += a[i][j] * x[j];
                }
                xNew[i] = (b[i] - sum) / a[i][i];

                eMax = Math.max(Math.abs(xNew[i] - x[i]), eMax);
            }
            x = xNew;
            if (eMax < e)
                return x;
        }
        return null;
    }
}
