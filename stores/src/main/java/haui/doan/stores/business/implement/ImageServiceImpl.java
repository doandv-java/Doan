package haui.doan.stores.business.implement;

import haui.doan.stores.business.service.ImageService;
import haui.doan.stores.framework.Constants;
import haui.doan.stores.framework.ImageStorage;
import haui.doan.stores.utils.FileUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * The service to save image upload by user in web
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    //The image storage path of user
    private final ImageStorage imageStorage;

    /**
     * The method is used to save image into image storage
     *
     * @param imageLink path of file image
     * @param image     file in form multipart file
     * @return path of file image save
     */
    @Override
    public String saveImage(String imageLink, MultipartFile image) {
        //Path new image if file multipart file not empty
        String imageLinkNew = StringUtils.EMPTY;
        //Check file image not empty
        if (!FileUtils.checkNullOrEmptyImage(image)) {
            //Save image in to storage root
            imageLinkNew = FileUtils.saveImage(imageStorage.getRoot().getPath(), image);
        }
        //Check image link old empty or not empty
        if (!StringUtils.isEmpty(imageLink)) {
            //update
            return FileUtils.checkNullOrEmptyImage(image) ? imageLink : imageLinkNew;
        } else {
            //create
            return FileUtils.checkNullOrEmptyImage(image) ? Constants.IMAGE_DEFAULT.NAME : imageLinkNew;
        }
    }
}
