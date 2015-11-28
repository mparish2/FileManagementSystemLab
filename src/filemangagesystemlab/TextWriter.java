/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemangagesystemlab;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Matthew_2
 */
public class TextWriter implements FileWriterStrategy {
    private DataFormatStrategy dataFormat;
    private final File file;

    public TextWriter(final File file, DataFormatStrategy dataFormat) {
        this.file = file;
    }

    @Override
    public void write(final List<Map<String,String>> data) throws IOException {
        try (BufferedWriter out
                = new BufferedWriter(
                        new FileWriter(file))) {
                    out.write(dataFormat.encode(data));
                } catch (IOException ioe) {
                    throw ioe;
                } catch (Exception e) {
                    throw e;
                }
    }

}
