package pl.bemowski.football.data.api.main;

import pl.bemowski.football.data.api.downloader.DownloadFiles;
import pl.bemowski.football.data.api.downloader.UnzipFiles;
import pl.bemowski.football.data.api.model.FilePackage;

import java.io.File;
import java.util.List;
import java.util.Map;

public class FootballDataProcessor
{

    public Map<String, FilePackage> process() {
        final FilesChecker filesChecker = new FilesChecker();
        filesChecker.checkIsAllFilesAvailable();
        final DownloadFiles downloadFiles = new DownloadFiles();
        List<File> zips = downloadFiles.getAllZipPackages();
        UnzipFiles
                unzipFiles = new UnzipFiles();
        return unzipFiles.unzipFiles(zips);
    }
}
