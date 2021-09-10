package com.Jeka8833.LabsKPITwo.lab;

import com.Jeka8833.LabsKPITwo.ForceStopException;

public interface Lab {

    String getName();

    void run() throws ForceStopException;
}
