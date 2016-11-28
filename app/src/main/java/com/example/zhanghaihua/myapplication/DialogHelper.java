package com.example.zhanghaihua.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.WindowManager;



public class DialogHelper {
	
	public static CustomConfirmDialog.Builder showConfirmDialog(Context mContext,
																String dialogTitle,
																String dialogContent,
																String confirmText,
																String cancelText,
																DialogInterface.OnClickListener confirmClickListener,
																DialogInterface.OnClickListener cancelClickListener,
																DialogInterface.OnCancelListener cancelListener,
																DialogInterface.OnDismissListener dismissListener,
																boolean isShowEdit,
																boolean isCancelClickOutside,
																int maxLength){
		CustomConfirmDialog.Builder builder = null;
    	try{
    		if(dialogContent != null){
				dialogContent = dialogContent.replace("|", "\n");
			}
    		
    		builder = new CustomConfirmDialog.Builder(mContext);
    		builder.setTitle(dialogTitle);
    		builder.setMessage(dialogContent);
    		builder.setPositiveButton(confirmText, confirmClickListener);
    		if(cancelClickListener != null){
    			builder.setNegativeButton(cancelText,cancelClickListener);
    		}else{
    			builder.setNegativeButton(cancelText,new DialogInterface.OnClickListener() {
    				
    				@Override
    				public void onClick(DialogInterface arg0, int arg1) {
    					arg0.dismiss();
    				}
    			});
    		}
    		builder.create(cancelListener,dismissListener,isShowEdit,isCancelClickOutside,maxLength).show();
    	} catch(WindowManager.BadTokenException e){
			Log.d("DialogHelper", "activity is destroyed.");
		}
		
		return builder;
    }
}
