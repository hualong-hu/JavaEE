package org.bigjava.file;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @ProjectName: JavaEE
 * @ClassName: FileTest
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-27 16:31
 * @Version v1.0
 */
@Controller
public class FileTest implements HandlerInterceptor {
    /**
     * SpringMVC文件下载
     * @data: 2020-07-27-16:35
     * @method: download
     * @params: []
     * @return: java.lang.String
     */
    @RequestMapping(value="/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request) throws IOException {
        //1.得到要下载的文件的流，找到要下载的文件的真实路径
        ServletContext context = request.getServletContext();
        String realPath = context.getRealPath("/scripts/jquery-1.9.1.min.js");
        FileInputStream stream = new FileInputStream(realPath);
        byte[] bytes = new byte[stream.available()];
        stream.read(bytes);
        stream.close();

        //2.将要下载的文件流返回
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Disposition", "attachment;filename="+"jquery-1.9.1.min.js");
        return new ResponseEntity<byte[]>(bytes,httpHeaders, HttpStatus.OK);
    }
    /**
     * 单个文件的上传
     * @data: 2020-07-28-9:54
     * @method: up
     * @params: []
     * @return: java.lang.String
     */
    @RequestMapping(value="/upload")
    public String  upload(@RequestParam(value = "username",required = false)String username,
                          @RequestParam(value = "headerimg") MultipartFile file,
                          @RequestParam(value = "path")String path,
                          Model model){
        System.out.println("上传的文件信息：");
        System.out.println("文件的表单name值:"+file.getName());
        System.out.println("文件的文件名："+file.getOriginalFilename());

        try {
            file.transferTo(new File(path+"\\"+file.getOriginalFilename()));
            model.addAttribute("msg", "文件上传成功！");

        } catch (IOException e) {
            model.addAttribute("msg", "文件上传失败！");
            e.printStackTrace();
        }
        return "success";
    }
    /**
     * 多文件上传
     * @data: 2020-07-28-10:25
     * @method: uploadSome
     * @params: [username, file, path, model]
     * @return: java.lang.String
     */
    @RequestMapping(value="/uploadSome")
    public String  uploadSome(@RequestParam(value = "username",required = false)String username,
                          @RequestParam(value = "headerimg") MultipartFile[] file,
                          Model model){
        System.out.println("上传的文件信息：");
        for (MultipartFile multipartFile : file) {
            if (!multipartFile.isEmpty()){
                //文件保存
                try {
                    multipartFile.transferTo(new File("D:\\game\\"+multipartFile.getOriginalFilename()));
                    System.out.println("文件的文件名："+multipartFile.getOriginalFilename());
                    model.addAttribute("msg", "文件上传成功！");
                    return "success";
                } catch (IOException e) {
                    model.addAttribute("msg", "文件上传失败！");
                    e.printStackTrace();
                }
            }
        }

        return "response";
    }
}
