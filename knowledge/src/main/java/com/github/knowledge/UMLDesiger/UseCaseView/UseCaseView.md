用例图（Use Case View）
=======================
##版本记录
|  日期    | 版本  | 版本说明|修改人|
|----------|-------|---------|------|
|2016-04-30|V0.0.1 | 初始版本|张日雄|
|          |       |         |      |

#用例图使用背景
> 笔者一般会把使用背景或场景放在开章的首页，就如学数学和物理一样，我们必须先了解他的数学意义和物理意义，才能深刻的理解一
条定理的作用和功能，并灵活的使用，而不是仅仅只是会做题或只会画图这些无意义的事情。同理，万般皆是此学问罢了。

- 需求阶段 
用例描述文档的书写是系统分析人员对用户需求的深刻理解的体现。是后期时序图和实际开发的重要依据。也可以对作为项目估算的依据，
以及根据UC复杂度和开发周期来衡量开发人员的工作效率。因此UC的书写规范及其重要，就工作用的一些经验，比如书写格式、书写内容
及其注意事项与大家分享。

- 系统设计阶段
试图描概括了用例中角色和系统之间的关系，描述了系统功能需求，角色和系统的交互以及系统的反应。是客户和开发人员全貌理解项目
需求功能比较好的一个方式，也是后续功能迭代的依据和方向。

- 总结
用例图，主要能清楚的表达出，用户使用这个系统能做什么，即系统的基本功能。

#需求阶段的用例图
1、基本描述（Brief Description）
    描述用例在系统中的作用。比如此用例的使用者是谁、使用者所要做的操作。
2、前置条件（Precodition）
    描述该用例执行前所要满足的条件。比如用例B执行前，必须先执行A，则用例的前置条件是执行A。 B->A  即B依赖A。
3、事后保证（PostCodition）
    此用例执行完毕后的条件。即最终的结果。
4、主要流程（Basic Flows）
    用户操作该用例的基本流程，是后期时序图的主要参考。
5、选择性流程（Alternative Flows）
    在操作主要流程过程中，出现的一些分支流程，是后期时序图的主要参考。
6、特别需求（Special Requirement）
    对一些细微功能点进行描述，比如用户身份验证规则、订单号码产生规则、是否需要SSL加密等等。
7、使用界面（User Interface）
    美工、前端根据需求制作的UI，及其对UI中栏位进行的说明。
8、附加资讯（Addition Information）
    一些商务逻辑的描述，可以把系统逻辑试图（Logic View）放到这里
    
#用例图简述
用例试图描概括了用例中角色和系统之间的关系，描述了系统功能需求，角色和系统的交互以及系统的反应。
![Use Case01.jpg](./img/UseCase01.jpg)  

#术语解释
- 1、Extends 用例扩展关系
扩展关系一般用来描述一个元素延伸为另外一种行为。Use Case中的扩展表示一个UC有可能扩展到另外一个UC的功能。Use Case中的扩展
通常暗示一个选择性流程。


- 2、Include 用例包含关系
包行关系表示源元素包行目标元素的行为，UC中的包含关系就是一个UC中包行另外一个ＵＣ的行为功能。用包行关系可以防止在多个ＵＣ
中同时定义共同的功能模块，有些像委托delegation    

- 3、角色（Actor）
系统中的用户根据系统分为多个角色，每个角色都会与系统有交互。一个用户可以具有一个或者多个角色。
系统中用到的角色如果细分，可以分为主要角色和辅助角色
比如：在电子商务网站中主要角色有供应商、前台会员、系统管理员等等；辅助角色有Email Sender、物流系统、金流系统等等。

![Use Case01.jpg](./img/UseCase02.jpg)  