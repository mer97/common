package top.leemer.common.util;

import org.springframework.http.HttpStatus;
import top.leemer.common.bean.PageInfo;
import top.leemer.common.emun.ErrorCode;

import java.io.Serializable;
import java.util.Map;

/**
 * Restful统一Json响应对象封装
 *
 * @author LEEMER
 * Create Date: 2019-10-11
 */
public class ResultUtils<T> implements Serializable {

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

    public ResultUtils(){
        this.status = SUCCESS_CODE;
        this.message = "SUCCESS";
    }

    public ResultUtils(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public ResultUtils(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ResultUtils(String status, String message, T data, Map<String, Object> ext) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.ext = ext;
    }

    public ResultUtils(String status, String message, T data, PageInfo pageInfo) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.page = pageInfo;
    }

    public ResultUtils(String status, String message, T data, Map<String, Object> ext, PageInfo pageInfo) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.ext = ext;
        this.page = pageInfo;
    }

    public ResultUtils(String status, String message, T data, Long total, Integer pageNo, Integer pageSize){
        PageInfo pageInfo = new PageInfo(total, pageNo, pageSize);
        this.status = status;
        this.message = message;
        this.data = data;
        this.page = pageInfo;
    }

    public ResultUtils(String status, String message, T data, Map<String, Object> ext, Long total, Integer pageNo, Integer pageSize){
        PageInfo pageInfo = new PageInfo(total, pageNo, pageSize);
        this.status = status;
        this.message = message;
        this.data = data;
        this.ext = ext;
        this.page = pageInfo;
    }

    //快速返回成功
    public static <T>ResultUtils success(){
        return new ResultUtils<T>(SUCCESS_CODE,"请求成功",null);
    }

    public static <T>ResultUtils success(T result){
        return new ResultUtils<T>(SUCCESS_CODE,"请求成功",result);
    }

    public static <T>ResultUtils success(String message, T result){
        return new ResultUtils<T>(SUCCESS_CODE,message,result);
    }

    public static <T>ResultUtils success(String message, T result, Map<String, Object> extra){
        return new ResultUtils<T>(SUCCESS_CODE,message,result, extra);
    }

    public static <T>ResultUtils success(T result, Long total, Integer pageNo, Integer pageSize){
        PageInfo pageInfo = new PageInfo(total, pageNo, pageSize);
        return new ResultUtils<T>(SUCCESS_CODE,"请求成功",result, pageInfo);
    }

    public static <T>ResultUtils success(T result, Map<String, Object> extra, Long total, Integer pageNo, Integer pageSize){
        PageInfo pageInfo = new PageInfo(total, pageNo, pageSize);
        return new ResultUtils<T>(SUCCESS_CODE,"请求成功",result, extra,pageInfo);
    }

    public static <T>ResultUtils success(String message, T result, Long total, Integer pageNo, Integer pageSize){
        PageInfo pageInfo = new PageInfo(total, pageNo, pageSize);
        return new ResultUtils<T>(SUCCESS_CODE,message,result,pageInfo);
    }

    public static <T>ResultUtils success(String message, T result, Map<String, Object> extra, Long total, Integer pageNo, Integer pageSize){
        PageInfo pageInfo = new PageInfo(total, pageNo, pageSize);
        return new ResultUtils<T>(SUCCESS_CODE,message,result, extra,pageInfo);
    }

    //快速返回失败状态
    public static <T>ResultUtils fail(){
        return new ResultUtils<T>(ErrorCode.SYSTEM_ERROR.getCode(),ErrorCode.SYSTEM_ERROR.getMessage());
    }

    public static <T>ResultUtils fail(T result){
        return new ResultUtils<T>(ErrorCode.SYSTEM_ERROR.getCode(),ErrorCode.SYSTEM_ERROR.getMessage(),result);
    }

    public <T>ResultUtils fail(String message, T result){
        return new ResultUtils<T>(ErrorCode.SYSTEM_ERROR.getCode(),message,result);
    }

    public <T>ResultUtils fail(String message, T result, Map<String, Object> extra){
        return new ResultUtils<T>(ErrorCode.SYSTEM_ERROR.getCode(),message,result, extra);
    }

    public static <T>ResultUtils fail(ErrorCode errorCode){
        return new ResultUtils<T>(errorCode.getCode(),errorCode.getMessage());
    }

    public static <T>ResultUtils fail(ErrorCode errorCode, T result){
        return new ResultUtils<T>(errorCode.getCode(),errorCode.getMessage(),result);
    }

    public static <T>ResultUtils fail(ErrorCode errorCode, String message, T result){
        return new ResultUtils<T>(errorCode.getCode(),message,result);
    }

    public static <T>ResultUtils fail(ErrorCode errorCode, String message, T result, Map<String, Object> extra){
        return new ResultUtils<T>(errorCode.getCode(),message,result, extra);
    }

    //快速返回自定义状态码
    public static <T>ResultUtils result(String statusCode, String message){
        return new ResultUtils<T>(statusCode,message);
    }

    public static <T>ResultUtils result(String statusCode, String message, T result){
        return new ResultUtils<T>(statusCode,message,result);
    }

    public static <T>ResultUtils result(String statusCode, String message, T result, Map<String, Object> extra){
        return new ResultUtils<T>(statusCode,message,result, extra);
    }

    public static <T>ResultUtils result(String statusCode, String message, T result, Long total, Integer pageNo, Integer pageSize){
        PageInfo pageInfo = new PageInfo(total, pageNo, pageSize);
        return new ResultUtils<T>(statusCode,message,result, pageInfo);
    }

    public static <T>ResultUtils result(String statusCode, String message, T result, Map<String, Object> extra, Long total, Integer pageNo, Integer pageSize){
        PageInfo pageInfo = new PageInfo(total, pageNo, pageSize);
        return new ResultUtils<T>(statusCode,message,result, extra,pageInfo);
    }

    //快速返回Http状态
    public static <T>ResultUtils httpStatus(HttpStatus httpStatus, String message){
        return result(httpStatus.toString(),message);
    }

    public static <T>ResultUtils httpStatus(HttpStatus httpStatus, String message, T result){
        return result(httpStatus.toString(),message,result);
    }

    public static <T>ResultUtils httpStatus(HttpStatus httpStatus, String message, T result, Map<String, Object> extra){
        return result(httpStatus.toString(),message,result, extra);
    }

    public static <T>ResultUtils httpStatus(HttpStatus httpStatus, String message, T result, Long total, Integer pageNo, Integer pageSize){
        PageInfo pageInfo = new PageInfo(total, pageNo, pageSize);
        return result(httpStatus.toString(),message,result, total, pageNo, pageSize);
    }

    public static <T>ResultUtils httpStatus(HttpStatus httpStatus, String message, T result, Map<String, Object> extra, Long total, Integer pageNo, Integer pageSize){
        PageInfo pageInfo = new PageInfo(total, pageNo, pageSize);
        return result(httpStatus.toString(),message,result, extra, total, pageNo, pageSize);
    }


}
