package com.Jeka8833.LabsKPITwo;

import com.Jeka8833.LabsKPITwo.lab.LabManager;

public class Main {

    public static void main(String[] args) {
        LabManager.init();
        while (true)
            LabManager.draw();
    }
}
