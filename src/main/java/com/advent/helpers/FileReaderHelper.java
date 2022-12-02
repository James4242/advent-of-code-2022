package com.advent.helpers;

import com.advent.exceptions.InvalidFileException;
import com.advent.problems.DayOne;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class FileReaderHelper {

    private FileReaderHelper() {
    }

    public static List<String> convertFileToList(String fileName) {
        var res = DayOne.class.getClassLoader().getResource(fileName);
        if (Objects.isNull(res)) {
            throw new InvalidFileException("File cannot be found");
        }
        try {
            return Files.readAllLines(Path.of(res.getPath()));
        } catch (IOException e) {
            throw new InvalidFileException("Unable to read from file", e);
        }
    }
}
