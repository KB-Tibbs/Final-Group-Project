package com.example.anagrams

import com.example.anagrams.Anagram
import java.util.*
//This File isn't neccesary I just needed an extra space to code inbelt
class Anagram{
    val RANDOM = Random()
    val wrds = arrayOf("ORANGE", "BELTWAY", "APPLE", "KOTLIN", "MOJA")

    public final fun ranWrd(): String {
        return wrds[RANDOM.nextInt(wrds.size)]
    }

    fun mixWrds(anag: String?): String? {
        if (anag != null && "" != anag) {
            val let = anag.toCharArray()
            for (i in let.indices) {
                val r = RANDOM.nextInt(let.size)
                val temp = let[i]
                let[i] = let[r]
                let[r] = temp
            }
        }
        return anag
    }
}