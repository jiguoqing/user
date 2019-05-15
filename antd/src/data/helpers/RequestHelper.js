/**
 * 请求默认编码
 *
 * @type {string}
 */
export const DEFAULT_CHARSET = "GBK";

/**
 * AJAX默认请求配置参数
 *
 * @see @ali/ajax
 * @type {{withInputCharset: boolean, contentType: string}}
 */
export const OVERRIDE_GLOBAL_OPTIONS = {
  withInputCharset: false,
  contentType: 'application/x-www-form-urlencoded;charset=' + DEFAULT_CHARSET
};