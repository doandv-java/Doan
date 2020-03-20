package haui.doan.stores;

import haui.doan.stores.framework.ImageStorage;
import haui.doan.stores.utils.FileUtils;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class StoresApplication implements CommandLineRunner {


    private final ImageStorage imageStorage;

    public static void main(String[] args) {
        SpringApplication.run(StoresApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        FileUtils.createDirectoryIfNotExist(imageStorage.getRoot().getPath());
    }
}
