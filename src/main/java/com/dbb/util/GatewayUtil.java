package com.dbb.util;

import java.util.Date;

import com.alibaba.fastjson.JSONObject;

public class GatewayUtil {

	private final static String BaseURL = "http://gateway.hzdbb.cn/api/";
	private final static String appid = "huizhitech";
	private final static String appsecret = "80791510-9a96-4996-aea4-0482f6a5b654";
//	private final static String BaseURL = "http://wg.znwwhl.com/api/";
//	private final static String appid = "c1527128685";
//	private final static String appsecret = "0212e575-c152-438b-96ed-fa17fe1e0e30";

	/*
	 * 获取采集器基本信息 collectors: 采集器id（多个id使用”,”连接）
	 */
	public static JSONObject get_collector_info(String collectors) {
		String tm = new Date().getTime() + "";
		String common = "appid=" + appid + "&collectors=" + collectors + "&tm=" + tm;
		String sign = MD5Util.md5(common + appsecret);
		String url = BaseURL + "get_collector_info?" + common + "&sign=" + sign;
		System.err.println(url);
		return HttpClientUtil.doPost(url, "");
	}

	/*
	 * 获取采集器在线状态（最后一次与服务器通信的时间） collectors: 采集器id（多个id使用”,”连接）
	 */
	public static JSONObject get_collector_online_state(String collectors) {
		String tm = new Date().getTime() + "";
		String common = "appid=" + appid + "&collectors=" + collectors + "&tm=" + tm;
		String sign = MD5Util.md5(common + appsecret);
		String url = BaseURL + "get_collector_online_state?" + common + "&sign=" + sign;
		return HttpClientUtil.doPost(url, "");
	}

	/*
	 * 获取表计最新的数据 devs: 设备id（多个设备id使用”,”连接） attrs:
	 * 过滤属性，只返回attrs中定义的属性(多功能电表属性非常多，但并不是所有的属性都需要用到，过滤之后可以减少json的数据量，提高解析的效率)。
	 * 该属性可为空，苦为空则返回全部属性。多个属性使用”,”连接。例如：ImpEp,ExpEp,Ua,Ub,Uc
	 */
	public static JSONObject get_latest(String devs, String attrs) {
		String tm = new Date().getTime() + "";
		String common = "appid=" + appid + "&attrs=" + attrs + "&devs=" + devs + "&tm=" + tm;
		String sign = MD5Util.md5(common + appsecret);
		String url = BaseURL + "get_latest?" + common + "&sign=" + sign;
		System.out.println(url);
		return HttpClientUtil.doPost(url, "");
	}

	/*
	 * 获取表计一天内的详细数据 devs: 设备id（多个设备id使用”,”连接） day: 日期，格式为YYYYmmdd, 例如：20160801
	 * attrs: 过滤属性
	 */
	public static JSONObject get_detail(String devs, String day, String attrs) {
		String tm = new Date().getTime() + "";
		tm = "1571391016";
		String common = "appid=" + appid + "&attrs=" + attrs + "&day=" + day + "&devs=" + devs + "&tm=" + tm;
		String sign = MD5Util.md5(common + appsecret);
		String url = BaseURL + "get_detail?" + common + "&sign=" + sign;
		System.err.println(url);
		return HttpClientUtil.doPost(url, "");
	}

	/*
	 * 获取表计一天内的每小时的数据 devs: 设备id（多个设备id使用”,”连接） day: 日期，格式为YYYYmmdd, 例如：20160801
	 * attrs: 过滤属性
	 */
	public static JSONObject get_hourly_by_day(String devs, String day, String attrs) {
		String tm = new Date().getTime() + "";
		String common = "appid=" + appid + "&attrs=" + attrs + "&day=" + day + "&devs=" + devs + "&tm=" + tm;
		String sign = MD5Util.md5(common + appsecret);
		String url = BaseURL + "get_hourly_by_day?" + common + "&sign=" + sign;
		return HttpClientUtil.doPost(url, "");
	}

	/*
	 * 获取表计一个月内的每小时的数据 devs: 设备id（多个设备id使用”,”连接） day: 日期，格式为YYYYmmdd, 例如：20160801
	 * attrs: 过滤属性
	 */
	public static JSONObject get_hourly_by_month(String devs, String day, String attrs) {
		String tm = new Date().getTime() + "";
		String common = "appid=" + appid + "&attrs=" + attrs + "&day=" + day + "&devs=" + devs + "&tm=" + tm;
		String sign = MD5Util.md5(common + appsecret);
		String url = BaseURL + "get_hourly_by_month?" + common + "&sign=" + sign;
		return HttpClientUtil.doPost(url, "");
	}

	/*
	 * 获取表计指定时间段的每小时的数据 devs: 设备id（多个设备id使用”,”连接） beg: 开始日期，格式为YYYYmmdd, 例如：20160801
	 * end: 结束日期，格式参照beg参数。（结果包含结束日期的关门数据） attrs: 过滤属性
	 */
	public static JSONObject get_hourly_in_range(String devs, String beg, String end, String attrs) {
		String tm = new Date().getTime() + "";
		String common = "appid=" + appid + "&attrs=" + attrs + "&beg=" + beg + "&devs=" + devs + "&end=" + end + "&tm="
				+ tm;
		String sign = MD5Util.md5(common + appsecret);
		String url = BaseURL + "get_hourly_in_range?" + common + "&sign=" + sign;
		return HttpClientUtil.doPost(url, "");
	}

