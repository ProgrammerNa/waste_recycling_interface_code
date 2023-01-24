package cn.edu.guet.waste_recycling.service.impl;

import cn.edu.guet.waste_recycling.bean.ApplicationPic;
import cn.edu.guet.waste_recycling.mapper.IApplicationPicMapper;
import cn.edu.guet.waste_recycling.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author HHS
 */
@Service
public class ImageServiceImpl implements IImageService {

    @Autowired
    private IApplicationPicMapper applicationPicMapper;

    //将文件写入到本地
    public String uploadimage(MultipartFile file, String orderId) {
        String path = "D:\\iwrp\\picture\\" + orderId;
        File file1 = new File(path);
        if (!file1.exists() && !file1.isDirectory()) {
            System.out.println(path + "路径不存在");
            file1.mkdirs();
        }

        FileOutputStream out = null;
        File newFile = null;
        try {
            byte[] bytes = file.getBytes();
            newFile = new File(path + "\\" + file.getOriginalFilename());// 获取上传时的文件名
            out = new FileOutputStream(newFile);
            out.write(bytes);
            out.flush();
            System.out.println("成功保存至本地");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                out.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return newFile.getAbsolutePath();
    }

    //从本地读取文件并返回到网页中
    public void getImage(String filename, HttpServletResponse response) {
        FileInputStream in = null;
        ServletOutputStream out = null;
        try {
            File file = new File("D:\\iwrp\\picture\\" + filename);
            in = new FileInputStream(file);
            out = response.getOutputStream();
            byte[] bytes = new byte[1024 * 10];
            int len = 0;
            while ((len = in.read(bytes)) != -1) {
                out.write(bytes,0,len);
            }
            out.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                in.close();
                out.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean insertImage(List<ApplicationPic> list) {
        return applicationPicMapper.insertPic(list);
    }
}
