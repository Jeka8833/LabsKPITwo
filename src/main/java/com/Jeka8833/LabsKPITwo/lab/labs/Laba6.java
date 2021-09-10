package com.Jeka8833.LabsKPITwo.lab.labs;

import com.Jeka8833.LabsKPITwo.ForceStopException;
import com.Jeka8833.LabsKPITwo.Reader;
import com.Jeka8833.LabsKPITwo.lab.Lab;

public class Laba6 implements Lab {

    //http://www.machinelearning.ru/wiki/index.php?title=%D0%9C%D0%B5%D1%82%D0%BE%D0%B4_%D0%BA%D0%B0%D1%81%D0%B0%D1%82%D0%B5%D0%BB%D1%8C%D0%BD%D1%8B%D1%85_%28%D0%9D%D1%8C%D1%8E%D1%82%D0%BE%D0%BD%D0%B0-%D0%A0%D0%B0%D1%84%D1%81%D0%BE%D0%BD%D0%B0%29

    @Override
    public String getName() {
        return "No 6. Розв’язання нелінійних рівнянь з одним невідомим. Метод Ньютона-Рафсона (дотичних)";
    }

    @Override
    public void run() throws ForceStopException {
        double x = Reader.readDouble("Введите x: ");
        final double e = Reader.readDouble("Введите e: ");
        double gamma;
        do {
            final double fx = Laba5.F(x);
            final double fxq = Laba5.Fq(x);
            gamma = (fx) / fxq;
            x = x - gamma;
        } while (Math.abs(gamma) > e);
        System.out.println("Ответ x: " + x);
    }
}