	/*
	 * 获取表计一个月内的每天（零时）的数据 devs: 设备id（多个设备id使用”,”连接） month: 日期，格式为YYYYmm, 例如：201608
	 * attrs: 过滤属性。
	 */
	public static JSONObject get_daily_by_month(String devs, String month, String attrs) {
		String tm = new Date().getTime() + "";
		String common = "appid=" + appid + "&attrs=" + attrs + "&devs=" + devs + "&month=" + month + "&tm=" + tm;
		String sign = MD5Util.md5(common + appsecret);
		String url = BaseURL + "get_daily_by_month?" + common + "&sign=" + sign;
		return HttpClientUtil.doPost(url, "");
	}

	/*
	 * 获取表计指定时间段的每天（零时）的数据 devs: 设备id（多个设备id使用”,”连接） beg: 开始日期，格式为YYYYmmdd,
	 * 例如：20160801 end: 结束日期，格式参照beg参数。（结果包含结束日期的关门数据） attrs: 过滤属性。
	 */
	public static JSONObject get_daily_in_range(String devs, String beg, String end, String attrs) {
		String tm = new Date().getTime() + "";
		String common = "appid=" + appid + "&attrs=" + attrs + "&beg=" + beg + "&devs=" + devs + "&end=" + end + "&tm="
				+ tm;
		String sign = MD5Util.md5(common + appsecret);
		String url = BaseURL + "get_daily_in_range?" + common + "&sign=" + sign;
		return HttpClientUtil.doPost(url, "");
	}

	/*
	 * 获取表计指定日期（零时）的数据 devs: 设备id（多个设备id使用”,”连接） days:
	 * 日期，多个日期使用”,”连接，例如：20160801,20160901,20161001 attrs: 过滤属性。
	 */
	public static JSONObject get_daily_at(String devs, String days, String attrs) {
		String tm = new Date().getTime() + "";
		String common = "appid=" + appid + "&attrs=" + attrs + "&days=" + days + "&devs=" + devs + "&tm=" + tm;
		String sign = MD5Util.md5(common + appsecret);
		String url = BaseURL + "get_daily_at?" + common + "&sign=" + sign;
		return HttpClientUtil.doPost(url, "");
	}

	/*
	 * 获取表计一天内的极值数据 devs: 设备id（多个设备id使用”,”连接） day: 日期，格式为YYYYmmdd, 例如：20160801
	 * attrs: 过滤属性。
	 */
	public static JSONObject get_edge_by_day(String devs, String day, String attrs) {
		String tm = new Date().getTime() + "";
		String common = "appid=" + appid + "&attrs=" + attrs + "&day=" + day + "&devs=" + devs + "&tm=" + tm;
		String sign = MD5Util.md5(common + appsecret);
		String url = BaseURL + "get_edge_by_day?" + common + "&sign=" + sign;
		System.err.println(url);
		return HttpClientUtil.doPost(url, "");
	}

	/*
	 * 获取表计一个月内的每天的极值数据 devs: 设备id（多个设备id使用”,”连接） month: 日期，格式为YYYYmm, 例如：201608
	 * attrs: 过滤属性。
	 */
	public static JSONObject get_edge_by_month(String devs, String month, String attrs) {
		String tm = new Date().getTime() + "";
		String common = "appid=" + appid + "&attrs=" + attrs + "&devs=" + devs + "&month=" + month + "&tm=" + tm;
		String sign = MD5Util.md5(common + appsecret);
		String url = BaseURL + "get_edge_by_month?" + common + "&sign=" + sign;
		return HttpClientUtil.doPost(url, "");
	}

	/*
	 * 获取表计指定时间段的每天的极值数据 devs: 设备id（多个设备id使用”,”连接） beg: 开始日期，格式为YYYYmmdd,
	 * 例如：20160801 end: 结束日期，格式参照beg参数。 attrs: 过滤属性。
	 */
	public static JSONObject get_edge_in_range(String devs, String beg, String end, String attrs) {
		String tm = new Date().getTime() + "";
		String common = "appid=" + appid + "&attrs=" + attrs + "&beg=" + beg + "&devs=" + devs + "&end=" + end + "&tm="
				+ tm;
		String sign = MD5Util.md5(common + appsecret);
		String url = BaseURL + "get_edge_in_range?" + common + "&sign=" + sign;
		return HttpClientUtil.doPost(url, "");
	}

