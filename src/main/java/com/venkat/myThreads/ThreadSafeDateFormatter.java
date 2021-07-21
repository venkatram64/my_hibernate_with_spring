package com.venkat.myThreads;

import java.text.SimpleDateFormat;

public class ThreadSafeDateFormatter {
    public static ThreadLocal<SimpleDateFormat> sdf = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));
}
