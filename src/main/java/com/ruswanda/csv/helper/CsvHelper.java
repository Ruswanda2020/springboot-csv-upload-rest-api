package com.ruswanda.csv.helper;

import com.ruswanda.csv.entity.Book;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CsvHelper {

    private static final String TYPE = "text/csv";
    private static final String[] HEADERS = {"id", "title", "description", "price"};

    public static Boolean hasCsvFormat(MultipartFile file) {
        return TYPE.equals(file.getContentType());
    }

    public static List<Book> csvToBook(InputStream inputStream) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"))){
            CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                    .setHeader(HEADERS)
                    .setSkipHeaderRecord(true)
                    .build();

            List<Book> books = new ArrayList<>();

            Iterable<CSVRecord> records = csvFormat.parse(fileReader);
            for (CSVRecord record : records) {
                Book book = new Book();
                book.setId(Long.parseLong(record.get(0)));
                book.setTitle(record.get(1));
                book.setDescription(record.get(2));
                book.setPrice(Double.parseDouble(record.get(3)));
                books.add(book);
            }
            return books;
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse CSV file: " + e.getMessage());
        }
    }
}
