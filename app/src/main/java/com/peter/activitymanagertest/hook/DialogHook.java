package com.peter.activitymanagertest.hook;

import android.app.Dialog;
import android.graphics.Color;
import android.view.Window;

import java.lang.reflect.Field;

/**
 * Created by jiangbin on 2018/7/23.
 */

public class DialogHook {
    public static void printDialogWindowManager(Dialog dialog) {
        try {
            Field mWindowManagerField =  Dialog.class.getDeclaredField("mWindowManager");
            mWindowManagerField.setAccessible(true);
            System.out.println("jiangbin--> window in Dialog "+mWindowManagerField.get(dialog));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    public static void printDialogPhoneWindow(Dialog dialog) {
        try {
            
            Field mWindowField =  Dialog.class.getDeclaredField("mWindow");
            mWindowField.setAccessible(true);
            Window mWindow = (Window) mWindowField.get(dialog);
            System.out.println("jiangbin--> window attr dialog " + mWindow.getAttributes());
            mWindow.getDecorView().setBackgroundColor(Color.RED);
            System.out.println("jiangbin--> window in Dialog "+mWindowField.get(dialog));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
