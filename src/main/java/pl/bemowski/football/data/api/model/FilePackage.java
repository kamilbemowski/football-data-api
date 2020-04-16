package pl.bemowski.football.data.api.model;

import lombok.Builder;
import lombok.Data;

import java.io.InputStream;

@Data
@Builder
public class FilePackage {
    InputStream inputStream;
    String season;
}
