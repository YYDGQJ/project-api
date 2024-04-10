package com.project.common.util;

import cn.hutool.core.io.FileUtil;
import com.project.common.constant.RMS;
import com.project.common.response.ResultBean;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.BodyPart;
import javax.mail.MessagingException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

/**
 * FTPUtil
 *
 * @author YYDGQJ
 * create 2023/9/3 19:46
 */
public class FTPUtil {
    public static ResultBean<?> getResultBean(MultipartFile[] attachments, String filePath) {
        boolean re = false;
        for (MultipartFile file : attachments) {
            re = uploadFile(
                    com.project.common.constant.FTP.HOST,
                    com.project.common.constant.FTP.POST,
                    com.project.common.constant.FTP.USER_NAME,
                    com.project.common.constant.FTP.PASS_WORD,
                    com.project.common.constant.FTP.BASE_PATH,
                    filePath,
                    file.getOriginalFilename(),
                    file);
        }
        ResultBean<Boolean> result = new ResultBean<>();
        if (re){
            result.success(re);
        }else {
            result.error500(RMS.FILE_UPLOAD_ERROR);
        }
        return result;
    }

    /**
     * Description: 向FTP服务器上传文件
     * @param host FTP服务器hostname
     * @param port FTP服务器端口
     * @param username FTP登录账号
     * @param password FTP登录密码
     * @param basePath FTP服务器基础目录
     * @param filePath FTP服务器文件存放路径。文件的路径为basePath+filePath
     * @param filename 上传到FTP服务器上的文件名
     * @param multipartFile 输入流
     * @return 成功返回true，否则返回false
     */
    public static boolean uploadFile(String host,
                                     int port,
                                     String username,
                                     String password,
                                     String basePath,
                                     String filePath,
                                     String filename,
                                     MultipartFile multipartFile){

        boolean result = false;
        FTPClient ftp = new FTPClient();
        try {
            int reply;
            ftp.connect(host, port);// 连接FTP服务器
            // 如果采用默认端口，可以使用ftp.connect(host)的方式直接连接FTP服务器
            ftp.login(username, password);// 登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return result;
            }
            //切换到上传目录
            if (!ftp.changeWorkingDirectory(basePath+filePath)) {
                //如果目录不存在创建目录
                String[] dirs = filePath.split("/");
                String tempPath = basePath;
                for (String dir : dirs) {
                    if (null == dir || dir.isEmpty()) {
                        continue;
                    }
                    tempPath += "/" + dir;
                    if (!ftp.changeWorkingDirectory(tempPath)) {  //进不去目录，说明该目录不存在
                        if (!ftp.makeDirectory(tempPath)) { //创建目录
                            //如果创建文件目录失败，则返回
                            return result;
                        } else {
                            //目录存在，则直接进入该目录
                            ftp.changeWorkingDirectory(tempPath);
                        }
                    }
                }
            }
            File file = convertMultipartFileToFile(multipartFile);
            InputStream input = FileUtil.getInputStream(file);
            //设置上传文件的类型为二进制类型
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
//            //开启服务器对UTF-8的支持，如果服务器支持就用UTF-8编码，否则就用本地编码（ISO-8859-1）
////            ftp.getClient().sendCommand("OPTS UTF8", "ON")
//            if (FTPReply.isPositiveCompletion(ftp.sendCommand("OPTS UTF8", "ON"))) {
//                ftp.setControlEncoding("UTF-8");
//            } else {
//                //FTP协议里面，规定文件名编码为iso-8859-1
//                ftp.setControlEncoding("ISO-8859-1");
//            }
            ftp.setControlEncoding("UTF-8");
            ftp.enterLocalPassiveMode();
            //上传文件
            if (!ftp.storeFile(filename, input)) {
                FileUtil.del(file);
                return result;
            }
            input.close();
            ftp.logout();
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ignored) {
                }
            }
        }
        //System.out.println(result);
        return result;
    }
    public static File convertMultipartFileToFile(MultipartFile multipartFile) throws IOException {
        File file = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(multipartFile.getBytes());
        fileOutputStream.close();
        return file;
    }


    public static ResultBean<?> getResultBean2(List<BodyPart> bodyParts, String filePath)  {
        boolean re = false;
        for (BodyPart bodyPart : bodyParts) {
            re = uploadFile2(
                    com.project.common.constant.FTP.HOST,
                    com.project.common.constant.FTP.POST,
                    com.project.common.constant.FTP.USER_NAME,
                    com.project.common.constant.FTP.PASS_WORD,
                    com.project.common.constant.FTP.BASE_PATH,
                    filePath,
                    bodyPart);
        }
        ResultBean<Boolean> result = new ResultBean<>();
        if (re){
            result.success(re);
        }else {
            result.error500(RMS.FILE_UPLOAD_ERROR);
        }
        return result;
    }

    /**
     * Description: 向FTP服务器上传文件
     * @param host FTP服务器hostname
     * @param port FTP服务器端口
     * @param username FTP登录账号
     * @param password FTP登录密码
     * @param basePath FTP服务器基础目录
     * @param filePath FTP服务器文件存放路径。文件的路径为basePath+filePath
     * @return 成功返回true，否则返回false
     */
    public static boolean uploadFile2(String host,
                                     int port,
                                     String username,
                                     String password,
                                     String basePath,
                                     String filePath,
                                      BodyPart bodyPart){

        boolean result = false;
        FTPClient ftp = new FTPClient();
        try {
            int reply;
            ftp.connect(host, port);// 连接FTP服务器
            // 如果采用默认端口，可以使用ftp.connect(host)的方式直接连接FTP服务器
            ftp.login(username, password);// 登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return result;
            }
            //切换到上传目录
            if (!ftp.changeWorkingDirectory(basePath+filePath)) {
                //如果目录不存在创建目录
                String[] dirs = filePath.split("/");
                String tempPath = basePath;
                for (String dir : dirs) {
                    if (null == dir || dir.isEmpty()) {
                        continue;
                    }
                    tempPath += "/" + dir;
                    if (!ftp.changeWorkingDirectory(tempPath)) {  //进不去目录，说明该目录不存在
                        if (!ftp.makeDirectory(tempPath)) { //创建目录
                            //如果创建文件目录失败，则返回
                            return result;
                        } else {
                            //目录存在，则直接进入该目录
                            ftp.changeWorkingDirectory(tempPath);
                        }
                    }
                }
            }
            //设置上传文件的类型为二进制类型
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
//            //开启服务器对UTF-8的支持，如果服务器支持就用UTF-8编码，否则就用本地编码（ISO-8859-1）
////            ftp.getClient().sendCommand("OPTS UTF8", "ON")
//            if (FTPReply.isPositiveCompletion(ftp.sendCommand("OPTS UTF8", "ON"))) {
//                ftp.setControlEncoding("UTF-8");
//            } else {
//                //FTP协议里面，规定文件名编码为iso-8859-1
//                ftp.setControlEncoding("ISO-8859-1");
//            }
            ftp.setControlEncoding("UTF-8");
            ftp.enterLocalPassiveMode();
            //上传文件
            if (!ftp.storeFile(bodyPart.getFileName(), bodyPart.getInputStream())) {
                return result;
            }
            bodyPart.getInputStream().close();
            ftp.logout();
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ignored) {
                }
            }
        }
        //System.out.println(result);
        return result;
    }

}
