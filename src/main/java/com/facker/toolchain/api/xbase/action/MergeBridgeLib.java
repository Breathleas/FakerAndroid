package com.facker.toolchain.api.xbase.action;

import com.facker.toolchain.base.utils.IOUtil;
import com.facker.toolchain.api.xbase.WorkerAction;
import com.facker.toolchain.api.xbase.XBridge;
import com.facker.toolchain.api.xbase.XTarget;
import java.io.File;

public class MergeBridgeLib extends WorkerAction  {
    private XBridge xBridge;
    private XTarget xTarget;
    public MergeBridgeLib(XBridge xBridge, XTarget xTarget){
        this.xBridge = xBridge;
        this.xTarget = xTarget;
    }

    @Override
    public void action() throws Exception {
        //对老的armeabi
        File fileArmeabi = new File(xTarget.getLibDir(),"armeabi");
        if(fileArmeabi.exists()&&fileArmeabi.isDirectory()){
            IOUtil.copyDir(new File(xBridge.getLibDir(),"armeabi-v7a"),fileArmeabi);
        }

        File fileV8a = new File(xTarget.getLibDir(),"arm64-v8a");
        if(fileV8a.exists()&&fileV8a.isDirectory()){
            IOUtil.copyDir(new File(xBridge.getLibDir(),"arm64-v8a"),fileV8a);
        }

        File fileV7a = new File(xTarget.getLibDir(),"armeabi-v7a");
        if(fileV7a.exists()&&fileV7a.isDirectory()){
            IOUtil.copyDir(new File(xBridge.getLibDir(),"armeabi-v7a"),fileV7a);
        }

        File fileX86 = new File(xTarget.getLibDir(),"x86");
        if(fileX86.exists()&&fileX86.isDirectory()){
            IOUtil.copyDir(new File(xBridge.getLibDir(),"x86"),fileX86);
        }
        File fileX86_64 = new File(xTarget.getLibDir(),"x86_64");

        if(fileX86_64.exists()&&fileX86_64.isDirectory()){
            IOUtil.copyDir(new File(xBridge.getLibDir(),"x86_64"),fileX86_64);
        }
        if(!xTarget.getLibDir().exists()){
            IOUtil.copyDir(xBridge.getLibDir(), xTarget.getLibDir());
        }
    }
}
