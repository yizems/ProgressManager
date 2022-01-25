# ProgressManager

[![](https://jitpack.io/v/yizems/ProgressManager.svg)](https://jitpack.io/#yizems/ProgressManager)


## 为何修改

1. 全局监听并不适合于所有场景,目前的这种方式,内存泄漏的几率挺高的,特别是常量`url`的情况;这也是为何作者推荐`new String()`方式创建Url的原因
2. 不支持单次设置,大部分场景下我们都是单次监听,并不需要全局监听某个URL


## 修改后

```
//kotlin
Request.Build()
    .requestListener(listener: RequestProgressListener)
    .responseListener(listener: ResponseProgressListener)
    .build()

//java
new Request.Build()
    .tag(RequestProgressListener.class,listener)
    .tag(ResponseProgressListener.class,listener)
    .build()

//retrofit
class ApiService{
    //kotlin
    fun test(@Tag listener:RequestProgressListener?,@Tag listener:ResponseProgressListener?)

    //java
    Callback<ResponseBody> test(@Nullable @Tag RequestProgressListener:listener,@Nullable @Tag ResponseProgressListener:listener)
}
```