	/*
	 * 获取表计一天内的每小时的电度数据 devs: 设备id（多个设备id使用”,”连接） day: 日期，格式为YYYYmmdd, 例如：20160801
	 * attrs: 过滤属性。
	 */
	public static JSONObject get_ep_by_day(String devs, String day, String attrs) {
		String tm = new Date().getTime() + "";
		String common = "appid=" + appid + "&attrs=" + attrs + "&day=" + day + "&devs=" + devs + "&tm=" + tm;
		String sign = MD5Util.md5(common + appsecret);
		String url = BaseURL + "get_ep_by_day?" + common + "&sign=" + sign;
		return HttpClientUtil.doPost(url, "");
	}

	/*
	 * 获取表计一个月内的每小时的电度数据 devs: 设备id（多个设备id使用”,”连接） month: 日期，格式为YYYYmm, 例如：201608
	 * attrs: 过滤属性。
	 */
	public static JSONObject get_ep_by_month(String devs, String month, String attrs) {
		String tm = new Date().getTime() + "";
		String common = "appid=" + appid + "&attrs=" + attrs + "&devs=" + devs + "&month=" + month + "&tm=" + tm;
		String sign = MD5Util.md5(common + appsecret);
		String url = BaseURL + "get_ep_by_month?" + common + "&sign=" + sign;
		return HttpClientUtil.doPost(url, "");
	}

	/*
	 * 获取表计指定时间段的每小时的电度数据 devs: 设备id（多个设备id使用”,”连接） beg: 开始日期，格式为YYYYmmdd,
	 * 例如：20160801 end: 结束日期，格式参照beg参数。 attrs: 过滤属性。
	 */
	public static JSONObject get_ep_in_range(String devs, String beg, String end, String attrs) {
		String tm = new Date().getTime() + "";
		String common = "appid=" + appid + "&attrs=" + attrs + "&beg=" + beg + "&devs=" + devs + "&end=" + end + "&tm="
				+ tm;
		String sign = MD5Util.md5(common + appsecret);
		String url = BaseURL + "get_ep_in_range?" + common + "&sign=" + sign;
		return HttpClientUtil.doPost(url, "");
	}

	/*
	  *  设置告警条件 alarm: 告警条件json字符串，格式如： { E1001001_0101: {}, # 空对象，或者空字符串，将删除该表计的报警条件
	 * E1001001_0102: { callback: “回调地址”, s: “任何字符串，回调时原样返回”, type：1 or 2, #告警类型,
	 * 1表示实时报警，一旦检测到值符合条件立马触发告警；2表示时间段告警，表示指定时间段内的数据都符合条件才触发告警
	 * period：3600，时间段设置，如果为时间段告警，表示最后x秒内的采集值。单位为秒。 expression: “$$.Ia > 6 || $$.Ib
	 * > 10”, 告警判断表示式，$$表示采集值，如果属性不存在，视为false, 例如：采集值如果不包含Ia属性，则有关Ia的所有判断都将返回false }
	 * }
	 */
	public static JSONObject set_alarm(String alarm) {
		String tm = new Date().getTime() + "";
		String common = "appid=" + appid + "&tm=" + tm;
		String sign = MD5Util.md5(common + appsecret);
		String url = BaseURL + "set_alarm?" + common + "&sign=" + sign;
		System.err.println(url);
		return HttpClientUtil.doPost(url, alarm);
	}

	/*
	 * 获取告警条件 collectors: 设备id，如果有多个设备，使用”,”连接设备id。
	 */
	public static JSONObject get_alarm(String collectors, String attrs) {
		String tm = new Date().getTime() / 1000 + "";
		String common = "appid=" + appid + "&collectors=" + collectors + "&tm=" + tm;
		String sign = MD5Util.md5(common + appsecret);
		String url = BaseURL + "get_alarm?" + common + "&sign=" + sign;
		System.err.println(url);
		return HttpClientUtil.doPost(url, "");
	}

	/*
	 * 发送指令     一次向一个表计发送指令
	 * cmd: 指令（十六进制中间用 空格转义之后（%20） 链接）
	 * uid:网关编号（如：E7014001）
	 * pipe:路数（int类型）
	 * baut:波特率（int类型）
	 * fmt:校验方式（如8N1）
	 * 
	 * 失败返回：{"err": "发送指令失败"}
	 * 成功返回：{"control_id":"XX"}   如:{"control_id":"9d7cc539-6a4a-4b71-ab0a-fe271df29c34"}
	 */
	public static JSONObject send_cmd(String cmd, String uid, int pipe, int baut, String fmt) {
		String tm = new Date().getTime() / 1000 + "";
		String common = "appid=" + appid + "&baut=" + baut + "&cmd=" + cmd + "&fmt=" + fmt + "&pipe=" + pipe + "&uid=" + uid + "&tm=" + tm;
		String sign = MD5Util.md5(common + appsecret);
		String url = BaseURL + "send_cmd?" + common + "&sign=" + sign;
		return HttpClientUtil.doPost(url, "");
	}


	public static void main(String[] args) {
//		String cmd = "14%2003%2001%2031%2000%2001%20D6%20FC";
//		String uid = "E7014131";
//		int pipe = 2;
//		int baut = 9600;
//		String fmt = "8N1";
//		System.err.println(GatewayUtil.send_cmd(cmd, uid, pipe, baut, fmt));
		
	}
}
