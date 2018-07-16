package com.example.alice.filesavelimit.service;

import android.annotation.SuppressLint;
import android.content.Context;

import java.io.FileOutputStream;

public class LoginService {
    @SuppressLint({"WorldReadableFiles","WorldWriteableFiles"})
    public static boolean saveUserIofo(Context context, String username, String password, int mode){
        try{
            FileOutputStream fos = null;
            switch (mode)
            {
                case 1:
                    fos = context.openFileOutput("private.txt",Context.MODE_PRIVATE);
                    break;
                case 2:
                    fos = context.openFileOutput("read.txt",Context.MODE_WORLD_READABLE);
                    break;
                case 3:
                    fos = context.openFileOutput("write.txt",Context.MODE_WORLD_WRITEABLE);
                    break;
                case 4:
                    fos = context.openFileOutput("public.txt",Context.MODE_WORLD_WRITEABLE+Context.MODE_WORLD_READABLE);
                    break;
            }
            fos.write((username + "##" + password).getBytes());
            fos.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
