package cn.edu.guet.waste_recycling.service;

import cn.edu.guet.waste_recycling.bean.ApplicationPic;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author HHS
 */
public interface IImageService {
    String uploadimage(MultipartFile file, String orderId);
    void getImage(String filename, HttpServletResponse response);

    boolean insertImage(List<ApplicationPic> list);
}
