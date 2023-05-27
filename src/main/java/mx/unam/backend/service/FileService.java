package mx.unam.backend.service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    public void save(MultipartFile in) throws IOException;

    public Resource load(String name) throws IOException;

    public void save(List<MultipartFile> in) throws IOException;

    public Stream<Path> loadAll() throws IOException;
}