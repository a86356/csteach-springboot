# csteach-springboot

## 项目介绍

这个项目是springboot的开发脚手架，

集成了权限，mybatis plus, 各种工具类，拦截器。

项目采用controller->service->mapper->db

这样的开发模式，目录结构清晰，common包下面放的都是通用的功能，无论你做什么springboot项目都可以用到，你实际开发的话，只需要把数据库的表建好，再做好数据库链接，然后就可以用代码自动生成器来生成controller,service,mapper的文件，另外需要再用两个包，一个是dto，用来封装传输的数据，另一个是vo，用于返回给前端做展示的。

这样的项目结构是很清晰的。



## 接口列表

restful的接口列表，匹配前端的vue项目的

下面是接口列表

```java
// 会员
'member.sendsms'=>'app\modules\v2\forms\member\sendsms',
'member.register'=> 'app\modules\v2\forms\member\register',
'member.login'=> 'app\modules\v2\forms\member\login',
'member.forgetpwd'=> 'app\modules\v2\forms\member\forgetpwd',
'member.getuserinfo'=> 'app\modules\v2\forms\member\getuserinfo',
'member.getmyuserinfo'=> 'app\modules\v2\forms\member\getmyuserinfo',
'member.saveuserinfo'=> 'app\modules\v2\forms\member\saveuserinfo',
'member.changepwd'=> 'app\modules\v2\forms\member\changepwd',
'member.getstudyclasses'=> 'app\modules\v2\forms\member\getstudyclasses',
'member.getcheckinlist'=> 'app\modules\v2\forms\member\getcheckinlist',
'member.getnewmember'=> 'app\modules\v2\forms\member\getnewmember',


//课程
'classes.getlist'=> 'app\modules\v2\forms\classes\getclaseslist',
'classes.getallcategory'=> 'app\modules\v2\forms\classes\getcategorylist',
'classes.getclassdetail'=> 'app\modules\v2\forms\classes\getclassdetail',
'classes.gethotclass'=> 'app\modules\v2\forms\classes\gethotclass',

// 节数
'segment.update'=>'app\modules\v2\forms\segment\updateseg',
'segment.getoneprogress'=>'app\modules\v2\forms\segment\getoneprogress',
'segment.getprogresslist'=>'app\modules\v2\forms\segment\getprogresslist',
'segment.getseglist'=>'app\modules\v2\forms\segment\getseglist',

//签到
'checkin.getlist'=> 'app\modules\v2\forms\checkin\getcheckinlist',
'checkin.daycheckin'=> 'app\modules\v2\forms\checkin\daycheckin',

//社区
'community.getlist'=> 'app\modules\v2\forms\community\getlist',


//文章
'article.publish'=>'app\modules\v2\forms\article\publish',
'article.lastest'=> 'app\modules\v2\forms\article\lastest',
'article.getone'=> 'app\modules\v2\forms\article\getone',
'article.getalllovers'=> 'app\modules\v2\forms\article\getalllovers',
'article.increaseview'=> 'app\modules\v2\forms\article\increaseview',
'article.getlist'=> 'app\modules\v2\forms\article\getlist',

//cdn
'qiniu.gettoken'=>'app\modules\v2\forms\cdn\getqiniutoken',

//收藏
'collect.addcollection'=> 'app\modules\v2\forms\collection\addcollection',
'collect.cancelcollection'=> 'app\modules\v2\forms\collection\cancelcollection',
'collect.getonecollection'=> 'app\modules\v2\forms\collection\getonecollect',
'collect.getcollectionlist'=> 'app\modules\v2\forms\collection\getcollectionlist',

//评论
'comment.publish'=>'app\modules\v2\forms\comment\publish',
'comment.getlist'=>'app\modules\v2\forms\comment\getlist',
'comment.getreplylist'=>'app\modules\v2\forms\comment\getreplylist',

//视频
'videos.getallseg'=>'app\modules\v2\forms\videos\getallseg',
'videos.getoneseg'=>'app\modules\v2\forms\videos\getoneseg',
'videos.studyclass'=>'app\modules\v2\forms\videos\studyclass',
'videos.getallstudymember'=>'app\modules\v2\forms\videos\getallstudymember',
'videos.getcomments'=>'app\modules\v2\forms\videos\getallstudymember',

//cdn
'cdn.uploader'=>'app\modules\v2\forms\cdn\OssUploader'
```

项目最终展示环节，请看cs1024com 这个网站





