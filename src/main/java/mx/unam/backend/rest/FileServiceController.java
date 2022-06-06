package mx.unam.backend.rest;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import mx.unam.backend.model.File;
import mx.unam.backend.service.FileService;
import mx.unam.backend.utils.UploadFileResponse;

@RestController
@RequestMapping("/files")
public class FileServiceController {

    @Autowired
    private FileService fileService;

    private final Path rutaAbs = Paths.get("src", "main", "resources", "static", "imagenes");

    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        // String fileName = fileStorageService.storeFile(file);
        String fileName = file.getName();

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();
        fileService.save(file);
        return new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> {
                    try {
                        return uploadFile(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .collect(Collectors.toList());
    }

    @GetMapping("/{ruta:.+}")
    public ResponseEntity<Resource> obtenArchivo(@PathVariable String ruta) throws IOException {
        Resource resource = fileService.load(ruta);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "ATTACHMENT; FILENAME=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @GetMapping("/archivos")
    public ResponseEntity<List<File>> obtenArchivos() throws IOException {
        List<File> archivos = fileService.loadAll().map(path -> {
            String ruta = rutaAbs.toString() + "/" + path.getFileName().toString();
            String nombre = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(FileServiceController.class,
                            "obtenArchivo",
                            path.getFileName().toString())
                    .build().toString();
            return new File(nombre, url, ruta);
        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(archivos);
    }
}
