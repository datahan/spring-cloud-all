package com.datahan.common;

import lombok.Data;

/**
 * 请求的响应类
 * @author Jim
 */
@Data
public class ResponseResult<T> {

  /**
   * 操作成功
   */
  public static final String SUCCESS_CODE = "10000";
  /**
   * 操作失败
   */
  public static final String ERROR_CODE = "19999";
  /**
   * 业务异常错误
   */
  public static final String BIZ_ERROR_CODE = "29999";
  /**
   * 系统异常错误
   */
  public static final String SYS_ERROR_CODE = "39999";

  /**
   * 响应信息
   */
  private String msg;
  /**
   * 响应code
   */
  private String code;
  /**
   * 操作成功，响应数据
   */
  private T data;

  public ResponseResult(String code, String msg, T data) {
    this.msg = msg;
    this.code = code;
    this.data = data;
  }

  /**
   * 创建一个成功的响应对象
   *
   * @return
   */
  public static ResponseResult<String> success() {
    return success(null);
  }

  /**
   * 创建一个成功的响应对象
   *
   * @param data
   * @return
   */
  public static <T> ResponseResult<T> success(T data) {
    return new ResponseResult<T>(SUCCESS_CODE, "请求成功", data);
  }

  /**
   * 创建一个失败的响应对象
   *
   * @param msg
   * @return
   */
  public static <T> ResponseResult<T> error(String msg) {
    return new ResponseResult<T>(ERROR_CODE, msg, null);
  }

  /**
   * 创建一个业务异常错误
   *
   * @param msg
   * @return
   */
  public static <T> ResponseResult<T> bizError(String msg) {
    return new ResponseResult<T>(BIZ_ERROR_CODE, msg, null);
  }

  /**
   * 创建一个系统异常错误
   *
   * @param msg
   * @return
   */
  public static <T> ResponseResult<T> sysError(String msg) {
    return new ResponseResult<T>(SYS_ERROR_CODE, msg, null);
  }
}

