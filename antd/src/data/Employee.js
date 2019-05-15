
import * as OptionsHelper from './helpers/OptionsHelper.js';
import * as ResponseHelper from './helpers/ResponseHelper.js';
import * as RequestHelper from './helpers/RequestHelper.js';

import $ from 'jquery';
/**
 * 设置默认请求编码
 */
$.ajaxSetup(RequestHelper.OVERRIDE_GLOBAL_OPTIONS);


/**
 * 保存风险场景
 *
 * @param Employee    风险场景
 * @param options 请求配置
 */
export function save(Employee, options) {
  options = OptionsHelper.generate(options);
  $.ajax({
    url: "/available/manager/Employee/save.json",
    method: "POST",
    data: {
      id: Employee.id,                            // 风险场景编号(编辑状态有值)
      triggerPoint: Employee.triggerPoint,                        // 风险场景表达式
      description: Employee.description,          // 措施描述

      name: Employee.name,                        // 风险场景名称

    },
    success: function (resp) {
      if (ResponseHelper.isSuccess(resp)) {           // 成功
        options.success(resp);
      } else {
        options.error(resp);           // 失败
      }
    },
    error: options.error,
    complete: options.complete
  });
}


/**
 * 分页查询风险场景
 *
 * @param pageSize    每页显示风险场景条数
 * @param currentPage    单前页
 * @param options 请求配置
 */

export function findByPage(pageSize, currentPage, formData, options) {
  options = OptionsHelper.generate(options);
  return $.ajax({
    url: "/available/manager/Employee/findByPageModel.json",
    method: "POST",
    data: {
      page_size: pageSize,                            // 每页大小
      page: currentPage,                        	 // 当前页
      name: formData.name,

    },
    success: function (resp) {
      if (ResponseHelper.isSuccess(resp)) {           // 成功
        options.success(resp);
      } else {
        options.error(resp);           // 失败
      }
    },
    error: options.error,
    complete: options.complete
  });
}
/**
 * 查询风险场景详情
 *
 * @param id  风险场景编号
 * @param options 请求配置
 */
export function findById(id, options) {
  options = OptionsHelper.generate(options);
  return $.ajax({
    url: "/available/manager/Employee/findById.json",
    method: "POST",
    data: {
      id: id
    },
    success: function (resp) {
      if (ResponseHelper.isSuccess(resp)) {           // 成功
        options.success(resp);
      } else {
        options.error(resp);           // 失败
      }
    },
    error: options.error,
    complete: options.complete
  });
}

/**
 * 删除风险场景
 *
 * @param id  风险场景编号
 * @param options 请求配置
 */
export function deleteById(id, options) {
  options = OptionsHelper.generate(options);
  return $.ajax({
    url: "/available/manager/Employee/deleteById.json",
    method: "POST",
    data: {
      id: id
    },
    success: function (resp) {
      if (ResponseHelper.isSuccess(resp)) {           // 处理成功
        options.success(resp);
      } else {
        options.error(resp);           // 处理失败
      }
    },
    error: options.error,
    complete: options.complete
  });
}

/**
 * 查询模板对应的评估风险列表
 *
 * @param EmployeeId  appId
 * @param pageSize    每页显示风险条数
 * @param currentPage    单前页
 * @param formData 
 * @param exclude exclude=true,返回没有被当前应用选择的风险
 * @param options 请求配置
 * @returns {*}
 */
export function findRelateByPageModel(appId, pageSize, currentPage, formData, exclude, targetType, options) {

  options = OptionsHelper.generate(options);
  return $.ajax({
    url: "/available/manager/Employee/findEmployeeByPageModel.json",
    method: "POST",
    data: {
      page_size: pageSize,
      targetType: targetType,
      page: currentPage,
      appId: appId,
      name: formData.name,
      exclude: exclude,
    },
    success: function (resp) {
      if (ResponseHelper.isSuccess(resp)) {           // 处理成功
        options.success(resp);
      } else {
        options.error(resp.errorMsg || "");           // 处理失败
      }
    },
    error: options.error,
    complete: options.complete
  });

}
