package haui.doan.stores.business.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    String saveImage(String imageLink, MultipartFile image);
}
