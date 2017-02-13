package pl.bemowski.football.data.api.downloader;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipFile;

/**
 * Created by Kamil Bemowski on 2017-02-13.
 */
@Component
public class UnzipFiles {

    private static final Logger LOGGER = Logger.getLogger(UnzipFiles.class);

    /**
     * return multivaluemap with season and league code as a key and input stream as a value
     * 
     * @param files
     * @return
     */
    public Map<String, InputStream> unzipFiles(List<File> files) {
        Map<String, InputStream> valueMap = new LinkedHashMap<>();
        files.forEach(f -> {
            String fileName = f.getName();
            try {
                ZipFile zip = new ZipFile(f);
                zip.stream().forEach(e -> {
                    try {
                        InputStream inputStream = zip.getInputStream(e);
                            String key = fileName.substring(0, fileName.indexOf(".zip"))
                                    + e.getName().substring(0, e.getName().indexOf(".csv"));
                            valueMap.put(key, inputStream);
                    } catch (IOException ex) {
                        LOGGER.error("Cannot read file", ex);
                    }
                });
            } catch (IOException e) {
                LOGGER.error("Cannot open zip file", e);
            }

        });
        return valueMap;
    }
}
