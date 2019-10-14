package top.leemer.common.util;

import org.springframework.http.HttpStatus;
import top.leemer.common.bean.PageInfo;

import java.io.Serializable;
import java.util.Map;

/**
 * Restful统一Json响应对象封装
 *
 * @author LEEMER
 * Create Date: 2019-10-11
 */
public class ResponseUtils<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private final static String SUCCESS_CODE = "200";

    /**
     * 返回状态码
     */
    private String status;

    /**
     * 返回消息
     */
    private String message;

    /**
     * 返回内容
     */
    private T data;

    /**
     * 分页信息
     */
    private PageInfo page;

    /**
     * 其他内容
     */
    private Map<String, Object> ext;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Map<String, Object> getExt() {
        return ext;
    }

    public void setExt(Map<String, Object> ext) {
        this.ext = ext;
    }

    public PageInfo getPage() {
        return page;
    }

    public void setPage(PageInfo page) {
        this.page = page;
    }

    public ResponseUtils(){
        this.status = SUCCESS_CODE;
        this.message = "SUCCESS";
    }

    public ResponseUtils(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public ResponseUtils(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ResponseUtils(String status, String message, T data, Map<String, Object> ext) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.ext = ext;
    }

    public ResponseUtils(String status, String message, T data, PageInfo pageInfo) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.page = pageInfo;
    }

    public ResponseUtils(String status, String message, T data, Map<String, Object> ext, PageInfo pageInfo) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.ext = ext;
        this.page = pageInfo;
    }

    public ResponseUtils(String status, String message, T data, Long total, Integer pageNo, Integer pageSize){
        PageInfo pageInfo = new PageInfo(total, pageNo, pageSize);
        this.status = status;
        this.message = message;
        this.data = data;
        this.page = pageInfo;
    }

    public ResponseUtils(String status, String message, T data, Map<String, Object> ext, Long total, Integer pageNo, Integer pageSize){
        PageInfo pageInfo = new PageInfo(total, pageNo, pageSize);
        this.status = status;
        this.message = message;
        this.data = data;
        this.ext = ext;
        this.page = pageInfo;
    }

    //快速返回成功
    public static <T>ResponseUtils success(){
        return new ResponseUtils<T>(SUCCESS_CODE,"请求成功",null);
    }

    public static <T>ResponseUtils success(T result){
        return new ResponseUtils<T>(SUCCESS_CODE,"请求成功",result);
    }

    public static <T>ResponseUtils success(String message, T result){
        return new ResponseUtils<T>(SUCCESS_CODE,message,result);
    }

    public static <T>ResponseUtils success(String message, T result, Map<String, Object> extra){
        return new ResponseUtils<T>(SUCCESS_CODE,message,result, extra);
    }

    public static <T>ResponseUtils success(T result, Long total, Integer pageNo, Integer pageSize){
        PageInfo pageInfo = new PageInfo(total, pageNo, pageSize);
        return new ResponseUtils<T>(SUCCESS_CODE,"请求成功",result, pageInfo);
    }

    public static <T>ResponseUtils success(T result, Map<String, Object> extra, Long total, Integer pageNo, Integer pageSize){
        PageInfo pageInfo = new PageInfo(total, pageNo, pageSize);
        return new ResponseUtils<T>(SUCCESS_CODE,"请求成功",result, extra,pageInfo);
    }

    public static <T>ResponseUtils success(String message, T result, Long total, Integer pageNo, Integer pageSize){
        PageInfo pageInfo = new PageInfo(total, pageNo, pageSize);
        return new ResponseUtils<T>(SUCCESS_CODE,message,result,pageInfo);
    }

    public static <T>ResponseUtils success(String message, T result, Map<String, Object> extra, Long total, Integer pageNo, Integer pageSize){
        PageInfo pageInfo = new PageInfo(total, pageNo, pageSize);
        return new ResponseUtils<T>(SUCCESS_CODE,message,result, extra,pageInfo);
    }

    //快速返回失败状态
    public static <T>ResponseUtils fail(){
        return new ResponseUtils<T>(ErrorCode.SYSTEM_ERROR.getCode(),ErrorCode.SYSTEM_ERROR.getMessage());
    }

    public static <T>ResponseUtils fail(T result){
        return new ResponseUtils<T>(ErrorCode.SYSTEM_ERROR.getCode(),ErrorCode.SYSTEM_ERROR.getMessage(),result);
    }

    public <T>ResponseUtils fail(String message, T result){
        return new ResponseUtils<T>(ErrorCode.SYSTEM_ERROR.getCode(),message,result);
    }

    public <T>ResponseUtils fail(String message, T result, Map<String, Object> extra){
        return new ResponseUtils<T>(ErrorCode.SYSTEM_ERROR.getCode(),message,result, extra);
    }

    public static <T>ResponseUtils fail(ErrorCode errorCode){
        return new ResponseUtils<T>(errorCode.getCode(),errorCode.getMessage());
    }

    public static <T>ResponseUtils fail(ErrorCode errorCode, T result){
        return new ResponseUtils<T>(errorCode.getCode(),errorCode.getMessage(),result);
    }

    public static <T>ResponseUtils fail(ErrorCode errorCode, String message, T result){
        return new ResponseUtils<T>(errorCode.getCode(),message,result);
    }

    public static <T>ResponseUtils fail(ErrorCode errorCode, String message, T result, Map<String, Object> extra){
        return new ResponseUtils<T>(errorCode.getCode(),message,result, extra);
    }

    //快速返回自定义状态码
    public static <T>ResponseUtils result(String statusCode, String message){
        return new ResponseUtils<T>(statusCode,message);
    }

    public static <T>ResponseUtils result(String statusCode, String message, T result){
        return new ResponseUtils<T>(statusCode,message,result);
    }

    public static <T>ResponseUtils result(String statusCode, String message, T result, Map<String, Object> extra){
        return new ResponseUtils<T>(statusCode,message,result, extra);
    }

    public static <T>ResponseUtils result(String statusCode, String message, T result, Long total, Integer pageNo, Integer pageSize){
        PageInfo pageInfo = new PageInfo(total, pageNo, pageSize);
        return new ResponseUtils<T>(statusCode,message,result, pageInfo);
    }

    public static <T>ResponseUtils result(String statusCode, String message, T result, Map<String, Object> extra, Long total, Integer pageNo, Integer pageSize){
        PageInfo pageInfo = new PageInfo(total, pageNo, pageSize);
        return new ResponseUtils<T>(statusCode,message,result, extra,pageInfo);
    }

    //快速返回Http状态
    public static <T>ResponseUtils httpStatus(HttpStatus httpStatus, String message){
        return result(httpStatus.toString(),message);
    }

    public static <T>ResponseUtils httpStatus(HttpStatus httpStatus, String message, T result){
        return result(httpStatus.toString(),message,result);
    }

    public static <T>ResponseUtils httpStatus(HttpStatus httpStatus, String message, T result, Map<String, Object> extra){
        return result(httpStatus.toString(),message,result, extra);
    }

    public static <T>ResponseUtils httpStatus(HttpStatus httpStatus, String message, T result, Long total, Integer pageNo, Integer pageSize){
        PageInfo pageInfo = new PageInfo(total, pageNo, pageSize);
        return result(httpStatus.toString(),message,result, total, pageNo, pageSize);
    }

    public static <T>ResponseUtils httpStatus(HttpStatus httpStatus, String message, T result, Map<String, Object> extra, Long total, Integer pageNo, Integer pageSize){
        PageInfo pageInfo = new PageInfo(total, pageNo, pageSize);
        return result(httpStatus.toString(),message,result, extra, total, pageNo, pageSize);
    }


}
