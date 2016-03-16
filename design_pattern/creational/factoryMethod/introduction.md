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
	
	#小结
	- 识别工厂方法：
		并非每一个能创建并返回一个新的对象的方法，都是工厂方法模式的实例。工厂方法模式不仅仅要求有一个能够创建新对象的方法，还要让客户代码必须要了解具体实例化的类（在实际开发中这可以交给spring @Resource（name="pojo"）来做），
		工厂方法模式一般包含了若干个类，这些类实现了相同的操作。返回了相同的抽象类型，注意：这是抽象类型，它必然会有子类去继成，作为不同的返回值。
 		然而，这些操作的内部实际上却实例化了不同的类（spring IOC来做），并且，这些类都实现了上述的抽象类型，当客户端请求一个新的对象时，这个对象该由那个类实例化，取决于工厂对象接收创建请求时的行为。
		
	- 并行层次结构中的工厂方法模式	
		在使用并行层次结构对问题与进行建模时，常常会使用工厂方法模式。一个并行层次结构是一对类层次结构。其中，一个类在一个层次，与其相关的类在另一个层次。当将现有类层次结构的部分行为移出该层次后，并行层次结构就会显露出来。

		工厂方法模式的意图是让服务的提供者确定实例化那一个类，而不是客户代码。这种模式在java类库中非常常见，比如collection接口的iterator()方法。