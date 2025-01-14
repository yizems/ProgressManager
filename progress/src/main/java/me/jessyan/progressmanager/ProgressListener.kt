/*
 * Copyright 2017 JessYan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.jessyan.progressmanager

import me.jessyan.progressmanager.body.ProgressInfo
import okhttp3.Request

/**
 * ================================================
 * Created by JessYan on 02/06/2017 18:23
 * [Contact me](mailto:jess.yan.effort@gmail.com)
 * [Follow me](https://github.com/JessYanCoding)
 * ================================================
 */
interface ProgressListener {
    /**
     * 进度监听
     *
     * @param progressInfo 关于进度的所有信息
     */
    fun onProgress(progressInfo: ProgressInfo?)

    /**
     * 错误监听
     *
     * @param id 进度信息的 id
     * @param e  错误
     */
    fun onError(id: Long, e: Exception?)
}

interface RequestProgressListener : ProgressListener {

}

interface ResponseProgressListener : ProgressListener {

}

/**
 * 单次请求请求进度监听
 * @receiver Request.Builder
 * @param listener RequestProgressListener
 */
fun Request.Builder.requestListener(listener: RequestProgressListener) {
    tag(RequestProgressListener::class.java, listener)
}

/**
 * 单次请求请求进度监听
 * @receiver Request.Builder
 * @param listener ResponseProgressListener
 */
fun Request.Builder.responseListener(listener: ResponseProgressListener) {
    tag(ResponseProgressListener::class.java, listener)
}
