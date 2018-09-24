package com.deanxd.taxiform.util;

import android.text.TextUtils;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;

/**
 * Log工具类,修改LOGLEVEL即可调整打印Log的等级.
 */
public class LogTools {
    private static final int VERBOSE = 5;
    private static final int DEBUG = 4;
    private static final int INFO = 3;
    private static final int WARN = 2;
    private static final int ERROR = 1;
    private static int LOGLEVEL = 6;
    public static final String XMPP_MSG_TAG = "XmppManager";


    public static void closeLog() {
        LOGLEVEL = 2;
    }

    public static void updateLogLevel() {
        LOGLEVEL += 4;
        if (LOGLEVEL > 6) {
            LOGLEVEL = 2;
        }
        Log.e(TAG, "当前日志等级:" + LOGLEVEL);
    }

    private static String TAG = "qtsoft";
    private static BufferedWriter bufferWritter;

    public static void v(String tag, String msg) {
        if (LOGLEVEL > VERBOSE && !TextUtils.isEmpty(msg)) {
            Log.v(tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (LOGLEVEL > DEBUG && !TextUtils.isEmpty(msg)) {
            Log.d(tag, msg);
        }
    }

    public static void dFormat(String format, Object... msg) {
        if (LOGLEVEL > DEBUG && msg != null) {
            Log.d(TAG, String.format(format, msg));
        }
    }

    public static void i(String tag, String msg) {
        if (LOGLEVEL > INFO && !TextUtils.isEmpty(msg)) {
            Log.i(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (LOGLEVEL > WARN && !TextUtils.isEmpty(msg)) {
            Log.w(tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (LOGLEVEL > ERROR && !TextUtils.isEmpty(msg)) {
            Log.e(tag, msg);
        }
    }

    public static void v(String msg) {
        if (LOGLEVEL > VERBOSE && !TextUtils.isEmpty(msg)) {
            Log.v(TAG, msg);
        }
    }

    public static void d(String msg) {
        if (LOGLEVEL > DEBUG && !TextUtils.isEmpty(msg)) {
            Log.d(TAG, msg);
        }
    }

    public static void i(String msg) {
        if (LOGLEVEL > INFO && !TextUtils.isEmpty(msg)) {
            Log.i(TAG, msg);
        }
    }

    public static void w(String msg) {
        if (LOGLEVEL > WARN && !TextUtils.isEmpty(msg)) {
            Log.w(TAG, msg);
        }
    }

    public static void e(String msg) {
        if (LOGLEVEL > ERROR && !TextUtils.isEmpty(msg)) {
            Log.e(TAG, msg);
        }
    }

    public static void e(Throwable ex) {
        if (LOGLEVEL > ERROR && ex != null) {
            String errorInfo = null;
            ByteArrayOutputStream baos = null;
            PrintStream printStream = null;
            try {
                baos = new ByteArrayOutputStream();
                printStream = new PrintStream(baos);
                ex.printStackTrace(printStream);
                byte[] data = baos.toByteArray();
                errorInfo = new String(data);
                data = null;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (printStream != null) {
                        printStream.close();
                    }
                    if (baos != null) {
                        baos.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Log.e(TAG, errorInfo);
        }
    }


    public static void v(Object obj, String msg) {
        if (LOGLEVEL > VERBOSE && !TextUtils.isEmpty(msg)) {
            Log.v(TAG, obj.getClass().getName() + ":" + msg);
        }
    }

    public static void d(Object obj, String msg) {
        if (LOGLEVEL > DEBUG && !TextUtils.isEmpty(msg)) {
            String name = obj.getClass().getName();
            name = name.substring(name.lastIndexOf(".") + 1, name.length());
            Log.d(TAG, name + ":" + msg);
        }
    }

    public static void i(Object obj, String msg) {
        if (LOGLEVEL > INFO && !TextUtils.isEmpty(msg)) {
            Log.i(TAG, obj.getClass().getName() + ":" + msg);
        }
    }

    public static void w(Object obj, String msg) {
        if (LOGLEVEL > WARN && !TextUtils.isEmpty(msg)) {
            Log.w(TAG, obj.getClass().getName() + ":" + msg);
        }
    }

    public static void e(Object obj, String msg) {
        if (LOGLEVEL > ERROR && !TextUtils.isEmpty(msg)) {
            Log.e(obj.getClass().getName() + ":" + TAG, msg);
        }
    }


    public static void save(String msg) {//插入一行日志
        if (bufferWritter != null) {
            try {
                bufferWritter.write("[" + new Date().toLocaleString() + "]: " + msg);
                bufferWritter.newLine();
                bufferWritter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
