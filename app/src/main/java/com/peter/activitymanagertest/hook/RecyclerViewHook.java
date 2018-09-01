package com.peter.activitymanagertest.hook;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by jiangbin on 2018/9/1.
 */

public class RecyclerViewHook {
    /**
     * 通过反射的方式获得RecyclerView的mRecycler对象
     *
     * @param recyclerView
     * @return
     */
    public static RecyclerView.Recycler getRecycler(RecyclerView recyclerView) {
        try {
            Field recyclerField = RecyclerView.class.getDeclaredField("mRecycler");
            recyclerField.setAccessible(true);
            return (RecyclerView.Recycler) recyclerField.get(recyclerView);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过反射的方式获取Recycler的 mAttachedScrap
     *
     * @param recycler
     * @return
     */
    public static ArrayList<RecyclerView.ViewHolder> getAttachedScrap(RecyclerView.Recycler recycler) {
        try {
            Field attachedScrapField = RecyclerView.Recycler.class.getDeclaredField("mAttachedScrap");
            attachedScrapField.setAccessible(true);
            return (ArrayList<RecyclerView.ViewHolder>) attachedScrapField.get(recycler);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<RecyclerView.ViewHolder> getChangedScrap(RecyclerView.Recycler recycler) {
        try {
            Field changedScrapField = RecyclerView.Recycler.class.getDeclaredField("mChangedScrap");
            changedScrapField.setAccessible(true);
            return (ArrayList<RecyclerView.ViewHolder>) changedScrapField.get(recycler);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<RecyclerView.ViewHolder> getCachedViews(RecyclerView.Recycler recycler) {
        try {
            Field cachedViewsFiled = RecyclerView.Recycler.class.getDeclaredField("mCachedViews");
            cachedViewsFiled.setAccessible(true);
            return (ArrayList<RecyclerView.ViewHolder>) cachedViewsFiled.get(recycler);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static RecyclerView.RecycledViewPool getRecycledViewPool(RecyclerView.Recycler recycler) {
        try {
            Field recycledViewPoolField = RecyclerView.Recycler.class.getDeclaredField("mRecyclerPool");
            recycledViewPoolField.setAccessible(true);
            RecyclerView.RecycledViewPool recycledViewPool = (RecyclerView.RecycledViewPool) recycledViewPoolField.get(recycler);
            return recycledViewPool;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getRecycledViewPoolSize(RecyclerView.RecycledViewPool recycledViewPool) {
        try {
            Method recycledViewPoolMethod = RecyclerView.RecycledViewPool.class.getDeclaredMethod("size");
            recycledViewPoolMethod.setAccessible(true);
            return (int) recycledViewPoolMethod.invoke(recycledViewPool);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static SparseArray forEachRecycledViewPool(RecyclerView.RecycledViewPool recycledViewPool) {
        try {
            Field mScrapField = RecyclerView.RecycledViewPool.class.getDeclaredField("mScrap");
            mScrapField.setAccessible(true);
            SparseArray mScrap = (SparseArray) mScrapField.get(recycledViewPool);
            return mScrap;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String forEachSparseArray(SparseArray mScrap) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < mScrap.size(); i++) {
            Object object  = mScrap.valueAt(i);
            try {
                Field field = object.getClass().getDeclaredField("mScrapHeap");
                field.setAccessible(true);
                ArrayList<RecyclerView.ViewHolder> mScrapHeap  = (ArrayList<RecyclerView.ViewHolder>) field.get(object);
            for(RecyclerView.ViewHolder viewHolder:mScrapHeap){
                sb.append(viewHolder+"\n ");
            }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }


    public static String getMessage(RecyclerView mRecyclerView) {
        RecyclerView.Recycler recycler = getRecycler(mRecyclerView);
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList<RecyclerView.ViewHolder> attachedScrap = getAttachedScrap(recycler);
        stringBuffer.append(attachedScrap == null ? "attachedScrap == null" : "attachedScrap.size = " + attachedScrap.size());
        stringBuffer.append("\n");

        ArrayList<RecyclerView.ViewHolder> changedScrap = getChangedScrap(recycler);
        stringBuffer.append(changedScrap == null ? "changedScrap == null" : "changedScrap.size = " + changedScrap.size());
        stringBuffer.append("\n");
        stringBuffer.append("mRecyclerView->"+mRecyclerView+"\n");
        ArrayList<RecyclerView.ViewHolder> cachedViews = getCachedViews(recycler);
        stringBuffer.append(cachedViews == null ? "cachedViews == null" : "cachedViews.size = " + cachedViews.size());
        stringBuffer.append("\n");

        if(cachedViews!=null&&cachedViews.size()!=0){
            stringBuffer.append("========= cachedViews\n");

            for(RecyclerView.ViewHolder viewHolder:cachedViews){
                stringBuffer.append(viewHolder+"\n");
            }
        }
        stringBuffer.append("\n");

        RecyclerView.RecycledViewPool recycledViewPool = getRecycledViewPool(recycler);
        stringBuffer.append(recycledViewPool == null ? "recycledViewPool == null" : "recycledViewPool.size = " + getRecycledViewPoolSize(recycledViewPool));
        stringBuffer.append("\n");
        stringBuffer.append(forEachSparseArray(forEachRecycledViewPool(recycledViewPool)));
        stringBuffer.append("\n");
        stringBuffer.append("=======================\n");


        return stringBuffer.toString();
    }
}
