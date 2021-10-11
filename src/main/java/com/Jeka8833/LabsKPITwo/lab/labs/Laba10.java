package com.Jeka8833.LabsKPITwo.lab.labs;

import com.Jeka8833.LabsKPITwo.Column;
import com.Jeka8833.LabsKPITwo.ForceStopException;
import com.Jeka8833.LabsKPITwo.Reader;
import com.Jeka8833.LabsKPITwo.Writer;
import com.Jeka8833.LabsKPITwo.lab.Lab;

public class Laba10 implements Lab {


    @Override
    public String getName() {
        return "No 10. Власні вектори і власні числа матриць з елементами-дійсними числами";
    }

    @Override
    public void run() throws ForceStopException {
        final double[][] a = Reader.readMatrix(2, 2, "Введём матрицу СЛАР A[" + 2 + "," + 2 + "], можно написать random - для авто заполнения матрицы");
        Writer.reset();
        Writer.add(new Column("rad", Double.class), new Column("vecX - x", Double.class), new Column("vecX - y", Double.class)
                , new Column("vecY - x", Double.class), new Column("vecY - y", Double.class));
        for (int i = 0; i < 360; i++) {
            final double rad = Math.toRadians(i);
            final double y1 = a[0][0] * Math.cos(rad) + a[0][1] * Math.sin(rad);
            final double y2 = a[1][0] * Math.cos(rad) + a[1][1] * Math.sin(rad);
            Writer.add(rad, Math.cos(rad), Math.sin(rad), y1, y2);
        }
        Writer.add(new Column("x", Double.class), new Column("y", Double.class));
        for (int i = 0; i < 360; i++) {
            final double rad = Math.toRadians(i);
            final double y1 = a[0][0] * Math.cos(rad) + a[0][1] * Math.sin(rad);
            final double y2 = a[1][0] * Math.cos(rad) + a[1][1] * Math.sin(rad);
            if (Math.abs(Math.sin(rad) - y2) < Math.toRadians(1) ||
                    Math.abs(Math.abs(Math.sin(rad) - y2) - Math.PI) < Math.toRadians(1)) {
                Writer.add(0., 0.);
                Writer.add(y1, y2);
            }
        }
        Writer.saveResult();
    }
}
