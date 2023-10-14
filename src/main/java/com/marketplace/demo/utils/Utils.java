package com.marketplace.demo.utils;

import java.util.List;

public class Utils {
    public static boolean emailExists(String emailId, List<String> emailIds) {
        return !emailIds.contains(emailId);
    }
}
