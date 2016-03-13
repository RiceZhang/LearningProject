设计模型类别之——构建类别（工厂方法模式）
===========


####模式：工厂方法模式
应用度：5

精妙度：3

##原理：
> 定义一个用于创建对象的接口,让子类决定实例化哪一个类,Factory Method使一个类的实例化延迟到了子类。

##应用场景：
> 由于需求的变化，一个类的子类经常面临着剧烈的变化，但他却拥有比较稳定的接口。使用一种封装机制来“隔离这种易变对象的变化”，工厂方法定义一个用于创建对象的接口，让子类来确定创建哪一个具体类的对象，将对象的实例化延迟。 

##示例场景Case1:
> 发送信息 ，不管你施法短信还是发邮件、还是发微信，发qq信息，只是定义一个稳定的接口，延迟实现。

![普通工厂UML示例图片](img/case01.png "邮件发送场景")



##示例场景Case2:
> 改进版

![普通工厂UML示例图片](img/case02.png "邮件发送场景")
	
##示例场景Case3:结合实际开发来用谈谈工厂模式
	> 在实际开发中，我们一般会用spring 的IOC 以及接口来实现工厂方法的一个并行结构。现在我最近遇到了这样一个场景：
	我们要做一个数据统计，统计不同活动（如：秒杀活动、刮刮卡、抱团、瑶一摇、抢购等）
	'''java
	
	@Autowired
	@Qualifier("allActivityService")
	private IActivityStaticsService allActivityService;//所有活动	
	@Autowired
	@Qualifier("bargainActivityService")	
	private IActivityStaticsService bargainActivityService;//砍价活动	
	@Autowired
	@Qualifier("luckActivityStatisService")	
	private IActivityStaticsService luckActivityStatisService;//抽奖活动	
	@Autowired
	@Qualifier("presaleActivityStatisService")
	private IActivityStaticsService presaleActivityStatisService;//预售卡活动	
	@Autowired
	@Qualifier("skillActivityStatisService")
	private IActivityStaticsService skillActivityStatisService;//秒杀活动
	
		/**
     * 各个活动统计汇总根据  type 判断
     * @param request
     * @return
     */
    @RequestMapping("/collect")
    @ResponseBody
	 public ApiResult activityStatistics(HttpServletRequest request)  {
		 String type = ServletRequestUtils.getStringParameter(request, "type", "ALL");
		 String startTime = request.getParameter("startTime");
	     String endTime = request.getParameter("endTime");
	     
	     if( StringUtils.isEmpty(startTime) || StringUtils.isEmpty(endTime) ) {
			try {
				throw new Exception("开始时间或结束时间不能为空");
			} catch (Exception e) {
				return ApiResultGenerate.badParameter();
			}
	     }
	     
	     ActivityStaticsVo result = new ActivityStaticsVo();
	     logger.info("验证类型："+ type);
	     if(type.equals(ActivityType.LUCK.name())) {//砍价活动
	    	 result =  luckActivityStatisService.overView(startTime, endTime); // 抽奖
	     }else if(type.equals(ActivityType.BARGAIN.name())){
	    	 result =  bargainActivityService.overView(startTime, endTime);
	     }else if(type.equals(ActivityType.PRESALE.name())) {
	    	 result = presaleActivityStatisService.overView(startTime, endTime);
	     }else if(type.equals(ActivityType.SECKILL.name())) {
	    	 result = skillActivityStatisService.overView(startTime, endTime);
	     }else{
	    	 result = allActivityService.overView(startTime, endTime);
	     }
	     
	     result.setStartTime(startTime); //开始时间
	     result.setEndTime(endTime); //结束时间
	     
		return ApiResultGenerate.success(result);	 
	 }
	 '''
	
	
 		 
