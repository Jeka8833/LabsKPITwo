package com.Jeka8833.LabsKPITwo;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Writer {

    private static final int LENGTH = 20;
    private static final String LINE_SEPARATOR = " | ";

    private static Column[] columns;
    private static final List<Object[]> lines = new ArrayList<>();

    public static void init(final Column... columns) {
        Writer.columns = columns;
        lines.clear();
    }

    public static void add(final Object... o) {
        lines.add(o);
    }

    public static void saveResult() throws IOException {
        if (columns == null)
            throw new NullPointerException("Writer not initialized");
        final String outText = getFormattedText();
        Files.writeString(Path.of("output.txt"), outText);
        Files.writeString(Path.of("output.csv"), getFormattedCSV());
        System.out.println(outText);
    }

    private static @NotNull String getFormattedText() {
        final StringBuilder out = new StringBuilder();
        final StringBuilder format = new StringBuilder();
        for (Column type : columns) {
            out.append(String.format("%" + LENGTH + "s", type.name)).append(LINE_SEPARATOR);

            format.append("%").append(LENGTH);
            if (type.type.equals(String.class)) {
                format.append("s");
            } else if (type.type.equals(Float.class) || type.type.equals(Double.class)) {
                format.append("g");
            } else if (type.type.equals(Byte.class) || type.type.equals(Short.class) || type.type.equals(Integer.class) || type.type.equals(Long.class)) {
                format.append("d");
            } else if (type.type.equals(Boolean.class)) {
                format.append("b");
            } else {
                throw new NullPointerException("Unknown type: " + type.getClass());
            }
            format.append(LINE_SEPARATOR);
        }
        out.append('\n');
        for (Object[] line : lines)
            out.append(String.format(format.toString(), line)).append('\n');
        return out.toString();
    }

    private static @NotNull String getFormattedCSV() {
        final StringBuilder out = new StringBuilder();
        for (Column column : columns)
            out.append('"').append(column.name).append("\";");
        out.deleteCharAt(out.length() - 1);
        out.append("\r\n");
        for (Object[] line : lines) {
            for (Object arg : line) {
                if (arg instanceof String)
                    out.append('"').append(arg).append("\";");
                else if (arg instanceof Float || arg instanceof Double)
                    out.append('"').append(arg.toString().replace('.', ',')).append("\";");
                else
                    out.append(arg).append(';');
            }
            out.deleteCharAt(out.length() - 1);
            out.append("\r\n");
        }
        return out.toString();
    }
}
