package pl.bemowski.football.data.api.downloader;

import com.google.common.base.MoreObjects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.bemowski.football.data.api.model.FilePackage;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Created by Kamil Bemowski on 2017-02-13.
 */
public class UnzipFiles {

    private static final Logger LOGGER = LogManager.getLogger(UnzipFiles.class);

    /**
     * return mapToRecord with season and league code as a keyValue and input stream as a value
     *
     * @param files files with results
     * @return
     */
    public Map<String, FilePackage> unzipFiles(final Iterable<File> files) {
        final Map<String, FilePackage> valueMap = new LinkedHashMap<>();
        files.forEach(file -> {
            try {
                final ZipFile zip = new ZipFile(file);
                final String fileName = file.getName();
                zip.stream().forEach(entry -> {
                    try {
                        final TransformZipFile zipFile = new TransformZipFile(zip, fileName, entry);
                        String zipName = zip.getName();
                        valueMap.put(zipFile.getKeyValue(), FilePackage.builder()
                                .inputStream(zipFile.getInputStream()).
                                        season(zipName.substring(0, zipName.indexOf("."))).build());
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

    private static class TransformZipFile {
        private final InputStream inputStream;
        private final String keyValue;

        TransformZipFile(final ZipFile zip, final String fileName, final ZipEntry entry) throws IOException {
            this.inputStream = zip.getInputStream(entry);
            final String name = entry.getName();
            this.keyValue = new StringBuilder(fileName.substring(0, fileName.indexOf(".zip")))
                    .append(name.substring(0, name.indexOf(".csv"))).toString();
        }

        InputStream getInputStream() {
            return inputStream;
        }

        String getKeyValue() {
            return keyValue;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("inputStream", inputStream)
                    .add("keyValue", keyValue)
                    .toString();
        }
    }
}
