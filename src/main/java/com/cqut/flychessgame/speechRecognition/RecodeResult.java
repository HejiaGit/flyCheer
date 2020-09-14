package com.cqut.flychessgame.speechRecognition;

import com.cqut.flychessgame.util.ClipboardUitl;
import com.cqut.flychessgame.util.StringToolUtil;
import com.iflytek.cloud.speech.*;

/**
 * Create with IntelliJ IDEA.
 * 语音识别类
 *
 * @author hj
 */
public class RecodeResult {
    //语音听写对象
    private SpeechRecognizer mIat = SpeechRecognizer.createRecognizer();

    //标志是否已经开始录音
    private boolean startRecordFlag = false;

    public RecodeResult() {
        setting();
    }

    /**
     * 开始录音
     */
    public void startRecord() {
        startRecordFlag = true;
        if (!mIat.isListening()) {
            mIat.startListening(recognizerListener);
        }
    }

    /**
     * 停止录音
     */
    public void stopRecord() {
        startRecordFlag = false;
        mIat.stopListening();
    }

    /**
     * 听写监听器
     */
    private RecognizerListener recognizerListener = new RecognizerListener() {
        private StringBuffer sb = new StringBuffer();

        /**
         * 获取听写结果. 获取RecognizerResult类型的识别结果
         */
        @Override
        public void onResult(RecognizerResult results, boolean islast) {
            sb.append(results.getResultString());
            if (islast) {
                String text = sb.toString();
                if (StringToolUtil.isChinese(text)) {
                    ClipboardUitl.paste(sb.toString());
                    System.out.println("Result: " + sb.toString());
                    sb.setLength(0);
                }
                //开始新一轮语音识别
                if (startRecordFlag) {
                    mIat.stopListening();
                    mIat.startListening(recognizerListener);
                }
            }
        }

        @Override
        public void onError(SpeechError error) {
            System.out.println("===Error===");
            if (null != error) {
                System.out.println(" Code：" + error.getErrorDescription(true));
            }
            //出错重试
            if (startRecordFlag) {
                mIat.stopListening();
                mIat.startListening(recognizerListener);
            }
        }

        //扩展接口
        @Override
        public void onEvent(int eventType, int arg1, int agr2, String msg) {
        }
        //音量值0-30
        @Override
        public void onVolumeChanged(int volume) {
        }
        //开始录音
        @Override
        public void onBeginOfSpeech() {
        }
        //结束录音
        @Override
        public void onEndOfSpeech() {
        }
    };

    /**
     * 初始化基本配置
     */
    private void setting() {
        //设置开发者信息 appid
        SpeechUtility.createUtility("appid=5cd184e3");

        //配置参数
        //返回结果类型  {json， xml， plain}， 默认值：json
        mIat.setParameter(SpeechConstant.RESULT_TYPE, "plain");
        mIat.setParameter(SpeechConstant.NET_TIMEOUT, "20000");//网络连接超时时间，[0, 30000]，默认值：20000
        mIat.setParameter(SpeechConstant.KEY_SPEECH_TIMEOUT, "10000");//设置录取音频的最长时间，[0, 60000]，默认值：60000
//		mIat.setParameter(SpeechConstant.DOMAIN, "iat");//应用领域用于听写和语音语义服务，{ "iat"（短信和日常用语）, "video", "poi"（地图）, "music" }，默认值："iat"
        mIat.setParameter(SpeechConstant.VAD_BOS, "2000");//开始录入音频后，音频前面部分最长静音时长，[1000, 10000]， 默认值：5000
        mIat.setParameter(SpeechConstant.LANGUAGE, "zh_cn");//语言，{ "zh_cn", "en_us" }， 默认值："zh_cn"
        mIat.setParameter(SpeechConstant.ACCENT, "mandarin");//语言区域 默认 mandarin：普通话 | cantonese：粤语 | lmz：四川话 | henanese：河南话
        mIat.setParameter(SpeechConstant.VAD_EOS, "300");//后端点超时，开始录入音频后，音频后面部分最长静音时长，[0, 10000]， 默认值：1800
        mIat.setParameter(SpeechConstant.SAMPLE_RATE, "16000");//识别采样率，{8000，16000}， 默认值：16000
//		mIat.setParameter(SpeechConstant.ASR_NBEST, "1");//句子级多候选，有歧义的句子有多少个候选结果 ，[1, 5]，默认值：1
//		mIat.setParameter(SpeechConstant.ASR_WBEST, "1");//词级多候选，有歧义的词有多少个候选结果 ，[1, 5]，默认值：1
        mIat.setParameter(SpeechConstant.ASR_PTT, "0");//设置是否有标点符号， { null， 0， 1}， 默认值：1
//		mIat.setParameter(SpeechConstant.ASR_AUDIO_PATH, null );//识别录音保存路径 当前识别支持未压缩的16位，单声道，采样率为16000或8000，字节顺序为 Little-Endian的Windows PCM音频。
    }
}
