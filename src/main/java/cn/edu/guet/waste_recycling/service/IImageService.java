package cn.edu.guet.waste_recycling.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @author HHS
 */
public interface IImageService {
    void uploadimage(MultipartFile file, String orderId);
    void getImage(String filename, HttpServletResponse response);
}
