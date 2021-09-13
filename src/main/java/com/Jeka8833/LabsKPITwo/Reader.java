package com.Jeka8833.LabsKPITwo;

import org.jetbrains.annotations.NotNull;

import java.util.Random;
import java.util.Scanner;

public class Reader {

    private static final Scanner in = new Scanner(System.in);
    private static final Random r = new Random();

    public static int readInt(final String msg) throws ForceStopException {
        while (true) {
            try {
                return Integer.parseInt(readString(msg));
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
                return Long.parseLong(readString(msg));
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
                return Float.parseFloat(readString(msg));
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
                return Double.parseDouble(readString(msg));
            } catch (ForceStopException exception) {
                throw exception;
            } catch (Exception ignored) {
                System.out.println();
                System.out.println("Ой, сложный ты.... Хочу double... Попробуй ещё раз");
            }
        }
    }

    public static @NotNull String readString(final String msg) throws ForceStopException {
        System.out.print(msg);
        final String read = in.nextLine();
        if (read.equalsIgnoreCase("exit"))
            System.exit(0);
        else if (read.equalsIgnoreCase("break"))
            throw new ForceStopException();
        return read;
    }

    public static double[][] readMatrix(final int width, final int height, final String msg) throws ForceStopException {
        System.out.println(msg);

        final double[][] a = new double[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                while (true) {
                    try {
                        final String text = Reader.readString("x: " + x + " y: " + y + " Value: ");
                        if (text.equalsIgnoreCase("random")) {
                            for (int y1 = 0; y1 < height; y1++) {
                                for (int x1 = 0; x1 < width; x1++) {
                                    a[y1][x1] = r.nextInt(10);
                                }
                            }
                            return a;
                        }
                        a[y][x] = Double.parseDouble(text);
                        break;
                    } catch (ForceStopException exception) {
                        throw exception;
                    } catch (Exception ignored) {
                        System.out.println("Ой, сложный ты.... Хочу int... Попробуй ещё раз");
                    }
                }
            }
        }
        return a;
    }

    public static double[] readMatrix(final int width, final String msg) throws ForceStopException {
        System.out.println(msg);
        final double[] b = new double[width];
        for (int i = 0; i < width; i++) {
            while (true) {
                try {
                    final String text = Reader.readString("y: " + i + " Value: ");
                    if (text.equalsIgnoreCase("random")) {
                        for (int j = 0; j < width; j++) {
                            b[j] = r.nextInt(10);
                        }
                        return b;
                    }
                    b[i] = Double.parseDouble(text);
                    break;
                } catch (ForceStopException exception) {
                    throw exception;
                } catch (Exception ignored) {
                    System.out.println("Ой, сложный ты.... Хочу int... Попробуй ещё раз");
                }
            }
        }
        return b;
    }
}
