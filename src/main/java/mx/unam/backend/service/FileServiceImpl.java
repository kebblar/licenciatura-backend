package mx.unam.backend.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {

    private final Path ruta = Paths.get("src", "main", "resources", "static", "imagenes");

    @Override
    public void save(MultipartFile in) throws IOException {
        Files.copy(in.getInputStream(), this.ruta.resolve(in.getOriginalFilename()));
    }

    @Override
    public Resource load(String nombre) throws IOException {
        Path archivo = ruta.resolve(nombre);
        return new UrlResource(archivo.toUri());
    }

    @Override
    public void save(List<MultipartFile> in) throws IOException {
        for (MultipartFile m : in)
            this.save(m);
    }

    @Override
    public Stream<Path> loadAll() throws IOException {
        return Files.walk(ruta, 1).filter(path -> !path.equals(ruta)).map(ruta::relativize);
    }

}