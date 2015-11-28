/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemangagesystemlab;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Matthew_2
 */
public class FileService implements FileServiceStrategy {

    //File garageDataFile = new File("src" + File.separatorChar + "filemangagesystemlab" + File.separatorChar + "GarageData.txt");

    private FileReaderStrategy reader;
    private FileWriterStrategy writer;

    /**
     * Default Constructor to provide a new instance of FileService
     */
    public FileService() {
    }

    /**
     * Constructor for FileService with a specified reader and writer strategy
     *
     * @param reader
     * @param writer
     */
    public FileService(FileReaderStrategy reader, FileWriterStrategy writer) {
        this.reader = reader;
        this.writer = writer;
    }

    /**
     * Sets the specific reader for the FileService Class
     *
     * @param reader
     */
    @Override
    public void setReader(FileReaderStrategy reader) {
        if (reader == null) {
            throw new IllegalArgumentException();
        }
        this.reader = reader;
    }

    /**
     * Sets the specific writer for the FileService Class
     *
     * @param writer
     */
    @Override
    public void setWriter(FileWriterStrategy writer) {
        if (writer == null) {
            throw new IllegalArgumentException();
        }
        this.writer = writer;
    }

    /**
     * Reads the whole file and returns the records
     *
     * @return
     * @throws IOException
     */
    @Override
    public String readAll() throws IOException {
        return reader.readFile();
    }

    /**
     * Writes a list of records to the file
     *
     * @param data
     * @throws IOException
     */
    @Override
    public void writeAll(List<Map<String, String>> data) throws IOException {
        writer.write(data);
    }

}
