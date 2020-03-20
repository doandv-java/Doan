package haui.doan.stores.framework;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "image.storage")
public class ImageStorage {

    private Root root = new Root();

    @Data
    public static class Root {
        String path;
    }

}
