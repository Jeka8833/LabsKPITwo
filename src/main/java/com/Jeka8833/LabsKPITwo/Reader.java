package com.Jeka8833.LabsKPITwo;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class Reader {

    private static final Scanner in = new Scanner(System.in);

    public static int readInt(final String msg) throws ForceStopException {
        while (true) {
            try {
                System.out.print(msg);
                return Integer.parseInt(readString());
            } catch (ForceStopException exception) {
                throw exception;
            } catch (Exception ignored) {
                System.out.println();
                System.out.println("Ой, сложный ты.... Хочу int... Попробуй ещё раз");
            }
        }
    }

    public static long readLong(final String msg) throws ForceStopException {
        while (true) {
            try {
                System.out.print(msg);
                return Long.parseLong(readString());
            } catch (ForceStopException exception) {
                throw exception;
            } catch (Exception ignored) {
                System.out.println();
                System.out.println("Ой, сложный ты.... Хочу long... Попробуй ещё раз");
            }
        }
    }

    public static float readFloat(final String msg) throws ForceStopException {
        while (true) {
            try {
                System.out.print(msg);
                return Float.parseFloat(readString());
            } catch (ForceStopException exception) {
                throw exception;
            } catch (Exception ignored) {
                System.out.println();
                System.out.println("Ой, сложный ты.... Хочу float... Попробуй ещё раз");
            }
        }
    }

    public static double readDouble(final String msg) throws ForceStopException {
        while (true) {
            try {
                System.out.print(msg);
                return Double.parseDouble(readString());
            } catch (ForceStopException exception) {
                throw exception;
            } catch (Exception ignored) {
                System.out.println();
                System.out.println("Ой, сложный ты.... Хочу double... Попробуй ещё раз");
            }
        }
    }

    public static @NotNull String readString() throws ForceStopException {
        final String read = in.nextLine();
        if (read.equalsIgnoreCase("exit"))
            System.exit(0);
        else if (read.equalsIgnoreCase("break"))
            throw new ForceStopException();
        return read;
    }
}
