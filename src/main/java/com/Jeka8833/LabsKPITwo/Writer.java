package com.Jeka8833.LabsKPITwo;

import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Writer {

    private static final int LENGTH = 20;
    private static final String LINE_SEPARATOR = " | ";

    private static final List<Object[]> lines = new ArrayList<>();

    public static void reset() {
        lines.clear();
    }

    public static void add(final Object... o) {
        if (o[0] instanceof Column && !lines.isEmpty()) {
            final Column[] columns = new Column[lines.get(lines.size() - 1).length];
            for (int i = 0; i < lines.get(lines.size() - 1).length; i++) {
                columns[i] = new Column(StringUtils.repeat('=', LENGTH), String.class);
            }
            lines.add(columns);
        }
        lines.add(o);
    }

    public static void saveResult() {
        final String outText = getFormattedText();
        try {
            Files.writeString(Path.of("output.txt"), outText);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        try {
            Files.writeString(Path.of("output.csv"), getFormattedCSV());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        System.out.println(outText);
    }

    private static @NotNull String getFormattedText() {
        final StringBuilder out = new StringBuilder();
        final StringBuilder format = new StringBuilder();
        for (Object[] line : lines) {
            if (line[0] instanceof Column) {
                format.setLength(0);
                for (Object column : line) {
                    final Column type = (Column) column;
                    out.append(StringUtils.center(type.name, LENGTH)).append(LINE_SEPARATOR);

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
            } else {
                out.append(String.format(format.toString(), line)).append('\n');
            }
        }
        return out.toString();
    }

    private static @NotNull String getFormattedCSV() {
        final StringBuilder out = new StringBuilder();
        for (Object[] line : lines) {
            if (line[0] instanceof Column) {
                for (Object t : line) {
                    out.append('"').append(((Column) t).name).append("\";");
                }
            } else {
                for (Object arg : line) {
                    if (arg instanceof String)
                        out.append('"').append(arg).append("\";");
                    else if (arg instanceof Float || arg instanceof Double)
                        out.append('"').append(arg.toString().replace('.', ',')).append("\";");
                    else
                        out.append(arg).append(';');
                }
            }
            out.deleteCharAt(out.length() - 1);
            out.append("\r\n");
        }
        return out.toString();
    }

    public static void addMatrix(final double[][] matrix, final String columnPrefix) {
        final Column[] name = new Column[matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            name[i] = new Column(columnPrefix + i, Double.class);
        }
        add((Object[]) name);
        for (int y = 0; y < matrix.length; y++) {
            final Object[] tmp = new Object[matrix[y].length];
            for (int x = 0; x < matrix[y].length; x++) {
                tmp[x] = matrix[y][x];
            }
            add(tmp);
        }
    }

    public static void addMatrix(final double[] matrix, final String columnPrefix) {
        final Column[] name = new Column[matrix.length];
        final Object[] tmp = new Object[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            name[i] = new Column(columnPrefix + i, Double.class);
            tmp[i] = matrix[i];
        }
        add((Object[]) name);
        add(tmp);
    }
}
