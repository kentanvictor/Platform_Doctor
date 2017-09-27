package com.example.dell.platform_doctor.model;

import android.os.Parcel;
import android.util.Log;

import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion;

/*
 * Created by JohnnyTan on 2017/9/27.
 */

public class SuggesstionItem implements SearchSuggestion {
    private String title;
    private boolean isHistory = false;

    public SuggesstionItem(String title) {
        this.title = title;
    }

    //从parcel中读取存储数据
    public SuggesstionItem(Parcel source) {
        title = source.readString();
        //==1 : true ; ==0 : false
        isHistory = source.readInt() != 0;
    }

    public void setHistory(boolean history) {
        isHistory = history;
    }

    public boolean isHistory() {
        return isHistory;
    }

    @Override
    //getTitle
    public String getBody() {
        return title;
    }

    public static final Creator<SuggesstionItem> CREATOR = new Creator<SuggesstionItem>() {
        @Override
        public SuggesstionItem createFromParcel(Parcel source) {
            return new SuggesstionItem(source);
        }

        @Override
        public SuggesstionItem[] newArray(int size) {
            return new SuggesstionItem[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    //储存数据
    public void writeToParcel(Parcel dest, int flags) {
        Log.d("SuggestionItem", "write to parcel");
        dest.writeString(title);
        dest.writeInt(isHistory ? 1 : 0);
    }
}
