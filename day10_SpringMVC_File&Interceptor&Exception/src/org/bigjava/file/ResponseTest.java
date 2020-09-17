package org.bigjava.file;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ProjectName: JavaEE
 * @ClassName: FileTest
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-27 15:52
 * @Version v1.0
 */
@Controller
public class ResponseTest {

    /**
     *
     * @data: 2020-07-27-16:14
     * @method: requestBodyTest
     * @params: []
     * @return: java.lang.String
     * @ResponseBody :将返回数据放在响应体中
     *
     */
    @ResponseBody
    @RequestMapping(value="/requestBody")
    public String  requestBodyTest(){
        return "<h1>success</h1>";
    }
    /**
     * 
     * @data: 2020-07-27-16:26
     * @method: responseEntityTest
     * @params: []
     * @return: org.springframework.http.ResponseEntity<java.lang.String>
     *     ResponseEntity<String>:设置响应体中内容的类型
     */
    @ResponseBody
    @RequestMapping(value="/responseEntity")
    public ResponseEntity<String> responseEntityTest(){
        MultiValueMap<String,String> headers = new HttpHeaders();
        String body = "<h1>success</h1>";
        headers.add("Set-Cookie", "username=洛笙");
        return new ResponseEntity<String>(body,headers, HttpStatus.OK);
    }
}
