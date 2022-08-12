package com.giobar.fantastacapp.utils

import java.math.BigInteger
import java.security.MessageDigest

class StringUtils {

    companion object {
        fun String.md5Hash(): String {
            val mdInstance = MessageDigest.getInstance("MD5")
            val bigInt = BigInteger(1, mdInstance.digest(this.toByteArray(Charsets.UTF_8)))
            return String.format("%032x", bigInt)
        }
    }
}