package Medione.utils;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @ClassName HttpUtils
 * @Description utils for sending
 **/
public class HttpUtils {
    public static String apiSendPostFile(String url, File files) {

        HttpHeaders headers = new HttpHeaders();
        //set content-type
        MediaType type = MediaType.parseMediaType("multipart/form-data");
        headers.setContentType(type);
        headers.setContentLength(files.length());
        headers.add("Authorization","dqOfd2mnoSAKmByqw73K1hVlya5JhpcT");
        headers.add("User-Agent","Mozilla/5.0(Windows;U;Windows NT 5.1;en-US;rv:0.9.4)");
        MultiValueMap<String, Object> form = new LinkedMultiValueMap<>();
        if (files != null) {
            //set request body
            FileSystemResource fileSystemResource = new FileSystemResource(files);
            form.add("smfile", fileSystemResource);
            //form.add("bucketName", bucket);
        }
        HttpEntity<MultiValueMap<String, Object>> params = new HttpEntity<>(form, headers);


        RestTemplate restTemplate= new RestTemplate();

        return restTemplate.postForObject(url, params, String.class);

    }


    /**
     * MultipartFile to File
     *
     * @param file
     * @throws Exception
     */
    public static File multipartFileToFile(MultipartFile file,String name) throws Exception {

        File toFile = null;
        if (file.equals("") || file.getSize() <= 0) {
            file = null;
        } else {
            InputStream ins = null;
            ins = file.getInputStream();
            toFile = new File(name);
            inputStreamToFile(ins, toFile);
            ins.close();
        }
        return toFile;
    }

    //get inputStream
    private static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * delete temporary file
     * @param file
     */
    public static void delteTempFile(File file) {
        if (file != null) {
            File del = new File(file.toURI());
            del.delete();
        }
    }




    }

