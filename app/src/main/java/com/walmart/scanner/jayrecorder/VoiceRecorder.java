package com.walmart.scanner.jayrecorder;

import android.content.Context;
import android.media.MediaRecorder;
import android.os.Environment;

import java.io.IOException;

public class VoiceRecorder {

    private static MediaRecorder mRecorder;
    private final Context mContext;
    private String mFileName;

    public VoiceRecorder(Context context) {
        mContext = context;
    }

    public void startRecording() {
        mFileName = Environment.getExternalStorageDirectory().getAbsolutePath();
        mFileName += "/test.3gp";

        System.out.println("VoiceRecorder.startRecording");
        mRecorder = new MediaRecorder();
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mRecorder.setOutputFile(mFileName);
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        try {
            mRecorder.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mRecorder.start();
    }

    public void stopRecording() {
        System.out.println("VoiceRecorder.stopRecording");
        mRecorder.stop();
        mRecorder.release();
        mRecorder = null;
    }
}
