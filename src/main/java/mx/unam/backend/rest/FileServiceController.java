package mx.unam.backend.rest;

import java.io.IOException;
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

import mx.unam.backend.model.File;
import mx.unam.backend.service.FileService;

@RestController
@RequestMapping("/files")
public class FileServiceController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<String> subeArchivos(@RequestParam("files") List<MultipartFile> in) {
        try {
            fileService.save(in);
        } catch (IOException ioe) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error al subir el archivo");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Se cargaron los archivos correctamente");
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
            String ruta = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(FileServiceController.class,
                            "obtenArchivo",
                            path.getFileName().toString())
                    .build().toString();
            return new File(ruta, url);
        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(archivos);
    }
}
