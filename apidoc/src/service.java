/**
 * @api {GET} /business/order/query1/{id} 订单查询接口（1）
 * @apiName orderQuery1
 * @apiGroup 1.Order
 * @apiVersion v0.1.1
 * @apiDescription 使用RestTemplate模板(服务地址写死)，进行远程接口调用，实现按订单id查询订单信息的功能
 * @apiParam {id} id 订单标识（ID）
 * @apiParamExample 获取订单信息:
/business/order/query1/1
 * @apiSuccessExample {json} Success-Response:
{
"status": 200,
"message": "成功",
"data": "订单id = 1",
"timeStamp": "2020-10-04 23:02:37"
}
 */

/**
 * @api {GET} /business/order/query2/{id} 订单查询接口（2）
 * @apiName orderQuery2
 * @apiGroup 1.Order
 * @apiVersion v0.1.1
 * @apiDescription 使用RestTemplate模板（服务地址使用服务的逻辑名称），进行远程接口调用，实现按订单id查询订单信息的功能
 * @apiParam {id} id 订单标识（ID）
 * @apiParamExample 获取订单信息::
/business/order/query2/2
 * @apiSuccessExample {json} Success-Response:
{
"status": 200,
"message": "成功",
"data": "订单id = 2",
"timeStamp": "2020-10-03 21:56:46"
}
 */

/**
 * @api {GET} /business/order/query3/{id} 订单查询接口（3）
 * @apiName orderQuery3
 * @apiGroup 1.Order
 * @apiVersion v0.1.1
 * @apiDescription 使用Feign组件（服务地址使服务的逻辑名称），进行远程接口调用，实现按订单id查询订单信息的功能
 * @apiParam {id} id 订单标识（ID）
 * @apiParamExample 获取订单信息:
/business/order/query3/3
 * @apiSuccessExample {json} Success-Response:
{
"status": 200,
"message": "成功",
"data": "订单id = 3",
"timeStamp": "2020-10-03 21:51:51"
}
 * @apiSuccessExample {json} Fail-Response[服务降级处理]:
{
"status": 200,
"message": "成功",
"data": "订单服务繁忙，请稍候再试（言外之意：订单服务要么挂了要么调用失败！！！",
"timeStamp": "2020-10-03 21:36:49"
}
 */


/**
 * @api {POST} /business/commodity/buy 下单/购买商品（正常）
 * @apiName commodity_buy
 * @apiGroup 2.Commodity
 * @apiDescription
 正常下单购买商品（全局提交）：从创建订单、账户扣款到用户积分增加，再到商品对应的库存减少服务的调用；
 主要模拟全局事务的注册（XID），以及在各个微服务模块的接口调用均正常的情况下，
 由TM（事务管理者）发起全局事务的提交，最终保证微服务模块之间互相调用下的全局事务一致性（全部提交）！
 * @apiParam {Long} userId 用户标识（ID）
 * @apiParam {String} commodityCode 商品唯一编码（一个商品对应一个唯一的商品号）
 * @apiParam {String} name 私钥密码，非空
 * @apiParam {Integer} count 购买商品的数量
 * @apiParam {Double} amount 购买商品的总价
 * @apiVersion v0.1.1
 * @apiParamExample params-Json:
{
"userId":1001,
"commodityCode":"C201901140001",
"name":"水杯",
"count":2,
"amount":20.0
}
 * @apiSuccessExample {json} Success-Response:
{
"status": 200,
"message": "成功",
"data": true,
"timeStamp": "2020-10-04 22:59:38"
}
 *
 */

/**
 * @api {POST} /business/commodity/buy/exception 下单/购买商品（异常）
 * @apiName commodity_buy_excep
 * @apiGroup 2.Commodity
 * @apiDescription
异常下单购买商品（全局回滚）：从创建订单、账户扣款到用户积分增加，再到商品对应的库存减少服务的调用；
主要模拟全局事务的注册（XID），以及在各个微服务模块的接口调用出现其中一个或多个服务异常的情况下，
由TM（事务管理者）发起全局事务的回滚，最终保证微服务模块之间互相调用下的全局事务一致性（全部回滚）！
 * @apiParam {Long} userId 用户标识（ID）
 * @apiParam {String} commodityCode 商品唯一编码（一个商品对应一个唯一的商品号）
 * @apiParam {String} name 私钥密码，非空
 * @apiParam {Integer} count 购买商品的数量
 * @apiParam {Double} amount 购买商品的总价
 * @apiVersion v0.1.1
 * @apiParamExample params-Json:
{
"userId":1001,
"commodityCode":"C201901140001",
"name":"水杯",
"count":2,
"amount":20.0
}
 * @apiSuccessExample {json} Success-Response:
{
"status": 400,
"message": "失败",
"data": "[500] during [POST] to [http://storage-server/stock/reduce/exception] [StockService#reduce2(CommodityDTO)]: [{\"timestamp\":\"2020-10-04T15:16:15.596+0000\",\"status\":500,\"error\":\"Internal Server Error\",\"message\":\"/ by zero\",\"path\":\"/stock/reduce/exception\"}]",
"timeStamp": "2020-10-04 23:16:15"
}
 *
 */